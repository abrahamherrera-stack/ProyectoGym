
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
import Control.GestionarProductos;
import Control.GestionarCliente;
import Control.GestionarEmpleados;
import Control.GestionarEntrenador;
import Control.GestionarPlan;
import Control.GestionarServicios;
import Model.Cliente;
import Model.Empleado;
import Model.Entrenador;
import Model.PlanEntrenamiento;
import Model.Producto;
import Util.Lectura;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author samuelr.quinones
 */
public class CentroEntretenimiento {

    private static GestionarProductos gp = new GestionarProductos();
    private static GestionarCliente gc = new GestionarCliente();
    private static GestionarServicios gs = new GestionarServicios();
    private static GestionarEmpleados gEmpleado = new GestionarEmpleados();
    private static GestionarEntrenador ge = new GestionarEntrenador();
    private static GestionarPlan gpPlan = new GestionarPlan();
    private static Lectura lectura = new Lectura();

    public static void menu() {
        int op;
        Scanner entrada = new Scanner(System.in);
        Entrenador entrenador = null;

        do {
            System.out.println("\nMenu gym Olimpus");
            System.out.println("[1] Registrar cliente");
            System.out.println("[2] Registar plan");
            System.out.println("[3] Registrar entrenador");
            System.out.println("[4] Crear producto");
            System.out.println("[5] Estado cuenta");
            System.out.println("[6] Crear empleado");
            System.out.println("[7] Consultar planes");
            System.out.println("[8] Realizar pago mensualidad");
            System.out.println("[9] Hacer liquidación de caja");
            System.out.println("[10] Salir\n");
            System.out.print("Ingrese opción (1-8): ");
            op = entrada.nextInt();

            switch (op) {
                case 1:
                    Cliente cliente = gc.crearCliente();
                    gc.agregarCliente(cliente);
                    if (entrenador != null) {
                        entrenador.asignarCliente(cliente);
                    } else {
                        System.out.println("No hay entrenadores registrados");
                    }
                    break;

                case 2:
                    List<Cliente> clientes = gc.getClientes();
                    if (clientes.isEmpty()) {
                        System.out.println("Debe registrar clientes primero");
                    } else {
                        System.out.println("Seleccione el cliente al que desea asignar el plan: ");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + clientes.get(i).getNombre());
                        }

                        System.out.print("Ingrese opción (1-" + clientes.size() + "): ");
                        int seleccion = entrada.nextInt();

                        if (seleccion >= 1 && seleccion <= clientes.size()) {
                            Cliente clienteSeleccionado = clientes.get(seleccion - 1);

                            if (!clienteSeleccionado.isAccesoPermitido()) {
                                System.out.println("El cliente tiene saldo pendiente. No se le puede asignar planes");
                            } else {
                                PlanEntrenamiento plan = gpPlan.crearPlanEntrenamiento();
                                clienteSeleccionado.asignarPlan(plan);
                            }

                            if (entrenador != null) {
                                entrenador.asignarCliente(clienteSeleccionado);
                            }

                        } else {
                            System.out.println("Opción inválida.");
                        }
                    }
                    break;

                case 3:
                    entrenador = ge.crearEntrenador();
                    for (Cliente c : gc.getClientes()) {
                        entrenador.asignarCliente(c);
                    }
                    break;

                case 4:
                    Producto producto = gp.crearProducto();
                    break;

                case 5:
                    int idCliente = lectura.leerInt("Ingrese el id del cliente: ");
                    gc.consultarEstadoCuenta(idCliente);
                    break;

                case 6:
                    Empleado empleado = gEmpleado.crearEmpleado();
                    break;

                case 7:
                    if (entrenador != null) {
                        entrenador.consultarPlanesClientes();
                    } else {
                        System.out.println("No hay entrenadores registrados");
                    }
                    break;

                case 8:
                    int idPago = lectura.leerInt("Ingrese el id del cliente que quiere realizar el pago: ");
                    Cliente clientePago = gc.buscarCliente(idPago);
                    if (clientePago != null) {
                        System.out.println("----- Metodos de pago ------");
                        System.out.println("""
                                           1. Efectivo 
                                           2. Cheque 
                                           3. Tarjeta debito
                                           4. Tarjeta credito
                                           """);
                        int metodo = lectura.leerInt("Ingrese el metodo de pago a utilizar: ");
                        if (metodo == 1) {
                            clientePago.pagoEfectivo();
                        } else if (metodo == 2) {
                            clientePago.pagoCheque();
                        } else if (metodo == 3){
                            clientePago.pagoDebito();
                        }else if(metodo == 4){
                            clientePago.pagoCredito();
                        }else {
                            System.out.println("Metodo de pago incorrecto");
                        }
                    } else {
                        System.out.println("Cliente no encontrado");
                    }
                    break;
                case 9:
                    float base = lectura.leerFloat("Ingrese la base de la caja asignada: ");
                    gEmpleado.realizarArqueoCaja(base, gc.getClientes());
                    break;
                case 10:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Valor invalido, ingrese un valor correcto");
            }
        } while (op != 10);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        menu();
    }
}

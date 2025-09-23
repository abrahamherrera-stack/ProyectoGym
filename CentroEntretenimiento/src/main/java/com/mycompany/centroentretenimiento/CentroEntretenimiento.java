/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.centroentretenimiento;

import Model.*;
import Control.GestionarProductos;
import Control.GestionarCliente;
import Control.GestionarEmpleados;
import Control.GestionarEntrenador;
import Control.GestionarPlan;
import Control.GestionarServicios;
import java.util.ArrayList;
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
    
    public static void menu(){
        int op;
        Scanner entrada = new Scanner(System.in);
        Entrenador entrenador = null;
        List<Cliente> clientes = new ArrayList<>();
        
        do {
            System.out.println("\nMenu gym Olimpus");
            System.out.println("[1] Registrar cliente");
            System.out.println("[2] Registar plan");
            System.out.println("[3] Registrar entrenador");
            System.out.println("[4] Crear producto");
            System.out.println("[5] crear servicio");
            System.out.println("[6] crear empleado");
            System.out.println("[7] Consultar planes");
            System.out.println("[8] Salir\n");
            System.out.print("Ingrese opción (1-8): ");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    Cliente cliente= gc.crearCliente();;
                    clientes.add(cliente);
                    if (entrenador != null){
                        entrenador.asignarCliente(cliente);
                    }else{
                        System.out.println("No hay entrenadores registrados");
                    }
                    break;
                case 2:
                    if (clientes.isEmpty()){
                        System.out.println("Debe registrar clientes primero");
                    }else{
                        System.out.println("Seleccione el cliente al que desea asignar el plan: ");
                        for (int i = 0; i < clientes.size(); i++) {
                            System.out.println("[" + (i + 1) + "] " + clientes.get(i).getNombre());
                        }

                        System.out.print("Ingrese opción (1-" + clientes.size() + "): ");
                        int seleccion = entrada.nextInt();

                        if (seleccion >= 1 && seleccion <= clientes.size()) {
                            Cliente clienteSeleccionado = clientes.get(seleccion - 1);
                            PlanEntrenamiento plan = gpPlan.crearPlanEntrenamiento();
                            clienteSeleccionado.asignarPlan(plan);

                            if (entrenador != null) {
                                entrenador.asignarCliente(clienteSeleccionado);
                            }

                            System.out.println("Plan asignado al cliente: " + clienteSeleccionado.getNombre());
                            }else {
                                System.out.println("Opción inválida.");
                            }
                    }
                    break;
                case 3:
                    entrenador = ge.crearEntrenador();;
                    for (Cliente c : clientes){
                        entrenador.asignarCliente(c);
                    }
                    break;
                case 4:
                    Producto producto = gp.crearProducto();;
                    break;
                case 5:
                    Servicio servicio = gs.crearServicio();
                    break;
                case 6: 
                    Empleado empleado = gEmpleado.crearEmpleado();
                    break;
                case 7:
                    if (entrenador != null){
                        entrenador.consultarPlanesClientes();
                    }else{
                        System.out.println("No hay entrenadores registrados");
                    }
                    break;
                case 8:
                    System.out.println("Saliendo del sistema...");
                default:
                    System.out.println("Valor invalido, ingrese un valor correcto");
            }
        } while (op != 9);
    }   
        
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("");
        menu();
    }
}

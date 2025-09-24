/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Util.Lectura;
import Model.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alima
 */
public class GestionarCliente {

    private Lectura lectura = new Lectura();
    private List<Cliente> clientes;

    public GestionarCliente() {
        clientes = new ArrayList<>();
    }

    public Cliente crearCliente() {
        Cliente cliente = new Cliente();
        System.out.println("A continuacion los datos del cliente:");
        cliente.setIdentificación(lectura.leerInt("Identificacion: "));
        cliente.setNombre(lectura.leerString("Nombre: "));
        cliente.setTelefono(lectura.leerLong("Telefono: "));
        cliente.setDirección(lectura.leerString("Dirección: "));
        cliente.setSaldoPendiente(90000);
        cliente.setEstratoSE(lectura.leerInt("Estrato: "));
        cliente.setPracticaActividadFisica(lectura.leerBoolean("Practiva actividad fisica?(True/False)"));
        cliente.setActividadFisica(lectura.leerString("Realiza actividad fisica? (S/N):"));
        cliente.setCantidadAFMinutos(lectura.leerInt("Si realiza actividad fisica, ¿Cuantos minutos a la semana?:"));
        var mostrarCliente = cliente.toString();
        System.out.println(mostrarCliente);
        return cliente;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente agregado correctamente");
    }

    public Cliente buscarCliente(int id) {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return null;
        } else {
            for (Cliente cliente : clientes) {
                if (cliente.getIdentificación() == id) {
                    return cliente;
                }
            }
        }
        return null;
    }

    public void consultarEstadoCuenta(int id) {
        Cliente cliente = buscarCliente(id);
        if (cliente != null){
            cliente.consultarEstadoCuenta();
        }else{
            System.out.println("Cliente no encontrado");
        }
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}

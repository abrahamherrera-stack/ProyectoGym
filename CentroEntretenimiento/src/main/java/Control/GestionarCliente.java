/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;
import Util.Lectura;
import Model.Cliente;

/**
 *
 * @author Alima
 */
public class GestionarCliente {
    private Lectura lectura = new Lectura();
    
    public Cliente crearCliente(){
        Cliente cliente = new Cliente();
        System.out.println("A continuacion los datos del cliente:");
        cliente.setIdentificación(lectura.leerInt("Identificacion: "));
        cliente.setNombre(lectura.leerString("Nombre: "));
        cliente.setTelefono(lectura.leerLong("Telefono: "));
        cliente.setDirección(lectura.leerString("Dirección: "));
        cliente.setEstratoSE(lectura.leerInt("Estrato: "));
        cliente.setPracticaActividadFisica(lectura.leerBoolean("Practiva actividad fisica?(True/False)"));
        cliente.setActividadFisica(lectura.leerString("Realiza actividad fisica? (S/N):"));
        cliente.setCantidadAFMinutos(lectura.leerInt("Si realiza actividad fisica, ¿Cuantos minutos a la semana?:"));
        //var mostrarCliente = cliente.toString();
        //System.out.println(mostrarCliente);
        return cliente;
    }
    
    
}

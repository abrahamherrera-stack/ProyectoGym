/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.ArqueoCaja;
import Model.Cliente;
import Model.Empleado;
import Util.Lectura;
import java.time.LocalDate;
import java.util.List;
/**
 *
 * @author Alima
 */
public class GestionarEmpleados {
    private Lectura lectura = new Lectura();
    public Empleado crearEmpleado(){
        Empleado empleado = new Empleado();
        System.out.println("A continuacion los datos del empleado:");
        empleado.setIdentificación(lectura.leerInt("Identificacion"));
        empleado.setNombre(lectura.leerString("Nombre"));
        empleado.setDirección(lectura.leerString("Dirección: "));
        empleado.setTelefono(lectura.leerInt("Telefono"));
        empleado.setAntiguedad(lectura.leerInt("Numero de años en la empresa"));
        empleado.setCargo(lectura.leerString("Cargo en la empresa"));
        return empleado;
    }
    public void realizarArqueoCaja(float base, List<Cliente>clientes){
        ArqueoCaja arqueoCaja = new ArqueoCaja(base); 
        
        for(Cliente cliente:clientes){
            if (cliente.getFechaPago() != null && cliente.getFechaPago().equals(LocalDate.now())){
                arqueoCaja.agregarPago(cliente);
            }
        }
        arqueoCaja.mostrarArqueoCaja();
    }
}

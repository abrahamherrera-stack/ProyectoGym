/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Abraham
 */
public class Entrenador extends Empleado{
    private List<PlanEntrenamiento>planes;
    private Set<Cliente>clientes;

    public Entrenador() {
    }

    public Entrenador(List<PlanEntrenamiento> planes,List<Cliente>clientes, int salario, int antiguedad, String cargo, int identificación, String nombre, String dirección, int telefono) {
        super(salario, antiguedad, cargo, identificación, nombre, dirección, telefono);
        this.planes = planes;
        this.clientes = new HashSet<>();
    }

    public Entrenador(List<PlanEntrenamiento> planes, int identificación, String nombre, String dirección, int telefono) {
        super(identificación, nombre, dirección, telefono);
        this.planes = new ArrayList<>();
    }
    
    public void crearPlanEntrenamiento(String objetivo, boolean actividadFisica, float peso,String descripcion){
        PlanEntrenamiento plan = new PlanEntrenamiento(objetivo,actividadFisica, peso, descripcion);
        planes.add(plan);
        if (this.planes == null) {
            this.planes = new ArrayList<>();
        }
        this.planes.add(plan);
        System.out.println("Plan asignado correctamente");
    }
    
    public void consultarPalnes(){
        if(planes.isEmpty()){
            System.out.print("No hay planes registrados");
        }else{
            for(PlanEntrenamiento plan:planes){
                System.out.print("Plan: " + plan);
            }
        }
    }
    
    public void asignarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente asignado correctamente");
    }
    
    public void consultarCliente(){
        if (clientes.isEmpty()){
            System.out.println("El entrenador no tiene clientes");
        }else{
            for (Cliente cliente : clientes){
                System.out.println("cliente: " + cliente.getNombre());
            }
        }
    }
    
     public void consultarPlanesClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Este entrenador no tiene clientes");
        } else {
            System.out.println("Clientes del entenador: " + getNombre());
            for (Cliente cliente : clientes) {
                System.out.println("Cliente: " + cliente.getNombre());
                cliente.consultarPlanes();
                System.out.println("------------------");
            }
        }
    }
    
     @Override
    public String toString() {
        return "Entrenador{" +
                "id=" + getIdentificación() +
                ", nombre='" + getNombre() + '\'' +
                ", direccion='" + getDirección() + '\'' +
                ", telefono=" + getTelefono() +
                ", cargo='" + getCargo() + '\'' +
                ", salario=" + getSalario() +
                ", antiguedad=" + getAntiguedad() +
                ", planes=" + planes.size() +
                '}';
    }
}

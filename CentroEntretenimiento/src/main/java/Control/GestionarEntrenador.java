/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.Cliente;
import Model.Entrenador;
import Model.PlanEntrenamiento;
import Util.Lectura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham
 */
public class GestionarEntrenador {
    private List<Entrenador> entrenadores;
    private Lectura lectura;
   
        public GestionarEntrenador() {
        this.entrenadores = new ArrayList<>();
        this.lectura = new Lectura();
    }
    
        public Entrenador crearEntrenador(){
             System.out.println("=== Registro de Entrenador ===");

        String nombre = lectura.leerString("Nombre: ");
        int identificacion = lectura.leerInt("Identificación: ");
        String direccion = lectura.leerString("Dirección: ");
        int telefono = lectura.leerLong("Teléfono: ");
        String cargo = lectura.leerString("Cargo: ");
        int salario = lectura.leerInt("Salario: ");
        int antiguedad = lectura.leerInt("Ingrese antigüedad(años): ");
        
        Entrenador entrenador = new Entrenador(new ArrayList<>(),new ArrayList<>(),salario, antiguedad, cargo,identificacion, nombre, direccion, telefono );
        
        entrenadores.add(entrenador);
        System.out.println("Entrenador registrado con éxito: " + entrenador.getNombre());
        var mostrarEntrenador = entrenador.toString();
        System.out.println(mostrarEntrenador);
        return entrenador;
    }
         public void listarEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("⚠ No hay entrenadores registrados.");
        } else {
            System.out.println("=== Lista de Entrenadores ===");
            for (Entrenador entrenador : entrenadores) {
                System.out.println("- " + entrenador.getNombre());
            }
        }
    }

    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }
}

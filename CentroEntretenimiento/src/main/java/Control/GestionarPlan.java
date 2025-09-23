/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Model.PlanEntrenamiento;
import Util.Lectura;

/**
 *
 * @author Abraham
 */
public class GestionarPlan {
    private Lectura lectura = new Lectura();

    public PlanEntrenamiento crearPlanEntrenamiento() {
        System.out.println("Creacion plan de entrenamiento: ");
        String objetivo = lectura.leerString("Ingrese el objetivo del plan(Bajar peso, tonificar,etc):");
        float peso = lectura.leerFloat("Ingrese el peso del cliente: ");
        boolean practica = lectura.leerBoolean("¿Practica actividad fisica?(True/False): ");
        String descripcion = lectura.leerString("Descripcion del plan: ");
        
        PlanEntrenamiento plan = new PlanEntrenamiento(objetivo, practica, peso, descripcion);
        //var mostrarPlan = plan.toString();
        //System.out.println(mostrarPlan);
        return plan;
        
    }
}

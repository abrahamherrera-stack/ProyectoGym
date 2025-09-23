/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Abraham
 */
public class PlanEntrenamiento {
    private String objetivo;
    private String descripcion;
    private boolean actividadFisica;
    private float pesoInicial;
    private final int duracionDias = 30;

    public PlanEntrenamiento() {
    }

    public PlanEntrenamiento(String objetivo, boolean actividadFisica, float pesoInicial,String descripcion) {
        this.objetivo = objetivo;
        this.actividadFisica = actividadFisica;
        this.pesoInicial = pesoInicial;
        this.descripcion = descripcion;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    
    public void setActividadFisica(boolean actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public void setPesoInicial(float PesoInicial) {
        this.pesoInicial = PesoInicial;
    }

    public boolean getActividadFisica() {
        return actividadFisica;
    }

    public float getPesoInicial() {
        return pesoInicial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlanEntrenamiento{");
        sb.append("objetivo=").append(objetivo);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", actividadFisica=").append(actividadFisica);
        sb.append(", PesoInicial=").append(pesoInicial);
        sb.append(", duracionDias=").append(duracionDias);
        sb.append('}');
        return sb.toString();
    }
}

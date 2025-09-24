/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Control.Pago;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alima
 */
public class Cliente extends Persona implements Pago {

    private int estratoSE;
    private String trabajaEn;
    private Boolean practicaActividadFisica;
    private String actividadFisica;
    private int cantidadAFMinutos;
    private List<PlanEntrenamiento> planes;
    private float saldoPendiente;
    private boolean accesoPermitido;

    public Cliente() {
    }

    public Cliente(int estratoSE, String trabajaEn, Boolean practicaActividadFisica, String actividadFisica, int cantidadAFMinutos, int identificación, String nombre, String dirección, int telefono) {
        super(identificación, nombre, dirección, telefono);
        this.estratoSE = estratoSE;
        this.trabajaEn = trabajaEn;
        this.practicaActividadFisica = practicaActividadFisica;
        this.actividadFisica = actividadFisica;
        this.cantidadAFMinutos = cantidadAFMinutos;
        this.planes = new ArrayList<>();
        this.saldoPendiente = 90000;
        this.accesoPermitido = false;
    }

    public boolean isAccesoPermitido() {
        return accesoPermitido;
    }

    public void setAccesoPermitido(boolean accesoPermitido) {
        this.accesoPermitido = accesoPermitido;
    }

    public int getEstratoSE() {
        return estratoSE;
    }

    public float getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(float saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public void setEstratoSE(int estratoSE) {
        this.estratoSE = estratoSE;
    }

    public String getTrabajaEn() {
        return trabajaEn;
    }

    public void setPlanes(List<PlanEntrenamiento> planes) {
        this.planes = planes;
    }

    public void setTrabajaEn(String trabajaEn) {
        this.trabajaEn = trabajaEn;
    }

    public Boolean getPracticaActividadFisica() {
        return practicaActividadFisica;
    }

    public void setPracticaActividadFisica(Boolean practicaActividadFisica) {
        this.practicaActividadFisica = practicaActividadFisica;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public int getCantidadAFMinutos() {
        return cantidadAFMinutos;
    }

    public List<PlanEntrenamiento> getPlanes() {
        return planes;
    }

    public void setCantidadAFMinutos(int cantidadAFMinutos) {
        this.cantidadAFMinutos = cantidadAFMinutos;
    }

    public void asignarPlan(PlanEntrenamiento plan) {
        if (this.planes == null) {
            this.planes = new ArrayList<>();
        }
        this.planes.add(plan);
        System.out.println("Plan asignado correctamente");
    }

    public void consultarPlanes() {
        if (planes == null || planes.isEmpty()) {
            System.out.println("El cliente " + getNombre() + " no tiene planes");
        } else {
            for (PlanEntrenamiento plan : planes) {
                System.out.println("El cliente " + getNombre() + " Tiene el sigueinte plan: " + plan);
            }
        }
    }

    public void consultarEstadoCuenta() {
        System.out.println("cliente: " + getNombre());
        if (this.saldoPendiente == 0) {
            System.out.println("El cliente tiene la cuenta al día");
        } else {
            System.out.println("La cuenta no se encunetra al día");
            System.out.println("saldo pendiente: $" + this.saldoPendiente);
        }
    }

    @Override
    public void pagoEfectivo() {
        if (this.saldoPendiente > 0) {
            this.saldoPendiente = 0;
            this.accesoPermitido = true;
            System.out.println("Pago en efectivo realizado correctamente. Ya puede ingresar");
        } else {
            System.out.println("No tiene saldo pendiente");
        }
    }

    @Override
    public void pagoCheque() {
        if (this.saldoPendiente > 0) {
            this.saldoPendiente = 0;
            this.accesoPermitido = true;
            System.out.println("Pago con cheque realizado correctamente. Ya puede ingresar");
        } else {
            System.out.println("No tiene saldo pendiente");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("estratoSE=").append(estratoSE);
        sb.append(", trabajaEn=").append(trabajaEn);
        sb.append(", practicaActividadFisica=").append(practicaActividadFisica);
        sb.append(", actividadFisica=").append(actividadFisica);
        sb.append(", cantidadAFMinutos=").append(cantidadAFMinutos);
        sb.append(", planes=").append(planes);
        sb.append(", saldoPendiente=").append(saldoPendiente);
        sb.append(", accesoPermitido=").append(accesoPermitido);
        sb.append('}');
        return sb.toString();
    }

}

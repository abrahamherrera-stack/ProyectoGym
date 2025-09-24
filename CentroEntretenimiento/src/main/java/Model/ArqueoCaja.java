/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abraham
 */
public class ArqueoCaja {

    private LocalDate fecha;
    private float baseCaja;
    private float totalRecaudado;
    private float totalFinal;
    private List<Cliente> clientesPagaron;

    public ArqueoCaja() {
    }

    public ArqueoCaja(float baseCaja) {
        this.fecha = LocalDate.now();
        this.baseCaja = baseCaja;
        this.totalRecaudado = 0;
        this.totalFinal = 0;
        this.clientesPagaron = new ArrayList<>();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public float getBaseCaja() {
        return baseCaja;
    }

    public float getTotalRecaudado() {
        return totalRecaudado;
    }

    public float getTotalFinal() {
        return totalFinal;
    }

    public List<Cliente> getClientesPagaron() {
        return clientesPagaron;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setBaseCaja(float baseCaja) {
        this.baseCaja = baseCaja;
    }

    public void setTotalRecaudado(float totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public void setTotalFinal(float totalFinal) {
        this.totalFinal = totalFinal;
    }

    public void setClientesPagaron(List<Cliente> clientesPagaron) {
        this.clientesPagaron = clientesPagaron;
    }
    
    
    public void agregarPago(Cliente cliente){
        this.totalRecaudado += 90000;
        this.clientesPagaron.add(cliente);
        this.totalFinal = baseCaja + totalRecaudado;
    }
    public void mostrarArqueoCaja(){
        System.out.println("---- Arqueo caja --" + fecha + " ----");
        System.out.printf("""
                        base inicial: $%f
                        Total recaudado: %f
                        Total final en caja: %f
                        \n---- Pagos registrados ---
                           """,this.baseCaja, this.totalRecaudado, this.totalFinal);
        for (Cliente cliente : clientesPagaron){
            System.out.println("Fecha de pago: " + cliente.getFechaPago() + "\n"+
                               "Cliente : " + cliente.getNombre()+ "\n" +
                               "Metodo de pago: " + cliente.getMetodoPgago());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArqueoCaja{");
        sb.append("fecha=").append(fecha);
        sb.append(", baseCaja=").append(baseCaja);
        sb.append(", totalRecaudado=").append(totalRecaudado);
        sb.append(", totalFinal=").append(totalFinal);
        sb.append(", clientesPagaron=").append(clientesPagaron);
        sb.append('}');
        return sb.toString();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author Alima
 */
public class Factura implements Pago {
    @Override
    public void pagoEfectivo(){
        System.out.println("Ingrese el valor a pagar: ");
    }
    @Override
    public void pagoCheque(){
        System.out.println("Banco del cheque:");
        System.out.println("Numero: ");
    }

    @Override
    public void pagoDebito() {
    }

    @Override
    public void pagoCredito(){
        
    }
}    

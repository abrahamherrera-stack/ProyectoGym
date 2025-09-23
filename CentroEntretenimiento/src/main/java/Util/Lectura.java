/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.util.*;

/**
 *
 * @author Ali
 */
public class Lectura {
    private Scanner entrada = new Scanner(System.in);
    
    public int leerInt(String mensaje){
        System.out.print(""+mensaje);
        return Integer.parseInt(entrada.nextLine().trim());
    }
    
        public int leerLong(String mensaje){
        System.out.print(""+mensaje);
        return (int)Long.parseLong(entrada.nextLine().trim());
    }

    public String leerString(String mensaje){
        System.out.print(""+mensaje);
        return entrada.nextLine().trim();
    }
    
    public float leerFloat(String mensaje){
        System.out.print(""+mensaje);
        return Float.parseFloat(entrada.nextLine().trim());
    }
    public Boolean leerBoolean(String mensaje){
        System.out.print(""+mensaje);
        return Boolean.valueOf(entrada.nextLine().trim());  
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author jchavezc1000
 */
public class Principal {
    
    public static void main (String[] args){
        Trabajador trabajador = new Trabajador("Juan", "456");
        Empleado empleador = new Empleado("Jose", "123", 24000.0);
        Consultor consultorext = new Consultor("Juan", "456", 10, 50.0);
        //Salida estándar con toString()
        System.out.println(trabajador);
        System.out.println(empleador);
        System.out.println(consultorext);
        
        //Comparación con equals()
        System.out.println(trabajador.equals(empleador));
        System.out.println(trabajador.equals(consultorext));
    }
}

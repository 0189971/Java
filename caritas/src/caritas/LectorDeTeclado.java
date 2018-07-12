/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caritas;

import java.util.Scanner;

/**
 *
 * @author sdelaot
 */
public class LectorDeTeclado {
    private int entero;
    private float flotante;
    private double dobleFlotante;
    private String linea;
    private char caracter;
    public int leerEntero() {
        System.out.print( " Introduzca un numero entero: " );
        Scanner teclado = new Scanner( System.in );
        entero = teclado.nextInt();
        return entero;
    }
    public float leerFlotante() {
        flotante = Float.parseFloat( 
            leerLinea( " Introduzca un numero flotante " ) );
        return flotante;
    }
    public double leerFlotanteDoble() {
        dobleFlotante = Double.parseDouble( 
            leerLinea( " Introduzca un numero floante doble" ) );
        return dobleFlotante;
    }
    public String leerLinea( String mensaje ) {
        System.out.print( mensaje + ": " );
        Scanner teclado = new Scanner( System.in );
        linea = teclado.nextLine();
        return linea;
    }
}

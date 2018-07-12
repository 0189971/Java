/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;
/**
 *
 * @author sdelaot
 */
import javax.swing.*;
/** 
 * Un programa que muestra el seguimiento 
 * de una llamada a un método recursivo.
 */
public class ProbadorDeTrazadoDePila {
    public static void main( String[] args ) {
        String entrada = JOptionPane.showInputDialog( 
                " Introduzca el valor de n:" );
        int n;
        Factorial factorial;
        try {
            n = Integer.parseInt( entrada );
            factorial = new Factorial();
            factorial.calcularFactorial( n );
        } catch( NumberFormatException nfe ) {
            nfe.printStackTrace();
        } finally {
            n = 10;
            factorial = new Factorial();
            factorial.calcularFactorial( n );
        }
        System.out.println( "Termino el programa" );
        System.exit( 0 );
    }
}

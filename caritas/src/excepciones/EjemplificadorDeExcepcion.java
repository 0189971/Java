/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

class Excepcion {
    public Excepcion() {
    
    }
    public int dividir( int a, int b ) {
        return a / b;
    }
    public void imprimirElementoDeArreglo( int [] arreglo, int cual ) {
        System.out.println( arreglo[cual] );
    }
    public void imprimirElementoDeArreglo( int [] arreglo ) {
        for( int n=0; n<arreglo.length; n++ ) {
            System.out.println( arreglo[n] );
            }
    }
}

/**
 *
 * @author sdelaot
 */
public class EjemplificadorDeExcepcion {
    public static void main( String [] args ) {
        int a = 10;
        int b = 0;
        Excepcion e = new Excepcion();
        //System.out.println( a + " / " + b + " = " + e.dividir( a, b ) );
        int [] arreglo = {
            10, 5, 27, 300, 46, 34, -100
            };
        int [] otroArreglo = null;
        //e.imprimirElementoDeArreglo( arreglo, a );
        //e.imprimirElementoDeArreglo( arreglo, -1 );
        e.imprimirElementoDeArreglo( otroArreglo );
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 * @author sdelaot
 */
public class Q {
    private int valor;
    boolean tomaValor = false;
    synchronized int get() {
        if( !tomaValor ) {
            try {
                wait();
            } catch( InterruptedException e ) {
                System.out.println( "Captura la excepción InterruptedException" );
            }
            }
        System.out.println( "Consume : " + valor );
        tomaValor = false;
        notify(); 
        return valor;
    }
    synchronized void put( int n ) {
        if( tomaValor ) {
            try {
                wait();
                } catch( InterruptedException e ) {
                    System.out.println( "Captura la excepción InterruptedException" );
                }
            } 
        this.valor = n;
        tomaValor = true; 
        System.out.println( "Produce : " + valor );
        notify();
   }
}
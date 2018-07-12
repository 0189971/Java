/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public class Llamame {
    // primera forma de sincronizar
    public 
    //synchronized 
    void llamando( String mensaje ) {
        System.out.print( "[" + mensaje );
        try {
            Thread.sleep( 1000 );
        } catch( InterruptedException e ) {
            System.out.println( "Interrumpido" );
        }
        System.out.println( "]" );
    }
}

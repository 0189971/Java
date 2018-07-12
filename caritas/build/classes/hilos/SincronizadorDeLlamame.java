/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public class SincronizadorDeLlamame {
    public static void main( String [] args ) {
        Llamame llamando = new Llamame();
        ElQueLlama hola = new ElQueLlama( llamando, "Hola" );
        ElQueLlama mundo = new ElQueLlama( llamando, "Mundo" );
        ElQueLlama java = new ElQueLlama( llamando, "Java" );
        hola.start();
        hola.setPrioridad( 4 );
        mundo.start();
        mundo.setPrioridad( 10 );
        java.setPrioridad( 1 );
        try {
            mundo.join();
            hola.join();
            java.start();
            java.join();
        } catch( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public class MiHiloHerencia extends Thread {
    private int idDeHilo;
    private int contador;
    public MiHiloHerencia( int id ) {
        super( "Hilo heredado" );
        idDeHilo = id;
    }
    @Override
    public void run() {
        try {
            for( contador=5; contador>=0; contador-- ) {
                System.out.println( idDeHilo + ") " + 
                        getName() + " : " + contador );
                Thread.sleep( 1000 );
                }
        }catch( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }
}

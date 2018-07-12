/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public class ProbadorDeHilos {
    public static void main( String [] args ) {
        MiHiloEmulado me1 = new MiHiloEmulado( 1 );
        MiHiloEmulado me2 = new MiHiloEmulado( 2 );
        MiHiloEmulado me3 = new MiHiloEmulado( 3 );
        
        MiHiloHerencia mh1 = new MiHiloHerencia( 1 );
        MiHiloHerencia mh2 = new MiHiloHerencia( 2 );
        MiHiloHerencia mh3 = new MiHiloHerencia( 3 );
        
        Thread principal = Thread.currentThread();
        System.out.println( principal.getName() );
        principal.setName( "Hilo principal" );
        System.out.println( principal.getName() );
        me1.start();
        me2.start();
        me3.start();
        mh1.start();
        mh2.start();
        mh3.start();
        try {
            for( int contador=5; contador>=0; contador-- ) {
                System.out.println( 
                        principal.getName() + " : " + contador );
                Thread.sleep( 500 );
                }
        }catch( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }
}

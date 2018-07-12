/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author sdelaot
 */
public class MedidorDeTiempo implements Runnable {
    private Thread unHilo;
    private int tiempo;
    public MedidorDeTiempo() {
        this( 5 );
    }
    public MedidorDeTiempo( int tiempo ) {
        this.tiempo = tiempo;
        unHilo = new Thread( this, "Tiempo" );
    }
    public MedidorDeTiempo( MedidorDeTiempo medidor ) {
        this.tiempo = medidor.tiempo;
    }
    public void start() {
        unHilo.start();
    }
    @Override
    public void run() {
        try {
                Thread.sleep(tiempo*100);
            } catch( InterruptedException ie ) {
                ie.printStackTrace();
            }
        System.out.println( " Tiempo de calentamiento " + tiempo );
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public  class ElQueLlama implements Runnable {
    private String mensaje;
    private Llamame destino;
    private Thread t;
    public ElQueLlama( Llamame dest, String s ) {
        destino = dest;
         mensaje = s;
         t = new Thread( this );
    }
    public void start() {
        t.start();
    }
    public void join() throws InterruptedException {
        try {
            t.join();
        } catch( InterruptedException ie ) {
            System.out.println( ie.getMessage() );
        }
    }
    @Override
    public void run() {
        //synchronized( destino ) {
            destino.llamando( mensaje );
        //    }
    }
    public void setPrioridad( int prioridad ) {
        if( prioridad<1 ) {
            t.setPriority( 1 );
            }
        if( prioridad>10 ) {
            t.setPriority( 10 );
            }
        t.setPriority( prioridad );
    }
}

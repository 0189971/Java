/*
 * Paquete al que pertenece la clase.
 */
package hilos;
/**
 * @author sdelaot
 */
public  class Productor implements Runnable {
    private Q q;
    private Thread hiloProductor;
    public Productor( Q q ) {
        this.q = q;
        hiloProductor = new Thread( this, "Productor" );
    }
    public void start() {
        hiloProductor.start();
    }
    @Override
    public void run() {
        int i = 0;
        while( true ) {
            q.put( i );
            i++;
            if( i==10 ) {
                break;
                }
            }
    }
}
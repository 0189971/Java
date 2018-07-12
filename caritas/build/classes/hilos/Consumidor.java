/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;
/**
 * @author sdelaot
 */
public class Consumidor implements Runnable {
    private Q q;
    private Thread hiloConsumidor;
    public Consumidor( Q q ) {
        this.q = q;
        hiloConsumidor = new Thread( this, "Consumidor" );
    }
    public void start() {
        hiloConsumidor.start();
    }
    @Override
    public void run() {
        int i = 0;
        while( true ) {
            q.get();
            i++;
            if( i==10 ) {
                break;
                }
            }
    }
}

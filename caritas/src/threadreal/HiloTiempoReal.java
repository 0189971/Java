/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadreal;

import javax.realtime.RealtimeThread;

/**
 *
 * @author sdelaot
 */
public class HiloTiempoReal extends RealtimeThread {
    public void run() {
        for( int n=100000; n>=0; n-- ) {
            System.out.println( n + ") " + this.getName() );
            }
    }
    public static void main(String[] args) {
        new HiloTiempoReal().start();
    }
}

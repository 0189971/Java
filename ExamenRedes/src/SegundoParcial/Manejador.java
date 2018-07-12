
package SegundoParcial;

import java.net.Socket;
import java.util.concurrent.Semaphore;

/**
 *
 * @author javis
 */
public class Manejador extends Thread{
    Semaphore s;
    Socket cl;
        public Manejador(Socket cl,Semaphore s){
            this.cl=cl;
            this.s=s;
        }
    public void run(){
        //Nos preparamos para ver que hilo va a tener el control
        
    }
    
}

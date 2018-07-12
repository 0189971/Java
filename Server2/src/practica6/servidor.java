package practica6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Semaphore;



/**
 *
 * @author javis
 */
public class servidor {
    public static final int PUERTO = 8000;
    ServerSocket ss;
    
    
        public servidor() throws IOException, InterruptedException{
            System.out.println("Iniciando Servidor.......");
            this.ss = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado:---OK");
            System.out.println("Esperando por Cliente....");
            Semaphore web=new Semaphore(10);
            for(int i=0;i<100;i++){
                Socket ace=ss.accept();
                    Manejador c=new Manejador(ace, web);
                    c.start();
                    System.out.println("El hilo esta vivo:---------------------------------------------"+c.isAlive()+" - - "+c.getId());  
                    try{
                    Thread.sleep(1000);
                    }catch(Exception e){}
                    c.join();
            }
        } 
    
    public static void main(String[] args) throws Exception{
           servidor cl=new servidor();                
    }
    
 
}

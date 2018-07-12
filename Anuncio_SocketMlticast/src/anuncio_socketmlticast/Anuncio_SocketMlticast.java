
package anuncio_socketmlticast;

import java.io.*;
import java.net.*;


public class Anuncio_SocketMlticast {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MulticastSocket s=null;
        InetAddress gpo=null;
        
            try{
                s=new MulticastSocket(9001);
                s.setTimeToLive(125);
                s.setReuseAddress(true);
                String dir="228.1.1.1";
                
                    try{
                        gpo=InetAddress.getByName(dir);
                    }catch(UnknownHostException a){
                        a.printStackTrace();
                        System.exit(1);
                    }
                s.joinGroup(gpo);
                System.out.println("Comienza el envio de anuncios...");
                
                for(;;){
                    String msj="mensaje";
                    byte[] b=msj.getBytes();
                    
                    DatagramPacket p= new DatagramPacket(b,b.length,gpo,9001);
                    s.send(p);
                    
                    try{
                    Thread.sleep(5000);
                    }catch(Exception e){
                    e.printStackTrace();
                    }
                
                }   
            }catch(Exception e){
            e.printStackTrace();
            }    
    }
}

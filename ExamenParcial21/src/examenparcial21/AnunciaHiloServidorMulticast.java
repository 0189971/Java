package examenparcial21;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author javis
 */
public class AnunciaHiloServidorMulticast extends Thread{
    private int pto;
    String anuncia;
    String url;
        public AnunciaHiloServidorMulticast(int pto, String anumcia, String url){ //Necesitamos anunciar el puerto del servidor de flujo
            this.pto=pto;
            this.anuncia=anumcia;
            this.url=url;
        }
    public void run(){
                InetAddress gpo=null;
        try{
            MulticastSocket s= new MulticastSocket(pto);
            s.setReuseAddress(true);
            s.setTimeToLive(125);
            String msj=anuncia+url;      //Enviamos el puerto del servidor
            String msj2=url;
            String msj3=anuncia;
            System.out.println("El mensaje a enviar es: "+msj);
            System.out.println("La url es: "+msj2);
            byte[] b = msj.getBytes();
            byte[] c = msj2.getBytes();
            byte[] d = msj3.getBytes();
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            s.joinGroup(gpo);
            for(;;){
                DatagramPacket p = new DatagramPacket(b,b.length,gpo,9999);
                s.send(p);
                DatagramPacket p1 = new DatagramPacket(c,c.length,gpo,9999);
                s.send(p1);
                DatagramPacket p2 = new DatagramPacket(d,d.length,gpo,9999);
                s.send(p2);
                //System.out.println("Enviando mensaje "+msj+ " con un TTL= "+ s.getTimeToLive());
                try{
                    Thread.sleep(2000);
                }catch(InterruptedException ie){}
            }//for
        }catch(Exception e){
            
        }//catch
    
    }
    
    
    
    
    
}

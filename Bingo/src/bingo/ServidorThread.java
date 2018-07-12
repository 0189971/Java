package bingo;
import java.io.*;
import java.net.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Yuca
 */
public class ServidorThread extends Thread {
    private Socket s;
    private ServerSocket ss;
    int i=0;
    int cont=0;
    int win=0;
    int[] numerosrand={};
    String msj ="";
    
    ObjectOutputStream salida;
    ObjectInputStream entrada;
    MulticastSocket ms=null;
    InetAddress gpo=null;
    
    public ServidorThread(){
            try{
            ss= new ServerSocket(1234);
//            ms = new MulticastSocket(9000);
//            ms.setTimeToLive(128);
//            ms.setReuseAddress(true);
//            String dir = "227.1.2.3";
//            
//             try{
//                gpo=InetAddress.getByName(dir);               
//            }catch(UnknownHostException u){
//                u.printStackTrace();
//                System.exit(1);
//            }
     
//       isr = new InputStreamReader(s.getInputStream());
//       br = new BufferedReader(isr); 
//       dos = new DataOutputStream(s.getOutputStream());
       }catch(Exception e){
           System.out.println("No funcionaaaaaaa");
           e.printStackTrace();
       }
    }
    
//    public void numerosRandom(){
//        int random=0;
//        Random rand = new Random();
//       
//        for (int i = 0; i <16; i++) {
//            random =(int)(rand.nextDouble()*99+0);
//            numerosrand[i]=random;
//            
//    
//            
//            System.out.println(""+random);
//        }
//    }

 public void run() {
     try{
            System.out.println("Servicio iniciado...Esperando cliente");   
            for(;;){
            s = ss.accept();
            System.out.println("Cliente conectado desde"+s.getInetAddress()+":"+s.getPort());
            cont++;
            System.out.println("Clientes conectados: "+cont);
           // numerosRandom();
             int unicos[]= NumSinRepeticion(16);
                for (int i = 0; i < 16; i++) {
                        System.out.println("Num gen enviado "+unicos[i]);
                }
          
            salida = new ObjectOutputStream(s.getOutputStream());
//          entrada = new ObjectInputStream(s.getInputStream());
            salida.writeObject(unicos);      
            
            if(cont==3){
                try{
                ms = new MulticastSocket(9000);
                ms.setTimeToLive(128);
                ms.setReuseAddress(true);
                String dir = "227.1.2.3";

                 try{
                    gpo=InetAddress.getByName(dir);               
                }catch(UnknownHostException u){
                    u.printStackTrace();
                    System.exit(1);
                }
                
                ms.joinGroup(gpo);
                System.out.println("Comienzan numeroos...");
                int num[] = NumSinRepeticion(99); //arreglo de tamaño 99
                   try{
                        Thread.sleep(5000);
                    }catch(InterruptedException ie){
                    }
                   
                for(;;){
                    if(i<99){
                        msj=""+num[i];
          
                        byte[]b=msj.getBytes();
                        DatagramPacket p = new DatagramPacket(b,b.length,gpo,9001);
                        ms.send(p);
                        System.out.println(i+" :"+"Se ha enviado... "+num[i]);
                    }
                    try{
                        Thread.sleep(250);
                    }catch(InterruptedException ie){
                    }
                    byte[] b2 = new byte[256];
                    DatagramPacket p2 = new DatagramPacket(b2, b2.length);
                    ms.receive(p2); 
                    String data = new String (p2.getData(),0,p2.getLength());
                    //System.out.println("Palabra recibida: "+data);
                    if(data.toLowerCase().indexOf("-")>=0){
                            win++;
                            System.out.println("El jugador"+data+ "-ah ganado en la posicon no. "+win);
                             String msj3=""+win;
                             byte[]b3=msj3.getBytes();
                             DatagramPacket p3 = new DatagramPacket(b3,b3.length,gpo,9001);
                             ms.send(p3);
//                            s.close();
//                            ss.close();
//                            ms.close();
//                            this.stop();      
//                            this.destroy();
//                            this.interrupt();
//                            System.exit(0);
//                            break;
                    }
                         i++;                  
                } 
                }catch(Exception e){
                    e.printStackTrace();
                }
                try {
                    ms.leaveGroup(gpo);
                    ms.close();
                 } catch (IOException ex) {
                       ex.printStackTrace();
                }
                }
            }
       }catch(Exception ie){
           ie.printStackTrace();
       System.out.println("Servidor no se pudo iniciar correctamente");             
       }
  }
       public int[] NumSinRepeticion(int NumRepet){
        int numeros[] = new int[NumRepet];
        for (int i = 0; i < NumRepet; i++) {
            numeros[i]=-1;
        }
        Random rand = new Random();
        boolean aux;
        int num = 0;
        for (int i = 0; i <NumRepet; i++) {
            aux=true;
            while(aux){
                aux=false;
                num=(int)(rand.nextDouble()*99+0);
                for (int j = 0; j<numeros.length; j++) {
                    if(numeros[j]==num){
                        aux=true;
                        break;
                    }
                }
            }
             numeros[i]=num;
        }
       return numeros;
    }
    
    
}

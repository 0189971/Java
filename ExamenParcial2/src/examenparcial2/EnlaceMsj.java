package examenparcial2;

import java.io.File;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author javis
 */
public class EnlaceMsj extends Thread{
    public String msj ="";
    public String msj2="";
    public int con=4;
    ArrayList<String> List = new ArrayList<String>();
            public EnlaceMsj(){
            
            }
    
    public void run(){
        InetAddress gpo=null;        
        try{
            MulticastSocket s= new MulticastSocket();
            s.setReuseAddress(true);
            s.setTimeToLive(128);
            
            System.out.println("Iniciamos EnlaceMsj ");
            
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            s.joinGroup(gpo);
            while(true){
                //System.out.println("Enlace");
                switch(con){
                    case 1:
                        byte[] b = msj.getBytes();
                        byte[] c = msj2.getBytes();
                        DatagramPacket p = new DatagramPacket(b,b.length,gpo,10100);
                        s.send(p);   
                        DatagramPacket p1 = new DatagramPacket(c,c.length,gpo,10100);
                        s.send(p1); 
                        con=0;
                        break;
                    case 2:
                        byte[] y = msj.getBytes();
                        byte[] x= msj2.getBytes();
                        DatagramPacket p6 = new DatagramPacket(y,y.length,gpo,10100);
                        s.send(p6);   
                        DatagramPacket p7 = new DatagramPacket(x,x.length,gpo,10100);
                        s.send(p7); 
                        con=0;
                        break;
                    case 3:
                        System.out.println("Nos preparamos para listar los archivos");
                            byte[] xz= msj.getBytes();
                            DatagramPacket p10 = new DatagramPacket(xz,xz.length,gpo,10100);
                            s.send(p10);
                        con=0;    
                        break;
                    case 4:
                        String [] ficherosname = null;
                            String directorio="C:\\Users\\javis\\Documents\\NetBeansProjects\\ExamenParcial2";                                 
                                   File dir=new File(directorio);
                                   
                                    if (dir.exists()){
                                       File[] ficheros = dir.listFiles();
                                       System.out.println(ficheros.length);
                                       String llenar="4";
                                       String numficheros=String.valueOf(ficheros.length);
                                        byte []d= llenar.getBytes();
                                            DatagramPacket p2 = new DatagramPacket(d,d.length,gpo,10100);
                                            s.send(p2);
                                            System.out.println("El numero de ficheros es: "+numficheros);
                                        byte []e=numficheros.getBytes();
                                            DatagramPacket p3 = new DatagramPacket(e,e.length,gpo,10100);
                                            s.send(p3);
                                            
                                       for(int u=0;u<(ficheros.length);u++){
                                           String m=ficheros[u].getName();
                                           System.out.println(m);
                                           byte []f=m.getBytes();
                                           DatagramPacket p4 = new DatagramPacket(f,f.length,gpo,10100);
                                           s.send(p4);
                                           try{
                                            Thread.sleep(1000);
                                           }catch(Exception h){}
                                       }
                                    }
                            con=0;
                        break;
                    
                    default: 
                        break;
                }
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
            
            
    }catch(Exception e){}                
    }

    public ArrayList<String> Obtenerlista(){
    
    
        return List;
    }
    
    
}

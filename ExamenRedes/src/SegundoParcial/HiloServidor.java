package SegundoParcial;

import javax.swing.JFrame;
import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author javis
 */
public class HiloServidor extends Thread {
        private int port;
        private JFrame ventana;
        Socket cl;
        String acc="0";
        Semaphore sem= new Semaphore(3);
        
        HiloServidor(int port, JFrame ventana){
              this.port=port;
              this.ventana=ventana;
        }
    
    @Override
    public void run(){
        ServerSocket ss=null;
        
            try{
                ServerSocket s=new ServerSocket(port);
                System.out.println("Servidor iniciado... En el puerto "+port);
                int c=0;
                    
                while(true){
                    
                    cl=s.accept();
                    
                    System.out.println("hola");
                    DataInputStream dis= new DataInputStream(cl.getInputStream());
                    acc=dis.readUTF();
                    System.out.println(acc);
                    
                    switch(Integer.parseInt(acc)){
                        case 1:
                            System.out.printf("Caso 1 iniciado...\nPreparado para recibir archivos...\n");
                            String nombre;
                            long tam;
                            int porcentaje=0;
                            nombre= dis.readUTF();
                            tam= dis.readLong();
                            
                            DataOutputStream dos= new DataOutputStream(new FileOutputStream(nombre)); //String path="file:///c:\\...";
                            
                            byte[] buf= new byte[1500];
                            long recibidos=0;
                            int n=0;

                            while(recibidos<tam){
                                n=dis.read(buf);
                                dos.write(buf,0,n);
                                dos.flush();
                                recibidos=recibidos+n;
                                porcentaje=(int)((recibidos*100)/tam);
                                //System.out.println("Recibido "+porcentaje+"%");
                             }//while

                            System.out.println("Archivo recibido..");
                            //dos.close();
                            //dis.close();
                           break;
                        case 2:
                            System.out.printf("Caso 2 iniciado...\nPreparado para borrar archivos...");
                            String archivo=dis.readUTF();
                                File fichero = new File(archivo);
                                if (fichero.delete())
                                    System.out.println("El fichero ha sido borrado satisfactoriamente");
                                 else
                                    System.out.println("El fichero no puede ser borrado");
                                
                            acc="0";
                            break;
                        case 3:
                            System.out.printf("Caso 3 iniciado...\nPreparado para listar los archivos...\n");
                            String [] ficherosname = null;
                            String directorio="C:\\Users\\javis\\Documents\\NetBeansProjects\\ExamenRedes";                                 
                                   File dir=new File(directorio);
                                   if (dir.exists()){
                                       File[] ficheros = dir.listFiles();
                                       System.out.println(ficheros.length);
                                       for(int u=0;u<(ficheros.length);u++){
                                           System.out.println("Los archivos son:"+ficheros[u].getName());
                                           //ficherosname[u]=ficheros[u].getName();
                                       }
                                   }
                            //Nos preparamos para enviar los nombres de los archivos    
                            acc="0";    
                            break;
                        default:
                            
                            break;
                    } 
                }
                
            }catch(Exception e){
                System.out.println("No se realizo el bloque try");
                
                try {
                     ss.close();
                } catch (IOException ex) {
                    
                }
                
            } 
    }

}

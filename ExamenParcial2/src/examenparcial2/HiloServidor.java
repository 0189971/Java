package examenparcial2;

import javax.swing.JFrame;
import java.io.*;
import java.net.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author javis
 */
public class HiloServidor extends Thread {
        private int port;
        private JFrame ventana;
        Socket cl;
        Socket pcl;
        String acc="0";
        EnlaceMsj EnlaMsj=null;
        int enlacePto;
        Semaphore sem= new Semaphore(3);
        
        HiloServidor(int port, JFrame ventana,int enlacePto ){
              this.port=port;
              this.ventana=ventana;
              this.enlacePto=enlacePto;
        }
        
    class manejador extends Thread{
        private Semaphore se;  
        
        public manejador(int numero){
           this.se=new Semaphore(numero);
        }
        
            public void getMesa() {
            try {
                // Acquire a permit for a table
                se.acquire();       
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
            public void returnMesa() {
               se.release();
            } 
    
    }
      
    @Override
    public void run(){
        ServerSocket ss=null;
            try{
                if(EnlaMsj==null){
                    EnlaMsj= new EnlaceMsj();
                    EnlaMsj.start();
                }
            }catch(Exception e){
            }
        
            try{
                ServerSocket s=new ServerSocket(port);
                System.out.println("Servidor iniciado... En el puerto "+port);
                int c=0;
                
                    cl=s.accept();
                    cl=s.accept();
                    cl=s.accept();
                
                while(true){
                    
                    System.out.println("hola");
                    DataInputStream dis= new DataInputStream(cl.getInputStream());
                    acc=dis.readUTF();
                    System.out.println(acc);
                    
                    switch(Integer.parseInt(acc)){
                        case 1:
                            System.out.printf("Caso 1 iniciado...\nPreparado para recibir archivos...\n");
                            pcl=s.accept();
                            DataInputStream dis1= new DataInputStream(pcl.getInputStream());
                            String nombre;
                            long tam;
                            int porcentaje=0;
                            nombre= dis1.readUTF();
                            tam= dis1.readLong();
                            
                            
                            DataOutputStream dos= new DataOutputStream(new FileOutputStream(nombre)); //String path="file:///c:\\...";
                            
                            byte[] buf= new byte[1500];
                            long recibidos=0;
                            int n=0;

                            while(recibidos<tam){
                                n=dis1.read(buf);
                                dos.write(buf,0,n);
                                dos.flush();
                                recibidos=recibidos+n;
                                porcentaje=(int)((recibidos*100)/tam);
                                //System.out.println("Recibido "+porcentaje+"%");
                             }//while
                            
                            acc="0";
                            System.out.println("Archivo recibido..");
                            //dos.close();
                            //dis.close();
                            
                            EnlaMsj.msj="1";
                            EnlaMsj.msj2=nombre;
                            EnlaMsj.con=1;
                            
                           break;
                        case 2:
                            System.out.printf("Caso 2 iniciado...\nPreparado para borrar archivos...");
                            String archivo=dis.readUTF();
                            archivo=archivo.trim();
                            System.out.println(archivo);
                                File fichero = new File(""+archivo);
                                if (fichero.delete())
                                    System.out.println("El fichero ha sido borrado satisfactoriamente");
                                 else
                                    System.out.println("El fichero no puede ser borrado");
                            
                            EnlaMsj.msj="2";
                            EnlaMsj.msj2=archivo;
                            EnlaMsj.con=2;
                            acc="0";
                            break;
                        case 3:
                            System.out.printf("Caso 3 iniciado...\nPreparado para listar los archivos...\n");
                                EnlaMsj.msj="3";
                                EnlaMsj.con=3;
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
                    
                }finally{
                    sem.release();
                }
                
            } 
    }
    
    public void recibir(DataInputStream dis) throws IOException{
                            


    }
    
    
}


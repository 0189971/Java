package Servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class ControlServidor {

    public static void Recibir() throws IOException {
        try{
            ServerSocket s = new ServerSocket(9000);
            System.out.println("Servidor listo... Esperando Clientes:");
            Socket cl = s.accept();
            DataInputStream dis = new DataInputStream(cl.getInputStream());
            int n_archivos = dis.readInt();
            System.out.println("numero de archivos a recibir: " + n_archivos );
            //cl.setSoTimeout(3000);
            cl.close();
           // for(;;){
            for(int cont = 0; cont < n_archivos ; cont++){
                cl = s.accept();
                dis = new DataInputStream(cl.getInputStream());
                System.out.println("\nNo: " + (cont + 1));
                String nombre =  dis.readUTF();
                System.out.println("nombre: " + "copy_"+ cont +"_"+ nombre);
                int tamano = dis.readInt();
                System.out.println("Tamano: " + tamano);
               
                FileOutputStream fos = new FileOutputStream("datosRecibidos/" +  "copy_"+ nombre);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                BufferedInputStream bis = new BufferedInputStream(cl.getInputStream());
                
                byte[] buffer = new byte[1024];
               
                int len;
                int acumulador=0;
                int recibido=0;

                while((len = bis.read(buffer,0,buffer.length))!=-1){
                        bos.write(buffer, 0, len);
                        bos.flush();
                        
                        acumulador+=len;   
                        if(((double)acumulador*100/(double)tamano)>recibido+1){
                        recibido = (int)((double)acumulador*100/(double)tamano);
                        System.out.println("Recibido: "+recibido+"%");
                        }
                    }
                
                bis.close();
                bos.close();
                }
                     
                cl.close();
            
            //}//end for
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
}

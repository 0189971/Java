/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_primitovos;

import java.net.*;
import java.io.*;

/**
 *
 * @author javis
 */
public class Servidor_de_Datrama_recibe_archivo {
        public static void main(String[] args) {
        
        try{  
            DatagramSocket s= new DatagramSocket(2000);
            System.out.println("Servicio iniciado...esperando datagramas...");
            int porcentaje;
            for(;;){
                DatagramPacket p = new DatagramPacket(new byte[1500],1500);
                s.receive(p);
                DataInputStream dis= new DataInputStream(new ByteArrayInputStream(p.getData()));
                String archivo=dis.readUTF();
                String nombre=dis.readUTF();
                int tam=dis.readInt();
                
                System.out.println(archivo);
                System.out.println(nombre);
                System.out.println(tam);
                
                 
            
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
                System.out.println("Recibido "+porcentaje+"%");
             }//while
            System.out.println("Archivo recibido..");
            dis.close();
            }
        
        }catch(Exception e){
        e.printStackTrace();
        
        }
        
        }
}

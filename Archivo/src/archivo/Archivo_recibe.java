/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.net.*;
import java.io.*;
import javax.swing.JFileChooser;

public class Archivo_recibe {
 
    public static void main(String[] args) {
            try{
            ServerSocket s=new ServerSocket(1234);
            System.out.println("Servicio iniciado.. esperando cliente");
        
        for(;;){
            
            Socket cl=s.accept();
            System.out.println("Cliente conectado desde"+cl.getInetAddress()+":"+cl.getPort());
            System.out.println("Preparado para recibir archivo");
            String nombre;
            long tam;
            int porcentaje=0;
            String num;
            DataInputStream dis= new DataInputStream(cl.getInputStream());  
            num=dis.readUTF();
            System.out.println(String.valueOf(num));
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
                System.out.println("Recibido "+porcentaje+"%");
             }//while
            
            System.out.println("Archivo recibido..");
            dos.close();
            dis.close();
            cl.close();
        }//for
                       
        }catch(Exception e){
            e.printStackTrace();
        }//catch
    }
}

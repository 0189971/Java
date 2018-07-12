/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenparcial21;

import java.io.File;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author javis
 */
public class EliminarArchi extends Thread{
    
        public EliminarArchi(){
        
        }
    
    public void run(){
        InetAddress gpo=null;        
        try{
            MulticastSocket s= new MulticastSocket(15000);
            s.setReuseAddress(true);
            s.setTimeToLive(128);
            
            System.out.println("Iniciamos ELIMINA ");
            
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            s.joinGroup(gpo);
        while(true){
            System.out.println("Elimina...");
            DatagramPacket p = new DatagramPacket(new byte[101],101);
            s.receive(p);
            String archivo=new String(p.getData());
            archivo=archivo.trim();
            elimina(archivo);
        }
        }catch(Exception e){}
    }
    
    public void elimina(String archivo){    
    File fichero = new File(""+archivo);
        if (fichero.delete())
            System.out.println("El fichero ha sido borrado satisfactoriamente");
        else
            System.out.println("El fichero no puede ser borrado");
    }
    
    
}

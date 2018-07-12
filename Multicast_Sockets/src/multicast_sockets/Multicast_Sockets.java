/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast_sockets;

import java.net.*;
import  java.io.*;

public class Multicast_Sockets {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MulticastSocket s=null;
        InetAddress gpo=null;
        
        try{
            
            s=new MulticastSocket(1234);
            String dir="225.1.1.2";
            
            try{
                
            gpo=InetAddress.getByName(dir);
                
            }catch(Exception e){
                System.err.println("Direccion no valida");
                System.exit(1);
            }
            s.joinGroup(gpo);
            System.out.println("Unido al grupo"+dir+"Enviando datos...");
            s.setTimeToLive(255);
            s.setReuseAddress(true);
            int dato=47;
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            DataOutputStream dos=new DataOutputStream(baos);
            dos.write(dato);
            dos.flush();
            byte[] b=baos.toByteArray();
            DatagramPacket p= new DatagramPacket(b,b.length,gpo,1234); 
            s.send(p);
        
        }catch(Exception e){
        }finally{
        s.leaveGroup(gpo);
        s.close();
        }
    
}
}

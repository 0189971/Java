/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author javis
 */
public class EnlaceMsj extends Thread{
    String msj ="";
    String msj2="";
    public int con=0;
            public EnlaceMsj(String msj, String msj2){
            this.msj=msj;
            this.msj2=msj2;
            }
    
    public void run(){
        InetAddress gpo=null;        
        try{
            MulticastSocket s= new MulticastSocket();
            s.setReuseAddress(true);
            s.setTimeToLive(128);
            
            byte[] b = msj.getBytes();
            byte[] c = msj2.getBytes();
            
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            s.joinGroup(gpo);
            while(true){
                switch(con){
                    case 1:
                        
                        DatagramPacket p = new DatagramPacket(b,b.length,gpo,10100);
                        s.send(p);   
                        DatagramPacket p1 = new DatagramPacket(c,c.length,gpo,10100);
                        s.send(p1); 
                       
                        break;
                    default: 
                        break;
                }
            }
            
            
    }catch(Exception e){}                
    }
    
    
}

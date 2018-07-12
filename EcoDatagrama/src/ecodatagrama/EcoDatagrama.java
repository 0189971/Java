/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecodatagrama;

import java.io.*;
import java.net.*;

/**
 *
 * @author javis
 */
public class EcoDatagrama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
        DatagramSocket s= new DatagramSocket(2000);
        
        
        
        
            System.out.println("Servicio iniciado...esperando datagramas...");
            
            for(;;){
                DatagramPacket p = new DatagramPacket(new byte[1500],1500);
                s.receive(p);
                System.out.println("Datagrama recivido desde"+p.getAddress()+":"+p.getPort());
                String msj= new String(p.getData(),0,p.getLength());
                System.out.println("Con el mensaje :"+msj);
            }
    }catch(Exception e){
        e.printStackTrace();
        }
    
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketecode_.datagrama;

import java.io.*;
import java.net.*;

public class Servidor_eco_de_datagrama {
        public static void main(String[] args) {
            
            try{
               
            DatagramSocket s= new DatagramSocket(2000);
            System.out.println("Servicio iniciado...esperando datagramas...");
                
                for(;;){
                    DatagramPacket p = new DatagramPacket(new byte[1500],1500);
                    s.receive(p);
                    System.out.println("Datagrama recivido desde"+p.getAddress()+":"+p.getPort());
                    String msj= new String(p.getData(),0,p.getLength());
                    
                    if(msj.indexOf("salir")>=0){
                        System.out.println("Terminamos el servicor"+msj);
                        s.close();
                        System.exit(0);
                    }else{      
                    System.out.println("Con el mensaje :"+msj);
                     DatagramPacket f= new DatagramPacket(p.getData(), p.getLength(), p.getAddress(), p.getPort());
                     s.send(f);  
                    }
                    
                }            
            }catch(Exception e){
            e.printStackTrace();
            }
        
        }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

/**
 *
 * @author javis
 */
public class Recibe_archivo_datagrama {
    public static void main(String[] args) {
            
            try{
               
            DatagramSocket s= new DatagramSocket(2000);
            System.out.println("Servicio iniciado...esperando datagramas...");
                
                for(;;){
                DatagramPacket p = new DatagramPacket(new byte[1500],1500);
                s.receive(p);
                System.out.println("Datagrama recivido desde"+p.getAddress()+":"+p.getPort());
                
                }
            
            
            }catch(Exception e){
                e.printStackTrace();
            }}
}

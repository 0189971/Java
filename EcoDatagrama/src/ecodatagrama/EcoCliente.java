/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecodatagrama;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author javis
 */
public class EcoCliente {
    
    
    public static void main(String[] args) {
     try{
     
     BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe la direccion del servidor:");
        String host=br.readLine();
        System.out.println("Escriba un mensaje de saludo");
        String msj=br.readLine();
        int pto=2000;
        DatagramSocket cl= new DatagramSocket();
        byte[] b= msj.getBytes();
        
        for(;;){
        if(b.length <=1500){
         //Si es menor enviamos el mensaje 
            DatagramPacket p=new DatagramPacket(b,b.length,InetAddress.getByName(host),pto);
        }else{
         //Lo seccionamos en partes 
            int cant=b.length;
            for(int i=cant; i>0; i=i-1450){
            
                DatagramPacket p=new DatagramPacket(b,1500,InetAddress.getByName(host),pto);
            }
        
        }
        }
     
     }catch(Exception e){
      e.printStackTrace();
    }
    
    
    
}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketecode_.datagrama;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author javis
 */
public class Socketecode_Datagrama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la dirección del servidor: ");
            String host=br.readLine();
            System.out.println("Escribe un mensaje <Enter> para enviar, <salir> para terminar");
            DatagramSocket cl= new DatagramSocket();
            int pto=2000;
                    for(;;){
                           String msj= br.readLine();
                           byte[] b=msj.getBytes();
                           
                           if(msj.toLowerCase().indexOf("salir")>=0){
                               System.out.println("Termina la aplicavion");
                               String mej2="salir";
                               byte[] b2=mej2.getBytes();
                               DatagramPacket p= new DatagramPacket(b2,b2.length,InetAddress.getByName(host), pto);
                               cl.close();
                               System.exit(0);
                           }else if(b.length>1500){
                               ByteArrayInputStream bais= new ByteArrayInputStream(b);
                               byte[] tmp= new byte[1500];
                               int n=0;
                               while((n=bais.read(tmp))!=-1){
                                   DatagramPacket p=new DatagramPacket(tmp,n,InetAddress.getByName(host), pto);
                                   cl.send(p);
                                   DatagramPacket p2= new DatagramPacket(new byte[1500],1500);
                                   cl.receive(p2);
                                   System.out.println("Eco: "+new String(p2.getData(),0,p2.getLength()));
                               }
                           
                           }else{
                               
                               DatagramPacket p=new DatagramPacket(b,b.length,InetAddress.getByName(host),pto);
                                cl.send(p);
                                
                                System.out.println("Mensaje enviado");
                                System.out.println("Esperando recivir archivo...");
                                
                                DatagramPacket p2= new DatagramPacket(new byte[1500],1500);
                                cl.receive(p2);
                                System.out.println("Eco: "+new String(p2.getData(),0,p2.getLength()));
                           
                           }


                    }
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}

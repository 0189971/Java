/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holasd;


import java.net.*;
import java.io.*;
/**
 *
 * @author javis
 */
public class HolaCD {
    

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
            DatagramPacket p=new DatagramPacket(b,b.length,InetAddress.getByName(host),pto);
            cl.send(p);
            cl.close();
            System.out.println("    Mensaje enviado");
    }catch(Exception e){
    e.printStackTrace();
}
}
}
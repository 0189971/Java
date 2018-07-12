/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicast_sockets;

import java.net.InetAddress;

import java.net.*;
import java.io.*;

public class Socket_recibe_Multicast {
    
    public static void main(String[] args) throws IOException{
    MulticastSocket cl=null;
    InetAddress gpo=null;
    
    try{
        cl=new MulticastSocket(1234);
        String dir="225.1.1.2";
        try{
            
            gpo=InetAddress.getByName(dir);


        }catch(UnknownHostException u){
        u.printStackTrace();
        } 
        cl.joinGroup(gpo);
        cl.setReuseAddress(true);
        DatagramPacket p= new DatagramPacket(new byte[4],4); 
        cl.receive(p);
        System.out.println("Datagrama multicast recibido desde:"+p.getAddress()+":"+p.getPort());
        DataInputStream dis= new DataInputStream(new ByteArrayInputStream(p.getData()));
        int d=dis.readInt();
        
        
    }catch(Exception e){
        e.printStackTrace();
    }finally{
        cl.leaveGroup(gpo);
        cl.close();  
    }
    
    }
}

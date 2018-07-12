/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package anuncio_socketmlticast;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Recibeanuncio {
        
        public static void main(String[] args) throws IOException {
            
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList <InetAddress> server = new ArrayList<InetAddress>();
        MulticastSocket s = null;
        InetAddress gpo = null;
        try{
            s = new MulticastSocket (9000);
            s.setReuseAddress(true);
            s.setTimeToLive(120);
            String dir = "228.1.1.1";
            try{
                gpo = InetAddress.getByName(dir);
            }catch(UnknownHostException a){
                System.out.println("Direccion no valida");
                System.exit(1);
            }
            s.joinGroup(gpo);
            System.out.println("Comienza a recibir anuncios");
            String msj = "puerto anunciado";
            for(;;){
               //Empezamos a recibir anuncios
                byte [] buffer = new byte[1024];
                DatagramPacket p = new DatagramPacket (new byte[1024],1024);
                s.receive(p);
                server.add(p.getAddress());
                buffer=p.getData();
                System.out.println("Servidor anunciado "+p.getAddress());
                System.out.println(new String(buffer));
            }
        }catch(Exception e){
            e.printStackTrace();
        
        }finally {
            s.leaveGroup(gpo);
            s.close();
        }   
        }
}

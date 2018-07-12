/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;

import java.io.*;
import java.net.*;

public class Servidorudp {

    /*Puerto de servidor dns*/
    public static final int DNS_SERVER_PORT = 53;
    /*Dirección del servidor dns*/
    public static final String DNS_SERVER_ADDRESS = "8.8.8.8";

    public static void main(String[] args) {
        new Servidorudp();
    }
    
    public Servidorudp(){
         try {

      DatagramSocket socketUDP = new DatagramSocket(162);
      byte[] bufer = new byte[1000];
      byte[] buferResponse =new byte[1024];
      byte[] buferdos= new byte[1000];
      

      while (true) {
        // Construimos el DatagramPacket para recibir peticiones
        DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);

        // Leemos una petición del DatagramSocket
        socketUDP.receive(peticion);
        
        buferResponse = bufer;
        int peticionC =peticion.getPort();
        InetAddress peticionCA =peticion.getAddress();
        

        System.out.println();
        System.out.print("Datagrama recibido del host: " +
                           peticion.getAddress());
        System.out.println(" desde el puerto remoto: " +
                           peticion.getPort());
         
        for (int i = 0; i < peticion.getLength(); i++) {
            System.out.print(" 0x" + String.format("%x", bufer[i]) + " " );
            
        }
          System.out.println();
        DataInputStream din = new DataInputStream(new ByteArrayInputStream(bufer));
        //System.out.println("\nTransaction ID: 0x" + String.format("%x", din.readShort()));
        /*Guardamos el identificador de la ip*/
        short id=din.readShort();
        System.out.println("EL identificador es el siguiente: " +String.format("%x",id));
        System.out.println("Flags: 0x" + String.format("%x", din.readShort()));
        System.out.println("Questions: 0x" + String.format("%x", din.readShort()));
        System.out.println("Answers RRs: 0x" + String.format("%x", din.readShort()));
        System.out.println("Authority RRs: 0x" + String.format("%x", din.readShort()));
        System.out.println("Additional RRs: 0x" + String.format("%x", din.readShort())); 
        /*Guardamos la parte de la consulta*/
        short [] saveQ = null; 
        int recLen = 0;
        int j=0;
        String direccion = "";
        ByteArrayOutputStream output1 = new ByteArrayOutputStream( );
                            byte[] record = null;
                            byte [] guarda = null;
                            while ((recLen = din.readByte()) > 0) {
                                 output1.write(recLen);
                                 record= new byte[recLen];
                                System.out.println("Tamaño de la dirección: "+ recLen);
                                for (int i = 0; i < recLen; i++) {
                                    record[i] = din.readByte();
                                    output1.write(record[i]);
                                }
                                if(j < 2){
                                direccion = direccion + new String(record, "UTF-8")+".";
                                }else{
                                direccion = direccion + new String(record, "UTF-8");
                                }
                                j++;
                                System.out.println("Record: " + new String(record, "UTF-8"));
                            }
                            //System.out.println("Guarda: "+ new String(guarda, "UTF-8"));
                                  
                    
                            System.out.println("Direccion: "+direccion);
                            //System.out.println("Record Type: 0x" + String.format("%x", din.readShort()));
        byte [] medio=output1.toByteArray();
        /*Verificamos si la url es valida */
        int caso = comparacadena(direccion);                    
        /*Si el caso es 1 la cadena es valida si no es 0*/
        if(caso == 0){
            System.out.println("El dominio es valido");
            //Enviamos una solicidtud a el dns por default 
            DatagramSocket socketdns = new DatagramSocket();
             //Construimos el DatagramPacket para enviar la respuesta
            DatagramPacket respuestadns = new DatagramPacket(peticion.getData(), peticion.getLength(),
                                           InetAddress.getByName(DNS_SERVER_ADDRESS), DNS_SERVER_PORT );

            // Enviamos la respuesta, que es un eco
            socketdns.send(respuestadns);
            System.out.println("Esperando la respuesta...");
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socketdns.receive(packet);

            System.out.println("Enviando respuesta a el cliente...");
            /*Primero se agrega la querya la respuesta*/
            for (int i = 0; i < packet.getLength(); i++) {
            System.out.print(" 0x" + String.format("%x", buf[i]) + " " );
            
            }
            DatagramPacket respuestacliente = new DatagramPacket(packet.getData(), packet.getLength(),
                                           peticionCA, peticionC);
            socketUDP.send(respuestacliente);
        }else if(caso == 1){
            System.out.println("El dominio no es valido");
                //Enviamos una solicidtud a el dns por default 
            DatagramSocket socketdns = new DatagramSocket();
             //Construimos el DatagramPacket para enviar la respuesta
            DatagramPacket respuestadns = new DatagramPacket(peticion.getData(), peticion.getLength(),
                                           InetAddress.getByName(DNS_SERVER_ADDRESS), DNS_SERVER_PORT );

            // Enviamos la respuesta, que es un eco
            socketdns.send(respuestadns);
            System.out.println("Esperando la respuesta...");
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socketdns.receive(packet);
            buferdos=buf;
            int k=0;
                for(k=0; k<packet.getLength(); k++){
                System.out.print("0x" + String.format("%x", buferdos[k]) + " " );
                }
                System.out.println();
                buferdos [k-4]= (byte)10;
                buferdos [k-3]= (byte)100;
                buferdos [k-2]= (byte)74;
                buferdos [k-1]= (byte)201;
                
                for(k=0; k<packet.getLength(); k++){
                System.out.print("0x" + String.format("%x", buferdos[k]) + " " );
                }
                
            DatagramPacket packetdos = new DatagramPacket(buferdos, buferdos.length);
            DatagramPacket respuestacliente = new DatagramPacket(packetdos.getData(), packetdos.getLength(),
                                           peticionCA, peticionC);
            socketUDP.send(respuestacliente);
           
        }

      }

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
    
 /*Funcion que compara las direccioes que no estan peermitidas*/  
  public int comparacadena (String cadena){
      /*Arreglo de direcciones prohibidas*/
        String[ ] direcciones = {"www.google.com","www.facebook.com"};
      int i=0;
        for(i=0;i<direcciones.length; i++){
            if(cadena.equals(direcciones[i]))
                return 1;
        }
    return 0;
  }
  
}
      

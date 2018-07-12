/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dns.cliente;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class DNSClienteServidor {
    
    private String url="";
    public InetAddress ipAddressPeticion;
    public int puertopeticion;
    
    String[ ] direcciones = {"xvideos.com", "google.com", "yahoo.com"};
    public static void main(String[] args){
        new DNSClienteServidor();
    }
   
    public DNSClienteServidor(){
        String peticion="";
        int caso = 2;
        try
        {
            // La IP es la local, el puerto es en el que el servidor est� 
            // escuchando.
            DatagramSocket socket = new DatagramSocket(
                    Constantes.DNS_SERVER_PORT);
            
            // Un DatagramPacket para recibir los mensajes.
            DatagramPacket dato = new DatagramPacket(new byte[1000], 1000);
            System.out.println("Servidor inicializado");
            // Bucle infinito.
            while (true)
            {
                // Se recibe un dato y se escribe en pantalla.
                socket.receive(dato);
                System.out.print("Recibido dato de "
                        + dato.getAddress() + " : ");
                ipAddressPeticion=dato.getAddress();
                puertopeticion=dato.getPort();
                System.out.println("La dirección de la petición"+ipAddressPeticion +"y el puerto es"+puertopeticion);
                
                // Conversion de los bytes a DatoUdp
                DatoUdp datoRecibido = DatoUdp.fromByteArray(dato.getData());
                System.out.println(datoRecibido.cadenaTexto);
                
                //asignamos petición 
                peticion=datoRecibido.cadenaTexto.trim();
                for(int i=0; i<direcciones.length; i++){
                    caso=revisa(direcciones, peticion, i);
                    System.out.println("El caso es: " + caso );
                    if(caso == 1 ) break;
                }
                
                
                switch(caso){
                    case 1:
                        System.out.println("No esta permitida...");
                            try{
                            String domain = "google.com";
                            InetAddress ipAddress = InetAddress.getByName(Constantes.DNS_SERVER_ADDRESS);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            DataOutputStream dos = new DataOutputStream(baos);            
                            dos.writeShort(0x1234);
                            dos.writeShort(0x0100);
                            dos.writeShort(0x0001);
                            dos.writeShort(0x0000);
                            dos.writeShort(0x0000);
                            dos.writeShort(0x0000);
                            String[] domainParts = domain.split("\\.");
                            System.out.println(domain + " has " + domainParts.length + " parts");
                            for (int i = 0; i<domainParts.length; i++) {
                                System.out.println("Writing: " + domainParts[i]);
                                byte[] domainBytes = domainParts[i].getBytes("UTF-8");
                                dos.writeByte(domainBytes.length);
                                dos.write(domainBytes);
                            }
                            dos.writeByte(0x00);
                            dos.writeShort(0x0001);
                            dos.writeShort(0x0001);
                            
                            byte[] dnsFrame = baos.toByteArray();

                            System.out.println("Sending: " + dnsFrame.length + " bytes");
                            for (int i =0; i< dnsFrame.length; i++) {
                                System.out.print("0x" + String.format("%x", dnsFrame[i]) + " " );
                            }
                             DatagramPacket defsocket = new DatagramPacket(dnsFrame, dnsFrame.length,InetAddress.getByName(Constantes.HOST_CLIENTE), Constantes.PUERTO_DEL_CLIENTE );
                             socket.send(defsocket);
                            }catch(UnknownHostException ex){
                                Logger.getLogger(DNSClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                    case 0:
                        System.out.println("Esta permitida...");    
                        try{
                            String domain = peticion;
                            InetAddress ipAddress = InetAddress.getByName(Constantes.DNS_SERVER_ADDRESS);
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            DataOutputStream dos = new DataOutputStream(baos);            
                            dos.writeShort(0x1234);
                            dos.writeShort(0x0100);
                            dos.writeShort(0x0001);
                            dos.writeShort(0x0000);
                            dos.writeShort(0x0000);
                            dos.writeShort(0x0000);
                            String[] domainParts = domain.split("\\.");
                            System.out.println(domain + " has " + domainParts.length + " parts");
                            for (int i = 0; i<domainParts.length; i++) {
                                System.out.println("Writing: " + domainParts[i]);
                                byte[] domainBytes = domainParts[i].getBytes("UTF-8");
                                dos.writeByte(domainBytes.length);
                                dos.write(domainBytes);
                            }
                            dos.writeByte(0x00);
                            dos.writeShort(0x0001);
                            dos.writeShort(0x0001);

                            byte[] dnsFrame = baos.toByteArray();

                            System.out.println("Sending: " + dnsFrame.length + " bytes");
                            for (int i =0; i< dnsFrame.length; i++) {
                                System.out.print("0x" + String.format("%x", dnsFrame[i]) + " " );
                            }
                            // *** Send DNS Request Frame ***
                            DatagramSocket socketdns = new DatagramSocket();
                            DatagramPacket dnsReqPacket = new DatagramPacket(dnsFrame, dnsFrame.length, ipAddress, Constantes.DNS_SERVER_PORT);
                            socketdns.send(dnsReqPacket);

                            // Await response from DNS server
                            byte[] buf = new byte[1024];
                            DatagramPacket packet = new DatagramPacket(buf, buf.length);
                            socketdns.receive(packet);

                            System.out.println("\n\nReceived: " + packet.getLength() + " bytes");

                            for (int i = 0; i < packet.getLength(); i++) {
                                System.out.print(" 0x" + String.format("%x", buf[i]) + " " );
                            }
                            System.out.println("\n");
                            System.out.println("El tamaño a enviar es de "+buf.length);
                            DatagramPacket enviaP = new DatagramPacket(buf, packet.getLength(),ipAddressPeticion , puertopeticion);
                            socket.send(enviaP);
                        }catch(UnknownHostException ex){
                            Logger.getLogger(DNSClienteServidor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    default:
                }
              
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }
    
    private int revisa(String [] cadena, String peticion, int i){
            if(peticion.equals(cadena[i])){
                return 1;
            }else 
                return 0;
    }
    
    
}

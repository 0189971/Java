
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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DNSpeticion  {
    
    public static void main(String[] args){
        new DNSpeticion();
    }
    
    public DNSpeticion(){
        /*Casos*/
       
            try
            {
                
                // La IP es la local, el puerto es en el que este cliente est�
                // escuchando.
                DatagramSocket socket = new DatagramSocket(Constantes.PUERTO_DEL_CLIENTE, InetAddress
                                .getByName("localhost"));
                while(true){
                    Scanner scan = new Scanner(System.in);
                    System.out.println("\nEscribe la url de peticion");
                    String host=scan.next();
                    
                    System.out.println("Enviando... "+host);
                    
                    // Se instancia un DatoUdp y se convierte a bytes[]
                    DatoUdp elDato = new DatoUdp(host.trim());
                    byte[] elDatoEnBytes = elDato.toByteArray();

                    // Se meten los bytes en el DatagramPacket, que es lo que se
                    // va a enviar por el socket.
                    // El destinatario es el servidor.
                    // El puerto es por el que est� escuchando el servidor.
                    DatagramPacket dato = new DatagramPacket(elDatoEnBytes,elDatoEnBytes.length, InetAddress.getByName(Constantes.HOST_SERVIDOR),
                            Constantes.PUERTO_DEL_SERVIDOR);

                  

                    socket.send(dato);
                    
                    System.out.println("Esperando la respuesta...");
                    byte[] buf = new byte[1024];
                            DatagramPacket packet = new DatagramPacket(buf, buf.length);
                            socket.receive(packet);

                            System.out.println("\n\nReceived: " + packet.getLength() + " bytes");

                            for (int i = 0; i < packet.getLength(); i++) {
                                System.out.print(" 0x" + String.format("%x", buf[i]) + " " );
                            }
                            DataInputStream din = new DataInputStream(new ByteArrayInputStream(buf));
                            System.out.println("\nTransaction ID: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Flags: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Questions: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Answers RRs: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Authority RRs: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Additional RRs: 0x" + String.format("%x", din.readShort()));

                            int recLen = 0;
                            while ((recLen = din.readByte()) > 0) {
                                byte[] record = new byte[recLen];

                                for (int i = 0; i < recLen; i++) {
                                    record[i] = din.readByte();
                                }

                                System.out.println("Record: " + new String(record, "UTF-8"));
                            }

                            System.out.println("Record Type: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Class: 0x" + String.format("%x", din.readShort()));

                            System.out.println("Field: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Type: 0x" + String.format("%x", din.readShort()));
                            System.out.println("Class: 0x" + String.format("%x", din.readShort()));
                            System.out.println("TTL: 0x" + String.format("%x", din.readInt()));

                            short addrLen = din.readShort();
                            System.out.println("Len: 0x" + String.format("%x", addrLen));

                            System.out.print("Address: ");
                            for (int i = 0; i < addrLen; i++ ) {
                                System.out.print("" + String.format("%d", (din.readByte() & 0xFF)) + ".");
                            }
                    Thread.sleep(1000);
                }
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            
        
        
    }
}

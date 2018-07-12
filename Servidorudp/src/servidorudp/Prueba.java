/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author javis
 */
public class Prueba {
     public static void main(String[] args) throws IOException {
        new Prueba();
    }
    
     public Prueba() throws IOException{
     /*Agregamos el contenido*/
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos); 
            dos.writeShort(0xc00);
            dos.writeShort(0x0103);
            dos.writeShort(0x0000);
            dos.writeShort(0x0006);
            dos.writeShort(0x0000);
            dos.writeShort(0x0001);
            dos.writeShort(0x0000);
            dos.writeShort(0x0000);
            dos.writeShort(0x0001);
            dos.writeShort(0x07a);
            dos.writeShort(0x0000);
            dos.writeShort(0x0201);
            dos.writeShort(0x0004);
            dos.writeShort(0x0604);
            dos.writeShort(0x06e);
            dos.writeShort(0x0703);
            dos.writeShort(0x0301);
            dos.writeShort(0xc00);
            dos.writeShort(0x0103);
            dos.writeShort(0x0003);
            dos.writeShort(0x0704);
            dos.writeShort(0x0609);
            dos.writeShort(0x0603);
            dos.writeShort(0xc00);
            dos.writeShort(0x0103);
            dos.writeShort(0x0708);
            dos.writeShort(0x0408);
            dos.writeShort(0xb06);
            dos.writeShort(0xc05);
            dos.writeShort(0x0000);
            dos.writeShort(0x0000);
            dos.writeShort(0x02a);
            dos.writeShort(0x0300);
            dos.writeShort(0x0000);
            dos.writeShort(0x0000);
            dos.writeShort(0x00e);
            dos.writeShort(0x0100);
            dos.writeShort(0x0000);
            dos.writeShort(0x0102);
            dos.writeShort(0x0705);
            dos.writeShort(0x0000);
            dos.writeShort(0x0000);
            dos.writeShort(0x0000);
            dos.writeShort(0x02a);
            dos.writeShort(0x0300);
            byte[] dnsFrame = baos.toByteArray();
            for(int j=0;j < dnsFrame.length; j++)
                System.out.print("0x" + String.format("%x", dnsFrame[j]) + "\n");
     
     }
}

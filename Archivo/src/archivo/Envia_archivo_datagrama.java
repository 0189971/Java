/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JFileChooser;

/**
 *
 * @author javis
 */
public class Envia_archivo_datagrama {

    public static void main(String[] args) {
    try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la dirección del servidor: ");
            String host=br.readLine();
            DatagramSocket cl= new DatagramSocket();
            int pto=2000;
            
            JFileChooser jf= new JFileChooser();   //  ----> jf.setMultiSelectionEnabled(true); Enviar varios archivos misma ruta..
            int r= jf.showOpenDialog(null);
            System.out.println(r);
            
            if(r==JFileChooser.APPROVE_OPTION){
                File f= jf.getSelectedFile();  //File[] f= jf.getSelectedFiles();
                String archivo=f.getAbsolutePath();
                System.out.println("EL path es:"+archivo);
                String nombre=f.getName();
                System.out.println(nombre);
                long tam=f.length();
                String tm;
                byte[] b2=nombre.getBytes();
                byte[] b1;
                        
                DatagramPacket p= new DatagramPacket(b2,b2.length,InetAddress.getByName(host), pto);
                DataInputStream dis=new DataInputStream(new FileInputStream(archivo));
                
                int porcentaje=0;
                byte[] buf= new byte[1500];
                long recibidos=0;
                int n=0;
                
                while(recibidos<tam){
                    n=dis.read(buf);
                    //dos.write(buf,0,n);
                    //dos.flush();
                    recibidos=recibidos+n;

                    porcentaje=(int)((recibidos*100)/tam);
                    System.out.println("Recibido "+porcentaje+"%");
                }//while
                
                
            }
    }catch(Exception e){
    e.printStackTrace();
    }
    }
    
}

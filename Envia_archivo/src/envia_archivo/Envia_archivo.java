/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envia_archivo;

import java.net.*;
import java.io.*;
import javax.swing.JFileChooser;
/**
 *
 * @author javis
 */
public class Envia_archivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba la dirección del host");
            String host=br.readLine();
            System.out.println("Escriba el puerto");
            int pto=Integer.parseInt(br.readLine());
            Socket cl= new Socket(host,pto);
            JFileChooser jf= new JFileChooser();
            int r=jf.showOpenDialog(null);
                if(r==JFileChooser.APPROVE_OPTION){
                       File f=jf.getSelectFile();
                       String archivo=f.getAbsolutePath();
                       String nombre=f.getName();
                       long tam=f.length();
                       DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
                       DataOutputStream dis= new DataOutputStream(cl.getOutputStream());
                       dos.writeUTF(nombre);
                       dos.flush();
                       dos.writeLong(tam);
                       dos.flush();
                       byte [] b= new byte[1024];

                }
                    
            
            long enviados=0;
            int porcentaje, n;
                
            while(enviados<tam){
                    n=dis.read(b);
                    dos.write(b,0,n);
                    dos.flush();
                    enviados=enviados+n;
                    porcentaje=(int)((enviados*100)/tam);
                        System.out.println("Enviado: "+porcentaje+"% \r");           
                }
            System.out.println("\n\n Archivo enviado");
            dos.close();
            dis.close();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
}

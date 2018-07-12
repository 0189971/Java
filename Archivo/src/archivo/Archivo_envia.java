/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivo;

import java.net.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author javis
 */
public class Archivo_envia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Escribe la direccion del servidor:");
            String host=br.readLine();
            System.out.print("\n\n Escribe el puerto:");
            int pto=Integer.parseInt(br.readLine());
            Socket cl=new Socket(host,pto);
            
            DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
            dos.writeUTF("1");
            dos.flush();
            
            JFileChooser jf= new JFileChooser();   //  ----> jf.setMultiSelectionEnabled(true); Enviar varios archivos misma ruta..
            int r= jf.showOpenDialog(null);
            System.out.println(r);
            if(r==JFileChooser.APPROVE_OPTION){
                File f= jf.getSelectedFile();  //File[] f= jf.getSelectedFiles();
                String archivo=f.getAbsolutePath();
                String nombre=f.getName();
                long tam=f.length();
                
                
                DataInputStream dis=new DataInputStream(new FileInputStream(archivo));
                
                System.out.println("Comienza el envio del archivo "+archivo);
                dos.writeUTF(nombre);
                dos.flush();
                dos.writeLong(tam);
                dos.flush();
                
                int porcentaje=0;
                byte[] buf= new byte[1500];
                long enviados=0;
                int n;
                
                while(enviados<tam){
                    n=dis.read(buf);
                    dos.write(buf,0,n);
                    dos.flush();
                    enviados=enviados+n;
                    porcentaje=(int)((enviados*100)/tam);
                    System.out.println("Completado el "+porcentaje+"%");
                }//while
                
            System.out.println("Archivo enviado..");
            dos.close();
            dis.close();            
            }//if
            br.close();
            cl.close();
              
        }catch(Exception e){
          e.printStackTrace();
        }//catch

    }
    
}

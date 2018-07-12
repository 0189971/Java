/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_de_archivos_multiplex;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JFileChooser;

/**
 *
 * @author javis
 */
public class Socket_de_archivos_multiplex {

    public static void main(String[] args) {
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la direccion del servidor:");
            String host=br.readLine();
            System.out.println("Escribe el puerto:");
            int pto=Integer.parseInt(br.readLine());
            
            JFileChooser jf= new JFileChooser();   //  ----> jf.setMultiSelectionEnabled(true); Enviar varios archivos misma ruta..
            jf.setMultiSelectionEnabled(true);
            
            int r= jf.showOpenDialog(null);
           
            
            if(r==JFileChooser.APPROVE_OPTION){
                
                    
                            File[] f= jf.getSelectedFiles();  //File[] f= jf.getSelectedFiles();
                            int numele=f.length;
                            System.out.println(numele);
                        
                        for(int i=0;i<numele;i++){
                            Socket cl=new Socket(host,pto);
                            String archivo=f[i].getAbsolutePath();
                            String nombre=f[i].getName();
                            long tam=f[i].length();
                            
                            System.out.println(archivo);
                            System.out.println(nombre);
                            System.out.println(tam);
                            
                            DataOutputStream dos= new DataOutputStream(cl.getOutputStream());
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
                        }
            }
            br.close();
          
        }catch(Exception e){
          e.printStackTrace();
        }
    
    
}
}

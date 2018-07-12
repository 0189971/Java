/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket_primitovos;

import java.io.*;
import java.net.*;
import javax.swing.JFileChooser;

public class Socket_archivos_datagramas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la dirección:");
            String host=br.readLine();
            System.out.println("Escribe el puerto");
            int pto=Integer.parseInt(br.readLine());
            
            ByteArrayOutputStream baos= new ByteArrayOutputStream();
            DataOutputStream dos=new DataOutputStream(baos);
            
            
            //Seleccionamos los multiplex archivos
            JFileChooser jf= new JFileChooser();
            jf.setMultiSelectionEnabled(true);
            int r= jf.showOpenDialog(null);
            
            if(r==JFileChooser.APPROVE_OPTION){
                    //Verificamos cuantos archivos fueron selecionados
                    File[] f= jf.getSelectedFiles();  //File[] f= jf.getSelectedFiles();
                    int numele=f.length;
                    System.out.println(numele);
                    
                    for(int i=0;i<numele;i++){
                     
                       DatagramSocket cl= new DatagramSocket(); 
                        
                    String archivo=f[i].getAbsolutePath();
                    dos.writeBytes(archivo);
                    dos.flush();
                    String nombre=f[i].getName();
                    dos.writeBytes(nombre);
                    dos.flush();
                    long tam=f[i].length();
                    dos.writeLong(tam);
                    dos.flush();
                    byte [] b=baos.toByteArray();
                    DatagramPacket p=new DatagramPacket(b,b.length,InetAddress.getByName(host),pto);
                    cl.send(p);
                    DataInputStream dis=new DataInputStream(new FileInputStream(archivo));
                    System.out.println("Comienza el envio de archivos....");
                /*
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
                }
                
                    System.out.println("Archivo enviado...");
                */
                }
                }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}

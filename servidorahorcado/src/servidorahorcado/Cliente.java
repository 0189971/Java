/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorahorcado;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.net.Socket;

/**
 *
 * @author javis
 */
public class Cliente {
         public static void main(String[] args){
        try{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la direccion del servidor:");
            String host=br.readLine();
            System.out.println("Escribe el puerto:");
            int pto=Integer.parseInt(br.readLine());
            Socket cl= new Socket(host,pto);
            PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            BufferedReader br2= new BufferedReader(new InputStreamReader(cl.getInputStream()));
            
            for(;;){
                    String msj= br.readLine();
                         if(msj.toLowerCase().indexOf("salir")>=0){
                            pw.println(msj);
                            pw.flush();
                            br2.close();
                            br.close();
                            cl.close();
                         System.exit(0);
                         }else{
                             pw.println(msj);
                             pw.flush();
                             String msjR=br2.readLine();
                             System.out.println("Mensaje Resivido: "+msjR);
                             continue;
            } 
            }
            
        }catch(Exception e){
        e.printStackTrace();
    }
 
}

}

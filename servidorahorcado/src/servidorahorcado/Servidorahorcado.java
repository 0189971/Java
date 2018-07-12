/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorahorcado;

import java.io.*;
import java.net.*;


public class Servidorahorcado {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try{
            ServerSocket by= new ServerSocket(2000);
            System.out.println("Servidor iniciado...");
            System.out.println("Listo para recibir mennsajes...");
            
            for(;;){
                Socket cl =by.accept();
                System.out.printf("Cliente conectado desde "+cl.getInetAddress()+":"+cl.getPort());
                PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                BufferedReader br= new BufferedReader(new InputStreamReader(cl.getInputStream()));
                 for(;;){
                     String msj= br.readLine();
                     if(msj.toLowerCase().indexOf("salir")>=0){
                         System.out.println("Termina cliente...");
                         pw.close();
                         br.close();
                         cl.close();
                         break;
                     }else{
                         System.out.println("Termina el cliente...");
                         String eco= msj+" Eco";
                         pw.println(eco);
                         pw.flush();
                         continue;                  
                     }
                 }
            }
        
        }catch(Exception e){
        e.printStackTrace();
        }

    }
    
}

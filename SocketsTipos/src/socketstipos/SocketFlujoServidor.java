/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketstipos;

import java.net.*;
import java.io.*;

public class SocketFlujoServidor {
        
    public static void main(String[] args) {
        
        try{
            ServerSocket by= new ServerSocket(2000);
            System.out.println("Servidor iniciado...");
            System.out.println("Listo para recibir mennsajes...");
            
            for(;;){
            Socket cl=by.accept(); 
            System.out.printf("Cliente conectado desde "+cl.getInetAddress()+":"+cl.getPort()+"\n");
            PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
            BufferedReader br= new BufferedReader(new InputStreamReader(cl.getInputStream()));
            
            int num=Integer.parseInt(br.readLine());
                System.out.println(num);
            
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketredes;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author javis
 */
public class Socketredes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket s1= new ServerSocket(1234);
           System.out.println("Esperando a los clientes...");
           for(;;){
               Socket cs = s1.accept();
               System.out.println("Conexion establecida desde");
               String Cadena= "Hola mundo";
               PrintWriter pw= new PrintWriter(new OutputStreamWriter(cs.getOutputStream()));
               pw.println(Cadena);
               pw.flush();
               pw.close();
           }
       }catch(Exception e ){
       e.printStackTrace();
       }
    }
    
}

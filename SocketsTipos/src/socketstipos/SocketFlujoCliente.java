/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketstipos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author javis
 */
public class SocketFlujoCliente {
    
    public static void main(String[] args){
    Scanner entra=new Scanner(System.in);
        
        
    try{
            BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escribe la direccion del servidor:");
            String host=br.readLine();
            System.out.println("Escribe el puerto:");
            int pto=Integer.parseInt(br.readLine());
            Socket cl= new Socket(host,pto);
            PrintWriter pw= new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
                System.out.println("Selecciona que tipo de dato desea enviar");
                System.out.println("1.-Entero");
                System.out.println("2.-String");
                System.out.println("3.-Char");
            int elec=Integer.parseInt(br.readLine());
            
            switch(elec){
                case 1:
                    //Enviamos un entero
                    System.out.println("Escribe un entero");
                    int num=Integer.parseInt(br.readLine());
                    pw.println(num);
                    pw.flush();
                    
                case 2: 
                    //Enviamos un String 
                    
            
                case 3:
                    //Enviamos un Char
                    
                    
            }
                
                
                
            
    
    
    
    }catch(Exception e){
        e.printStackTrace();
    } 
}
}

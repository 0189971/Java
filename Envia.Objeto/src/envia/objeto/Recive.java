/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envia.objeto;

import java.io.*;
import java.net.*;


    
public class Recive{
    
    public static void main(String[] args) {
    
    try{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escrible la direccion del servidor:");
        String host=br.readLine();
        System.out.println("Escribe el puerto:");
        int pto=Integer.parseInt(br.readLine());
        Socket cl=new Socket(host, pto);
        System.out.println("Conexión establecida...");
        ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
        ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
        
        Objeto o1=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1.a+"b->"+o1.b+"c->"+o1.c);
        Objeto o2= new Objeto(4, 5.0f, "seis");
        oos.writeObject(o2);
        oos.flush();
        System.out.println("Objeto enviado con los datos: a->"+o2.a+"b->"+o2.b+"c->"+o2.c);
        oos.close();
        ois.close();
        cl.close();
    
    }catch(Exception e){
        e.printStackTrace();
    }    
    
}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package envia.objeto;


import java.io.*;
import java.net.*;


class Objeto implements Serializable{
    int a;
    float b;
    String c;
    
    public Objeto(int a, float b, String c){
    this.a=a;
    this.b=b;
    this.c=c;
    }  
}

public class EnviaObjeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            ServerSocket s= new ServerSocket(2000);
            System.out.println("Esperando a que el cliente se conecte...");
            Socket cl=s.accept();
            ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
            
            Objeto o1= new Objeto(1,2.0f,"tres");
            
            System.out.println("Enviando objeto con los datos: a->"+o1.a+"b->"+o1.b+"c->"+o1.c);
            oos.writeObject(o1);
            oos.flush();
            Objeto o2=(Objeto)ois.readObject();
            System.out.println("Objeto recibido con los datos: a->"+o2.a+"b->"+o2.b+"c->"+o2.c);
            oos.close();
            ois.close();
            cl.close();
            s.close();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
}

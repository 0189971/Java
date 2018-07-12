
package servidorsopadeletras;

import java.io.*;
import java.net.*;
import java.util.Random;
import javax.swing.*;

class Objeto implements Serializable{
    char[][] palabras;
    String [] lista;
    
    public Objeto(char[] [] a, String[] d){
        this.palabras=a;
        this.lista=d;
    }  
}


public class ServidorSopaDeLetras {
    public static void main(String[] args) {
        
        try{
            ServerSocket s= new ServerSocket(2000);
            System.out.println("Esperando a que el cliente se conecte...");
            Socket cl=s.accept();
            ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
            
            //Leemos las palabras del archivo de texto 
            
            
            
            
            //Creamos el objeto con las palabras 
            
            
            
            
        }catch(Exception e){
        e.printStackTrace();
        }  
    }
    
    
    
    public char[][] rellenar(String[] lista){
        int num, num2;
        Random pal= new Random();
        num=pal.nextInt(16)+1;
        num2=pal.nextInt(16)+1;
        
        char[][] a= new char[16][16];
        
        int i=0, longitud;
        do{
           longitud=lista[i].length();
            //Verificamos como se puede escribir la palabra
            
        
        }while(i<16);
        
        
        return a;
    }
    
    
    
    
    public String[] leer(String [] lista){
        FileReader f=new FileReader(Palabras.txt);
    
        
    
    return lista;
    } 
    
}

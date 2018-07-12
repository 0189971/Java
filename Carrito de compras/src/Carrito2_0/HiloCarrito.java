/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrito2_0;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author javis
 */
public class HiloCarrito extends Thread{
   
    private int puerto;
    private String host;
    Carrito_2 ventana;


    public HiloCarrito(int pto, String host, Carrito_2 ventana){
        this.puerto=pto;
        this.host=host;
        this.ventana=ventana;
    }
    
    public void run(){
        try{
            Socket cl=new Socket(host, puerto);
            ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
            
        
        int[] almacen=new int[10];
        float[] pre=new float[10];
        String[] nom= new String[10];
        String[] imagen=new String[10];
        
        Objeto[] o=new Objeto[10];
        
        //Recibimos la información del servidor
            for(int i=0; i<3; i++){
                o[i]=(Objeto)ois.readObject();
                System.out.println("Objeto recibido con los datos:a->"+o[i].precio+"b->"+o[i].nombre+"c->"+o[i].imagen);
            }
            
        JOptionPane.showMessageDialog(ventana,"Se ha establecido la conexion");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar");
        }
       
    }
}

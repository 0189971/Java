/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrito.de.compras;

import java.io.*;
import java.net.*;

/**
 *
 * @author javis
 */
public class Recibe_compras_Socket_de_objetos {
    public static void main(String[] args) {
    
    try{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escrible la direccion del servidor:");
        String host=br.readLine();
        System.out.println("Escribe el puerto:");
        int pto=Integer.parseInt(br.readLine());
        
        System.out.println("Conexión establecida...");
        Socket cl=new Socket(host, pto);
        
        ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
        ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
        ObjectInputStream ois1= new ObjectInputStream(cl.getInputStream());
        ObjectInputStream ois2= new ObjectInputStream(cl.getInputStream());
        
        int[] almacen=new int[10];
        float[] pre=new float[10];
        String[] nom= new String[10];
        String[] imagen=new String[10];
        
        Objeto[] o1=new Objeto[10];
        
        o1[0]=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1[0].precio+"b->"+o1[0].nombre+"c->"+o1[0].imagen);
        Thread.sleep(4000);
        o1[1]=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1[1].precio+"b->"+o1[1].nombre+"c->"+o1[1].imagen);
        Thread.sleep(4000);
        o1[2]=(Objeto)ois.readObject();
        System.out.println("Objeto recibido con los datos:a->"+o1[2].precio+"b->"+o1[2].nombre+"c->"+o1[2].imagen);
        
        for(int i=0;i<3;i++){
        almacen[i]=o1[i].almacen;
        pre[i]=o1[i].precio;
        nom[i]=o1[i].nombre;
        imagen[i]=o1[i].imagen;
        }
        
        int eleccion;
        Objeto[] o2=new Objeto[10];
        
        eleccion=1;
        
        switch(eleccion){
            case 1:
                System.out.println("Desea confirmar la compra de un Arduino Mega");
                o2[0]= new Objeto(almacen[0]-1,pre[0],nom[0],imagen[0]);
                oos.writeObject(o2[0]);
                oos.flush();
                System.out.println("Objeto enviado con los datos: a->"+o2[0].precio+"b->"+o2[0].nombre+"c->"+o2[0].imagen);
                
                //Esperamos la respuesta del servidor 
                o1[4]=(Objeto)ois.readObject();
                System.out.println("Objeto recivido");
                float IVA;
                float precioreal;
                IVA=(float) (o1[4].precio*(0.16));
                System.out.println(IVA);
                precioreal=IVA+(o1[4].precio);
                System.out.println("El total es:" +precioreal);
                
                break;
            case 2:
                System.out.println("Desea confirmar la compra de una Ethernet Shield ");
                o2[1]= new Objeto(almacen[0]-1,pre[1],nom[1],imagen[1]);
                oos.writeObject(o2[1]);
                oos.flush();
                System.out.println("Objeto enviado con los datos: a->"+o2[1].precio+"b->"+o2[1].nombre+"c->"+o2[1].imagen);
                
                //Esperamos la respuesta del servidor 
                o1[4]=(Objeto)ois.readObject();
                System.out.println("Objeto recivido");
                IVA=(float) (o1[4].precio*(0.16));
                System.out.println(IVA);
                precioreal=IVA+(o1[4].precio);
                System.out.println("El total es:" +precioreal);
                
                break;
            case 3:
                System.out.println("Desea confirmar la compra de un USB ftdi");
                o2[2]= new Objeto(almacen[0]-1,pre[2],nom[2],imagen[2]);
                oos.writeObject(o2[0]);
                oos.flush();
                System.out.println("Objeto enviado con los datos: a->"+o2[0].precio+"b->"+o2[0].nombre+"c->"+o2[0].imagen);
                
                //Esperamos la respuesta del servidor 
                o1[4]=(Objeto)ois.readObject();
                System.out.println("Objeto recivido");
                IVA=(float) (o1[4].precio*(0.16));
                System.out.println(IVA);
                precioreal=IVA+(o1[4].precio);
                System.out.println("El total es:" +precioreal);
                break;   
            default:
            
        } 
        oos.close();
        //ois.close();
        //cl.close();
        
    
    }catch(Exception e){
        e.printStackTrace();
    }  
    
}
}

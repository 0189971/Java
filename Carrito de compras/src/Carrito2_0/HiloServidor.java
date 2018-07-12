/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrito2_0;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Objeto implements Serializable{
    int almacen;
    float precio;
    String nombre;
    String  imagen;
    float iva;
    
    
    public Objeto( int alma, float b, String c, String d){
    this.almacen=alma;
    this.precio=b;
    this.nombre=c;
    this.imagen=d;
    this.iva=(float) (b*(.16));
    }  
}   
    
    
    
public class HiloServidor extends Thread {
    private int puerto;
    private JFrame ventana;
    ServerSocket s;
    
    
    public HiloServidor(int pto, JFrame ventana){
    this.puerto=pto;
    this.ventana=ventana;
    }
    
    
    public void run(){
        //Inicializamos al azar el numero de elementos en almacen
        Random pal= new Random();
        int pnum=pal.nextInt(6)+1;
        
        //Inicializamos las imagenes para el envio de datos
        String [] imagenes=new String[10]; 
        imagenes[0]="ArduinoMega.jpg";
        imagenes[1]="ShieldEthernet1.jpg";
        imagenes[2]="FTDI_USB1.jpg";
          
        //Inicializamos los nombres para el envio de datos
        String [] nom={"Arduino Mega", "Ethernet Shield", "USB ftdi"};
        
        //Inicializamos los precios de los articulos
        int[] pre={300, 200, 500, 450};       
        try{
        s= new ServerSocket(puerto);
        Socket cl=s.accept();
        Objeto[] o=new Objeto[10];
        
        //Creamos los flujos de salida o entrada de objetos
        ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
        ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
        int x;
            //Inicializamos los objetos con los respectivos precios   
                for(x=0;x<3;x++){
                    o[x]=new Objeto(pnum,pre[x],nom[x],imagenes[x]);       
                }
            
        
            //Enviamos los objetos a el cliente
                for(x=0;x<3;x++){
                    oos.writeObject(o[x]);
                }
        
        
        JOptionPane.showMessageDialog(ventana, "Se ha establecido la conexion");
        }catch(Exception e){
        JOptionPane.showMessageDialog(ventana, "No se ha podido realizar la conexion");
        }
    }
    
}

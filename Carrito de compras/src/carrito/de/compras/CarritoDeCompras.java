
package carrito.de.compras;

import java.io.*;
import java.net.*;
import java.util.Random;
import javax.swing.JFileChooser;


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
    
    
    public String getPathImagen() {
        return imagen;
    }

  

    public String getNombre() {
        return nombre;
    }

    
}


public class CarritoDeCompras {


    public static void main(String[] args) {
        Random pal= new Random();
        int pnum=pal.nextInt(6)+1;
        String [] nom={"Arduino Mega", "Ethernet Shield", "USB ftdi"};
        int[] pre={300, 200, 500, 450};
        JFileChooser jf= new JFileChooser();
        String [] imagenes=new String[10];
        
        imagenes[0]="ArduinoMega.jpg";
        imagenes[1]="ShieldEthernet1.jpg";
        imagenes[2]="FTDI_USB1.jpg";
        int tam=pre.length;
        
        /*Carrito jf= new Carrito();
        jf.setVisible(true);
        */
            try{
                
            ServerSocket s= new ServerSocket(2000);
            System.out.println("Esperando a que el cliente se conecte...");
            Socket cl=s.accept();
            
            ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
            ObjectOutputStream oos2= new ObjectOutputStream(cl.getOutputStream());
            ObjectOutputStream oos1= new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
           
            Objeto[] o1=new Objeto[10];
                 
                for(int x=0;x<3;x++){
                    o1[x]=new Objeto(pnum,pre[x],nom[x],imagenes[x]);       
                }
                
            System.out.println("Enviando objeto con los datos: a->"+o1[0].precio+"b->"+o1[0].nombre+"c->"+o1[0].imagen);
            oos.writeObject(o1[0]);
            oos.flush();
            System.out.println("Enviando objeto con los datos: a->"+o1[1].precio+"b->"+o1[1].nombre+"c->"+o1[1].imagen);
            oos.writeObject(o1[1]);
            oos.flush(); 
            System.out.println("Enviando objeto con los datos: a->"+o1[2].precio+"b->"+o1[2].nombre+"c->"+o1[2].imagen);
            oos.writeObject(o1[2]);
            oos.flush(); 
            
            Objeto o2=(Objeto)ois.readObject();
            System.out.println("Objeto recibido con los datos: a->"+o2.precio+"b->"+o2.nombre+"c->"+o2.imagen);
            //recibiendo la compra del objeto 
                System.out.println("Verificando si hay en existencia el producto...");
                System.out.println(o2.almacen);
                if((o2.almacen)>0){
                    System.out.println("La compra se puede realizar");
                    oos.writeObject(o2);
                    oos.flush();
                }else{
                
                
                }
            
            oos.close();
            ois.close();
            //cl.close();
            //s.close();
        
        
        }catch(Exception e){
        e.printStackTrace();
        }    
    }
    
}

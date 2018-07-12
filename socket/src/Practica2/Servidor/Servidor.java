package Practica2.Servidor;
import Practica2.Articulo;
import Practica2.ArticuloCarrito;
import Practica2.ArticuloCarritoS;
import Practica2.Ticket;
import java.awt.Image;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
public class Servidor {
    public static void main(String[] args) {
       generarBD();
       ArrayList<Articulo> listArticulos= new ArrayList<Articulo>() ;
       ArrayList<ArticuloCarritoS> listArticulosCarritoCliente= new ArrayList<ArticuloCarritoS>() ;
       
		try{
			ServerSocket s = new ServerSocket(1234);
			for (; ; ){
                                System.out.println("Esperando clientes");
				Socket cl = s.accept();
                                
				System.out.println("Cliente conectado desde:"+cl.getInetAddress().getHostAddress()+":"+cl.getPort());
				
                                ObjectOutputStream oos =new ObjectOutputStream(cl.getOutputStream());
                          
                                ObjectInputStream ois =new ObjectInputStream(new FileInputStream("objetos.txt"));
                                listArticulos = (ArrayList<Articulo>)ois.readObject();
                                ois.close();
                                //se envian los objetos al cliente
                                oos.writeObject(listArticulos);
                                System.out.println("objets enviados:");
                                
                                //se reciben la lista de articulos del cliente
                                System.out.println("Recibiendo lista de articulos del  carrito del cliente");
                                
                                ObjectInputStream iis =new ObjectInputStream(cl.getInputStream());
                                listArticulosCarritoCliente = (ArrayList<ArticuloCarritoS>)iis.readObject();
                                System.out.println("Lista Recibida");
                                //se genera el ticket
                                System.out.println("Generando el ticket");
                                Ticket ticket=  new Ticket(listArticulosCarritoCliente);
                                
                                oos.flush();
                                System.out.println("Enviando ticket a cliente");
                                oos.writeObject(ticket);
                                
                                //Se actualiza la BD
                                actualizarBD(listArticulos,listArticulosCarritoCliente);
                                System.out.println("Base de datos Actualizada");
                              
                                
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
                
	}

   
    private static void generarBD() {
        
        try {
            
        ArrayList<Articulo> listArticulos= new ArrayList<Articulo>();
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("objetos.txt"));
        listArticulos.add(new Articulo(1000, "Motorola RAZR", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\celulares\\MotorolaRAZR.jpg", 2500.0,"celulares"));
        listArticulos.add(new Articulo(1001, "Sony XperisT", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\celulares\\SonyXperiaT.jpg", 2500.0,"celulares"));
        listArticulos.add(new Articulo(1002, "Iphone 6s", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\celulares\\iphone6s.jpg", 2500.0,"celulares"));
        listArticulos.add(new Articulo(1003, "Nokia Lumia 700", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\celulares\\nokialumia730.jpg", 2500.0,"celulares"));
        listArticulos.add(new Articulo(1004, "Samsung s6", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\celulares\\samsungS6.jpg", 2500.0,"celulares"));
        
        listArticulos.add(new Articulo(2000, "kinect", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\consolas de videojuegos\\kinect.jpg", 2500.0,"Consolas"));
        listArticulos.add(new Articulo(2001, "ps3", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\consolas de videojuegos\\ps2.jpg", 2500.0,"Consolas"));
        listArticulos.add(new Articulo(2002, "ps4", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\consolas de videojuegos\\ps3.jpg", 2500.0,"Consolas"));
        listArticulos.add(new Articulo(2003, "ps vita", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\consolas de videojuegos\\psvita.jpg", 2500.0,"Consolas"));
        listArticulos.add(new Articulo(2004, "Xbox", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\consolas de videojuegos\\xbox.jpg", 2500.0,"Consolas"));
        
        listArticulos.add(new Articulo(3000, "Smart Tv Lg", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\smartTV\\lg.jpg", 2500.0,"Smart Tv"));
        listArticulos.add(new Articulo(3001, "Smart Tv Panasonic", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\smartTV\\panasonic.jpg", 2500.0,"Smart Tv"));
        listArticulos.add(new Articulo(3002, "Smart Tv Samsung", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\smartTV\\samsung.jpg", 2500.0,"Smart Tv"));
        listArticulos.add(new Articulo(3003, "sony", "Hermosa Television", 200, "G:\\Users\\Javier\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\smartTV\\sony.jpg", 2500.0,"Smart Tv"));
        listArticulos.add(new Articulo(3004, "Toshiba", "Hermosa Television", 200, "C:\\Users\\javier-pc\\Documents\\NetBeansProjects\\Socket\\src\\Practica2\\Servidor\\Imagenes\\smartTV\\toshiba.jpg", 2500.0,"Smart Tv"));
        
        
        oos.writeObject(listArticulos);
        
        } catch (Exception e) {
        }
        
        
    }

    private static void generarTicket(ArrayList<ArticuloCarritoS> listArticulosCarritoCliente) {
        
    }

    private static void actualizarBD(ArrayList<Articulo> listArticulos, ArrayList<ArticuloCarritoS> listArticulosCarritoCliente) {
        for (int i = 0; i < listArticulosCarritoCliente.size(); i++) {
            for (int j = 0; j < listArticulos.size(); j++) {
                if(listArticulos.get(i).getIdArticulo() == listArticulosCarritoCliente.get(i).getArticulo().getIdArticulo()){
                    listArticulos.get(i).setExistencias(   listArticulos.get(i).getExistencias() - listArticulosCarritoCliente.get(i).getCantidad()  );       
                }
            }
        }
        try {
            ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("objetos.txt"));
            oos.writeObject(listArticulos);

            
        } catch (Exception e) {
        }
        
    }

    

    
    
}





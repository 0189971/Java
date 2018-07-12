package examenredes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author javis
 */
public class HiloPlayerSopa extends Thread{
    private int puerto;
    private String host;
    ClienteSopadeLatras ventana;
    char[][] coordenadas2= new char[20][20];
    String [] listaordenada= new String[20];
    private boolean continuar=true;
    Socket cl;
    public HiloPlayerSopa(int puerto, String host, ClienteSopadeLatras ventana){
        this.host=host;
        this.puerto=puerto;
        this.ventana=ventana;
    } 
    
    public void run(){
        
     
        try{
            cl=new Socket(host, puerto);
            ObjectOutputStream oos= new ObjectOutputStream(cl.getOutputStream());
            ObjectInputStream ois= new ObjectInputStream(cl.getInputStream());
            
            System.out.println("Recibimos el objeto :)");
            Objeto o1=(Objeto)ois.readObject();
                
                for(int i=0;i<15;i++){
                    System.out.println(o1.listaDes[i]);
                }
                
            FileWriter fichero = null;
            PrintWriter pw = null;
             try{
                    fichero = new FileWriter("C:\\Users\\javis\\Documents\\NetBeansProjects\\ExamenRedes\\prueba.txt");
                    pw = new PrintWriter(fichero);

                    for (int i = 0; i < 15; i++)
                        pw.println(o1.listaDes[i]);  
                        
                }catch(Throwable e){
                }
                fichero.close();
            
            FileWriter fichero2 = null;
            PrintWriter pw2 = null;
            
            //Rellenamos el arreglo de palabras
            int num1 = 65;
            int num2 = 90; 
            int relleno;
            try{
                    for(int i=0; i<16;i++){
                        for(int j=0; j<16; j++){
                            relleno=(int)Math.floor(Math.random()*(num2 -num1)+num1);
                            if(o1.SopaLetras[i][j]==' '){
                                o1.SopaLetras[i][j]=(char)relleno;
                            }
                        }
                    }
            
            }catch(Exception e){
            }

            //Imprimimos la matriz rellena aleatoriamente
                for (int i = 0; i < 16; i++){
                        for(int j=0; j<16; j++){
                            System.out.printf("%c",o1.SopaLetras[i][j]);
                        }
                    System.out.println();
                }
                
             try{
                    fichero2 = new FileWriter("C:\\Users\\javis\\Documents\\NetBeansProjects\\ExamenRedes\\sopa.txt");
                    pw2 = new PrintWriter(fichero2);

                    for (int i = 0; i <16; i++){
                        for(int j=0; j<16; j++){
                            pw2.print("-"+o1.SopaLetras[i][j]);
                        }  
                        pw2.println("\n");
                    }   
            }catch(Throwable e){
            }
            fichero2.close();    
            listaordenada=o1.lista;
            
            try{
                //Jalamos los valores de mis cordenadas
                    for (int i = 0; i <16; i++){
                        for(int j=0; j<16; j++){
                         coordenadas2[i][j]=o1.coordenadas[i][j];
                            System.out.printf("%c",coordenadas2[i][j]);
                        }  
                        System.out.println();
                    }
                }catch(Exception e){
                System.out.println("No se pudo leer las cordenadas");
                }
            
        JOptionPane.showMessageDialog(ventana,"Se ha establecido la conexion");
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"No se pudo conectar");
        }
        
        
    }
    
    public char[][] Obtinecordenadas(){
        return coordenadas2;
    }
    
    public String[] obtenerlistaordenada(){
        return listaordenada; 
    }
    
    public void detenElHilo() 
    { 
    continuar=false; 
    }
    
    
    public void rest() throws IOException{
    cl.close();
    
    }
}

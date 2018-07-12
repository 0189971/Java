package bingo;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import javax.swing.JOptionPane;
/**
 * @author Yuca
 */
  
public class Bingo {
     public Socket s;
     String ip="127.0.0.1";
     int puerto=1234;
     public int[]result={};
     public String usuario;
     public int bingo;  
    ObjectOutputStream salida;
    ObjectInputStream entrada; 
     
     public void conexion(){
       Random rand = new Random();
       try{
            s = new Socket (ip,puerto);
            usuario = JOptionPane.showInputDialog(null, "Jugador ?", "Introduzca nombre del jugador", JOptionPane.QUESTION_MESSAGE);

            if ( usuario==null && usuario.trim().length()<0 ) 
                usuario="Anomimo";

            entrada = new ObjectInputStream(s.getInputStream());
            salida = new ObjectOutputStream(s.getOutputStream());

            try {
                 result = (int[]) entrada.readObject();
             }catch (ClassNotFoundException ex) {
                 ex.printStackTrace();
            }
            for (int i = 0; i < 16; i++) {
                        System.out.println("Num "+i+"recibido: "+result[i]);
            }            
       }catch(Exception e){
                      JOptionPane.showMessageDialog(null, "Direccion IP o PUERTO no valido'", "VERIFICAR", JOptionPane.WARNING_MESSAGE);          
           e.printStackTrace();
       }
     }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Bingo bin = new Bingo();
//        bin.conexion();
          Interfaz inter = new Interfaz();
    }
}

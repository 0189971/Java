/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticastconsola;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author javis
 */
public class HILOServidor extends Thread{

private int puerto;
private JFrame ventana;
    
    public HILOServidor(JFrame ventana, int puerto){
    this.puerto=puerto;
    this.ventana=ventana;
    }
  
    public void run(){
        ServerSocket ss = null;
        try{
            ss=new ServerSocket(puerto);
            while(true){
                Socket s=ss.accept();
                manager.getInstance().conectarNuevocliente(new HiloConexiones(s));
            
            }
            
            //JOptionPane.showMessageDialog(ventana,"Se han conectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto");
        }
        
        try{
        ss.close();
        }catch(Exception e){
        
        }  
    }
    

}

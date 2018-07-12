/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticastconsola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author javis
 */
public class HILOCliente extends Thread{
   private int puerto;
   private String host;
   ChatCliente ventana;
   Socket  cl;
   String nick;
    public HILOCliente(int port, String host, ChatCliente ventana, String nick ){
    this.puerto=port;
    this.host=host;
    this.ventana=ventana;
    this.nick=nick;
    }

    public void run(){
        try{
        cl=new Socket(host,puerto);
        DataInputStream dis=new DataInputStream(cl.getInputStream());//Preparoandonos para recibir informacion del servidor
        enviartra(nick,1);
        JOptionPane.showMessageDialog(ventana,"Si se ha podido conectar");
        
        while(true){//Creamos un bucle para leer lo que servidor nos envia
            String msjr=dis.readUTF();
            ventana.recibirmsj(msjr);
        
        }
        
        }catch(Exception e){
        JOptionPane.showMessageDialog(ventana,"No se pudo conectar");
        }
        
    }
    public void enviartra(String msj, int numnick){
        try{
            DataOutputStream dos= new DataOutputStream(cl.getOutputStream());   //Creamos un flujo de salida para enviar los datos del chat al servidor 
            dos.writeInt(numnick);
            dos.writeUTF(msj);//Enviamos los mensajes
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se puedo enviar el mensaje");
        }
    }
        
    public void enviarmsj(String msj){
            enviartra(msj,2);
    }
 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatmulticastconsola;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author javis
 */
public class HiloConexiones extends Thread{
    
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    
    public HiloConexiones(Socket s) {
        try{
            this.s=s;
            dis= new DataInputStream(s.getInputStream());
            dos= new DataOutputStream(s.getOutputStream());
            start();
        }catch(Exception e){}
    }
    
    public void run(){
    try{    
        while(true){
            try{
                int nick=dis.readInt();
                String msj=dis.readUTF();
                manager.getInstance().enviartra(nick, msj);
            }catch(Exception e){}    
        }
    }catch(Exception e){
    }
    }
    
    
    
    public void enviarmsj(String msj){
        try{
            dos.writeUTF(msj);
        }catch(Exception e){
        }
    
    }

}

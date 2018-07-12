/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpractica5redes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javis
 */
public class WebPractica5redes {

        public static final int PUERTO=8000;
	ServerSocket ss;
        Servidor cliente=null;
        
        public WebPractica5redes() throws IOException{
                        System.out.println("Iniciando Servidor.......");
			this.ss=new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado:---OK");
			System.out.println("Esperando por Cliente....");
			for(;;)
			{
				Socket accept=ss.accept();
                                
                                try {
                                    cliente=new Servidor(accept);
                                } catch (Exception ex) {
                                    Logger.getLogger(WebPractica5redes.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                cliente.start();
			}
        
        }
        
        
    public static void main(String[] args) throws IOException {
        WebPractica5redes cl=new WebPractica5redes();
    }
    
}

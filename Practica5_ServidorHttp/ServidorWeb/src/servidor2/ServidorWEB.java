 package servidor2;

import Servidorweb.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;
//----------------------------------------------------------------------------------------------------------

public class ServidorWEB
{
    private Semaphore web;
    
    public static final int PUERTO=8000; //definimos puerto
    ServerSocket ss; ///Implementamos un socket servidor en espera de peticiones

    public ServidorWEB(int numero) throws Exception
    {
        this.web=new Semaphore(numero);

    }
    
//------------------------------------------------------------------------------------------------------------
    public void getMesa() {
    try {
        // Acquire a permit for a table
        web.acquire();       
    }
    catch (InterruptedException e) {
    e.printStackTrace();
    }
 }
    public void returnMesa() {
       web.release();
    }  
//-------------------------------------------------------------------------------------------------------------

    public static void main(String[] args) throws Exception{
        ServidorWEB s=new ServidorWEB(4);
        Manejador[] cl= new Manejador[4];
        
        for(int i=0; i<4;i++){
            cl[i]=new Manejador(s,1);
            cl[i].start();
        } 
            
            
            
    }
}

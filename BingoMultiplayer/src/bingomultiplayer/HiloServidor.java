/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingomultiplayer;

import java.net.*;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author javis
 */
public class HiloServidor extends Thread {
    
    int[] numbingo=new int[101];
    int[] numale=new int [101];
    String[] numevi=new String[101];
    String paro="te";
    String cparo="cl";
    InetAddress gpo=null;
    int pto =9999;
    int numconexiones;
    byte[] b;
    public HiloServidor(int numcon, JFrame ventana) throws IOException{
        System.out.println("Iniciando servidor");
        this.numconexiones=numcon;
    }
   

        public void run(){
            try{
                //Creamos la matriz de numeros para enviarlos
                MulticastSocket cl= new MulticastSocket(9999);
                System.out.println("Cliente escuchando puerto "+ cl.getLocalPort());
                cl.setReuseAddress(true);
                    int r=0;
                    for(int j=0;j<100;j++){
                        numbingo[j]=r;
                        r++;
                    }
                
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            cl.joinGroup(gpo);
            System.out.println("Unido al grupo");
                
                //Creamos un arreglo con los numeros aleatorios 
                    numale=genale(numbingo,numale);
                    System.out.println("Imprimimos el arreglo");
                    for(int k=0;k<100;k++){
                        System.out.printf("%d.- %d\n",k, numale[k]);
                    }
                    System.out.println("Preparando numeros para ser enviados...");
                    
                // Creamos el arreglo de cadenas
                    
                    
                    for(int k=0;k<100;k++){
                        numevi[k]=String.valueOf(numale[k]);
                    }
                    //b=numevi[0].getBytes();
                    System.out.println("Esperando a que todos los clientes se conecten");
                    int cp=0;
                    
                    while(cp<numconexiones){
                        DatagramPacket p = new DatagramPacket(new byte[10],10);
                        cl.receive(p);
                        String msj2 = new String(p.getData());
                            if(cparo.equals(msj2.trim())){
                                cp++;
                            }
                    }
                    
                    for(int i=0;i<100;i++){
                        try{
                        b=numevi[i].getBytes();
                        DatagramPacket p = new DatagramPacket(b,b.length,gpo,9876);
                        cl.send(p);
                        
                            Thread.sleep(350);
                        }catch(InterruptedException ie){}
                    
                    }
                    
                    //Enviamos el paro
                    b=paro.getBytes();
                    DatagramPacket p = new DatagramPacket(b,b.length,gpo,9876);
                    cl.send(p);
                    
                    try{
                        Thread.sleep(10000);
                    }catch(Exception e){
                    }
                    
                    //Nos preparamos para enviar los numeros 100 numeros a los clientes
                    System.out.println("Enviando los nuemeros para el juago al cliente...");
                    int x=0;
                    while(true){
                        b=numevi[x].getBytes();
                        DatagramPacket p3 = new DatagramPacket(b,b.length,gpo,9876);
                        cl.send(p3);
                        System.out.println("Numero "+numevi[x]+" enviado");
                        x++;
                        try{
                            Thread.sleep(1000);
                        }catch(InterruptedException ie){}
                }
                
                
            }catch(Exception e){
                System.out.println("termino");
            }
    
        }

    int[] genale(int a[], int b[]){
        int rango=100, c;
            for(int i=0; i<100;i++){
                Random pal= new Random();
                int pnum=pal.nextInt(rango)+1;
                System.out.printf("El rango es de 0 a %d\n",rango);
                System.out.printf("El numero aleatorio es: %d\n",pnum);
                    b[i]=a[pnum];   //Almacenamos el numero que esta en la pocision 
                    c=a[rango];     //Obtemos el ultimo numero del rango 
                    a[pnum]=c;      //A la posicion del numeroaleatorio le asignamos la ultima posicion del rango 
                rango--;
            }  
       return b;
    }
}

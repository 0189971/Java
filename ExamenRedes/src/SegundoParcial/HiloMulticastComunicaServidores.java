/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SegundoParcial;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.HashMap;


/**
 *
 * @author javis
 */
public class HiloMulticastComunicaServidores extends Thread {
    int pto;
    String nomPtoDir[]=new String[200];
    boolean Econtrol;
    HashMap<String,Integer> listaProductos = new HashMap<String,Integer>();
    
        public HiloMulticastComunicaServidores(int pto){
            this.pto=pto;
        }

    public void run(){
     InetAddress gpo=null;
        for(int i=0;i<nomPtoDir.length;i++){
            nomPtoDir[i]="x";
        }
     
        try{
                MulticastSocket cl= new MulticastSocket(pto);
                System.out.println("Cliente escuchando puerto "+ cl.getLocalPort());
                cl.setReuseAddress(true);
                try{
                    gpo = InetAddress.getByName("228.1.1.2");       //Direcion de grupo diferente para guardar la lista de archivos 
                }catch(UnknownHostException u){
                    System.err.println("Direccion no valida");
                }//catch
                cl.joinGroup(gpo);
                System.out.println("Unido al grupo");
                
                while(true){
                    DatagramPacket p = new DatagramPacket(new byte[13],13);
                    cl.receive(p);
                       
                }//while
        }catch(Exception e){
            
        }//catch
    
    }
    public boolean verifica(String msj){
        for(int j=0; j<nomPtoDir.length;j++){
            if(nomPtoDir[j].equals(msj)){
            return false;
            }else if(nomPtoDir[j].charAt(0)=='x'){
            return true;
            }
        }
    return false;
    }

}//class
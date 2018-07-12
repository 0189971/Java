package SegundoParcial;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author javis
 */
public class ReciveArrayList extends Thread{
        InetAddress gpo=null;
        int puerto;
        ArrayList<String> List = new ArrayList<String>();
        String [] elementos= new String[1000];
        int num=0;
            public ReciveArrayList(int pto){
                this.puerto=pto;
            }
            
    public void run(){
        
            try{
            MulticastSocket cl= new MulticastSocket(puerto);
            cl.setReuseAddress(true);
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            cl.joinGroup(gpo);
            System.out.println("Unido al grupo");
            
                System.out.println("Preparado para recibir lista de archivos");
           
            while(true){
                    DatagramPacket p3 = new DatagramPacket(new byte[100],100);
                    cl.receive(p3);
                    String list=new String(p3.getData());
                    num=Integer.parseInt(list.trim());
                        for(int j=0;j<num;j++){
                            DatagramPacket p2 = new DatagramPacket(new byte[100],100);
                            cl.receive(p2);
                            elementos[j]=new String(p2.getData());
                        }
                    
            }
        }catch(Exception e){
        }
    }   
    
    public int  getnum(){
        return num;
    }
    public String[] getelementos(){
        return elementos;
    }
    public ArrayList<String> getArrayList(){
        return List;
    }
        
}

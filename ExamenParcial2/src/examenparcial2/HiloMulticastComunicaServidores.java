package examenparcial2;

import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 *
 * @author javis
 */
public class HiloMulticastComunicaServidores extends Thread {
    int pto;
    String nomPtoDir[]=new String[200];
    String [] ficherosname = null;
    boolean Econtrol;
    int eleccion=0;
    String msj="";
    String msj2="";
    String msj3="";
    String [] archivos;
    ArrayList<String> List = new ArrayList<String>(); 
    String elemento;
        public HiloMulticastComunicaServidores(int pto){
            this.pto=pto;
        }

    public void run(){
     InetAddress gpo=null;
     int i=0;
     
        try{
                MulticastSocket cl= new MulticastSocket(pto);
                System.out.println("Cliente escuchando puerto "+ cl.getLocalPort());
                cl.setReuseAddress(true);
                try{
                    gpo = InetAddress.getByName("228.1.1.1");       //Direcion de grupo diferente para guardar la lista de archivos 
                }catch(UnknownHostException u){
                    System.err.println("Direccion no valida");
                }//catch
                cl.joinGroup(gpo);
                System.out.println("Servidor enlace iniciado");
                
                while(true){
                    DatagramPacket p = new DatagramPacket(new byte[1],1);   //guarda la accion que se realizo
                    cl.receive(p);
                    System.out.println(p.getAddress());
                    System.out.println(p.getPort());
                    msj= new String(p.getData());
                    msj=msj.trim();
                    System.out.println(msj);
                    
                    if(Integer.parseInt(msj)==4){
                        DatagramPacket p1 = new DatagramPacket(new byte[50],50); 
                        cl.receive(p1);
                          msj2=new String(p1.getData());
                          msj2=msj2.trim();  
                          int numeroficheros=Integer.parseInt(msj2);
                            for(int k=0;k<numeroficheros;k++){
                                DatagramPacket p2 = new DatagramPacket(new byte[50],50); 
                                cl.receive(p2);
                                msj3=new String(p2.getData());
                                List.add(msj3.trim());
                            }
                            
                        List=new ArrayList<String>(new HashSet<String>(List));
                                  
                    }else if(Integer.parseInt(msj)==1){
                        DatagramPacket p1 = new DatagramPacket(new byte[50],50); 
                        cl.receive(p1);
                        msj2=new String(p1.getData());
                        msj2=msj2.trim();
                        System.out.println(msj2);
                                List.add(msj2);   
                        listar(gpo,cl);
                        msj="";
                    }else if(Integer.parseInt(msj)==2){
                                DatagramPacket p1 = new DatagramPacket(new byte[50],50); 
                                cl.receive(p1);
                                msj2=new String(p1.getData());
                                msj2=msj2.trim();
                                boolean m=List.remove(msj2);
                                System.out.println(m);
                                listardos(gpo,cl, List);
                                //Enviamos el nombre a elimina
                                System.out.println("El ");
                                byte [] elimina=msj2.getBytes();
                                DatagramPacket p10 = new DatagramPacket(elimina,elimina.length,gpo,15000);
                                cl.send(p10);
                    }else if(Integer.parseInt(msj)==3){
                        String c=String.valueOf(List.size());
                        byte [] cm=c.getBytes();
                        DatagramPacket p8 = new DatagramPacket(cm,cm.length,gpo,10001);
                         cl.send(p8);
                            for(int j=0;j<List.size();j++){
                                byte[] x=List.get(j).getBytes();
                                DatagramPacket p6 = new DatagramPacket(x,x.length,gpo,10001);
                                cl.send(p6);
                                try{
                                    Thread.sleep(500);
                                }catch(Exception e){}
                            }
                    }
                    
                    
                    
                    
                        System.out.printf("\n Los elementos en la lista son los siguientes \n");
                        for(int j=0;j<List.size();j++){
                            System.out.println(elemento=List.get(j));
                        }
                }//while
        }catch(Exception e){   
        }//catch
        
    }//run
    
    public void listar( InetAddress gpo, MulticastSocket cl) throws IOException{
             String c=String.valueOf(List.size());
                        byte [] cm=c.getBytes();
                        DatagramPacket p8 = new DatagramPacket(cm,cm.length,gpo,10001);
                         cl.send(p8);
                            for(int j=0;j<List.size();j++){
                                byte[] x=List.get(j).getBytes();
                                DatagramPacket p6 = new DatagramPacket(x,x.length,gpo,10001);
                                cl.send(p6);
                                try{
                                    Thread.sleep(500);
                                }catch(Exception e){}
                            }
    
    }
        public void listardos( InetAddress gpo, MulticastSocket cl, ArrayList List2) throws IOException{
             String c=String.valueOf(List.size());
                        byte [] cm=c.getBytes();
                        DatagramPacket p8 = new DatagramPacket(cm,cm.length,gpo,10001);
                         cl.send(p8);
                            for(int j=0;j<List.size();j++){
                                byte[] x=List.get(j).getBytes();
                                DatagramPacket p6 = new DatagramPacket(x,x.length,gpo,10001);
                                cl.send(p6);
                                try{
                                    Thread.sleep(500);
                                }catch(Exception e){}
                            }
    
    }
    
    public static void main(String[] args ){
        HiloMulticastComunicaServidores enlace=new HiloMulticastComunicaServidores(10100);
        enlace.start();
    }
    
}//class
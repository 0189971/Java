package SegundoParcial;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author javis
 */
public class DescubreMulticastCliente extends Thread{
    int puerto;
    String div="--";
    String direc="", direc2="";
    int [] puertos=new int[100];
    String [] ip=new String[100];
    String [] direcciones=new String[100];
    boolean cont;
    
    private int pto;
            public DescubreMulticastCliente(int pto){
                this.pto=pto;
            }
        public void run()
        {
            InetAddress gpo=null;
                for(int x=0;x<100;x++){
                    direcciones[x]="x";
                }
            try{
                MulticastSocket cl= new MulticastSocket(pto);
                System.out.println("Cliente escuchando puerto "+ cl.getLocalPort());
                cl.setReuseAddress(true);
                try{
                    gpo = InetAddress.getByName("228.1.1.1");
                }catch(UnknownHostException u){
                    System.err.println("Direccion no valida");
                }//catch
                cl.joinGroup(gpo);
                System.out.println("Unido al grupo");
                int k=1;
                int m=0;
                while(true){
                    DatagramPacket p = new DatagramPacket(new byte[17],17);
                    cl.receive(p);
                    DatagramPacket p1 =new DatagramPacket(new byte[14],14);
                    cl.receive(p1);
                    DatagramPacket p2 =new DatagramPacket(new byte[4],4);
                    cl.receive(p2);
                    System.out.println("Datagrama recibido..");
                    String msj = new String(p.getData());
                    String msj2= new String(p1.getData());
                    String msj3= new String(p2.getData());
                    //System.out.println("El msj2 es: "+msj2);
                    //System.out.println("El msj3 es: "+msj3);
                    if((msj.length())>0){
                         cont=verifica(msj.trim());   
                         System.out.println(cont);
                         if(cont){
                            for(int i=0; i<100;i++){
                                if(direcciones[i].charAt(0)=='x'){
                                    direcciones[i]=msj.trim();
                                    ip[i]=msj2.trim();
                                    puertos[i]=Integer.parseInt(msj3.trim());
                                    break;
                                }
                            }
                         }
                    }
                    
                    div=""+msj.charAt(0)+msj.charAt(1)+msj.charAt(2)+msj.charAt(3);
                    puerto=Integer.parseInt(div);
                        for(int h=4;h<13;h++){
                            direc=direc+msj.charAt(h);
                        }
                    //System.out.println(puerto);
                    System.out.println("La direcion es "+direcciones[0]);
                    System.out.println("La direcion es "+direcciones[1]);
                    System.out.println("La direcion es "+direcciones[2]);
                    direc2=direc;
                    direc="";
                    k=0;
                }//while
            }catch(Exception e){}
            }
        
    private boolean verifica(String msj){   //Verifica si en el arreglo hay un elemento igual
        for(int j=0; j<100;j++){
            if(direcciones[j].equals(msj)){
            return false;
            }else if(direcciones[j].charAt(0)=='x'){
            return true;
            }
        }
    return false;
    }
    
    public String[] getdirecciones(){
        return direcciones;
    }
    
    public int[] getpuertos(){
        return puertos;
    }
    public String[] getips(){
        return ip;
    }
}

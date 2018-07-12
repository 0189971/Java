package bingomultiplayer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author javis
 */
public class HiloCliente extends Thread{
    int[] numeros=new int[101];
    String[] cliente=new String[17];
    boolean paro2=true;
    String aux;
    String nick;
    String cparo="cl";
    String paro="terminado";
    InetAddress gpo=null;
    String[] msj=new String[103];
    String[] msj2= new String[101];
    int numero=16;
    int pto =9876;
    MulticastSocket s;
    String [] caracteres=new String[120];
    JFrame ventana;
    
    public HiloCliente(int pto, String nick,JFrame ventana){
        this.pto=pto;
        this.nick=nick;
        this.ventana=ventana;
    }
    public void run(){
        //Llenamos el arrglo con numeros 
        try{
            s= new MulticastSocket(9876);
            s.setReuseAddress(true);
            s.setTimeToLive(125);
            try{
                gpo = InetAddress.getByName("228.1.1.1");
            }catch(UnknownHostException u){
                System.err.println("Direccion no valida");
            }//catch
            s.joinGroup(gpo);
            int i=0;
            //Enviamos una cadena para incrementar el contador que va llevar el control de los clientes 
            byte[] b;
            b=cparo.getBytes();
            DatagramPacket p1 = new DatagramPacket(b,b.length,gpo,9999);
            s.send(p1);
            
            //Creamos un ciclo para ir recibiendo los numeros
            while(paro2){
                DatagramPacket p = new DatagramPacket(new byte[2],2);
                s.receive(p);
                System.out.println("Mensaje recibido");
                msj[i]= new String(p.getData());
                System.out.printf("La longitud es: %d\n",msj[i].length()); 
                System.out.printf("La primera letra es: %c\n",msj[i].charAt(0));
                
                if(msj[i].charAt(0)=='t'){  //Rompemos el ciclo 
                    paro2=false;
                }
                
                System.out.printf("El contador es: %d\n",i);
                System.out.println("El mensaje es: "+msj[i]);

                //System.out.println("Servidor descubierto: "+p.getAddress());
                i++;
                try{
                    Thread.sleep(50);
                }catch(InterruptedException ie){}
                
            }
            
            System.out.println("Numeros recibidos con exito");
            System.out.println("Creamos el tablero del cliente");
                for(int m=0;m<16;m++){
                    cliente[m]="00";
                }
            cliente=tableroplayer(msj, cliente);
            System.out.println("Los numeros de los clientes son los siguientes");
            for(int j=0; j<16;j++){
                cliente[j]=cliente[j].trim();
                System.out.println(cliente[j]);
            }
            JOptionPane.showMessageDialog(ventana, "Se puede cargar los numeros de los clientes");
            System.out.println("Nos preparamos para ir reciviendo los numeros");
            int ij=0;
            int n=0;
            while(ij<100){
                DatagramPacket p = new DatagramPacket(new byte[2],2);
                s.receive(p);
                String msjj;
                msjj=new String(p.getData());
                caracteres[ij]=msjj.trim();
                System.out.println("Recibiendo "+caracteres[ij]);
                    for(int j=0;j<16;j++){
                        if(caracteres[ij].equals(cliente[j])){
                        n++;
                        }
                    }
                if(n==15){
                    System.out.println("Felicidades has ganado");
                    JOptionPane.showMessageDialog(ventana,"Felicidades el juagador "+nick+"ha GANADO");
                    
                    break;
                }
            ij++;
            }
            
                
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }
   
    
    String recibiendoletras(){
    int j=0;
            while(true){
                DatagramPacket p = new DatagramPacket(new byte[2],2);
                    try {
                        s.receive(p);
                    } catch (IOException ex) {
                        Logger.getLogger(HiloCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                msj2[j]= new String(p.getData());
                msj2[j]=msj2[j].trim();
                j++;
                try{
                    Thread.sleep(3500);
                }catch(InterruptedException ie){}
                return msj2[j];
                
            }
    }
    
    
    
    String[] verifica2(String a, String[] b){
        for(int z=0; z<16;z++){
            if(a.equals(cliente[z])){
                cliente[z]=null;
                return b;
            }
        }  
    return b;
    }
    
    
    String[] tableroplayer(String a[], String b[]){
        String n="", x;
        boolean verif;
        int i=0;
        while(i<16){
            Random pal= new Random();
            int pnum=pal.nextInt(99)+1;
            n=a[pnum];
            verif=verifica(b,n,i);
                if(verif==true){
                  b[i]=n;
                i++;
                }
        }
    return b;
    }
    
    boolean verifica(String a[], String num, int rango){
        for(int j=0;j<=rango;j++){
            if(a[j].equals(num)){
            return false;
            }    
        }
       return true; 
    }
    
    public String [] obtenertablero(){
    return cliente;
    }
    
    
}

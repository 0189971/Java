/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sincronizaciondehilosaniveldebloque;

/**
 *
 * @author javis
 */
public class SynchBlock implements Runnable{

    StringBuffer b;
    int counter;
    
    public SynchBlock(){
    b=new StringBuffer();
    counter=1;
    }
    
    @Override
    public void run() {
       synchronized(b){
           System.out.println("Comienza el bloque sincronizado");
           int tmp=counter++;
           tmp=counter++;
           String msg="La cuenta es:"+tmp+System.getProperty("line.separator");
           try{
           
           Thread.sleep(100);
           
           }catch(InterruptedException ie){}
           b.append(msg);
           System.out.println("Termina bloque sincronizado");
           
       }
    }
    
    public static void main(String[] args) throws Exception {
       SynchBlock bl=new SynchBlock();
       Thread t1=new Thread(bl);//Bl comparte el contesto del bloque sincronizado 
       Thread t2=new Thread(bl);
       Thread t3=new Thread(bl);
       Thread t4=new Thread(bl);
       t1.start();
       t2.start();
       t3.start();
       t4.start();
       t1.join();
       t2.join();
       t3.join();
       t4.join();
       System.out.println(bl.b);
    }
    
}

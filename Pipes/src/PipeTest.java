import java.io.*;
import java.util.Random;

class Producer extends Thread{
    private DataOutputStream out;
    private Random rand = new Random();
    
    public Producer(OutputStream os){
        out = new DataOutputStream(os);
    }//constructor
    
    @Override
    public void run(){
        while(true){
            try{
                double num = rand.nextDouble();
                out.writeDouble(num);
                out.flush();
                sleep(Math.abs(rand.nextInt()%1000));
            }catch(Exception e){
                e.printStackTrace();
            }//catch
        }//while
    }//run
}//producer

class Filter extends Thread{
    private DataInputStream in;
    private DataOutputStream out;
    private double total=0 ;
    private int count=0;
    
    public Filter(InputStream is,OutputStream os){
        in = new DataInputStream(is);
        out = new DataOutputStream(os);
    }//constructor
    
    public void run(){
        for(;;){
            try{
                double x = in.readDouble();
                total +=x;
                count++;
                if(count!=0)
                    out.writeDouble(total/count);
            }catch(IOException io){
                io.printStackTrace();
            }//catch
        }//for
    }//run
}//filter
class Consumer extends Thread{
    private double old_avg=0;
    private DataInputStream in;
    
    public Consumer(InputStream is){
        in=new DataInputStream(is);
    }//constructor
    
    public void run(){
        for(;;){
            try{
                double avg = in.readDouble();
                if(Math.abs(avg-old_avg)>0.01){
                    System.out.println("El promedio actual es "+avg);
                    old_avg=avg;
                }//if
            }catch(IOException io){
                io.printStackTrace();
            }//catch
        }//for
    }//run
}//Consumer

public class PipeTest {
     public static void main(String[] args){
        try{
            PipedOutputStream po1 = new PipedOutputStream();
            PipedInputStream pi1 = new PipedInputStream(po1); 
            PipedOutputStream po2 = new PipedOutputStream();
            PipedInputStream pi2 = new PipedInputStream(po2); 
            Producer p= new Producer(po1);
            Filter f = new Filter(pi1,po2);
            Consumer c = new Consumer(pi2);
            p.start(); f.start(); c.start();
        } catch(IOException io){
            io.printStackTrace();
        }
     }//main
}//class

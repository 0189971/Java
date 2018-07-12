/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sincronizacionAnivelDeMetodo;

/**
 *
 * @author javis
 */
public class Counter {
    private int countValue;
    
    public Counter(){
        countValue=0;
    }
    
    public Counter(int v){
        countValue=v;
    }
  
    public synchronized void increaseCount(){
        int count=countValue;
        try{            //Cambio de contexto forzamos al hilo a que otro hilo se inicialice 
        
            Thread.sleep(5);
        
        }catch(InterruptedException ie){
        }
        count=count+1;
        countValue=count;
    }
    public synchronized int getCount(){
        return countValue;
    }

    
    public class CountingThreads implements Runnable{
        Counter myCounter;
        int countAmount;
            public CountingThreads(Counter counter, int amount){
                myCounter=counter;
                countAmount=amount;      
            }
            
        public void run(){
            for(int i=1; i<=countAmount;i++){
                myCounter.increaseCount();
            }
                
        }
    }

        public static void main(String[] args) throws Exception {
                Counter c=new Counter();
                Runnable r = new CountingThreads(c,10);
                System.out.println("Comienza la cuenta de hilos");
                Thread t1=new Thread(r);//Bl comparte el contesto del bloque sincronizado 
                Thread t2=new Thread(r);
                Thread t3=new Thread(r);
                t1.start();
                t2.start();
                t3.start();
                t1.join();
                t2.join();
                t3.join();
                System.out.println("El resultado de la cuenta es: "+c.getCount());
            }
    
    }



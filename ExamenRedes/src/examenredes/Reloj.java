/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenredes;

import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author javis
 */



public class Reloj extends Thread {
    
    int seg, min;
    
    public Reloj(){
    this.seg=0;
    this.min=0;
    }
    
    
    public void run(){
        
        try{
            while(true){
            Thread.sleep(1000);
            seg++;
            }
        }catch(Exception e){
        }
        
    }
    
  
        
    
    
    public int obtenertime(){
    return seg;
    }

}

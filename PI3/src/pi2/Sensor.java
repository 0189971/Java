
package pi2;

import com.panamahitek.PanamaHitek_Arduino;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Sensor {
    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino ();
    public static void main(String[] args) {
        try {
            Sensor t = new Sensor();
            Sensores v=new Sensores();
            v.setVisible(true);
            t.conectar(v);
        } catch (AWTException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void conectar(Sensores v) throws AWTException {
        SerialPortEventListener event;
        event = new SerialPortEventListener() {
            //Robot robot = new Robot();
            Robot robot = new Robot(); 
            int vari=1,p=0; //1->a, 2->b, 3->c
            public void serialEvent(SerialPortEvent spe) {
                if(arduino.isMessageAvailable() ){
                    if(p==0){
                        float valor=Float.parseFloat(arduino.printMessage());
                        v.setMonox(valor);
                        p++;
                    }else if(p==1){
                        float co2=Float.parseFloat(arduino.printMessage());
                        v.setTemp(co2);
                        p++;
                    }else if(p==2){
                        float luz=Float.parseFloat(arduino.printMessage());
                        v.setPres(luz);
                        p=0;
                    }
                    
                }
            }   
        };
        try {
            
              
              arduino.ArduinoRXTX("COM3", 20000, 9600, event);
        } catch (Exception ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

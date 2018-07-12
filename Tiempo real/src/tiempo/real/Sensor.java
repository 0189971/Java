package tiempo.real;
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
            int vari=1,p=0, contador=1;
            long inicio;
            public void serialEvent(SerialPortEvent spe) {
                if(arduino.isMessageAvailable() ){
                        if(contador == 1){
                            inicio=System.currentTimeMillis();
                        }else if(contador==100){
                            long fin=System.currentTimeMillis();
                            long tiempo = fin-inicio;
                            tiempo=tiempo/1000;
                            v.setTiempo(tiempo);
                            contador=1;
                        }
                        float muestras=Float.parseFloat(arduino.printMessage());
                        v.contador(contador);
                        v.setMuestras(muestras);
                    
                contador++;  
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

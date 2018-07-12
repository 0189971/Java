package chat.simetrico;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class MServidor extends Thread{
    
    private int port;
    private JFrame ventana;
    
    /** Creates a new instance of MServidor */
    public MServidor(JFrame ventana, int port) {
        this.port = port;
        this.ventana = ventana;
    }
    
    public void run(){
        ServerSocket ss=null;
        try{
            ss=new ServerSocket(port);
            while (true){
                Socket s=ss.accept();
                MSGestorConexiones.getInstance().conectaNuevo(new MSConexion(s));
            }
            //JOptionPane.showMessageDialog(ventana,"Se han conectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana,"Error al abrir el puerto. Posiblemente ya est� en uso.");
        }
        try{
            ss.close();
        }catch(Exception e){
        }
    }
    
}

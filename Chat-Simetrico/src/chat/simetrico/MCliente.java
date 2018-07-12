package chat.simetrico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class MCliente extends Thread{

    private int port;
    private String url;
    private Socket s;
    private boolean bConectado;
    VCliente ventana;
    private String nick;
    /** Creates a new instance of MCliente */
    public MCliente(int port, String url, String nick, VCliente ventana) {
        this.port=port;
        this.url=url;
        this.ventana=ventana;
        this.nick=nick;
    }
    
    public void run(){
        try{
            s=new Socket(url, port);
            DataInputStream dis=new DataInputStream(s.getInputStream());
            enviarTrama(1, nick);
            bConectado=true;
            while(bConectado){
                int nCodigo =dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        ventana.nuevaPersona(sTrama);
                        break;
                    case 2:
                        sTrama=verdad(sTrama);
                        ventana.mensajeRecibido(sTrama);
                        break;
                    case 3:
                        try{
                            int nPos = Integer.parseInt(sTrama);
                            ventana.borrarPersona(nPos);
                        }catch(Exception e2){
                        }
                        break;
                }
            }
            //JOptionPane.showMessageDialog(ventana, "Se ha podido conectar");
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo establecer la conexi�n");
        }
    }
    
    public void enviarMensaje(String sMensaje){
        sMensaje=ocultar(sMensaje);
        enviarTrama(2, sMensaje);
    }
    public String ocultar(String sMensaje){
        int i, j;
        char c;
        String oculto="";
                    for(i=0;i<sMensaje.length();i++){
                     c = sMensaje.charAt(i);
                     c=(char) (c+6);
                     oculto=oculto+""+c;
                    }
        return oculto;
    }
    public String verdad(String sMensaje){
        String verdad="";
        int i, j;
        char c;
                for(i=0;i<sMensaje.length();i++){
                    c = sMensaje.charAt(i);
                    c=(char) (c-6);
                    verdad=verdad+""+c;
                }
        return verdad;
    }
    
    public void enviarTrama(int nCodigo, String sTrama){
        try{
            DataOutputStream dos=new DataOutputStream(s.getOutputStream());
            dos.writeInt(nCodigo);
            dos.writeUTF(sTrama);
        }catch(Exception e){
            JOptionPane.showMessageDialog(ventana, "No se pudo enviar el mensaje");
        }
        
    }

}

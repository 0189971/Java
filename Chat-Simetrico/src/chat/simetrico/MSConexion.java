package chat.simetrico;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Administrador
 */
public class MSConexion extends Thread{
    
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String nick;
    private String aux;
    
    /** Creates a new instance of MSConexion */
    public MSConexion(Socket s) {
        try{
            this.s=s;
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());
            start();
        }catch(Exception e){
        }
    }
    
    public String getNick(){
        return nick;
    }
    
    public void run(){
        while (true){
            try{
                int nCodigo=dis.readInt();
                String sTrama=dis.readUTF();
                switch(nCodigo){
                    case 1:
                        nick=sTrama;
                        MSGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 2:
                        aux="<" + nick + "> - ";
                        aux=ocultar(aux);
                        sTrama= aux + sTrama;
                        System.out.println("Conexiones "+sTrama);
                        MSGestorConexiones.getInstance().enviarTrama(nCodigo, sTrama);
                        break;
                    case 3:
                        MSGestorConexiones.getInstance().desconecta(this);
                        break;
                }
                
            }catch(Exception e){
            }
            
        }
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
    public void enviarTrama(int nCodigo, String sTrama){
        try{
           dos.writeInt(nCodigo);
           dos.writeUTF(sTrama);
        }catch(Exception e){
        }
    }
}

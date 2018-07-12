package chatmulticastconsola;

import java.util.ArrayList;

/**
 *
 * @author javis
 */
public class manager {
    private static manager solo=new manager();
        
        public static manager getInstance(){
        
            return  solo;
        }

    private ArrayList<HiloConexiones> conexiones =new ArrayList<HiloConexiones>();  
        
    public manager(){
    
    
    }
    public void enviarmsj(String msj){
        for(HiloConexiones hc: conexiones ){
            hc.enviarmsj(msj);
        
        }
    }
    public void enviartra(int nick, String msj){
        for(HiloConexiones hc: conexiones ){
           // hc.enviartra(nick, msj);
        }
    }
    
    public void conectarNuevocliente(HiloConexiones nuevo){
        conexiones.add(nuevo);
    }
    
}

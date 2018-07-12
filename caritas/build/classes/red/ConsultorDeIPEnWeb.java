/*
 * Paquete al que pertenece la clase.
 */
package red;

import java.net.InetAddress;
import java.net.UnknownHostException;
/**
 *
 * @author sdelaot
 */
public class ConsultorDeIPEnWeb {
    private String direccionWeb;
    public ConsultorDeIPEnWeb( String direccion ) {
        direccionWeb = direccion;
    }
    public void consultarMiIP() {
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            System.out.println( direccion );
        } catch( UnknownHostException uhe ) {
            System.out.println( uhe.getMessage() );
        }
    }
    public void consultarIP() {
        try {
            InetAddress direccion = InetAddress.getByName( direccionWeb );
            System.out.println( direccion );
        } catch( UnknownHostException uhe ) {
            System.out.println( uhe.getMessage() );
        }
    }
    public void consultarIPPorSegmento() {
        try {
            InetAddress [] segmentos = InetAddress.getAllByName( direccionWeb );
            System.out.println( segmentos.length );
            for( int n=0; n<segmentos.length; n++ ) {
                System.out.println( segmentos[n] + " " );
                }
        } catch( UnknownHostException uhe ) {
            System.out.println( uhe.getMessage() );
        }
    }
}

/*
 * Paquete al que pertenece la clase.
 */
package red;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author sdelaot
 */
public class ConsultorConURL {
    private String direccion; // "http://www.starwave.com/people/naughton"
    public ConsultorConURL( String dir ) {
        direccion = dir;
    }
    public void probarURL( ) throws MalformedURLException {
		URL hp = new URL( direccion );
		System.out.println( " Protocolo : " + hp.getProtocol() );
		System.out.println( " Puerto    : " + hp.getPort() );
		System.out.println( " Nodo      : " + hp.getHost() );
		System.out.println( " Archivo   : " + hp.getFile() );
		System.out.println( " Ext       : " + hp.toExternalForm() );
	}
}

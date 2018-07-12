/*
 * Paquete al que pertenece la clase.
 */
package red;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 *
 * @author sdelaot
 */
public class ConectorDeRed {
    private String direccion; // "http://www.starwave.com/people/naughton"
    public ConectorDeRed( String dir ) {
        direccion = dir;
    }
    public void conectar( ) throws Exception {
		int c = 0;
		URL hp = new URL( direccion );
		URLConnection hpCon = hp.openConnection();
		
		System.out.println( " Fecha               : " + new Date( hpCon.getDate() ) );
		System.out.println( " Tipo de contenido   : " + hpCon.getContentType() );
		System.out.println( " Espira              : " + hpCon.getExpiration() );
		System.out.println( " Ultima modificacion : " + new Date( hpCon.getLastModified() ) );
		int len = hpCon.getContentLength();
		System.out.println( " Longitud contenido  : " + len );
		if( len>0 ) {
			System.out.println( " Contenido " );
			InputStream input = hpCon.getInputStream();
			int i = len;
			while( ((c=input.read())!=-1) && (--i>0) )
				System.out.print( (char)c );
			input.close();
			}
		else {
			System.out.println( " Contenido no disponible " );
			}
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package red;

import java.net.MalformedURLException;

/**
 *
 * @author sdelaot
 */
public class ProbadorDeConsultorDeURL {
    public static void main( String [] args ) {
        ConsultorConURL url = 
          new ConsultorConURL( 
            "http://www.starwave.com/people/naughton" );
        try {
            url.probarURL();
        } catch( MalformedURLException murle ) {
            System.out.println( murle.getMessage() );
        }
    }
}
/*
 Protocolo : http
 Puerto    : -1
 Nodo      : www.starwave.com
 Archivo   : /people/naughton
 Ext       : http://www.starwave.com/people/naughton
 */
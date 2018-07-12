/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package red;

/**
 *
 * @author sdelaot
 */
public class ProbadorDeConectorDeRed {
    public static void main( String [] args ) {
        ConectorDeRed cone = 
            new ConectorDeRed( "http://www.starwave.com/people/naughton" );
        try {
            cone.conectar();
        } catch( Exception e ) {
            System.out.println( e.getMessage() );
        }
    }
}
/*
 Fecha               : Fri Oct 18 18:17:38 CDT 2013
 Tipo de contenido   : text/html; charset=iso-8859-1
 Espira              : 0
 Ultima modificacion : Wed Dec 31 18:00:00 CST 1969
 Longitud contenido  : 213
 Contenido 
http://www.starwave.com/people/naughton
 */
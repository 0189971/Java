/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
import java.io.*;
import java.net.*;
/**
 * @author sdelaot
 */
public class MinimoServidor {
    public static void main( String [] args ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
        String cadena = " Prueba de servidor,\n " + 
                " Cliente-Servidor,\n" + "Saul De La O Torres.";
        int longCad;
        OutputStream s1out;
        ObjectOutputStream oos;
        // Establece el servidor en el socket 4321 (espera 300 segundos)
        try {
            s = new ServerSocket( 4321,300 );
        } catch( IOException e ) {  System.out.println( e );  }
        // Ejecuta un bucle infinito de listen/accept
        while( true ) {
            System.out.print( " Esperando cliente ... " );
            try {
                // Espera para aceptar una conexión
                s1 = s.accept();
                System.out.println( "hecho" );
                // Obtiene un controlador de archivo de salida asociado
                // con el socket
                s1out = s1.getOutputStream();
                oos = new ObjectOutputStream( s1out );
                // Enviamos nuestro texto
                longCad = cadena.length();
                System.out.print( " Enviando mensaje ... " );
                oos.writeObject(cadena);
//                for( int i=0; i < longCad; i++ ) {
//                    s1out.write( (int)cadena.charAt( i ) );
//                    }
                System.out.println( "hecho" );
                // Cierra la conexión, pero no el socket del servidor
                //if( s1out!=null ) { s1out.close(); }
                if( oos!=null ) { oos.close(); }
                //if( s1!=null ) { s1.close(); }
                //if( s!=null ) { s.close(); }
            } catch( IOException e ) { System.out.println( e );   }
            }
        }
}

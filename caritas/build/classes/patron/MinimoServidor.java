package patron;
import java.awt.*;
import java.net.*;
import java.io.*;

class MinimoServidor {
    public static void main( String [] args ) {
        ServerSocket s = (ServerSocket)null;
        Socket s1;
        String cadena = "Prueba del servidor, Saul De La O Torres.\n";
        int longCad;
        OutputStream s1out;

        // Establece el servidor en el socket 4321 (espera 300 segundos)
        try {
            s = new ServerSocket( 4321,300 );
        } catch( IOException e ) {  System.out.println( e );  }
        // Ejecuta un ciclo infinito de listen/accept
        System.out.println( " Pulse Control+C para terminar..." );
        while( true ) {
            try {
            	System.out.println( " Esperando cliente..." );
                // Espera para aceptar una conexi�n
                s1 = s.accept();
                // Obtiene un controlador de fichero de salida asociado con el socket
                s1out = s1.getOutputStream();
                // Enviamos nuestro texto
                longCad = cadena.length();
                System.out.print( " Enviando mensaje ..." );
                for( int i=0; i < longCad; i++ ) 
                	s1out.write( (int)cadena.charAt( i ) );
                System.out.println( " Hecho." );
                // Cierra la conexi�n, pero no el socket del servidor
                s1.close();
            } catch( IOException e ) { System.out.println( e );   }
            System.out.println( " Pulse Control+C para terminar..." );
            }
        }
}

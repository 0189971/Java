/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import java.net.*;
import java.io.*;
/**
 * @author sdelaot
 */
public class MinimoCliente {
    public static void main( String [] args ) throws IOException {
        int c;
        Socket s = null;
        InputStream sIn;
        ObjectInputStream ois;
        // Abrimos una conexión con SAULTORR en el puerto 4321
        try {
            s = new Socket( "LOCALHOST", 4321 );
        }  catch( IOException e )  {  System.out.println( e ); }
        // Obtenemos un controlador de archivo de entrada del socket y
        // leemos esa entrada
        sIn = s.getInputStream();
        ois = new ObjectInputStream( sIn );
        try {
            String cadena = (String)ois.readObject();
            System.out.println( cadena );
        } catch( ClassNotFoundException cnfe ) {
            cnfe.printStackTrace();
        }
//        while( ( c = sIn.read() ) != -1 )
//            System.out.print( (char)c ); 
        // Cuando se alcance el fin de archivo, cerramos la conexión y
        // abandonamos
        //if( sIn!=null ) { sIn.close(); }
        if( ois!=null ) { ois.close(); }
        if( s!=null ) { s.close(); }
        }    
}

package patron;
import java.awt.*;
import java.net.*;
import java.io.*;

class MinimoServidorPatronDeFlujos {
	private ServerSocket server;
	private Socket socket;
	private String mensaje;
	private FlujosFactory flujoFac;
	private FlujosDeEntrada fdin;
	private DataInputStream din;
	/**
	 * Constructor de la clase.
	 */
	MinimoServidorPatronDeFlujos( String mensaje ) {
		server = (ServerSocket)null;
		socket = null;
		this.mensaje = mensaje;
	}
	/**
	 * Este metodo utiliza el ServerSocket para aceptar una peticion de
	 * conexion con la Computadora.
	 */
	private boolean esperaCliente() {
		boolean enEspera = false;
		System.out.println( " Pulse Control+C para terminar..." );
		// Establece el servidor en el socket 4321 (espera 300 segundos)
        try {
            server = new ServerSocket( 4321,300 );
            enEspera = true;
        } catch( IOException e ) {  System.out.println( e );  }
        return enEspera;
	}
	/**
	 * Este metodo utiliza el Socket para enviar a traves de
	 * el socket la informacion contenida en la variable mensaje.
	 */
    boolean enviaMensaje( ) {
		boolean mensajeEnviado = false;
        int longCad;
        OutputStream flujoSalida;
        // Ejecuta un ciclo infinito de listen/accept
        if( esperaCliente() )
		while( true ) {
            try {
            	System.out.println( " Esperando cliente..." );
                // Espera para aceptar una conexi�n
                socket = server.accept();
                // Obtiene un controlador de fichero de salida 
                // asociado con el socket
                flujoSalida = socket.getOutputStream();
                // Enviamos nuestro texto
                longCad = mensaje.length();
                System.out.print( " Enviando mensaje ..." );
                for( int i=0; i < longCad; i++ ) 
                	flujoSalida.write( (int)mensaje.charAt( i ) );
                System.out.println( " Hecho." );
                // Cierra la conexi�n, pero no el socket del servidor
                socket.close();
            	mensajeEnviado = true;
            } catch( IOException e ) { System.out.println( e );   }
            System.out.println( " Pulse Control+C para terminar..." );
            }
           return mensajeEnviado;
	}
	/**
	 * Este metodo utiliza el patron de flujos para enviar a traves de
	 * el socket la informacion contenida un archivo.
	 */
	boolean enviaMensajeConPatron() {
		boolean mensajeEnviado = false;
        int longCad;
        OutputStream flujoSalida;
        
        // se utiliza el patron para leer el archivo
        flujoFac = new FlujosFactory();
		fdin = flujoFac.creaFlujoDeEntrada();
		din = fdin.getFlujo( "c:\\AUTOEXEC.BAK" );
        try {
			String linea = din.readLine();
			System.out.println( linea );
			while( linea!=null ) {
				if( linea!=null ) {
					System.out.println( linea );
					mensaje += linea + "\n";
					}
				linea = din.readLine();
				}
			din.close();
		} catch( EOFException error ) {
			error.printStackTrace();
		} catch( IOException error ) {
			error.printStackTrace();
		}
		// utilizamos MinimoServidorPatronDeFlujos.enviaMensaje()
        mensajeEnviado = this.enviaMensaje();
        return mensajeEnviado;
	}
}

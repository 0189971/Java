package patron;
public class PruebaMinimoServidor {
	public static void main( String [] args ) {
		MinimoServidorPatronDeFlujos ms = 
            new MinimoServidorPatronDeFlujos( "Envio de mensaje : hola.\n" );
		//ms.enviaMensaje( );
		if( ms.enviaMensajeConPatron() )
			System.out.println( " Trabajando ... " );
	}
}
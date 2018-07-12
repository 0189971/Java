import java.net.*;

class URLPrueba {
	public static void main( String [] args ) throws MalformedURLException {
		URL hp = new URL( "http://www.starwave.com/people/naughton" );
		System.out.println( " Protocolo : " + hp.getProtocol() );
		System.out.println( " Puerto    : " + hp.getPort() );
		System.out.println( " Nodo      : " + hp.getHost() );
		System.out.println( " Archivo   : " + hp.getFile() );
		System.out.println( " Ext       : " + hp.toExternalForm() );
	}
}
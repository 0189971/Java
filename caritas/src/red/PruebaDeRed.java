import java.net.*;

class PruebaDeRed {
	public static void main( String [] args ) throws UnknownHostException {
		InetAddress direccion = InetAddress.getLocalHost();
		System.out.println( direccion );
		direccion = InetAddress.getByName( "starware.com" );
		System.out.println( direccion );
		InetAddress [] sw = InetAddress.getAllByName( "www.nba.com" );
		for( int n=0; n<sw.length; n++ )
			System.out.println( sw[n] );
		System.out.println( );
	}
}
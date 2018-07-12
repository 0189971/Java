/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package red;

/**
 *
 * @author sdelaot
 */
public class ProbadorDeInetAddress {
    public static void main( String [] args ) {
		DireccionDeRed d = new DireccionDeRed();
		System.out.println( " Host      : " + d.getNombreHost() );
		System.out.println( " IP        : " + d.getIp() );
		int [] dir = d.getDireccion();
		System.out.print( " Direccion : " );
		for( int n=0; n<dir.length; n++ ) {
			System.out.print( dir[n] + " " );
			}
		System.out.println( );
		System.out.println( " Estado    : " + d );
		System.out.println( " ip de www.escom.ipn.mx : " + 
			d.getPorNombre( "www.escom.ipn.mx" ) );
	}
}
/*
 Host      : MacBook-Pro-de-Saul-De-La-O-Torres-2.local
 IP        : 10.0.1.10
 Direccion : 10 0 1 10 
 Estado    : MacBook-Pro-de-Saul-De-La-O-Torres-2.local/10.0.1.10
 ip de www.escom.ipn.mx : www.escom.ipn.mx/148.204.103.231
 */

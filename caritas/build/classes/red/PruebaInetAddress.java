import java.net.*;

/**
 * Clase que devuelve la informacion del host de red
 * @author Saul De La O Torres
 * @version 1.0
 */
class DireccionDeRed {
	/**
     * Direccion del host
     */
	private InetAddress direccion;
	/**
     * Crea el objeto
     */
	public DireccionDeRed() {
		try {
			direccion = InetAddress.getLocalHost();
		} catch( UnknownHostException uhe ) {
			uhe.printStackTrace();
		}
	}
	/**
     * Devuelve el nombre del host
     */
	public String getNombreHost() {
		return direccion.getHostName();
	}
	/**
     * Devuelve la doreccion ip convertida en cadena
     */
	public String getIp() {
		byte [] ip = direccion.getAddress();
		int [] ipi = new int[ip.length];
		for( int n=0; n<ipi.length; n++ ) {
			ipi[n] = ip[n]; 
			} 
		String ipStr = "";
		for( int n=0; n<ip.length; n++ ) {
			if( ipi[n]<0 ) {
				int tmp = ipi[n];
				//System.out.print( " tmp=" + tmp );
				ipi[n] = 256 + tmp;
				}
			ipStr += "" + ipi[n]; 
			if( n<ipi.length-1 ) ipStr += ".";
			}
		return ipStr;
	}
	/**
     * Devuelve la ip en bytes
     */
    public int [] getDireccion() {
    	byte [] dir = direccion.getAddress();
    	int [] ipi = new int[dir.length];
		for( int n=0; n<ipi.length; n++ ) {
			ipi[n] = dir[n]; 
			} 
		for( int n=0; n<dir.length; n++ ) {
			if( ipi[n]<0 ) {
				int tmp = ipi[n];
				//System.out.print( " tmp=" + tmp );
				ipi[n] = 256 + tmp;
				}
			}
		return ipi;
    }
    /**
     * Devuelve la ip del nombre de dominio
     */
    public InetAddress getPorNombre( String dominio ) {
    	InetAddress dir = null;
    	try {
    		dir = InetAddress.getByName( dominio );
    	} catch( UnknownHostException uhe ) {
			uhe.printStackTrace();
		} 	
    	return dir;
    }
    /**
     * Devuelve el estado del objeto
     */
	public String toString() {
		return direccion.toString();
	}
}

/**
 * Prueba la clase
 * @author Saul De La O Torres
 * @version 1.0
 */
class PruebaInetAddress {
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
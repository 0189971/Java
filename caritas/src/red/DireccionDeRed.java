/*
 * Paquete al que pertenece la clase.
 */
package red;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author sdelaot
 */
public class DireccionDeRed {
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
			if( n<ipi.length-1 ) {
                ipStr += ".";
                }
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
    @Override
	public String toString() {
		return direccion.toString();
	}
}

package jdbc;

import java.sql.*;

/**
 * Clase de consulta a una base de datos.
 * @author Saul De La O Torres
 * @version 1.0
 */
public class ConsultorBD extends OperadorBD {
	/**
     * Crea el objeto de consulta
     */
	public ConsultorBD( String bd, String usu, String passwd ) {
		super( bd, usu, passwd );
	}
	/**
     * Devuelve el onjunto de resultados para que el usuario lo trabaje como 
     * desee
     */
	public ResultSet getResultado( String query ) {
		ResultSet rs = null;
		try {
			Statement stmt = this.getConexion().createStatement();
			rs = stmt.executeQuery( query );
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}
		return rs;
	}
	/**
     * Devuelve el conjunto de resultados en una cadena de String
     */
	public String getResultado( String query, String [] campos, int [] tipos ) {
		StringBuffer bufer = new StringBuffer();
		ResultSet rs = null;
		try {
			Statement stmt = this.getConexion().createStatement();
			rs = stmt.executeQuery( query );
			while( rs.next() ) {
				for( int n=0; n<campos.length; n++ ) {
					switch( tipos[n] ) {
						case 1: 
							bufer.append( " " + rs.getInt( campos[n] ) );
							break;
						case 2:
							bufer.append( " " + rs.getDouble( campos[n] ) );
							break;
						case 3:
							bufer.append( " " + rs.getString( campos[n] ) );
							break;
						}
					}
				bufer.append( "\n" );
				}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}
		return bufer.toString();
	}
    /**
     * Devuelve el conjunto de resultados en una cadena de String
     */
	public String getResultado( String query, int [] tipos ) {
		StringBuffer bufer = new StringBuffer();
		ResultSet rs = null;
		try {
			Statement stmt = this.getConexion().createStatement();
			rs = stmt.executeQuery( query );
			while( rs.next() ) {
				for( int n=0; n<tipos.length; n++ ) {
					switch( tipos[n] ) {
						case 1: 
							bufer.append( " " + rs.getInt( n+1 ) );
							break;
						case 2:
							bufer.append( " " + rs.getDouble( n+1 ) );
							break;
						case 3:
							bufer.append( " " + rs.getString( n+1 ) );
							break;
						}
					}
				bufer.append( "\n" );
				}
		} catch( SQLException sqle ) {
			sqle.printStackTrace();
		}
		return bufer.toString();
	}
//	public String [][] getResultados( String query, String [] campos, int [] tipos ) {
//		//String [][] bufer = new String[][campos.length];
//		ResultSet rs = null;
//		// leer numero tuplas que devuelve rs
//		String [][] bufer = new String[tuplas][campos.length];
//		try {
//			Statement stmt = this.getConexion().createStatement();
//			rs = stmt.executeQuery( query );
//			while( rs.next() ) {
//				for( int n=0; n<campos.length; n++ ) {
//					switch( tipos[n] ) {
//						case 1: 
//							bufer[][] = " " + rs.getInt( campos[n] );
//							break;
//						case 2:
//							bufer[][] = " " + rs.getDouble( campos[n] );
//							break;
//						case 3:
//							bufer[][] = " " + rs.getString( campos[n] );
//							break;
//						}
//					}
//				bufer.append( "\n" );
//				}
//		} catch( SQLException sqle ) {
//			sqle.printStackTrace();
//		}
//		return bufer;
//	}
}
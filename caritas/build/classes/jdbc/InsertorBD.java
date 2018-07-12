package jdbc;

import java.sql.*;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase de insercion de datos en una BD
 * @author Saul De La O Torres
 * @version 1.0
 */
public class InsertorBD extends OperadorBD {
	/**
     * Crea el objeto de insercion
     */
	public InsertorBD( String bd, String usu, String passwd ) {
		super( bd, usu, passwd );
	}
    private LinkedList<Integer> reactivo = new LinkedList<Integer>();
    /**
     * Construye un query con la tabla, los campos y los valores para insertar
     * en la base de datos.
     */
	private String construyeQuery( String tabla, String [] campos, 
		String [] valores, int [] tipos ) {
        Iterator itera = reactivo.iterator();
        
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO ").append(tabla).append( " ( ");
		for( int n=0; n<campos.length; n++ ) {
			query.append( campos[n] );
			if( n<campos.length-1 ) {
                query.append( ", " );
                } 
			}
		query.append( " ) VALUES ( " );
		for( int n=0; n<valores.length; n++ ) {
//            if( tipos[n]==3 ) {
//                query.append( "\"" );
//                }
			query.append(valores[n]);
//            if( tipos[n]==3 ) {
//                query.append( "\"" );
//                }
			if( n<valores.length-1 ) {
                query.append( ", " );
                } 
			}
		query.append( " )" );
        System.out.println( query.toString( ) );
		return query.toString();
	}
	/**
     * Inserta una tupla en la base de datos construyendo el query.
     */
	public int insertarBD( String tabla, String [] campos, String [] valores,
        int [] tipos ) {
		String query = construyeQuery( tabla, campos, valores, tipos );
		Connection conn = getConexion();
		int tuplasAfectadas = 0;
		try {
			Statement stmt = conn.createStatement();
			tuplasAfectadas = stmt.executeUpdate( query );
			conn.close();
		} catch( SQLException error ) {
			error.printStackTrace();
		}
		return tuplasAfectadas;
	}
}
package jdbc;

import java.sql.*;

/**
 * Clase de actualizacion sobre una base de datos
 * @author Saul De La O Torres
 * @version 1.0
 */
public class ActualizadorBD extends OperadorBD {
	/**
     * Crea el objeto de actualizacion
     */
	public ActualizadorBD( String bd, String usu, String passwd ) {
		super( bd, usu, passwd );
	}
    /**
     * Constuye el query para actualizar la base de datos con la tabla, los
     * valores y donde los va a actualizar.
     */
	protected String construirQuery( String tabla, String [] campos, 
		String [] valores, String [] donde ) {
		StringBuilder query = new StringBuilder();
		query.append("update ").append(tabla).append( " set ");
		for( int n=0; n<campos.length; n++ ) {
			query.append(campos[n]).append(" = ").append( valores[n] );
			if( n<campos.length-1 ) {
                query.append( ", " );
                }
			}
		    query.append(" where ").append( tabla ).append( "." ).
                  append(donde[0]).
                  append(" = ").
                  append(donde[1]).
                  append( ";");
		return query.toString();
	}
	/**
     * Actualiza la base de datos construyendo el query.
     */
	public int actualizaBD( String tabla, String [] campos, String [] valores, 
        String [] donde ) {
		String query = construirQuery( tabla, campos, valores, donde );
        System.out.println( query );
		Connection conn = getConexion();
		int tuplasAfectadas = 0;
		try {
			Statement stmt = conn.createStatement();
			tuplasAfectadas = stmt.executeUpdate( query );
		} catch( SQLException error ) {
			error.printStackTrace();
		}
        System.out.println( " TA " + tuplasAfectadas );
		return tuplasAfectadas;
	}
}
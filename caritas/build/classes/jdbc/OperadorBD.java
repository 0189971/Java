package jdbc;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase generica de operacion con la base de datos
 * @author Saul De La O Torres
 * @version 1.0
 */
public class OperadorBD {
    /**
     * Vector
     */
    private Vector tableList;
	/**
     * Conexion con la base de datos
     */
	private ConectorBD conecta;
	/**
     * Crea el objeto
     */
	public OperadorBD( String bd, String usu, String passwd ) {
		conecta = new ConectorBD( bd, usu, passwd );
	}
	/**
     * Devuelve la conexion
     */
	public Connection getConexion() {
        Connection conn = conecta.getConexionDB();
        if( conecta.getQueDriver()==2 ) {
            DatabaseMetaData dbMeta;
            try {
                dbMeta = conn.getMetaData();
                ResultSet tables_rs = 
                    dbMeta.getTables( null, null, null, null );
                leerMetadatos( tables_rs );
            } catch (SQLException ex) {
                Logger.getLogger( OperadorBD.class.getName() ).
                        log( Level.SEVERE, null, ex );
            }
            
            }
		return conn;
	}
	/**
     * Cierra la conexion
     */
	public void cierraBD() {
		conecta.cierraConexion();
	}
	/**
     * Inserta o Actualiza la base de datos con el query.
     */
	public int insertaActualizaBD( String query ) {
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
    public void leerMetadatos( ResultSet tables_rs ) {
        tableList = new Vector();
        //tableList = new LinkedList<String>();
        try {
            while ( tables_rs.next() ) {
                String tableName = tables_rs.getString( "TABLE_NAME" );
                tableList.addElement(tableName);
                //tableList.add(tableName);
                }
        } catch( SQLException sqle ) {
            sqle.printStackTrace();
        }
        if( tableList.size()==0 ) {
            System.out.println( "No hay tablas tinySQL en este directorio." );
            }
        else {
            System.out.println( "Hay " + tableList.size() + 
                " tablas tinySQL en este directorio." );
            }
    }
}
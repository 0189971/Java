package jdbc;

import java.sql.*;

/**
 * Clase de insercion avanzada a la base de datos mediante una sentencia 
 * preparada
 * @author Saul De La O Torres
 * @version 1.0
 */
public class InsertorAvanzado extends InsertorBD {
	/**
     * Crea el objeto de insercion
     */
	public InsertorAvanzado( String bd, String usu, String passwd ) {
		super( bd, usu, passwd );
	}
	/**
     * Crea un query para insertar sentencias preparadas
     */
    public StringBuffer creaQueryPreparado( String tabla, String [] campos ) {
    	StringBuffer query = new StringBuffer();
    	query.append( "insert into " + tabla + "( " );
    	for( int n=0; n<campos.length; n++ ) {
    		query.append( campos[n] );
    		if( n<campos.length-1 ) query.append( ", " ); 
    		}
    	query.append( " ) values( " );
    	for( int n=0; n<campos.length; n++ ) {
    		query.append( "?" );
    		if( n<campos.length-1 ) query.append( ", " ); 
    		}
    	query.append( " );" );
    	//System.out.println( query.toString() );
    	return query;
    }
	/**
     * Inserta con una sentencia preparada.
     */
    public int insertaBDPreperada( String tabla, String [] campos, 
    	String [][] vals, int [] tipos ) {
    	int filas = 0;
    	
		Connection conn = getConexion();
    	try {
    		conn.setAutoCommit( false );
    	} catch( SQLException error ) {
    		error.printStackTrace();
    	}
    	StringBuffer query = creaQueryPreparado( tabla, campos );
    	try {
    		PreparedStatement comando = 
    			conn.prepareStatement( query.toString() );
    		int m = 0;
    		String [] valores = new String[campos.length];
    		while( m<vals.length ) {
    			for( int n=0; n<valores.length; n++ ) {
    				valores[n] = vals[m][n];
    				//System.out.print( " " + m + " " + valores[n] + " " );
    				}
    				
    			for( int n=0; n<valores.length; n++ ) {
    				if( tipos[n]==1 ) {
    						if( n==0 ) comando.setInt( (n+1), (m+1) );
    						else {
    							int val = Integer.parseInt( valores[n] );
    							try {
    								
    							} catch( NumberFormatException e ) {
    								e.printStackTrace();
    							}
    							comando.setInt( (n+1), val  );
    							}
    						}
    					else
    					if( tipos[n]==2 ) {
    						double vald = 0.0;
    						try {
    							vald = Double.parseDouble( valores[n] );
    						} catch( NumberFormatException e ) {
    							e.printStackTrace();
    						}
    						comando.setDouble( (n+1), vald  );
    						}
    					else
    					if( tipos[n]==3 ) {
    						comando.setString( (n+1), valores[n] );
    						}
    				 
    				}
    			comando.execute();
    			comando.clearParameters();
    			//System.out.print( " " + tuplas[m] + " " );
    			m++;
    			filas++;
    			//System.out.println( " tupla insertada : " + m );
    			}
    		conn.commit();
    		comando.close();
    	} catch( SQLException error ) {
    		error.printStackTrace();
            try {
                conn.rollback();
            } catch( SQLException sqle ) {
                sqle.printStackTrace();
            }
    	}
    	return filas;
    }
}
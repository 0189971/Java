package jdbc;

import java.sql.*;

/**
 * Clase para hacer la conexion con la base de datos
 *
 * @author Saul De La O Torres
 * @version 1.0
 */
public class ConectorBD implements IDatosBD {
	/**
     * Usuario del sistema de base de datos
     */
	private String usuario;
	/**
     * Password del sistema de base de datos
     */
	private String password;
	/**
     * Base de datos a la que se accede
     */
	private String base;
	/**
     * Conexion con la base de datos
     */
	private Connection conn;
	/**
     * Con que se accede
     * 0. con el puente jdbc
     * 1. con mysql
     * 2. con tinysql
     */
	private int cual;
	/**
     * Crea el objeto de conexion
     */
	public ConectorBD( String bd, String usu, String passwd ) {
		conn 	 = null;
		base 	 = bd;
		usuario  = usu;
		password = passwd;
		cual = 2;
	}
	/**
     * Devuelve el conector URL de la base de datos
     */
	private String conectorURL() {
		String conectorURL = "";
		if( cual==0 ) {
            conectorURL = URL_DRIVER[cual] + base + "?" +
                    "user=" + usuario + "&password=" + password + "";
            }
		else
		if( cual==1 || cual==2 ) {
            conectorURL = URL_DRIVER[cual] + base;
            }
		return conectorURL;
	}
	/**
     * Carga el controlador del JDBC
     */
	private boolean cargaControlador() {
		boolean cargado = false;
		try {
			System.out.print( " Cargando DRIVER : " + DRIVER[cual] );
			Class.forName( DRIVER[cual] ).newInstance();
			cargado = true;
			System.out.println( " hecho." );
		} catch( InstantiationException ie ) {
			ie.printStackTrace();
		} catch( ClassNotFoundException cnfe ) {
			cnfe.printStackTrace();
		} catch( IllegalAccessException iae ) {
			iae.printStackTrace();
		}
		return cargado;
	}
	/**
     * Devuelve la conexion de con la base de datos.
     */
	public Connection getConexionDB() {
		conn = null;
		if( cargaControlador() ) {
			try {
				String conector = conectorURL();
				System.out.print( " Conectando con : " + conector );
				conn = DriverManager.getConnection( conector );
				System.out.println( " ... hecho" );
			} catch( SQLException ex ) {
				System.out.println( " SQLException : " + ex.getMessage() );
				System.out.println( " SQLState     : " + ex.getSQLState() );
				System.out.println( " VendorError  : " + ex.getErrorCode() );
			}
			}
		else {
            System.out.println( " No se puede cargar el controlador de BD" );
            }
		return conn;
	}
	/**
     * Cierra la conexion con la base de datos.
     */
	public void cierraConexion() {
		try {
			if( conn!=null ) {
                conn.close();
                }
		} catch( SQLException error ) {
			error.printStackTrace();
		}
	}
    /**
     * Devuelve que driver esta en uso
     * 
     * @return 0=jdbc-Odbc, 1=MySQL, 2=tinySQL
     */
    public int getQueDriver() {
        return cual;
    }
}
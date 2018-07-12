package jdbc;

/**
 * Interface que contiene los datos de conexion con:<br>
 * 0. El puente JDBC-ODBC<br>
 * 1. Directo a MySQL<br>
 *
 * @author Saul De La O Torres
 * @version 1.0
 */
public interface IDatosBD {
	/**
     * Drivers de distintas bases de datos
     */
	String [] DRIVER = {
		"sun.jdbc.odbc.JdbcOdbcDriver", 
		"com.mysql.jdbc.Driver",
        "com.sqlmagic.tinysql.dbfFileDriver"
		};
	/**
     * URLs de las bases de datos
     */
	String [] URL_DRIVER = {
		"jdbc:odbc:",
		"jdbc:mysql://69.89.31.146:3306/",
        "jdbc:dbfFile:"
		};
}
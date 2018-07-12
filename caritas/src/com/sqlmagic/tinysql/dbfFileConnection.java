/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Librerias para que trabaje la clase
 */
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Properties;
import java.util.concurrent.Executor;


/**
 * Connection class for the dbfFile/tinySQL JDBC driver
 *
 * A lot of this code is based on or directly taken from
 * George Reese's (borg@imaginary.com) mSQL driver.
 *
 * So, it's probably safe to say:
 *
 * Portions of this code Copyright (c) 1996 George Reese
 *
 * The rest of it:
 *
 * Copyright 1996 John Wiley & Sons, Inc. 
 * See the COPYING file for redistribution details.
 *
 * $Author: davis $
 * $Date: 2004/12/18 21:30:05 $
 * $Revision: 1.1 $
 * dBase read/write access <br> 
 * @author Brian Jepson <bjepson@home.com>
 * @author Marcel Ruff <ruff@swand.lake.de> Added write access to dBase and 
 * JDK 2 support
 * Revised by Saul De La O Torres in Septiembre, 2013.
 */
public class dbfFileConnection extends tinySQLConnection {
    /**
     * Archivo de metadatos de la base de datos
     */
    private dbfFileDatabaseMetaData myMetaData = null;
    /**
     *
     * Constructs a new JDBC Connection object.
     *
     * @exception SQLException in case of an error
     * @param user the user name - not currently used
     * @param u the url to the data source
     * @param d the Driver object
     */
    public dbfFileConnection( String user, String u, Driver d ) 
         throws SQLException {
        super( user, u, d );
    }
    /**
     *
     * Returns a new dbfFile object which is cast to a tinySQL
     * object.
     *
     * @return devuelve un objeto tinySQL
     */
    @Override
    public tinySQL getTinySQL() {
        // if there's a data directory, it will
        // be everything after the jdbc:dbfFile:
        if (url.length() > 13) {
            String dataDir = url.substring(13);
            return (tinySQL) new dbfFile(dataDir);
            }
         // if there was no data directory specified in the
         // url, then just use the default constructor
         //
         return (tinySQL) new dbfFile();
    }
    /**
     * This method retrieves DatabaseMetaData
     * see java.sql.Connection#getMetData
     * 
     * @exception SQLException la excepcion que se lanza
     * 
     * @return a DatabaseMetaData object (conforming to JDK 2)
     *
     */
    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        if (myMetaData == null) {
            myMetaData = new dbfFileDatabaseMetaData(this);
            }
        return (DatabaseMetaData)myMetaData;
    }
    /**
     * crea una estructura 
     * 
     * @param typeName el nombre
     * @param attributes los atributos
     * 
     * @return devuelve una estructura
     * 
     * @throws SQLException la excepcion que se lanza
     */
    @Override
    public Struct createStruct( String typeName, Object [] attributes )
        throws SQLException {
        return null;
    }
    /**
     * Crea un arreglo de
     * 
     * @param typeName el nombre
     * @param elements los elementos
     * 
     * @return devuelve un Array
     * 
     * @throws SQLException maneja una excepcion SQL
     */
    @Override
    public Array createArrayOf( String typeName, Object [] elements ) 
        throws SQLException {
        return null;
    }
    /**
     * Devuelve las propiedades del cliente
     * 
     * @return devuelve un objeto de tipo Properties
     * 
     * @throws SQLException la excepcion que se lanza
     */
    @Override
    public Properties getClientInfo()
		throws SQLException {
        return null;
    }
    /**
     * Devuelve una cadena
     * 
     * @param name el nombre del cliente
     * 
     * @return devuelve la informacion del cliente
     * 
     * @throws SQLException la excepcion que se lanza
     */
    @Override
    public String getClientInfo( String name )
		throws SQLException {
        return null;
    }
    /**
     * Pone al cliente
     * 
     * @param properties la informacion del cliente
     * 
     * @throws SQLClientInfoException la excepcion que se lanza
     */
    @Override
    public void setClientInfo( Properties properties )
		throws SQLClientInfoException {
        
    }
    /**
     * Pone la informacion del cliente
     * 
     * @param name el nombre
     * @param value el valor
     * 
     * @throws SQLClientInfoException maneja la excepcion
     */
    @Override
    public void setClientInfo( String name, String value )
		throws SQLClientInfoException {
    
    }
    /**
     * Prueba si es valido
     * 
     * @param timeout el tiempo de espera
     * 
     * @return true si es valido y false en caso contrario
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public boolean isValid( int timeout ) throws SQLException {
        return false;
    }
    /**
     * Crea un objeto SQLXML
     * 
     * @return devuelve un objeto SQLXML
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public SQLXML createSQLXML() throws SQLException {
        return null;
    }
    /**
     * Crea un objeto NClob
     * 
     * @return devuelve un objeto NClob
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public NClob createNClob() throws SQLException {
        return null;
    }
    /**
     * Crea un objeto blob
     * 
     * @return devuelve un objeto Blob
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public Blob createBlob() throws SQLException {
        return null;
    }
    /**
     * Crea un objeto Clob
     * 
     * @return devuelve un objeto Clob
     * 
     * @throws SQLException  maneja la excepcion
     */
    @Override
    public Clob createClob() throws SQLException{
        return null;
    } 
    /**
     * Crea una sentencia preparada
     * 
     * @param sql la sentencia SQL
     * @param columnNames el numero de columnas
     * 
     * @return devuelve la sentencia preparada
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public PreparedStatement prepareStatement(String sql, String columnNames[])
        throws SQLException {
        return null;
    }
    /**
     * Crea una sentencia preparada de las columnas seleccionadas
     * 
     * @param sql la sentencia SQL
     * @param columnIndexes los indices de las columnas
     * 
     * @return devuelve la sentencia preparada
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int columnIndexes[])
        throws SQLException {
        return null;
    }
    /**
     * Crea una sentencia preparada de claves
     * 
     * @param sql la sentencia SQL
     * @param autoGeneratedKeys las claves
     * 
     * @return devuelve la sentencia preparada
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
        throws SQLException {
        return null;
    }
    /**
     * Crea un comando exigente
     * 
     * @param sql la sentencia SQL
     * @param resultSetType el tipo de resultado
     * @param resultSetConcurrency si hay concurrencia
     * @param resultSetHoldability si hay persistencia
     * 
     * @return devuelve un comando exigente
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, 
				  int resultSetConcurrency, 
				  int resultSetHoldability) throws SQLException {
        return null;
    }
    /**
     * Prepara una sentencia
     * 
     * @param sql el comando sql
     * @param resultSetType el tipo de resultados
     * @param resultSetConcurrency si hay concurrencia
     * @param resultSetHoldability si hay persistencia
     * 
     * @return devuelve una sentencia preparada
     * 
     * @throws SQLException maneja la excepcion
     */
    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, 
				       int resultSetConcurrency, int resultSetHoldability)
        throws SQLException {
        return null;
    }
    /**
     * Crea el comando sql
     * 
     * @param resultSetType tipo de resultado
     * @param resultSetConcurrency concurrencia del resultado
     * @param resultSetHoldability habilidad de retencion
     * 
     * @return devuelve un comando sql
     * 
     * @throws SQLException 
     */
    @Override
    public Statement createStatement( int resultSetType, 
        int resultSetConcurrency, int resultSetHoldability) 
            throws SQLException {
        return null;
    }
    /**
     * 
     * @param savepoint el punto que se quita
     * 
     * @throws SQLException la excepcion que se lanza
     */
    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    
    }
    /**
     * 
     * @param savepoint
     * @throws SQLException 
     */
    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
    
    }
    /**
     * Devuelve un objeto de almacen
     * 
     * @param name el nombre
     * 
     * @throws SQLException la excepcion que se lanza
     * 
     * @return devuelve un objeto SavePoint
     */
    @Override
    public Savepoint setSavepoint( String name ) throws SQLException {
        return null;
    }
    /**
     * Pone a salvo al objeto
     * 
     * @return devuelve el objeto salvado
     * 
     * @throws SQLException la excepcion que se lanza
     * 
     * @return devuelve un objeto SavePoint
     */
    @Override
    public Savepoint setSavepoint() throws SQLException {
        return null;
    }
    /**
     * Devuelve la retencion
     * 
     * @return el entero de la retension
     * 
     * @throws SQLException la excepcion que se lanza
     */
    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }
    /**
     * Pone la retenciaon del objeto
     * 
     * @param holdability el tipo
     * 
     * @throws SQLException la excepcion que se lanza
     */
    @Override
    public void setHoldability( int holdability ) throws SQLException {
        
    }
    /**
     * 
     * @param iface
     * @return devuelve false si trabaja con envoltorio
     * 
     * @throws java.sql.SQLException la excepcion que se lanza
     */
    @Override
    public boolean isWrapperFor(java.lang.Class<?> iface) 
        throws java.sql.SQLException {
        return false;
    }
    /**
     * Devuelve un objeto envoltura
     * 
     * @param <T> cualquier parametro
     * @param iface un objeto de tipo T
     * 
     * @return devuelve un objeto de tipo T
     * 
     * @throws java.sql.SQLException la excepcion que se lanza
     */
    @Override
    public <T> T unwrap(java.lang.Class<T> iface) throws java.sql.SQLException {
        return null;
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSchema() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

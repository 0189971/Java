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
 * Connection class for the textFile/tinySQL
 * JDBC driver
 *
 * A lot of this code is based on or directly taken from
 * George Reese's (borg@imaginary.com) mSQL driver.
 *
 * So, it's probably safe to say:
 *
 * Portions of this code Copyright (c) 1996 George Reese
 *
 * The rest of it:
 * Copyright 1996, Brian C. Jepson
 *                 (bjepson@ids.net)
 *
 * $Author: davis $
 * $Date: 2004/12/18 21:29:35 $
 * $Revision: 1.1 $
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307 USA
 * Revised by Saul De La O Torres in Septiembre, 2013.
 */
public class textFileConnection extends tinySQLConnection {
    /**
     * Constructs a new JDBC Connection object.
     *
     * @exception SQLException in case of an error
     * @param user the user name - not currently used
     * @param u the url to the data source
     * @param d the Driver object
     */
    public textFileConnection( String user, String u, Driver d ) 
        throws SQLException {
        super( user, u, d );
    }
    /**
     * Returns a new textFile object which is cast to a tinySQL
     * object.
     *
     * @return devuelve un objeto textFile (tinySQL)
     */
    public tinySQL getTinySQL() {
        return (tinySQL) new textFile();
    }
    /**
     * crea una estructura 
     * 
     * @param typeName nombre tipo
     * @param attributes atributos
     * 
     * @return devuelve la estructura
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public Struct createStruct( String typeName, Object[] attributes)
        throws SQLException {
        return null;
    }
    /**
     * Crea un arreglo de
     * 
     * @param typeName nombre del tipo
     * @param elements los elementos
     * 
     * @return devuelve el arreglo
     * 
     * @throws SQLException por si ocurre una excepcion
     */
    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws
        SQLException {
        return null;
    }
    /**
     * Devuelve la informacion del cliente
     * 
     * @return devuelve las propiedades del cliente
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public Properties getClientInfo()
		throws SQLException {
        return null;
    }
    /**
     * Devuelve la informacion del cliente
     * 
     * @param name nombre del cliente
     * 
     * @return devuelve la informacion
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public String getClientInfo( String name )
		throws SQLException {
        return null;
    }
    /**
     * Pone las propiedades del cliente
     * 
     * @param properties las propiedades del cliente
     * 
     * @throws SQLClientInfoException por si ocurre un error
     */
    @Override
    public void setClientInfo(Properties properties)
		throws SQLClientInfoException {
        
    }
    /**
     * Pone la informacion del cluente
     * 
     * @param name el nombre del cliente
     * 
     * @param value el valor a poner
     * 
     * @throws SQLClientInfoException por si ocurre un error
     */
    @Override
    public void setClientInfo(String name, String value)
		throws SQLClientInfoException {
    
    }
    /**
     * Pregunta si es valido
     * 
     * @param timeout tiempo de espera
     * 
     * @return devuelve true si es valido y false en caso contrario
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public boolean isValid( int timeout ) throws SQLException {
        return false;
    }
    /**
     * Crea un objeto SQLXML
     * 
     * @return devuelve el objeto creado
     * 
     * @throws SQLException por si ocurre un error de creacion
     */
    @Override
    public SQLXML createSQLXML() throws SQLException {
        return null;
    }
    /**
     * Crea un objeto NClob
     * 
     * @return devuelve el objeto creado
     * 
     * @throws SQLException por si ocurre un error en la creacion del objeto
     */
    @Override
    public NClob createNClob() throws SQLException {
        return null;
    }
    /**
     * Crea un objeto Blob
     * 
     * @return devuelve el objeto
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public Blob createBlob() throws SQLException {
        return null;
    }
    /**
     * Crea un objeto Clob
     * 
     * @return devuelve el objeto creado
     * 
     * @throws SQLException si ocurre un error al crear el objeto
     */
    @Override
    public Clob createClob() throws SQLException{
        return null;
    } 
    /**
     * Crea una sentencia preparada
     * 
     * @param sql el comando SQL
     * @param columnNames los nombres de las columnas
     * 
     * @return devuelve la sentencia preparada
     * 
     * @throws SQLException si ocurre un error
     */
    @Override
    public PreparedStatement prepareStatement( String sql, 
        String columnNames[] ) throws SQLException {
        return null;
    }
    /**
     * Crea una sentencia preparada
     * 
     * @param sql el comando SQL
     * @param columnIndexes los indices de las columnas
     * 
     * @return devuelve la sentencia preparada
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public PreparedStatement prepareStatement( String sql, int columnIndexes[] )
        throws SQLException {
        return null;
    }
    /**
     * Crea una sentencia preparada
     * 
     * @param sql el comando SQL
     * @param autoGeneratedKeys las claves generadas
     * 
     * @return devuelve la sentencia preparada
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public PreparedStatement prepareStatement( String sql, 
        int autoGeneratedKeys ) throws SQLException {
        return null;
    }
    /**
     * Devuelve un objeto Callable
     * 
     * @param sql la sentencia SQL
     * @param resultSetType el tipo de resultados
     * @param resultSetConcurrency la concurrencia
     * @param resultSetHoldability la persistencia
     * 
     * @return devuelve el onjeto creado
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public CallableStatement prepareCall( String sql, int resultSetType, 
				  int resultSetConcurrency, 
				  int resultSetHoldability ) throws SQLException {
        return null;
    }
    /**
     * Crea una sentecia preparada
     * 
     * @param sql la sentencia SQL
     * @param resultSetType el conjunto de resultados
     * @param resultSetConcurrency la concurrencia
     * @param resultSetHoldability la persistencia
     * 
     * @return devuelve la sentancia preparada
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public PreparedStatement prepareStatement( String sql, int resultSetType, 
        int resultSetConcurrency, int resultSetHoldability )
        throws SQLException {
        return null;
    }
    /**
     * Crea un objeto statement
     * 
     * @param resultSetType el conjunto de resultados
     * @param resultSetConcurrency la concurrencia
     * @param resultSetHoldability la persistencia
     * 
     * @return devuelve el objeto creado
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public Statement createStatement(int resultSetType, 
        int resultSetConcurrency, int resultSetHoldability) 
            throws SQLException {
        return null;
    }
    /**
     * Salva un punto
     * 
     * @param savepoint el punto a salvar
     * 
     * @throws SQLException por si ocurre un error 
     */
    @Override
    public void releaseSavepoint( Savepoint savepoint ) throws SQLException {
    
    }
    /**
     * devuelve el punto
     * 
     * @param savepoint el punto a devolver
     * 
     * @throws SQLException  por si ocurre un error
     */
    @Override
    public void rollback( Savepoint savepoint ) throws SQLException {
    
    }
    /**
     * Crea un punto de salvamento
     * 
     * @param name el nombre del punto
     * 
     * @return devuelve el objeto de salvamento
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public Savepoint setSavepoint( String name ) throws SQLException {
        return null;
    }
    /**
     * Crea un punto de salvamento
     * 
     * @return devuelve el objeto de salvamento
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public Savepoint setSavepoint() throws SQLException {
        return null;
    }
    /**
     * devuelve la retencion
     * 
     * @return devuelve un entero
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public int getHoldability() throws SQLException {
        return 0;
    }
    /**
     * pone la retencion
     * 
     * @param holdability la retencion
     * 
     * @throws SQLException por si ocurre un error
     */
    @Override
    public void setHoldability(int holdability) throws SQLException {
        
    }
    /**
     * Pregunta si es un envoltorio
     * 
     * @param iface
     * 
     * @return devuelve true si es envoltorio y false en caso contrario
     * 
     * @throws java.sql.SQLException por si ocurre un error
     */
    @Override
    public boolean isWrapperFor( java.lang.Class<?> iface ) 
        throws java.sql.SQLException {
        return false;
    }
    /**
     * Devuelve un objeto cualquiera desenvuelto
     * 
     * @param <T> un template objeto
     * @param iface el objeto que se desenvuelve
     * 
     * @return devuelve el objeto
     * 
     * @throws java.sql.SQLException por si ocurre un error
     */
    @Override
    public <T> T unwrap( java.lang.Class<T> iface ) 
        throws java.sql.SQLException {
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

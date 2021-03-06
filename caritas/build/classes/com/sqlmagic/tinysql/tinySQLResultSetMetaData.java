/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Librerias para que trabaje la clase
 */
import java.sql.SQLException;
import java.sql.Types;

/**
 * tinySQLResultSetMetaData
 *
 * This is the tinySQL Result Set Meta Data class.
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
 * Copyright 1996, Brian C. Jepson
 *                 (bjepson@ids.net)
 * $Author: davis $
 * $Date: 2004/12/18 21:32:53 $
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
public class tinySQLResultSetMetaData implements java.sql.ResultSetMetaData {
    /**
     * The result set.
     */
    private tsResultSet tsql;
    /**
     * Constructs a tinySQLResultSet; requires a tsResultSet object
     * 
     * @param result the tsResultSet object
     */
    public tinySQLResultSetMetaData( tsResultSet result ) {
        tsql = result;
    }
    /**
     *
     * Returns the number of columns in this result set.
     * see java.sqlResultSetMetaData#getColumnCount
     * @return number of columns
     * 
     * @exception SQLException por si ocurre un error
     */
    @Override
    public int getColumnCount() throws SQLException {
        return tsql.getColumnCount();
    }
    /**
     *
     * Is the column an autoincrement (identity, counter) column?
     * see java.sql.ResultSetMetaData#isAutoIncrement
     * 
     * @param column la columna
     * 
     * @return false - tinySQL does not support autoincrement columns
     *
     * @exception SQLException por si ocurre una excepcion
     */
    @Override
    public boolean isAutoIncrement( int column ) throws SQLException { 
        return false;
    }
    /**
     *
     * Is case significant in column names?
     * see java.sql.ResultSetMetaData#isCaseSensitive
     * 
     * @param column la columna
     * 
     * @return true
     *
     * @exception SQLException por si ocurre una excepcion
     */
    @Override
    public boolean isCaseSensitive( int column ) throws SQLException {
        return true;
    }
    /**
     * Can the column be used in a where clause?
     * @see java.sql.ResultSetMetaData#isSearchable
     * 
     * @param column la columna
     * 
     * @return devuelve true si es bsucable y false en caso contrario
     * 
     * @exception SQLException por si ocurre una excepcion
     */
    @Override
    public boolean isSearchable( int column ) throws SQLException {
      return true;
    }
    /**
     * Is the column some sort of currency?
     * 
     * @param column la columna
     * 
     * @see java.sql.ResultSetMetaData#isCurrency
     * @return tinySQL doesn't have such things, so it's false
     *
     * @exception SQLException por si ocurre una excepcion
     */
    @Override
    public boolean isCurrency(int column) throws SQLException {
        return false;
    }
    /**
     *
     * Determines if the column in question is nullable. tinySQL
     * does not yet support nulls.
     * 
     * @param column la columna
     * 
     * @see java.sql.ResultSetMetaData#isNullable
     * @return columnNoNulls, columnNullable, or columnNullableUnknown
     *
     * @exception SQLException por si ocurre una excepcion
     */
    @Override
    public int isNullable(int column) throws SQLException{
        return columnNoNulls;
    }
    /**
     * All tinySQL integers are signed, so this returns true.
     * 
     * @param column la columna
     * 
     * @see java.sql.ResultSetMetaData#isSigned
     * @return true
     *
     * @exception SQLException por si ocurre un error
     */
    @Override
    public boolean isSigned( int column ) throws SQLException {
        return true;
    }
    /**
     * Gives the display size for this column.
     * 
     * @param column la columna
     * 
     * @see java.sql.ResultSetMetaData#getColumnDisplaySize
     *
     * @exception SQLException por si ocurre un error
     */
    @Override
    public int getColumnDisplaySize( int column ) throws SQLException {
        // get a column object. Remember, tinySQL uses a column
        // offset of zero, but JDBC columns start numbering at one.
        // That's why there's a -1 in the columnAtIndex invocation.
        tsColumn col = tsql.columnAtIndex(column-1);
        return col.size;
    }
    /**
     * This returns the column name in the form table_name.column_name.
     * @see java.sql.ResultSetMetaData#getColumnLabel
     * @param column the column whose label is wanted
     * @return the fully qualified column name
     *
     * @exception SQLException por si ocurre un error
     */
    @Override
    public String getColumnLabel( int column ) throws SQLException {
      // get the column, return its table and name, separated by a '.'
        tsColumn col = tsql.columnAtIndex(column-1);
        return (col.tableName + "." + col.name);
    }
    /**
     * The name of a given column
     * @see java.sql.ResultSetMetaData#getColumnName
     * @param column the column whose name is wanted
     * @return the name of the requested column
     * 
     * @exception SQLException por si ocurre un error
     */
    @Override
    public String getColumnName( int column ) throws SQLException {
        // get the column and return its name
        String columnName;
        int dotAt;
        String msg;
        tsColumn col = tsql.columnAtIndex(column-1);
        dotAt = col.name.indexOf(".");
        columnName = col.name;
        if ( dotAt > -1 ) { 
            columnName = col.name.substring(dotAt + 1);
            }
        if( col.alias != (String)null ) {
            if( !col.alias.equals( columnName ) ) {
                return col.alias;
                }
            }
        columnName = tinySQLGlobals.getLongName(columnName);
        return columnName;
    }
    /**
     * What's the column's schema? This is not applicable to tinySQL,
     * so it returns an empty string.
     * 
     * @param column the column whose label is wanted
     *
     * @exception SQLException por si ocurre un error
     */
    @Override
    public String getSchemaName( int column ) throws SQLException {
      return "";
    }
    /**
     * What's the column's precision? Use size.
     * 
     * @param column the column whose label is wanted
     *
     * @exception SQLException por si ocurre un error
     */
    @Override
    public int getPrecision( int column ) throws SQLException {
        tsColumn col = tsql.columnAtIndex(column-1);
        return col.size;
    }
    /**
     * What's a column's number of digits to right of decimal?
     * 
     * @param column the column whose label is wanted
     *
     * @exception SQLException por si ocurre un error
     */
    @Override
    public int getScale( int column ) throws SQLException {
        tsColumn col = tsql.columnAtIndex(column-1);
        return col.decimalPlaces;
    }
    /**
     * Gives the name of the table to which this column belongs.
     * @see java.sql.ResultSetMetaData#getTableName
     * @param column the column of the field this information is needed for
     * @return the table name
     *
     */
    @Override
    public String getTableName( int column ) throws SQLException {
        // retrieve the column info and return the table name
        tsColumn col = tsql.columnAtIndex(column-1);
        return col.tableName;
    }
    /**
     * 
     * Return the column's table catalog name. Not supported by tinySQL
     * 
     */
    @Override
    public String getCatalogName( int column ) throws SQLException {
        throw new SQLException("tinySQL does not support catalogues.");
    }
    /**
     *
     * Gives the column type using the types in java.sql.Types.
     * see java.sqlTypes
     * see java.sql.ResultSetMetaData#getColumnType
     * @exception SQLException thrown for any number of reasons
     * @param column the column type information is needed on
     * @return the type as listed in java.sql.Types
     *
     */
    @Override
    public int getColumnType( int column ) throws SQLException {
        // get the column info object
        tsColumn col = tsql.columnAtIndex(column-1);
        return col.type;
    }
    /**
     *
     * Gives the column type as a string.
     * see java.sql.ResultSetMetaData#getColumnTypeName
     * @exception SQLException thrown at you
     * @param column the column for which the type name is wanted
     * @return the name of the column type
     *
     * author Thomas Morgner <mgs@sherito.org>: This function does 
     * not properly return type names - everything except INTEGER or
     * CHAR returns &quot;NULL&quot;
     */
    @Override
    public String getColumnTypeName( int column ) throws SQLException {
        // just call getColumnType, and report on what it said
        switch( getColumnType( column ) ) {
            case Types.INTEGER:
                return "INT";
            case Types.CHAR:
                return "CHAR";
            case Types.FLOAT:
                return "FLOAT";
            case Types.DATE:
                return "DATE";
            default:
                return "NULL";
            }
    }
    /**
     * Is the column definitely not writable? This has no meaning
     * in tinySQL
     *
     */
    @Override
    public boolean isReadOnly( int column ) throws SQLException {
        return false;
    }
    /**
     *
     * Is the column potentially writable? This has no meaning
     * in tinySQL
     *
     */
    @Override
    public boolean isWritable( int column ) throws SQLException {
        return true;
    }
    /**
     *
     * Is the column definitely writable? This has no meaning
     * in tinySQL
     *
     */
    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return true;
    }
    //--------------------------JDBC 2.0-----------------------------------
    /**
     * JDBC 2.0
     *
     * <p>Returns the fully-qualified name of the Java class whose instances 
     * are manufactured if the method <code>ResultSet.getObject</code>
         * is called to retrieve a value 
     * from the column.  <code>ResultSet.getObject</code> may return a subclass of the
     * class returned by this method.
         *
         * @return the fully-qualified name of the class in the Java programming
         *         language that would be used by the method 
         * <code>ResultSet.getObject</code> to retrieve the value in the specified
         * column. This is the class name used for custom mapping.
     * @exception SQLException if a database access error occurs
     */
    @Override
    public String getColumnClassName( int column ) throws SQLException {
        throw new SQLException("tinySQL does not support getColumnClassName.");
    }
    /**
     * Returns an object that implements the given interface to allow access to
     * non-standard methods, or standard methods not exposed by the proxy.
     * 
     * If the receiver implements the interface then the result is the receiver 
     * or a proxy for the receiver. If the receiver is a wrapper
     * and the wrapped object implements the interface then the result is the
     * wrapped object or a proxy for the wrapped object. Otherwise return the
     * the result of calling <code>unwrap</code> recursively on the wrapped object 
     * or a proxy for that result. If the receiver is not a
     * wrapper and does not implement the interface, then an 
     * <code>SQLException</code> is thrown.
     *
     * @param iface A Class defining an interface that the result must 
     * implement.
     * @return an object that implements the interface. May be a proxy for the 
     * actual implementing object.
     * @throws java.sql.SQLException If no object found that implements the 
     * interface 
     * @since 1.6
     */
    @Override
	public <T> T unwrap(java.lang.Class<T> iface) throws java.sql.SQLException {
        return null;
    }
    /**
     * Returns true if this either implements the interface argument or is 
     * directly or indirectly a wrapper for an object that does. Returns false 
     * otherwise. If this implements the interface then return true, else if
     * this is a wrapper then return the result of recursively calling 
     * <code>isWrapperFor</code> on the wrapped object. If this does not 
     * implement the interface and is not a wrapper, return false.
     * This method should be implemented as a low-cost operation compared to 
     * <code>unwrap</code> so that callers can use this method to avoid 
     * expensive <code>unwrap</code> calls that may fail. If this method
     * returns true then calling <code>unwrap</code> with the same argument 
     * should succeed.
     *
     * @param iface a Class defining an interface.
     * @return true if this implements the interface or directly or indirectly 
     * wraps an object that does.
     * @throws java.sql.SQLException  if an error occurs while determining 
     * whether this is a wrapper for an object with the given interface.
     * @since 1.6
     */
    @Override
    public boolean isWrapperFor( java.lang.Class<?> iface ) 
        throws java.sql.SQLException {
        return false;
    }
}





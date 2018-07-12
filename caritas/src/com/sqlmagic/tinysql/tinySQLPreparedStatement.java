/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Librerias para que trabaje la clase
 */
import java.io.InputStream;
import java.io.Reader;
import java.math.*;
import java.sql.Connection;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.util.*;

/**
 * PreparedStatement object for the tinySQL driver
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
 *
 * $Author: davis $
 * $Date: 2004/12/18 21:31:53 $
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
 *
 * Revised by Saul De La O Torres in Septiembre, 2013.
 *
 * @author Thomas Morgner <mgs@sherito.org> statementString contains the last
 * used SQL-Query. Support for set/getFetchSize, ResultSets are created with a
 * reference to the creating statement
 */
public class tinySQLPreparedStatement implements java.sql.PreparedStatement {

  /**
   * Holds the original prepare stement including ? placeholders for 
   * values that will be replaced later.
   */
  private String statementString;
  /**
   * Holds the list of substitution values to be used in the prepared
   * statement.
   */
  private Vector substitute=(Vector)null;
  /**
   * Holds the list of table file objects so that they can be closed
   * when all the updates have been completed.
   */
  private Vector tableList=new Vector();
  /**
   * Holds the error message for invalid substitution index.
   */
  private String invalidIndex = (String)null;
  /**
   * Holds the last used queryString. execute() has to be synchronized,
   * to guarantee thread-safety
   */
  /**
   *
   * A connection object to execute queries and... stuff
   *
   */
  private tinySQLConnection connection;

  /**
   *
   * A result set returned from this query 
   *
   */
  private tinySQLResultSet result;
  /**
   *
   * A set of actions returned by tinySQLParser (see tinySQL.java)
   *
   */
  private Vector actions=(Vector)null;

  /**
   *
   * The max field size for tinySQL
   * This can be pretty big, before things start to break.
   *
   */
  private int max_field_size = 0;

  /**
   *
   * The max rows supported by tinySQL
   * I can't think of any limits, right now, but I'm sure some
   * will crop up...
   *
   */
  private int max_rows = 65536;

  /**
   *
   * The number of seconds the driver will allow for a SQL statement to
   * execute before giving up.  The default is to wait forever (0).
   *
   */
  private int timeout = 0;

  /**
   * How many rows to fetch in a single run. Default is now 4096 rows.
   */
  private int fetchsize = 4096;
  /**
   * Debug flag
   */
  private static boolean debug=false;
  /**
   *
   * Constructs a new tinySQLStatement object.
   * @param conn the tinySQLConnection object
   *
   */
  public tinySQLPreparedStatement(tinySQLConnection conn,String inputString) {

    int nextQuestionMark,startAt;
    connection = conn;
    startAt = 0;
    statementString = inputString;
    while ( (nextQuestionMark=statementString.indexOf("?",startAt)) > -1 )
    {
       if ( substitute == (Vector)null ) substitute = new Vector();
       substitute.addElement(new String(""));
       startAt = nextQuestionMark + 1;
    }
    invalidIndex = " is not in the range 1 to "
    + Integer.toString(substitute.size());
    if ( debug ) System.out.println("Prepare statement has " + substitute.size()
    + " parameters.");

  }

  /**
   * Execute an SQL statement and return a result set.
   * 
   * @see java.sql.PreparedStatement#executeQuery
   * 
   * @exception SQLException raised for any errors
   * 
   * @return the result set from the query
   */
  public synchronized ResultSet executeQuery()
       throws SQLException {

    // tinySQL only supports one result set at a time, so
    // don't let them get another one, just in case it's
    // hanging out.
    //
    result = null; 

    // create a new tinySQLResultSet with the tsResultSet
    // returned from connection.executetinySQL()
    //
    if ( debug) System.out.println("executeQuery conn is " + connection.toString());
    return new tinySQLResultSet(connection.executetinySQL(this), this);

  }
  public synchronized ResultSet executeQuery(String sql)
       throws SQLException {

    // tinySQL only supports one result set at a time, so
    // don't let them get another one, just in case it's
    // hanging out.
    //
    result = null; 
    statementString = sql;

    // create a new tinySQLResultSet with the tsResultSet
    // returned from connection.executetinySQL()
    //
    if ( debug) System.out.println("executeQuery conn is " + connection.toString());
    return new tinySQLResultSet(connection.executetinySQL(this), this);

  }

  /**
   * 
   * Execute an update, insert, delete, create table, etc. This can
   * be anything that doesn't return rows.
   * @see java.sql.PreparedStatement#executeUpdate
   * @exception java.sql.SQLException thrown when an error occurs executing
   * the SQL
   * @return either the row count for INSERT, UPDATE or DELETE or 0 for SQL statements that return nothing
   */
  public synchronized int executeUpdate(String sql) throws SQLException {

    statementString = sql;
    return connection.executetinyUpdate(this);

  }
  public synchronized int executeUpdate() throws SQLException {

    return connection.executetinyUpdate(this);

  }

  /**
   * 
   * Executes some SQL and returns true or false, depending on
   * the success. The result set is stored in result, and can
   * be retrieved with getResultSet();
   * 
   * @see java.sql.PreparedStatement#execute
   * 
   * @exception SQLException raised for any errors
   * 
   * @return true if there is a result set available
   */
  public boolean execute() throws SQLException {

    // a result set object
    //
    tsResultSet r;

    // execute the query 
    //
    r = connection.executetinySQL(this);

    // check for a null result set. If it wasn't null,
    // use it to create a tinySQLResultSet, and return whether or
    // not it is null (not null returns true).
    //
    if( r == null ) {
      result = null;
    } else {
      result = new tinySQLResultSet(r, this);
    }
    return (result != null);

  }
  public boolean execute(String sql) throws SQLException {

    // a result set object
    //
    tsResultSet r;
    statementString = sql;

    // execute the query 
    //
    r = connection.executetinySQL(this);

    // check for a null result set. If it wasn't null,
    // use it to create a tinySQLResultSet, and return whether or
    // not it is null (not null returns true).
    //
    if( r == null ) {
      result = null;
    } else {
      result = new tinySQLResultSet(r, this);
    }
    return (result != null);

  }

  /**
   * Returns the current query-String 
   */
  public String getSQLString ()
  {
  	return statementString;
  }

  /**
   * 
   * Close any result sets. This is not used by tinySQL.
   * @see java.sql.PreparedStatement#close
   *
   */
  public void close() throws SQLException
  {
     int i;
     tinySQLTable nextTable;
     for ( i = 0; i < tableList.size(); i++ )
     {
        nextTable = (tinySQLTable)tableList.elementAt(i);
        if ( debug ) System.out.println("Closing " + nextTable.table);
        nextTable.close();
     }
  }

  /**
   * 
   * Returns the last result set
   * @see java.sql.PreparedStatement#getResultSet
   * @return null if no result set is available, otherwise a result set
   *
   */
  public ResultSet getResultSet() throws SQLException {

    ResultSet r;

    r = result;    // save the existing result set
    result = null; // null out the existing result set
    return r;      // return the previously extant result set
  }

  /**
   * 
   * Return the row count of the last operation. tinySQL does not support
   * this, so it returns -1
   * @see java.sql.PreparedStatement#getUpdateCount
   * @return -1
   */
  public int getUpdateCount() throws SQLException {
    return -1;
  }

  /**
   *
   * This returns true if there are any pending result sets. This
   * should only be true after invoking execute() 
   * @see java.sql.PreparedStatement#getMoreResults
   * @return true if rows are to be gotten
   *
   */
  public boolean getMoreResults() throws SQLException {

    return (result != null);

  }

  /**
   *
   * Get the maximum field size to return in a result set.
   * @see java.sql.PreparedStatement#getMaxFieldSize
   * @return the value of max field size
   *
   */
  public int getMaxFieldSize() throws SQLException {
    return max_field_size;
  }

  /**
   *
   * set the max field size.
   * @see java.sql.PreparedStatement#setMaxFieldSize
   * @param max the maximum field size
   *
   */
  public void setMaxFieldSize(int max) throws SQLException {
    max_field_size = max;
  }

  /**
   * 
   * Get the maximum row count that can be returned by a result set.
   * @see java.sql.PreparedStatement#getMaxRows
   * @return the maximum rows 
   *
   */
  public int getMaxRows() throws SQLException {
    return max_rows;
  }

    /**
     *
     * Get the maximum row count that can be returned by a result set.
     * see java.sql.PreparedStatement.setMaxRows
     * @param max the max rows
     *
     */
    public void setMaxRows( int max ) throws SQLException {
        max_rows = max;
    }

  /**
   *
   * If escape scanning is on (the default) the driver will do
   * escape substitution before sending the SQL to the database.
   * @see java.sql.PreparedStatement#setEscapeProcessing
   * @param enable this does nothing right now
   *
   */
  public void setEscapeProcessing(boolean enable)
       throws SQLException {
    throw new SQLException("The tinySQL Driver doesn't " +
                           "support escape processing.");
  }

  /**
   *
   * Discover the query timeout.
   * @see java.sql.PreparedStatement#getQueryTimeout
   * see setQueryTimeout
   * @return the timeout value for this statement
   *
   */
  public int getQueryTimeout() throws SQLException {
    return timeout;
  }

  /**
   *
   * Set the query timeout.
   * @see java.sql.PreparedStatement#setQueryTimeout
   * see getQueryTimeout
   * @param x the new query timeout value
   *
   */
  public void setQueryTimeout(int x) throws SQLException {
    timeout = x;
  }

  /**
   *
   * This can be used by another thread to cancel a statement. This
   * doesn't matter for tinySQL, as far as I can tell.
   * @see java.sql.PreparedStatement#cancel
   *
   */
  public void cancel() {
  }

  /**
   *
   * Get the warning chain associated with this Statement
   * @see java.sql.PreparedStatement#getWarnings
   * @return the chain of warnings
   *
   */
  public final SQLWarning getWarnings() throws SQLException {
    return null;
  }

  /**
   *
   * Clear the warning chain associated with this Statement
   * @see java.sql.PreparedStatement#clearWarnings
   *
   */
  public void clearWarnings() throws SQLException {
  }

  /**
   * 
   * Sets the cursor name for this connection. Presently unsupported.
   *
   */
  public void setCursorName(String unused) throws SQLException {
    throw new SQLException("tinySQL does not support cursors.");
  }

    //--------------------------JDBC 2.0-----------------------------


    /**
     * JDBC 2.0
     *
     * Gives the driver a hint as to the direction in which
         * the rows in a result set
     * will be processed. The hint applies only to result sets created 
     * using this Statement object.  The default value is 
     * ResultSet.FETCH_FORWARD.
     * <p>Note that this method sets the default fetch direction for 
         * result sets generated by this <code>Statement</code> object.
         * Each result set has its own methods for getting and setting
         * its own fetch direction.
     * @param direction the initial direction for processing rows
     * @exception SQLException if a database access error occurs
         * or the given direction
     * is not one of ResultSet.FETCH_FORWARD, ResultSet.FETCH_REVERSE, or
     * ResultSet.FETCH_UNKNOWN
     */
    public void setFetchDirection(int direction) throws SQLException {
      throw new SQLException("tinySQL does not support setFetchDirection.");
    }

    /**
     * JDBC 2.0
     *
     * Retrieves the direction for fetching rows from
         * database tables that is the default for result sets
         * generated from this <code>Statement</code> object.
         * If this <code>Statement</code> object has not set
         * a fetch direction by calling the method <code>setFetchDirection</code>,
         * the return value is implementation-specific.
     *
     * @return the default fetch direction for result sets generated
         *          from this <code>Statement</code> object
     * @exception SQLException if a database access error occurs
     */
    public int getFetchDirection() throws SQLException {
      throw new SQLException("tinySQL does not support getFetchDirection.");
    }

    /**
     * JDBC 2.0
     *
     * Gives the JDBC driver a hint as to the number of rows that should 
     * be fetched from the database when more rows are needed.  The number 
     * of rows specified affects only result sets created using this 
     * statement. If the value specified is zero, then the hint is ignored.
     * The default value is zero.
     *
     * @param rows the number of rows to fetch
     * @exception SQLException if a database access error occurs, or the
     * condition 0 <= rows <= this.getMaxRows() is not satisfied.
     */
    public void setFetchSize(int rows) throws SQLException {
      if ((rows <= 0) || (rows >= this.getMaxRows ()))
    		  throw new SQLException ("Condition 0 <= rows <= this.getMaxRows() is not satisfied");
    
      fetchsize = rows;  
    }

    /**
     * JDBC 2.0
     *
     * Retrieves the number of result set rows that is the default 
         * fetch size for result sets
         * generated from this <code>Statement</code> object.
         * If this <code>Statement</code> object has not set
         * a fetch size by calling the method <code>setFetchSize</code>,
         * the return value is implementation-specific.
     * @return the default fetch size for result sets generated
         *          from this <code>Statement</code> object
     * @exception SQLException if a database access error occurs
     */
    public int getFetchSize() throws SQLException {
      return fetchsize;
    }

    /**
     * JDBC 2.0
     *
     * Retrieves the result set concurrency.
     */
    public int getResultSetConcurrency() throws SQLException {
      throw new SQLException("tinySQL does not support ResultSet concurrency.");
    }

    /**
     * JDBC 2.0
     *
     * Determine the result set type.
     */
    public int getResultSetType()  throws SQLException {
      throw new SQLException("tinySQL does not support getResultSetType.");
    }

    /**
     * JDBC 2.0
     *
     * Adds a SQL command to the current batch of commmands for the statement.
     * This method is optional.
     *
     * @exception SQLException if a database access error occurs, or the
     * driver does not support batch statements
     */
    @Override
    public void addBatch() throws SQLException {
      throw new SQLException("tinySQL does not support addBatch.");
    }
    /**
     * JDBC 2.0
     *
     * Adds a SQL command to the current batch of commmands for the statement.
     * This method is optional.
     *
     * @param sql typically this is a static SQL INSERT or UPDATE statement
     * @exception SQLException if a database access error occurs, or the
     * driver does not support batch statements
     */
    @Override
    public void addBatch( String sql ) throws SQLException {
      throw new SQLException("tinySQL does not support addBatch.");
    }

    /**
     * JDBC 2.0
     *
     * Makes the set of commands in the current batch empty.
     * This method is optional.
     *
     * @exception SQLException if a database access error occurs or the
     * driver does not support batch statements
     */
    public void clearBatch() throws SQLException {
      throw new SQLException("tinySQL does not support clearBatch.");
    }

    /**
     * JDBC 2.0
     * 
     * Submits a batch of commands to the database for execution.
     * This method is optional.
     *
     * @return an array of update counts containing one element for each
     * command in the batch.  The array is ordered according 
     * to the order in which commands were inserted into the batch.
     * @exception SQLException if a database access error occurs or the
     * driver does not support batch statements
     */
    public int[] executeBatch() throws SQLException {
      throw new SQLException("tinySQL does not support executeBatch.");
    }

    /**
     * JDBC 2.0
     * 
     * Returns the <code>Connection</code> object
         * that produced this <code>Statement</code> object.
         * @return the connection that produced this statement
     * @exception SQLException if a database access error occurs
     */
    public Connection getConnection()  throws SQLException
    {
      return connection;
    }
/*
 *  Set methods for the prepared statement.
 */
    public void setBoolean(int parameterIndex,boolean inputValue)
       throws SQLException
    {
       if ( inputValue ) setString(parameterIndex,"TRUE");
       else setString(parameterIndex,"FALSE");
    }
    public void setInt(int parameterIndex,int inputValue)
       throws SQLException
    {
       setString(parameterIndex,Integer.toString(inputValue));
    }
    public void setDouble(int parameterIndex,double inputValue)
       throws SQLException
    {
       setString(parameterIndex,Double.toString(inputValue));
    }
    public void setBigDecimal(int parameterIndex,BigDecimal inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setDate(int parameterIndex,java.sql.Date inputValue,
       java.util.Calendar inputCalendar) throws SQLException
    {
       String dateString;
/*
 *     Convert string to YYYYMMDD format that dBase needs.
 */
       if ( inputValue == (java.sql.Date)null )
       {
          setString(parameterIndex,(String)null);
       } else if ( inputValue.toString().trim().length() < 8 ) {
          setString(parameterIndex,(String)null);
       } else {
          dateString = inputValue.toString().trim();
/*
 *        Convert date string to the standard YYYYMMDD format
 */
          dateString = UtilString.dateValue(dateString);
          setString(parameterIndex,dateString);
       }
    }
    public void setDate(int parameterIndex,java.sql.Date inputValue)
       throws SQLException
    {
       String dateString;
/*
 *     Convert string to YYYYMMDD format that dBase needs.
 */
       dateString = UtilString.dateValue(inputValue.toString());
       setString(parameterIndex,dateString);
    }
    public void setTime(int parameterIndex,java.sql.Time inputValue,
       java.util.Calendar inputCalendar) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setTime(int parameterIndex,java.sql.Time inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setTimestamp(int parameterIndex,java.sql.Timestamp inputValue,
       java.util.Calendar inputCalendar ) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setTimestamp(int parameterIndex,java.sql.Timestamp inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setAsciiStream(int parameterIndex,
       java.io.InputStream inputValue,int streamLength) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setUnicodeStream(int parameterIndex,
       java.io.InputStream inputValue,int streamLength) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setBinaryStream(int parameterIndex,
       java.io.InputStream inputValue,int streamLength) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setCharacterStream(int parameterIndex,
       java.io.Reader inputValue,int streamLength) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setRef(int parameterIndex,java.sql.Ref inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setBlob(int parameterIndex,java.sql.Blob inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setArray(int parameterIndex,java.sql.Array inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setClob(int parameterIndex,java.sql.Clob inputValue)
       throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setByte(int parameterIndex,byte inputValue)
       throws SQLException
    {
       setString(parameterIndex,Byte.toString(inputValue));
    }
    public void setBytes(int parameterIndex,byte[] inputValue)
       throws SQLException
    {
       setString(parameterIndex,Byte.toString(inputValue[0]));
    }
    public void setShort(int parameterIndex,short inputValue)
       throws SQLException
    {
       setString(parameterIndex,Short.toString(inputValue));
    }
    public void setFloat(int parameterIndex,float inputValue)
       throws SQLException
    {
       setString(parameterIndex,Float.toString(inputValue));
    }
    public void setLong(int parameterIndex,long inputValue)
       throws SQLException
    {
       setString(parameterIndex,Long.toString(inputValue));
    }
    public void setObject(int parameterIndex,Object inputValue)
       throws SQLException
    {
       setObject(parameterIndex,inputValue,0,0);
    }
    public void setObject(int parameterIndex,Object inputValue,
       int targetSQLType) throws SQLException
    {
       setObject(parameterIndex,inputValue,targetSQLType,0);
    }
    public void setObject(int parameterIndex,Object inputValue,
       int targetSQLType, int scale) throws SQLException
    {
       setString(parameterIndex,inputValue.toString());
    }
    public void setNull(int parameterIndex,int sqlType)
       throws SQLException
    {
       setNull(parameterIndex,sqlType,(String)null);
    }
    public void setNull(int parameterIndex,int sqlType,String sqlTypeName)
       throws SQLException
    {
       if ( parameterIndex > substitute.size() )
          throw new SQLException("Parameter index " + parameterIndex 
          + invalidIndex);
       substitute.setElementAt((String)null,parameterIndex-1);
    }
    public void setString( int parameterIndex, String setString)
       throws SQLException
    {
       if ( parameterIndex > substitute.size() )
          throw new SQLException("Parameter index " + parameterIndex 
          + invalidIndex);
       substitute.setElementAt(setString,parameterIndex-1);
    }
    public void clearParameters() throws SQLException
    {
       substitute.removeAllElements();
    }
/*
 *  Update the actions based upon the contents of the substitute Vector.
 *  Only INSERT and UPDATE commands are supported at this time.
 */
    public void updateActions(Vector inputActions) throws SQLException
    {
       Vector values,originalValues;
       Hashtable action;
       String actionType,valueString;
       int i,j,subCount;
       if ( actions == (Vector)null )
          actions = inputActions;
       if ( actions == (Vector)null ) return;
       for ( i = 0; i < actions.size(); i++ )
       {
          action = (Hashtable)actions.elementAt(i); 
          actionType = (String)action.get("TYPE");
          if ( actionType.equals("INSERT") | actionType.equals("UPDATE") )
          {
/*
 *           Look for the original values (with the ? for parameters).
 */
             originalValues = (Vector)action.get("ORIGINAL_VALUES");
             values = (Vector)action.get("VALUES");
             if ( originalValues == (Vector)null ) 
             {
                originalValues = (Vector)values.clone();
                action.put("ORIGINAL_VALUES",originalValues);
             }
             subCount = 0;
             for ( j = 0; j < originalValues.size(); j++ )
             {
                valueString = (String)originalValues.elementAt(j);
                if ( valueString.equals("?") )
                {
                   if ( subCount > substitute.size() - 1 )
                      throw new SQLException("Substitution index " + subCount
                      + " not between 0 and " 
                      + Integer.toString(substitute.size() - 1));
                   values.setElementAt(substitute.elementAt(subCount),j);
                   subCount++;
                }
             }
          }
       }
    }
    public void addTable(tinySQLTable inputTable)
    {
       int i;
       tinySQLTable nextTable;
       for ( i = 0; i < tableList.size(); i++ )
       {
          nextTable = (tinySQLTable)tableList.elementAt(i);
          if ( nextTable.table.equals(inputTable.table) ) return;
       }
       tableList.addElement(inputTable);
    }
      
    /**
     * Devuelve el vector de acciones
     * 
     * @return devuelve un vector
     */
    public Vector getActions() {
       return actions;
    }
    /**
     * Devuelve el conjunto de resultados
     * 
     * @return devuelve el conjunto de resultados de los metadatos
     */
    @Override
    public ResultSetMetaData getMetaData() {
       return (ResultSetMetaData)null;
    }
    //------------------------- JDBC 3.0 -----------------------------------

    /**
     * Sets the designated parameter to the given <code>java.net.URL</code> value. 
     * The driver converts this to an SQL <code>DATALINK</code> value
     * when it sends it to the database.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x the <code>java.net.URL</code> object to be set
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.4
     */ 
    @Override
    public void setURL(int parameterIndex, java.net.URL x) throws SQLException {
    
    }

    /**
     * Retrieves the number, types and properties of this 
     * <code>PreparedStatement</code> object's parameters.
     *
     * @return a <code>ParameterMetaData</code> object that contains information
     *         about the number, types and properties for each 
     *  parameter marker of this <code>PreparedStatement</code> object
     * @exception SQLException if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @see ParameterMetaData
     * @since 1.4
     */
    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return null;
    }

    //------------------------- JDBC 4.0 -----------------------------------
   
    /**
     * Sets the designated parameter to the given <code>java.sql.RowId</code> object. The
     * driver converts this to a SQL <code>ROWID</code> value when it sends it
     * to the database
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     *
     * @since 1.6
     */
    @Override
    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        
    }
 

    /**
     * Sets the designated paramter to the given <code>String</code> object.
     * The driver converts this to a SQL <code>NCHAR</code> or
     * <code>NVARCHAR</code> or <code>LONGNVARCHAR</code> value
     * (depending on the argument's
     * size relative to the driver's limits on <code>NVARCHAR</code> values)
     * when it sends it to the database.
     *
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if the driver does not support national
     *         character sets;  if the driver can detect that a data conversion
     *  error could occur; if a database access error occurs; or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
    public void setNString(int parameterIndex, String value) 
        throws SQLException {
    
    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. The
     * <code>Reader</code> reads the data till end-of-file is reached. The
     * driver does the necessary conversion from Java character format to
     * the national character set in the database.
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value the parameter value
     * @param length the number of characters in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if the driver does not support national
     *         character sets;  if the driver can detect that a data conversion
     *  error could occur; if a database access error occurs; or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
    public void setNCharacterStream(int parameterIndex, Reader value, 
        long length) throws SQLException {
    
    }

    /**
     * Sets the designated parameter to a <code>java.sql.NClob</code> object. The driver converts this to a
     * SQL <code>NCLOB</code> value when it sends it to the database.
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if the driver does not support national
     *         character sets;  if the driver can detect that a data conversion
     *  error could occur; if a database access error occurs; or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        
    }

    /**
     * Sets the designated parameter to a <code>Reader</code> object.  The reader must contain  the number
     * of characters specified by length otherwise a <code>SQLException</code> will be
     * generated when the <code>PreparedStatement</code> is executed.
     *This method differs from the <code>setCharacterStream (int, Reader, int)</code> method
     * because it informs the driver that the parameter value should be sent to
     * the server as a <code>CLOB</code>.  When the <code>setCharacterStream</code> method is used, the
     * driver may have to do extra work to determine whether the parameter
     * data should be sent to the server as a <code>LONGVARCHAR</code> or a <code>CLOB</code>
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader An object that contains the data to set the parameter value to.
     * @param length the number of characters in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs; this method is called on
     * a closed <code>PreparedStatement</code> or if the length specified is less than zero.
     *
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
    public void setClob(int parameterIndex, Reader reader, long length)
       throws SQLException {
     
    }

    /**
     * Sets the designated parameter to a <code>InputStream</code> object.  The inputstream must contain  the number
     * of characters specified by length otherwise a <code>SQLException</code> will be
     * generated when the <code>PreparedStatement</code> is executed.
     * This method differs from the <code>setBinaryStream (int, InputStream, int)</code>
     * method because it informs the driver that the parameter value should be
     * sent to the server as a <code>BLOB</code>.  When the <code>setBinaryStream</code> method is used,
     * the driver may have to do extra work to determine whether the parameter
     * data should be sent to the server as a <code>LONGVARBINARY</code> or a <code>BLOB</code>
     * @param parameterIndex index of the first parameter is 1,
     * the second is 2, ...
     * @param inputStream An object that contains the data to set the parameter
     * value to.
     * @param length the number of bytes in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs; 
     * this method is called on a closed <code>PreparedStatement</code>; 
     *  if the length specified
     * is less than zero or if the number of bytes in the inputstream does not match
     * the specfied length.
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     *
     * @since 1.6
     */
    @Override
     public void setBlob(int parameterIndex, InputStream inputStream, long length)
        throws SQLException {
     
     }
    /**
     * Sets the designated parameter to a <code>Reader</code> object.  The reader must contain  the number
     * of characters specified by length otherwise a <code>SQLException</code> will be
     * generated when the <code>PreparedStatement</code> is executed.
     * This method differs from the <code>setCharacterStream (int, Reader, int)</code> method
     * because it informs the driver that the parameter value should be sent to
     * the server as a <code>NCLOB</code>.  When the <code>setCharacterStream</code> method is used, the
     * driver may have to do extra work to determine whether the parameter
     * data should be sent to the server as a <code>LONGNVARCHAR</code> or a <code>NCLOB</code>
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader An object that contains the data to set the parameter value to.
     * @param length the number of characters in the parameter data.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if the length specified is less than zero;
     * if the driver does not support national character sets;
     * if the driver can detect that a data conversion
     *  error could occur;  if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     *
     * @since 1.6
     */
    @Override
     public void setNClob(int parameterIndex, Reader reader, long length)
        throws SQLException {
     
     }

     /**
      * Sets the designated parameter to the given <code>java.sql.SQLXML</code> object.
      * The driver converts this to an
      * SQL <code>XML</code> value when it sends it to the database.
      * <p>
      *
      * @param parameterIndex index of the first parameter is 1, the second is 2, ...
      * @param xmlObject a <code>SQLXML</code> object that maps an SQL <code>XML</code> value
      * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs; 
      *  this method is called on a closed <code>PreparedStatement</code> 
      * or the <code>java.xml.transform.Result</code>,
      *  <code>Writer</code> or <code>OutputStream</code> has not been closed for 
      * the <code>SQLXML</code> object 
      * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
      *
      * @since 1.6
      */
    @Override
    public void setSQLXML(int parameterIndex, SQLXML xmlObject) 
        throws SQLException {
    
    }

    
   /**
     * Sets the designated parameter to the given input stream, which will have 
     * the specified number of bytes.
     * When a very large ASCII value is input to a <code>LONGVARCHAR</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.InputStream</code>. Data will be read from the stream
     * as needed until end-of-file is reached.  The JDBC driver will
     * do any necessary conversion from ASCII to the database char format.
     * 
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x the Java input stream that contains the ASCII parameter value
     * @param length the number of bytes in the stream 
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @since 1.6
    */
    @Override
    public void setAsciiStream(int parameterIndex, java.io.InputStream x, long length)
	    throws SQLException {
    
    }
    /**
     * Sets the designated parameter to the given input stream, which will have 
     * the specified number of bytes.
     * When a very large binary value is input to a <code>LONGVARBINARY</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.InputStream</code> object. The data will be read from the 
     * stream as needed until end-of-file is reached.
     * 
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x the java input stream which contains the binary parameter value
     * @param length the number of bytes in the stream 
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @since 1.6
     */
    @Override
    public void setBinaryStream(int parameterIndex, java.io.InputStream x, 
			 long length) throws SQLException {
    
    }
        /**
     * Sets the designated parameter to the given <code>Reader</code>
     * object, which is the given number of characters long.
     * When a very large UNICODE value is input to a <code>LONGVARCHAR</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.Reader</code> object. The data will be read from the stream
     * as needed until end-of-file is reached.  The JDBC driver will
     * do any necessary conversion from UNICODE to the database char format.
     * 
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param reader the <code>java.io.Reader</code> object that contains the 
     *        Unicode data
     * @param length the number of characters in the stream 
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @since 1.6
     */
    @Override
    public void setCharacterStream(int parameterIndex,
       			  java.io.Reader reader,
			  long length) throws SQLException {
    
    }
    //-----
    /**
     * Sets the designated parameter to the given input stream.
     * When a very large ASCII value is input to a <code>LONGVARCHAR</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.InputStream</code>. Data will be read from the stream
     * as needed until end-of-file is reached.  The JDBC driver will
     * do any necessary conversion from ASCII to the database char format.
     * 
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setAsciiStream</code> which takes a length parameter. 
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x the Java input stream that contains the ASCII parameter value
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
       * @since 1.6
    */
    @Override
    public void setAsciiStream(int parameterIndex, java.io.InputStream x)
	    throws SQLException {
    
    }
    /**
     * Sets the designated parameter to the given input stream.
     * When a very large binary value is input to a <code>LONGVARBINARY</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.InputStream</code> object. The data will be read from the 
     * stream as needed until end-of-file is reached.
     * 
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setBinaryStream</code> which takes a length parameter. 
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param x the java input stream which contains the binary parameter value
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
    public void setBinaryStream(int parameterIndex, java.io.InputStream x)
        throws SQLException {
    
    }
        /**
     * Sets the designated parameter to the given <code>Reader</code>
     * object.
     * When a very large UNICODE value is input to a <code>LONGVARCHAR</code>
     * parameter, it may be more practical to send it via a
     * <code>java.io.Reader</code> object. The data will be read from the stream
     * as needed until end-of-file is reached.  The JDBC driver will
     * do any necessary conversion from UNICODE to the database char format.
     * 
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setCharacterStream</code> which takes a length parameter. 
     *
     * @param parameterIndex the first parameter is 1, the second is 2, ...
     * @param reader the <code>java.io.Reader</code> object that contains the 
     *        Unicode data
     * @exception SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
    public void setCharacterStream(int parameterIndex,
       			  java.io.Reader reader) throws SQLException {
    
    }
  /**
     * Sets the designated parameter to a <code>Reader</code> object. The
     * <code>Reader</code> reads the data till end-of-file is reached. The
     * driver does the necessary conversion from Java character format to
     * the national character set in the database.
     
     * <P><B>Note:</B> This stream object can either be a standard
     * Java stream object or your own subclass that implements the
     * standard interface.
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setNCharacterStream</code> which takes a length parameter.
     *      
     * @param parameterIndex of the first parameter is 1, the second is 2, ...
     * @param value the parameter value
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if the driver does not support national
     *         character sets;  if the driver can detect that a data conversion
     *  error could occur; if a database access error occurs; or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
     public void setNCharacterStream(int parameterIndex, Reader value) 
        throws SQLException {
     
     }

    /**
     * Sets the designated parameter to a <code>Reader</code> object. 
     * This method differs from the <code>setCharacterStream (int, Reader)</code> method
     * because it informs the driver that the parameter value should be sent to
     * the server as a <code>CLOB</code>.  When the <code>setCharacterStream</code> method is used, the
     * driver may have to do extra work to determine whether the parameter
     * data should be sent to the server as a <code>LONGVARCHAR</code> or a <code>CLOB</code>
     * 
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setClob</code> which takes a length parameter.
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader An object that contains the data to set the parameter value to.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs; this method is called on
     * a closed <code>PreparedStatement</code>or if parameterIndex does not correspond to a parameter
     * marker in the SQL statement
     *
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.6
     */
    @Override
     public void setClob(int parameterIndex, Reader reader)
       throws SQLException {
     
     }

    /**
     * Sets the designated parameter to a <code>InputStream</code> object. 
     * This method differs from the <code>setBinaryStream (int, InputStream)</code>
     * method because it informs the driver that the parameter value should be
     * sent to the server as a <code>BLOB</code>.  When the <code>setBinaryStream</code> method is used,
     * the driver may have to do extra work to determine whether the parameter
     * data should be sent to the server as a <code>LONGVARBINARY</code> or a <code>BLOB</code>
     *
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setBlob</code> which takes a length parameter.
     *
     * @param parameterIndex index of the first parameter is 1,
     * the second is 2, ...
     * @param inputStream An object that contains the data to set the parameter
     * value to.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; if a database access error occurs; 
     * this method is called on a closed <code>PreparedStatement</code> or
     * if parameterIndex does not correspond
     * to a parameter marker in the SQL statement,  
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     *
     * @since 1.6
     */
    @Override
     public void setBlob(int parameterIndex, InputStream inputStream)
        throws SQLException {
     
     }
    /**
     * Sets the designated parameter to a <code>Reader</code> object.  
     * This method differs from the <code>setCharacterStream (int, Reader)</code> method
     * because it informs the driver that the parameter value should be sent to
     * the server as a <code>NCLOB</code>.  When the <code>setCharacterStream</code> method is used, the
     * driver may have to do extra work to determine whether the parameter
     * data should be sent to the server as a <code>LONGNVARCHAR</code> or a <code>NCLOB</code>
     * <P><B>Note:</B> Consult your JDBC driver documentation to determine if 
     * it might be more efficient to use a version of 
     * <code>setNClob</code> which takes a length parameter.
     *
     * @param parameterIndex index of the first parameter is 1, the second is 2, ...
     * @param reader An object that contains the data to set the parameter value to.
     * @throws SQLException if parameterIndex does not correspond to a parameter
     * marker in the SQL statement; 
     * if the driver does not support national character sets;
     * if the driver can detect that a data conversion
     *  error could occur;  if a database access error occurs or 
     * this method is called on a closed <code>PreparedStatement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     *
     * @since 1.6
     */
    @Override
     public void setNClob(int parameterIndex, Reader reader)
        throws SQLException {
         
     }
    /**
     * Moves to this <code>Statement</code> object's next result, deals with
     * any current <code>ResultSet</code> object(s) according  to the instructions
     * specified by the given flag, and returns
     * <code>true</code> if the next result is a <code>ResultSet</code> object.
     *
     * <P>There are no more results when the following is true:
     * <PRE>
     *     // stmt is a Statement object
     *     ((stmt.getMoreResults(current) == false) && (stmt.getUpdateCount() == -1))
     * </PRE>
     *
     * @param current one of the following <code>Statement</code>
     *        constants indicating what should happen to current 
     *        <code>ResultSet</code> objects obtained using the method
     *        <code>getResultSet</code>:
     *        <code>Statement.CLOSE_CURRENT_RESULT</code>, 
     *        <code>Statement.KEEP_CURRENT_RESULT</code>, or
     *        <code>Statement.CLOSE_ALL_RESULTS</code>
     * @return <code>true</code> if the next result is a <code>ResultSet</code> 
     *         object; <code>false</code> if it is an update count or there are no 
     *         more results
     * @exception SQLException if a database access error occurs, 
     * this method is called on a closed <code>Statement</code> or the argument
	 *         supplied is not one of the following:
     *        <code>Statement.CLOSE_CURRENT_RESULT</code>, 
     *        <code>Statement.KEEP_CURRENT_RESULT</code> or
     *        <code>Statement.CLOSE_ALL_RESULTS</code>
     *@exception SQLFeatureNotSupportedException if 
     * <code>DatabaseMetaData.supportsMultipleOpenResults</code> returns 
     * <code>false</code> and either 
     *        <code>Statement.KEEP_CURRENT_RESULT</code> or
     *        <code>Statement.CLOSE_ALL_RESULTS</code> are supplied as
     * the argument.
     * @since 1.4
     * @see #execute
     */
    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return false;
    }

    /**
     * Retrieves any auto-generated keys created as a result of executing this
     * <code>Statement</code> object. If this <code>Statement</code> object did 
     * not generate any keys, an empty <code>ResultSet</code>
     * object is returned.
     *
     *<p><B>Note:</B>If the columns which represent the auto-generated keys were not specified,
     * the JDBC driver implementation will determine the columns which best represent the auto-generated keys.
     *
     * @return a <code>ResultSet</code> object containing the auto-generated key(s) 
     *         generated by the execution of this <code>Statement</code> object
     * @exception SQLException if a database access error occurs or 
     * this method is called on a closed <code>Statement</code>
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.4
     */
    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return null;
    }

    /**
     * Executes the given SQL statement and signals the driver with the
     * given flag about whether the
     * auto-generated keys produced by this <code>Statement</code> object
     * should be made available for retrieval.  The driver will ignore the 
     * flag if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     *
     * @param sql an SQL Data Manipulation Language (DML) statement, such as <code>INSERT</code>, <code>UPDATE</code> or
     * <code>DELETE</code>; or an SQL statement that returns nothing, 
     * such as a DDL statement.
     *
     * @param autoGeneratedKeys a flag indicating whether auto-generated keys
     *        should be made available for retrieval;
     *         one of the following constants:
     *         <code>Statement.RETURN_GENERATED_KEYS</code>
     *         <code>Statement.NO_GENERATED_KEYS</code>
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *         or (2) 0 for SQL statements that return nothing
     *
     * @exception SQLException if a database access error occurs,
     *  this method is called on a closed <code>Statement</code>, the given
     *            SQL statement returns a <code>ResultSet</code> object, or
     *            the given constant is not one of those allowed
     * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
     * this method with a constant of Statement.RETURN_GENERATED_KEYS
     * @since 1.4
     */
    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) 
        throws SQLException {
        return 0;
    }

    /**
     * Executes the given SQL statement and signals the driver that the
     * auto-generated keys indicated in the given array should be made available
     * for retrieval.   This array contains the indexes of the columns in the 
     * target table that contain the auto-generated keys that should be made
     * available. The driver will ignore the array if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     *
     * @param sql an SQL Data Manipulation Language (DML) statement, such as <code>INSERT</code>, <code>UPDATE</code> or
     * <code>DELETE</code>; or an SQL statement that returns nothing, 
     * such as a DDL statement.
     *
     * @param columnIndexes an array of column indexes indicating the columns
     *        that should be returned from the inserted row
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *         or (2) 0 for SQL statements that return nothing
     *
     * @exception SQLException if a database access error occurs, 
     * this method is called on a closed <code>Statement</code>, the SQL
     *            statement returns a <code>ResultSet</code> object, or the
     *            second argument supplied to this method is not an <code>int</code> array
     *            whose elements are valid column indexes 
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.4
     */
    @Override
    public int executeUpdate(String sql, int columnIndexes[]) 
        throws SQLException {
        return 0;
    }

    /**
     * Executes the given SQL statement and signals the driver that the
     * auto-generated keys indicated in the given array should be made available
     * for retrieval.   This array contains the names of the columns in the 
     * target table that contain the auto-generated keys that should be made
     * available. The driver will ignore the array if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     *
     * @param sql an SQL Data Manipulation Language (DML) statement, such as <code>INSERT</code>, <code>UPDATE</code> or
     * <code>DELETE</code>; or an SQL statement that returns nothing, 
     * such as a DDL statement.
     * @param columnNames an array of the names of the columns that should be 
     *        returned from the inserted row
     * @return either the row count for <code>INSERT</code>, <code>UPDATE</code>,
     *         or <code>DELETE</code> statements, or 0 for SQL statements 
     *         that return nothing
     * @exception SQLException if a database access error occurs, 
     *  this method is called on a closed <code>Statement</code>, the SQL
     *            statement returns a <code>ResultSet</code> object, or the
     *            second argument supplied to this method is not a <code>String</code> array
     *            whose elements are valid column names
     *
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @since 1.4
     */
    @Override
    public int executeUpdate(String sql, String columnNames[]) 
        throws SQLException {
        return 0;
    }

    /**
     * Executes the given SQL statement, which may return multiple results,
     * and signals the driver that any
     * auto-generated keys should be made available
     * for retrieval.  The driver will ignore this signal if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <P>
     * In some (uncommon) situations, a single SQL statement may return
     * multiple result sets and/or update counts.  Normally you can ignore
     * this unless you are (1) executing a stored procedure that you know may
     * return multiple results or (2) you are dynamically executing an
     * unknown SQL string.  
     * <P>
     * The <code>execute</code> method executes an SQL statement and indicates the
     * form of the first result.  You must then use the methods 
     * <code>getResultSet</code> or <code>getUpdateCount</code>
     * to retrieve the result, and <code>getMoreResults</code> to
     * move to any subsequent result(s).
     *
     * @param sql any SQL statement
     * @param autoGeneratedKeys a constant indicating whether auto-generated 
     *        keys should be made available for retrieval using the method
     *        <code>getGeneratedKeys</code>; one of the following constants:
     *        <code>Statement.RETURN_GENERATED_KEYS</code> or
     *	      <code>Statement.NO_GENERATED_KEYS</code>
     * @return <code>true</code> if the first result is a <code>ResultSet</code>
     *         object; <code>false</code> if it is an update count or there are
     *         no results
     * @exception SQLException if a database access error occurs, 
     * this method is called on a closed <code>Statement</code> or the second 
     *         parameter supplied to this method is not 
     *         <code>Statement.RETURN_GENERATED_KEYS</code> or
     *         <code>Statement.NO_GENERATED_KEYS</code>.
     * @exception SQLFeatureNotSupportedException if the JDBC driver does not support
     * this method with a constant of Statement.RETURN_GENERATED_KEYS
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     * @see #getGeneratedKeys
     *
     * @since 1.4 
     */
    @Override
    public boolean execute(String sql, int autoGeneratedKeys) 
        throws SQLException {
        return false;
    }

    /**
     * Executes the given SQL statement, which may return multiple results,
     * and signals the driver that the
     * auto-generated keys indicated in the given array should be made available
     * for retrieval.  This array contains the indexes of the columns in the 
     * target table that contain the auto-generated keys that should be made
     * available.  The driver will ignore the array if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <P>
     * Under some (uncommon) situations, a single SQL statement may return
     * multiple result sets and/or update counts.  Normally you can ignore
     * this unless you are (1) executing a stored procedure that you know may
     * return multiple results or (2) you are dynamically executing an
     * unknown SQL string.  
     * <P>
     * The <code>execute</code> method executes an SQL statement and indicates the
     * form of the first result.  You must then use the methods 
     * <code>getResultSet</code> or <code>getUpdateCount</code>
     * to retrieve the result, and <code>getMoreResults</code> to
     * move to any subsequent result(s).
     *
     * @param sql any SQL statement
     * @param columnIndexes an array of the indexes of the columns in the 
     *        inserted row that should be  made available for retrieval by a
     *        call to the method <code>getGeneratedKeys</code>
     * @return <code>true</code> if the first result is a <code>ResultSet</code> 
     *         object; <code>false</code> if it is an update count or there 
     *         are no results
     * @exception SQLException if a database access error occurs, 
     * this method is called on a closed <code>Statement</code> or the 
     *            elements in the <code>int</code> array passed to this method
     *            are not valid column indexes
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     *
     * @since 1.4
     */
    @Override
    public boolean execute(String sql, int columnIndexes[]) 
        throws SQLException {
        return false;
    }

    /**
     * Executes the given SQL statement, which may return multiple results,
     * and signals the driver that the
     * auto-generated keys indicated in the given array should be made available
     * for retrieval. This array contains the names of the columns in the 
     * target table that contain the auto-generated keys that should be made
     * available.  The driver will ignore the array if the SQL statement
     * is not an <code>INSERT</code> statement, or an SQL statement able to return
     * auto-generated keys (the list of such statements is vendor-specific).
     * <P>
     * In some (uncommon) situations, a single SQL statement may return
     * multiple result sets and/or update counts.  Normally you can ignore
     * this unless you are (1) executing a stored procedure that you know may
     * return multiple results or (2) you are dynamically executing an
     * unknown SQL string.  
     * <P>
     * The <code>execute</code> method executes an SQL statement and indicates the
     * form of the first result.  You must then use the methods 
     * <code>getResultSet</code> or <code>getUpdateCount</code>
     * to retrieve the result, and <code>getMoreResults</code> to
     * move to any subsequent result(s).
     *
     * @param sql any SQL statement
     * @param columnNames an array of the names of the columns in the inserted
     *        row that should be made available for retrieval by a call to the
     *        method <code>getGeneratedKeys</code>
     * @return <code>true</code> if the next result is a <code>ResultSet</code> 
     *         object; <code>false</code> if it is an update count or there 
     *         are no more results
     * @exception SQLException if a database access error occurs, 
     * this method is called on a closed <code>Statement</code> or the 
     *          elements of the <code>String</code> array passed to this
     *          method are not valid column names
     * @throws SQLFeatureNotSupportedException  if the JDBC driver does not support this method
     * @see #getResultSet
     * @see #getUpdateCount
     * @see #getMoreResults
     * @see #getGeneratedKeys
     *
     * @since 1.4 
     */
    @Override
    public boolean execute(String sql, String columnNames[]) 
        throws SQLException {
        return false;
    }

   /**
     * Retrieves the result set holdability for <code>ResultSet</code> objects
     * generated by this <code>Statement</code> object.
     *
     * @return either <code>ResultSet.HOLD_CURSORS_OVER_COMMIT</code> or
     *         <code>ResultSet.CLOSE_CURSORS_AT_COMMIT</code>
     * @exception SQLException if a database access error occurs or 
     * this method is called on a closed <code>Statement</code>
     *
     * @since 1.4
     */
    @Override
    public int getResultSetHoldability() throws SQLException {
        return 0;
    }

    /**
     * Retrieves whether this <code>Statement</code> object has been closed. A <code>Statement</code> is closed if the
     * method close has been called on it, or if it is automatically closed.
     * @return true if this <code>Statement</code> object is closed; false if it is still open
     * @throws SQLException if a database access error occurs
     * @since 1.6
     */
    @Override
    public boolean isClosed() throws SQLException {
        return false;
    }
    
	/**
	 * Requests that a <code>Statement</code> be pooled or not pooled.  The value 
	 * specified is a hint to the statement pool implementation indicating 
	 * whether the applicaiton wants the statement to be pooled.  It is up to 
	 * the statement pool manager as to whether the hint is used.
	 * <p>
	 * The poolable value of a statement is applicable to both internal 
	 * statement caches implemented by the driver and external statement caches 
	 * implemented by application servers and other applications.
	 * <p>
	 * By default, a <code>Statement</code> is not poolable when created, and 
         * a <code>PreparedStatement</code> and <code>CallableStatement</code> 
         * are poolable when created.
	 * <p>
	 * @param poolable		requests that the statement be pooled if true and
	 * 						that the statement not be pooled if false 
	 * <p>
	 * @throws SQLException if this method is called on a closed 
         * <code>Statement</code>
	 * <p>
	 * @since 1.6
	 */
    @Override
	public void setPoolable(boolean poolable)
		throws SQLException {
    
    }
	
	/**
	 * Returns a  value indicating whether the <code>Statement</code>
         * is poolable or not.
	 * <p>
	 * @return		<code>true</code> if the <code>Statement</code> 
         * is poolable; <code>false</code> otherwise
	 * <p>
	 * @throws SQLException if this method is called on a closed 
         * <code>Statement</code>
	 * <p>
	 * @since 1.6
	 * <p>
	 * @see java.sql.Statement#setPoolable(boolean) setPoolable(boolean)
	 */
    @Override
	public boolean isPoolable()
		throws SQLException {
        return false;
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
     * wrapper and does not implement the interface, then an <code>SQLException</code> is thrown.
     *
     * @param iface A Class defining an interface that the result must implement.
     * @return an object that implements the interface. May be a proxy for the actual implementing object.
     * @throws java.sql.SQLException If no object found that implements the interface 
     * @since 1.6
     */
    @Override
	public <T> T unwrap(java.lang.Class<T> iface) throws java.sql.SQLException {
        return null;
    }

    /**
     * Returns true if this either implements the interface argument or is directly or indirectly a wrapper
     * for an object that does. Returns false otherwise. If this implements the interface then return true,
     * else if this is a wrapper then return the result of recursively calling <code>isWrapperFor</code> on the wrapped
     * object. If this does not implement the interface and is not a wrapper, return false.
     * This method should be implemented as a low-cost operation compared to <code>unwrap</code> so that
     * callers can use this method to avoid expensive <code>unwrap</code> calls that may fail. If this method
     * returns true then calling <code>unwrap</code> with the same argument should succeed.
     *
     * @param iface a Class defining an interface.
     * @return true if this implements the interface or directly or indirectly wraps an object that does.
     * @throws java.sql.SQLException  if an error occurs while determining whether this is a wrapper
     * for an object with the given interface.
     * @since 1.6
     */
    @Override
    public boolean isWrapperFor(java.lang.Class<?> iface) 
        throws java.sql.SQLException {
        return false;
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Libreria para que trabaje la clase
 */
import java.util.*;

/**
 * tinySQLTable - abstract class for physical table access under tinySQL
 *
 * Copyright 1996, Brian C. Jepson
 *                 (bjepson@ids.net)
 * $Author: davis $
 * $Date: 2004/12/18 21:26:51 $
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
 *
 * @author Thomas Morgner <mgs@sherito.org> colType returns int (an value from
 * java.sql.Types).
 * Revised by Saul De La O Torres in Septiembre, 2013.
 */
public abstract class tinySQLTable {
    /**
     * The name of the table
     */
    public String table; 
    /**
     * Nombre de alias de la tabla
     */
    public String tableAlias;
    /**
     * Hashtable to contain info about columns in the table
     */
    public Hashtable column_info = null;
    /**
     * Vector de columnas clave
     */
    public Vector columnNameKeys = null;
    /**
     * Returns the current number of records in this table
     * 
     * @return devuelve el conteo de columnas
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract int getRowCount() throws tinySQLException;
    /**
     * Closes the table.
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract void close() throws tinySQLException;
    /**
     * Checks to see if the file is Open or closed.
     * 
     * @return devuelve true si esta abierta la BD, false en caso contrario
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract boolean isOpen() throws tinySQLException;
    /**
     * Returns the size of a column.
     *
     * @param column name of the column.
     * 
     * @return devuelve el tamanio de la columna
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract int colSize( String column ) throws tinySQLException;
    /**
     * Returns the decimal places for a column.
     *
     * @param column name of the column.
     * 
     * @return devuelve el tamanio del decimal de la columna
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract int colDec( String column ) throws tinySQLException;
    /**
     * Devuelve la longitus en bytes de la tupla introducida
     * 
     * @return Length in bytes of one row
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract int getRecordLength();
    /**
     * Returns the datatype of a column.
     *
     * @param column name of the column.
     *
     * @return devuelve el tipo de la columna
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract int colType( String column ) throws tinySQLException;
    /**
     *
     * Updates the current row in the table.
     *
     * @param c Ordered Vector of column names
     * @param v Ordered Vector (must match order of c) of values
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract void updateCurrentRow( Vector c, Vector v )
        throws tinySQLException;
    /**
     * Position the record pointer at the top of the table.
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract void goTop() throws tinySQLException;
    /**
     * Advance the record pointer to the next record.
     * 
     * @return devuelve la siguiente tupla
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract boolean nextRecord() throws tinySQLException;
    /**
     *
     * Insert a row. If c or v == null, insert a blank row
     *
     * @param c Ordered Vector of column names
     * @param v Ordered Vector (must match order of c) of values
     * Insert a blank row.
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract void insertRow( Vector c, Vector v ) throws tinySQLException;
    /**
     * Retrieve a column's string value from the current row.
     *
     * @param column the column name
     * 
     * @return devuelve el nombre de la columna
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract String getCol( String column ) throws tinySQLException ;
    /**
     * Update a single column.
     *
     * @param column the column name
     * @param value the String value with which update the column
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract void updateCol( String column, String value )
        throws tinySQLException;
    /**
     * Delete the current row.
     *
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract void deleteRow() throws tinySQLException;
    /** 
     * Is the current row deleted?
     *
     * @return devuelve true si fue borrada y false en caso contrario
     * 
     * @exception tinySQLException la excepcion que se propaga
     */
    public abstract boolean isDeleted() throws tinySQLException;
}
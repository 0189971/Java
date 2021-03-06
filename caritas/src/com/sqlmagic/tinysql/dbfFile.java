/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Librerias para que trabaje la clase
 */
import java.io.*;
import java.sql.Types;
import java.util.*;

/**
 * dbfFile - an extension of tinySQL for dbf file access<br>
 *
 * Copyright 1996 John Wiley & Sons, Inc.<br>
 * See the COPYING file for redistribution details.<br>
 *
 * $Author: davis $<br>
 * $Date: 2004/12/18 21:27:51 $<br>
 * $Revision: 1.1 $<br>
 *
 * dBase read/write access <br>
 * 
 * Revised by Saul De La O Torres in Septiembre, 2013.<br>
 * 
 * @author Brian Jepson <bjepson@home.com><br>
 * @author Marcel Ruff <ruff@swand.lake.de> Added write access to dBase and 
 * JDK 2 support<br>
 * @author Thomas Morgner <mgs@sherito.org> Changed ColumnName to 11 bytes and 
 * strip name after first occurence of 0x00.<br><br>
 * Types are now handled as java.sql.Types, not as character flag<br>
*/
public class dbfFile extends tinySQL {
    /**
     * direccion de los datos
     */
    public static String dataDir;
    /**
     * Bandera de depuracion
     */
    public static boolean debug=false;
    /**
     * Vector que almacena la lista de tablas
     */
    private Vector tableList=new Vector();
    /**
     * Directorio de las bases de datos tinySQL
     */
    static {
        try {
            dataDir = System.getProperty( "user.home" ) + 
                    File.separator + ".tinySQL";
        } catch (Exception e) {
            String deDonde = "dbfFile.static :\n";
            System.err.println( deDonde + 
                " tinySQL: unable to get user.home property, "+
                    "reverting to current working directory.");
            dataDir = "." + File.separator + ".tinySQL";
        }
    }
    /**
     * Constructs a new dbfFile object
     */
    public dbfFile() {
        super();
        if ( tinySQLGlobals.DEBUG ) {
            //System.out.println( "Set datadir=" + dataDir );
            System.out.println( "Poner datadir=" + dataDir );
            }
    }

    /**
     *
     * Constructs a new dbfFile object
     *
     * @param d directory with which to override the default data directory
     *
     */
    public dbfFile( String d ) {
        super();
        dataDir = d; // d is usually extracted from the connection URL
        if( tinySQLGlobals.DEBUG ) { 
            //System.out.println( "Set datadir=" + dataDir );
            System.out.println( "Poner datadir=" + dataDir );
            }
    }
    /**
     * Creates a table given the name and a vector of
     * column definition (tsColumn) arrays.
     *
     * @param d directorio
     * see tinySQL#CreateTable
     */
    void setDataDir( String d ) {
        /*
         *   Method to set datadir - this is a crude way to allow support for
         *   multiple tinySQL connections
         */
        dataDir = d;
    }
    /**
     * Crea una tabla
     * 
     * @param tableName el nombre de la tabla
     * @param v el vector de parametros
     * 
     * @throws IOException por si hay excepcion de IO
     * @throws tinySQLException  dexcepcion SQL
     */
    public void createTable( String tableName, Vector v )
        throws IOException, tinySQLException {
        //---------------------------------------------------
        // determin meta data ....
        int numCols = v.size();
        int recordLength = 1;        // 1 byte for the flag field
        for( int i=0; i<numCols; i++ ) {
            tsColumn coldef = ( (tsColumn)v.elementAt( i ) );
            recordLength += coldef.size;
            }
        //---------------------------------------------------
        // create the new dBase file ...
        DBFHeader dbfHeader = new DBFHeader( numCols, recordLength );
        RandomAccessFile ftbl = dbfHeader.create( dataDir, tableName );
        //---------------------------------------------------
        // write out the rest of the columns' definition.
        for( int i=0; i<v.size(); i++ ) {
            tsColumn coldef = ( (tsColumn)v.elementAt( i ) );
            Utils.log( "CREATING COL=" + coldef.name );
            writeColdef( ftbl, coldef );
            }
        // header section ends with CR (carriage return)
        ftbl.write( (byte)0x0d ); 
        ftbl.close();
    }
    /**
     * Creates new Columns in tableName, given a vector of
     * column definition (tsColumn) arrays.<br>
     * It is necessary to copy the whole file to do this task.
     *
     * ALTER TABLE table [ * ] ADD [ COLUMN ] column type
     *
     * @param tableName the name of the table
     * @param v a Vector containing arrays of column definitions.
     * see tinySQL#AlterTableAddCol
     * 
     * @exception tinySQLException la excepcion que se propaga 
     * @exception IOException la excepcion que se propaga 
     */
    @Override
    public void alterTableAddCol( String tableName, Vector v )
        throws IOException, tinySQLException {
        // rename the file ...
        String fullpath = dataDir + File.separator + tableName + 
                dbfFileTable.dbfExtension;
        String tmppath = dataDir + File.separator + tableName + "_tmp_tmp" + 
                dbfFileTable.dbfExtension;
        if( Utils.renameFile( fullpath, tmppath )==false ) {
                throw new tinySQLException( 
                    "ALTER TABLE ADD COL error in renaming " + fullpath );
            }

        try {
            // open the old file ...
            RandomAccessFile ftbl_tmp = new RandomAccessFile(tmppath, "r");

            // read the first 32 bytes ...
            DBFHeader dbfHeader_tmp = new DBFHeader(ftbl_tmp);

            // read the column info ...
            Vector coldef_list = 
                new Vector( dbfHeader_tmp.numFields + v.size() );
            int locn = 0; // offset of the current column
            for( int i=1; i<=dbfHeader_tmp.numFields; i++ ) {
                tsColumn coldef = readColdef( ftbl_tmp, tableName, i, locn );
                // increment locn by the length of this field.
                locn += coldef.size; 
                coldef_list.addElement(coldef);
                }

            // add the new column definitions to the existing ...
            for (int jj = 0; jj < v.size(); jj++) {
                coldef_list.addElement(v.elementAt(jj));
                }

            // create the new table ...
            createTable( tableName, coldef_list );

            // copy the data from old to new

            // opening new created dBase file ...
            RandomAccessFile ftbl = new RandomAccessFile( fullpath, "rw" );
            ftbl.seek( ftbl.length() ); // go to end of file

            int numRec = 0;
            for( int iRec=1; iRec<=dbfHeader_tmp.numRecords; iRec++ ) {
                String str = getRecord(ftbl_tmp, dbfHeader_tmp, iRec);
                //Utils.log( "Copy of record#" + iRec + " str='" + str 
                //  + "' ...");
                if( str==null ) {
                    continue;
                    } // record was marked as deleted, ignore it
                // write original record
                ftbl.write( str.getBytes( Utils.encode ) );     
                numRec++;
                // write added columns
                for (int iCol = 0; iCol < v.size(); iCol++) {
                    tsColumn coldef = (tsColumn)v.elementAt( iCol );
                    // enforce the correct column length
                    String value = 
                        Utils.forceToSize( coldef.defaultVal, 
                            coldef.size, " " );
                    // transform to byte and write to file
                    byte [] b = value.getBytes( Utils.encode );
                    ftbl.write( b );
                    }
                }
            ftbl_tmp.close();
            DBFHeader.writeNumRecords( ftbl, numRec );
            ftbl.close();
            Utils.delFile(tmppath);
        } catch( Exception e ) {
            String deDonde = "dbfFile.alterTableAddCol():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     * Retrieve a record (=row)
     * @param dbfHeader dBase meta info
     * @param recordNumber starts with 1
     * @return the String with the complete record
     *         or null if the record is marked as deleted
     * @see tinySQLTable#getCol
     */
    public String getRecord( RandomAccessFile ff, DBFHeader dbfHeader, 
        int recordNumber ) throws tinySQLException {
        if( recordNumber<1 ) {
            //throw new tinySQLException( 
            //    "Internal error - current record number < 1" );
            throw new tinySQLException( 
                "Error interno - numero de tupla actual < 1" );
            }

        try {
            // seek the starting offset of the current record,
            // as indicated by recordNumber
            ff.seek( dbfHeader.headerLength + (recordNumber - 1) * 
                     dbfHeader.recordLength );

            // fully read a byte array out to the length of the record.
            byte [] b = new byte[dbfHeader.recordLength];
            ff.readFully( b );

            // make it into a String
            String record = new String( b, Utils.encode );

            // remove deleted records
            if( dbfFileTable.isDeleted( record ) ) {
                return null;
                }
            return record;
        } catch( Exception e ) {
            String deDonde = "dbfFile.getRecord():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     *
     * Deletes Columns from tableName, given a vector of
     * column definition (tsColumn) arrays.<br>
     *
     * ALTER TABLE table DROP [ COLUMN ] column { RESTRICT | CASCADE }
     *
     * @param tableName the name of the table
     * @param v a Vector containing arrays of column definitions.
     * @see tinySQL#alterTableDropCol
     * 
     * @exception tinySQLException la excepcion que se propaga 
     * @exception IOException la excepcion que se propaga 
     */
    public void alterTableDropCol( String tableName, Vector v )
        throws IOException, tinySQLException {

        // rename the file ...
        String fullpath = dataDir + File.separator + tableName + 
                dbfFileTable.dbfExtension;
        String tmppath = dataDir + File.separator + tableName + "-tmp" + 
                dbfFileTable.dbfExtension;
        if( Utils.renameFile( fullpath, tmppath )==false ) {
            throw new tinySQLException( 
                "ALTER TABLE DROP COL error in renaming " + fullpath );
            }
        try {
            // open the old file ...
            RandomAccessFile ftbl_tmp = new RandomAccessFile( tmppath, "r" );
            // read the first 32 bytes ...
            DBFHeader dbfHeader_tmp = new DBFHeader( ftbl_tmp );
            // read the column info ...
            Vector coldef_list = 
                new Vector( dbfHeader_tmp.numFields - v.size() );
            int locn = 0; // offset of the current column
            nextCol: 
                for( int i=1; i<=dbfHeader_tmp.numFields; i++ ) {
                    tsColumn coldef = 
                        readColdef( ftbl_tmp, tableName, i, locn );
                    // remove the DROP columns from the existing cols ...
                    for( int jj=0; jj<v.size(); jj++ ) {
                        String colName = (String)v.elementAt( jj );
                        if( coldef.name.equals( colName ) ) {
                            Utils.log( "Dropping " + colName );
                            continue nextCol;
                            }
                        }
                    // increment locn by the length of this field.
                    locn += coldef.size; 
                    // Utils.log("Recycling " + coldef.name);
                    coldef_list.addElement(coldef);
                    }
                // create the new table ...
                createTable( tableName, coldef_list );
                // copy the data from old to new
                // opening new created dBase file ...
                RandomAccessFile ftbl = new RandomAccessFile( fullpath, "rw" );
                ftbl.seek( ftbl.length() ); // go to end of file
                int numRec = 0;
                for( int iRec=1; iRec<=dbfHeader_tmp.numRecords; iRec++ ) {
                    if( dbfFileTable.isDeleted( 
                        ftbl_tmp, dbfHeader_tmp, iRec )==true ) {
                        continue;
                        }
                    numRec++;
                    // write flag
                    ftbl.write( dbfFileTable.RECORD_IS_NOT_DELETED );  
                    // Read the whole column into the table's cache
                    String column = 
                        dbfFileTable._GetCol( ftbl_tmp, dbfHeader_tmp, iRec );
                    // write columns
                    for( int iCol=0; iCol<coldef_list.size(); iCol++ ) {
                        tsColumn coldef = (tsColumn)coldef_list.elementAt( iCol );
                        // Extract column values from cache
                        String value = dbfFileTable.getColumn( coldef, column );
                        System.out.println( "From cache column value" + value );
                        // enforce the correct column length
                        value = Utils.forceToSize( value, coldef.size, " " ); 
                        // transform to byte and write to file
                        byte [] b = value.getBytes( Utils.encode );    
                        ftbl.write( b );
                        }
                    }
                ftbl_tmp.close();
                // remove temp file
                File f = new File(tmppath);
                if( f.exists() ) { 
                    f.delete();
                    }
                DBFHeader.writeNumRecords( ftbl, numRec );
                ftbl.close();
        } catch( Exception e ) {
            String deDonde = "dbfFile.alterTableDropCol():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage());
        }
    }
    /**
     * Rename columns<br>
     * ALTER TABLE table RENAME war TO peace
     * 
     * @param tableName nombre de la tabla
     * @param oldColname nombre viejo de la columna
     * @param newColname nombre nuevo de la columna
     * 
     * @throws tinySQLException la excepcion que se lanza
     */
    @Override
    public void alterTableRenameCol( String tableName, String oldColname, 
        String newColname ) throws tinySQLException {
        String fullpath = dataDir + File.separator + tableName + 
                dbfFileTable.dbfExtension;
        try {
            RandomAccessFile ftbl = new RandomAccessFile( fullpath, "rw" );
            // read the first 32 bytes ...
            DBFHeader dbfHeader = new DBFHeader( ftbl ); 
            // offset of the current column
            int locn = 0; 
            for( int iCol=1; iCol<=dbfHeader.numFields; iCol++ ) {
                tsColumn coldef = readColdef( ftbl, tableName, iCol, locn );
                if( coldef.name.equals( oldColname ) ) {
                    Utils.log( "Replacing column name '" + oldColname + 
                               "' with '" + newColname + "'" );
                    ftbl.seek( (iCol - 1) * 32 + 32 );
                    ftbl.write( Utils.forceToSize(newColname,
                        dbfFileTable.FIELD_TYPE_INDEX - 
                        dbfFileTable.FIELD_NAME_INDEX,
                        (byte)0 ) );
                    ftbl.close();
                    return;
                    }
                }
            ftbl.close();
            throw new tinySQLException( 
                "Renaming of column name '" + oldColname + 
                    "' to '" + newColname + "' failed, no column '" + 
                        oldColname + "' found" );
        } catch( Exception e ) {
            String deDonde = "dbfFile.alterTableRenameCol():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }

    /**
     *
     * Return a tinySQLTable object, given a table name.
     *
     * @param tableName
     * @see tinySQL#getTable
     *
     */
    @Override
    public tinySQLTable getTable( String tableName ) throws tinySQLException {
        int i,tableIndex;
        tinySQLTable nextTable;
        tableIndex = Integer.MIN_VALUE;
        if( tinySQLGlobals.DEBUG ) { 
            System.out.println( "Trying to create table"
                + " object for " + tableName );
            }
        for( i=0; i<tableList.size(); i++ ) {
            nextTable = (tinySQLTable)tableList.elementAt(i);
            if( nextTable.table.equals( tableName ) ) {
                if( nextTable.isOpen() ) {
                    if( tinySQLGlobals.DEBUG ) { 
                        System.out.println( "Found in cache " + 
                                nextTable.toString() );
                        }
                    return nextTable;
                    }
                tableIndex = i;
                break;
                }
            }
        if( tableIndex == Integer.MIN_VALUE ) {
            tableList.addElement(new dbfFileTable(dataDir,tableName));
            nextTable = (tinySQLTable)tableList.lastElement();
            if( tinySQLGlobals.DEBUG ) { 
                System.out.println("Add to cache "
                    + nextTable.toString()); 
                }
            return (tinySQLTable)tableList.lastElement(); 
            } 
        else {
            tableList.setElementAt( new dbfFileTable( dataDir, tableName ), 
                tableIndex );
            nextTable = (tinySQLTable)tableList.elementAt( tableIndex );
            if ( tinySQLGlobals.DEBUG )  { 
                System.out.println( "Update in cache "
                    + nextTable.toString() );
                }
            return (tinySQLTable)tableList.elementAt( tableIndex ); 
            }
    }
    /**
     *
     * The DBF File class provides read-only access to DBF
     * files, so this baby should throw an exception.
     *
     * @param fname table name
     * @see tinySQL#dropTable
     *
     */
    @Override
    public void dropTable( String fname ) throws tinySQLException {
        DBFHeader.dropTable( dataDir, fname );
    }
    /** 
     * Reading a column definition from file<br>
     * 
     * @param ff file handle (correctly positioned)
     * @param iCol index starts with 1
     * @param locn offset to the current column
     * 
     * @return struct with column info
     */
    public static tsColumn readColdef( RandomAccessFile ff, String tableName, 
        int iCol, int locn) throws tinySQLException {
        try {
            // seek the position of the field definition data.
            // This information appears after the first 32 byte
            // table information, and lives in 32 byte chunks.
            ff.seek( (iCol - 1) * 32 + 32 );
            // get the column name into a byte array
            byte [] b = new byte[11];
            ff.readFully( b );
            // convert the byte array to a String
            // Seek first 0x00 occurence and strip array after that
            // some C-implementations do not set the remaining bytes
            // after the name to 0x00, so we have to correct this.
            boolean clear = false;
            int i = 0;
            while ((i < 11) && (b[i] != 0)) {
                i++;
                }
            while (i < 11) {
                b[i] = 0;
                i++;
                }
            String colName = (new String(b, Utils.encode)).trim();
            // read in the column type which follows the 11 byte column name
            byte c[]= new byte[1];
            c[0]= ff.readByte();
            String ftyp= new String(c, Utils.encode);
            // skip four bytes
            ff.skipBytes(4);
            // get field length and precision which are in the two bytes 
            // following the column type.
            short flen = Utils.fixByte(ff.readByte()); // 16
            short fdec = Utils.fixByte(ff.readByte()); // 17
            if ( ftyp.equals("N") & fdec == 0 ) {
                ftyp = "I";
                }
            // bytes 18 - 31 are reserved
            // create a new tsColumn object and assign it the
            // attributes of the current field
            if( tinySQLGlobals.DEBUG ) {
                System.out.println("Try and create tsColumn for " + colName);
                }
            tsColumn column   = new tsColumn(colName);
            /*
             * The column type is now given as java.sql.Types constant
             */
            column.type = typeToSQLType(ftyp);
            column.size     = flen;
            column.decimalPlaces = fdec;
            // set the field position to the current
            column.position = locn + 1;  
            column.tableName    = tableName;
            return column;
        } catch( Exception e ) {
            String deDonde = "dbfFile.readColdef():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }

    /**
     * Writing a column definition to file<br>
     * NOTE: the file pointer (seek()) must be at the correct position
     * @param ff file handle (correctly positioned)
     * @param coldef struct with column info
     */
    public void writeColdef( RandomAccessFile ff, tsColumn coldef ) 
        throws tinySQLException {
        // Utils.log( "Writing Field Def: coldef.name=" + coldef.name + 
        //            ", coldef.type=" + coldef.type + ", 
        //              cildef.size=" + coldef.size);
        try {
            ff.write( Utils.forceToSize( coldef.name,
                dbfFileTable.FIELD_TYPE_INDEX - dbfFileTable.FIELD_NAME_INDEX,
                (byte)0 ) );
            // Convert the Java.SQL.Type back to a DBase Type and write it
            String type = null;
            if( coldef.type == Types.CHAR    || 
                coldef.type == Types.VARCHAR || 
                coldef.type == Types.LONGVARCHAR ) {
                type = "C";
                }
            else
            if( coldef.type == Types.NUMERIC || coldef.type == Types.INTEGER  || 
                coldef.type == Types.TINYINT || coldef.type == Types.SMALLINT ||
                coldef.type == Types.BIGINT  || coldef.type == Types.FLOAT    || 
                coldef.type == Types.DOUBLE  || coldef.type == Types.REAL) {
                type = "N";
                }
            else
            if (coldef.type == Types.BIT) {
                type = "L";
                }
            else
            if( coldef.type == Types.DATE ) {
                type = "D";
                }
            else {
                type = "M";
                }
            ff.write(Utils.forceToSize(type,
                1,
                (byte)0));
            ff.write(Utils.forceToSize(null,
                4,
                (byte)0));             // imu field (in memory use) 12-15
            ff.write(coldef.size);           // one byte
            ff.write(coldef.decimalPlaces);  // one byte
            ff.write( Utils.forceToSize( null,
                DBFHeader.BULK_SIZE-dbfFileTable.FIELD_RESERVED_INDEX,
                    (byte)0 ) );
        } catch (Exception e) {
            String deDonde = "dbfFile.writeColdef():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage());
        }
    }
    /**
     * 'C' Char (max 254 bytes)<br>
     * 'N' '-.0123456789' (max 19 bytes)<br>
     * 'L' 'YyNnTtFf?' (1 byte)<br>
     * 'M' 10 digit .DBT block number<br>
     * 'D' 8 digit YYYYMMDD<br>
     *
     * Uses java.sql.Types as key<br>
     * 
     * @param type el tipo de dato
     * 
     * @return devuelve el tipo java, su tamanio
     */
    public static String typeToLiteral( int type ) {
        if( type==Types.CHAR ) {
            return "CHAR";
            }
        if( type==Types.VARCHAR ) {
            return "VARCHAR";
            }
        if( type==Types.FLOAT ) {
            return "FLOAT";
            }
        if( type==Types.NUMERIC ) {
            return "NUMERIC";
            }
        if( type==Types.INTEGER ) {
            return "INT";
            }
        if( type==Types.BIT ) {
            return "BIT";
            }
        if( type==Types.BINARY ) {
            return "BINARY";
            }
        if( type==Types.DATE ) {
            return "DATE";
            }
        return "CHAR"; // fallback
    }
    /**
     * 'C' Char (max 508 bytes)<br>
     * 'N' '-.0123456789' (max 19 bytes)<br>
     * 'L' 'YyNnTtFf?' (1 byte)<br>
     * 'M' 10 digit .DBT block number<br>
     * 'D' 8 digit YYYYMMDD<br>
     * 
     * @param type el tipo de dato
     * 
     * @return devuelve el tipo java, su tamanio
     */
    public static int typeToSQLType( String type ) {
        if( type.equals( "C" )) {
            return java.sql.Types.CHAR;
            }
        if( type.equals( "N" ) ) {
            return java.sql.Types.FLOAT;
            }
        if( type.equals( "I" ) ) {
            return java.sql.Types.INTEGER;
            }
        if( type.equals( "L" ) ) {
            return java.sql.Types.CHAR;
            }
        if( type.equals( "M" ) ) {
            return java.sql.Types.INTEGER;
            }
        if( type.equals( "D" ) ) {
            return java.sql.Types.DATE;
            }
        return java.sql.Types.CHAR; // fallback
  }
}
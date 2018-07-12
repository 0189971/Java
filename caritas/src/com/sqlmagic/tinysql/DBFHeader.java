/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Libreria para que trabaje la clase
 */
import java.io.*;

/**
 * DBFHeader.java
 * tinySQL, manipulation of the first 32 bytes of a dBase III header
 *
 * $Author: davis $
 * $Date: 2004/12/18 21:31:13 $
 * $Revision: 1.1 $
 *
 *
 * dBase III header read/write access (bytes 0 - 31) <br> 
 * The column definitions are not read
 * 
 * @author Brian Jepson <bjepson@home.com>
 * @author Marcel Ruff <ruff@swand.lake.de> Added write access to dBase and 
 * JDK 2 support
 * Revised by Saul De La O Torres in Septiembre, 2013.
 */
public class DBFHeader {
    /**
     * Nombre de la tabla
     */
    String tableName = null;
    /**
     * Tipo de archivo
     */
    short file_type = 0;   // = 0x03 without .DBT, 0x83 with .DBT (memo file)
    /**
     * Ano de actualizacion del archivo
     */
    short file_update_year = 0;
    /**
     * Mes de actualizacion del archivo
     */
    short file_update_month = 0;
    /**
     * Dia de actualizacion del archivo
     */
    short file_update_day = 0;
    /**
     * Numero de definiciones de columna
     */
    int numFields = 0;     // number of column definitions
    /**
     * Numero de datos almacenados
     */
    int numRecords = 0;    // number of data records
    /**
     * Longitud de la cabecera en bytes
     */
    int headerLength = 0;  // in bytes
    /**
     * Longitud en bytes de una fila (tupla), incluido el principio del byte de
     * la bandera de borrado
     */
    int recordLength = 0;  
    // length in bytes of one data row, including the beginning delete flag-byte

    /* 
     The dBase III header consists of 32 byte bulks:
     0-32    primary header info
     32      bytes for each column info (n times)
     The number of columns is calculated from the headerLength
    */
    /**
     * Longitud del volumen
     */
    final static int BULK_SIZE = 32;             
    //=0x03 without .DBT, 0x83 with .DBT (memo file)
    /**
     * Indice de la bandera<br>
     * = 0x03 without .DBT, 0x83 con .DBT (memo file)
     */
    final static int FLAG_INDEX = 0;
    /**
     * Indice de fechoa<br>
     * 1=YY 2=MM 3=DD (ultima actualizacion)
     */
    final static int DATE_INDEX = 1;             // 1=YY 2=MM 3=DD (last update)
    /**
     * Indice del numero de grabaciones (4-7)
     */
    final static int NUMBER_OF_REC_INDEX = 4;    // 4-7
    /**
     * Longitud del indice de la cabecera (8-9)
     */
    final static int LENGTH_OF_HEADER_INDEX = 8; // 8-9
    /**
     * Longitud de indice de grabaciones (8-11)
     */
    final static int LENGTH_OF_REC_INDEX = 10;   // 8-11
    /**
     * Indice reservado (12-31)
     */
    final static int RESERVED_INDEX = 12;        // 12-31
    /**
     * Constructs a DBFHeader, read the data from file <br> 
     * You need to supply an open file handle to read from
     * @param ff open file handle for read access
     * 
     * @throws tinySQLException la excepcion que se lanza
     */
    public DBFHeader( RandomAccessFile ff ) throws tinySQLException {
        try {
            ff.seek( FLAG_INDEX );
            file_type         = Utils.fixByte( ff.readByte() );
            // get the last update date
            file_update_year  = Utils.fixByte( ff.readByte() );
            file_update_month = Utils.fixByte( ff.readByte() );
            file_update_day   = Utils.fixByte( ff.readByte() );
            // a byte array to hold little-endian long data
            byte[] b = new byte[4];
            // read that baby in...
            ff.readFully( b );
            // convert the byte array into a long (really a double)
            // 4-7 number of records
            numRecords        =  (int)Utils.vaxToLong( b );
            // a byte array to hold little-endian short data
            b = new byte[2];
            // get the data position (where it starts in the file)
            // 8-9 Length of header
            ff.readFully( b );
            headerLength      = Utils.vaxToShort( b );
            // find out the length of the data portion 10-11 Length of Record
            ff.readFully( b );
            recordLength      = Utils.vaxToShort( b );
            // calculate the number of fields
            numFields = (int) (headerLength - 33)/32;
            // skip the next 20 bytes - looks like this is not needed...
            //ff.skipBytes(20);
            // 12-31 reserved
            //Utils.log( "HEADER=" + this.toString() );
            Utils.log( "CABECERA=" + this.toString() );
        } catch( Exception e ) {
            String deDonde = "DBFHeader.DBFHeader():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     * Constructs a DBFHeader, read the data from file <br> 
     * You need to supply an open file handle to read from
     * 
     * @param numFields number of Columns
     * @param recordLength sum of all column.size plus 1 byte (delete flag)
     * 
     * @throws tinySQLException la excepcion que se lanza
     */
    public DBFHeader( int numFields, int recordLength ) throws tinySQLException {
        this.numFields = numFields;
        this.recordLength = recordLength;
//        Utils.log( "DBFHeader", "numFields="     + numFields + 
//                                " recordLength=" + recordLength);
        Utils.log( "DBFCabecera", "numFields="     + numFields + 
                                  " recordLength=" + recordLength);
    }


    /**
     * Create new dBase file and write the first 32 bytes<br> 
     * the file remains opened
     * 
     * @return file handle with read/write access
     * 
     * @throws tinySQLException la excepcion que se lanza
     */
    public RandomAccessFile create( String dataDir, String tableName ) 
        throws tinySQLException {
        this.tableName = tableName;
        try {
            // make the data directory, if it needs to be make
            mkDataDirectory( dataDir );
            // perform an implicit drop table.
            dropTable( dataDir, tableName );

            String fullPath = dataDir   + File.separator + 
                              tableName + dbfFileTable.dbfExtension;
            RandomAccessFile ff = new RandomAccessFile( fullPath, "rw" );
            write( ff );
            // ftbl.close();
            return ff;
        } catch( Exception e ) {
            String deDonde = "DBFHeader.create():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     * write the first 32 bytes to file
     * 
     * @param ff el archivo de escritura
     * 
     * @throws tinySQLException la excepcion que se lanza
     */
    public void write( RandomAccessFile ff ) throws tinySQLException {
        try {
            //-----------------------------
            // write out the primary header
            ff.seek( FLAG_INDEX );
            ff.writeByte( (byte)0x03 );
            // set current date YY MM DD (dBase is not Y2K save)
            setTimestamp( ff ); 
            setNumRecords( ff, 0 );
            setHeaderLength( ff, numFields );
            setRecordLength( ff, recordLength );
            setReserved( ff );
        } catch( Exception e ) {
            String deDonde = "DBFHeader.write():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     * Make the data directory unless it already exists
     * 
     * @throws NullPointerException la excepcion que se lanza
     */
    public void mkDataDirectory( String dataDir ) throws NullPointerException {
        File dd = new File( dataDir );
        if (!dd.exists()) {
            dd.mkdir();
            }
    }
    /**
     * Pone la actualizacion en el archivo
     * 
     * @param ff el archivo
     * 
     * @throws tinySQLException manejo de la excepcion
     */
    public void setTimestamp( RandomAccessFile ff ) throws tinySQLException {
        try {
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime( new java.util.Date() );
            int dd = cal.get( java.util.Calendar.DAY_OF_MONTH );
            int mm = cal.get( java.util.Calendar.MONTH ) + 1;
            int yy = cal.get( java.util.Calendar.YEAR );
            yy = yy % 100;          // Y2K problem: only 2 digits
            ff.seek( DATE_INDEX );
            ff.write( yy );
            ff.write( mm );
            ff.write( dd );
        } catch( Exception e ) {
            String deDonde = "DBFHeader.setTimestamp():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage());
        }
    }
    /**
     * Update the header (index 4-7) with the new number of records
     * 
     * @param ff el archivo de escritura
     * @param numRecords number of records
     * 
     * @throws tinySQLException manejo de la excepcion
     */
    public void setNumRecords( RandomAccessFile ff, int numRecords ) 
        throws tinySQLException {
        this.numRecords = numRecords;
        writeNumRecords( ff, numRecords );
    }
    /** 
     * Update the header (index 4-7) with the new number of records <br> 
     * This is the static variant (use it if you don't want to obtain a 
     * DBFHeader instance
     * 
     * @param ff archivo donde se almacena la informacion
     * @param numRecords numero de tuplas almacenadas
     * 
     * @throws tinySQLException manejo de la excepcion
     */
    public static void writeNumRecords( RandomAccessFile ff, int numRecords ) 
        throws tinySQLException {
        try {
            byte[] b = Utils.intToLittleEndian( numRecords );
            ff.seek( NUMBER_OF_REC_INDEX );
            ff.write(b);
        } catch( Exception e ) {
            String deDonde = "DBFHeader.writeNumRecords():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     * Update the header (index 8-9) with the new number of records
     * 
     * @param ff el archivo donde se almacena la informacion
     * @param numFields number of columns (used to calculate header length)
     * 
     * @throws tinySQLException manejo de la excepcion
     */
    public void setHeaderLength( RandomAccessFile ff, int numFields ) 
        throws tinySQLException {
        this.numFields = numFields;
        try {
            int headerLength = (DBFHeader.BULK_SIZE+1) + 
                                numFields * DBFHeader.BULK_SIZE;
            ff.seek( DBFHeader.LENGTH_OF_HEADER_INDEX );
            ff.write( Utils.shortToLittleEndian((short)headerLength) );
        } catch( Exception e ) {
            String deDonde = "DBFHeader.setHeaderLength():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }
    /**
     * Update the header (index 10-11) with the length of one record
     * 
     * @param ff el archivo donde se escribe
     * @param recordLength Length of one data record (row)
     * 
     * @throws tinySQLException lanza la excepcion
     */
    public void setRecordLength( RandomAccessFile ff, int recordLength ) 
        throws tinySQLException {
        this.recordLength = recordLength;
        try {
            ff.seek(DBFHeader.LENGTH_OF_REC_INDEX);
            ff.write(Utils.shortToLittleEndian((short)recordLength));
        } catch (Exception e) {
            String deDonde = "DBFHeader.setRecordLength():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage());
        }
    }
    /**
     * Update the header (index 10-11) with the length of one record<br> 
     * recordLength Length of one data record (row)
     * 
     * @param ff el archivo donde se almacena la informacion
     * 
     * @throws tinySQLException lanza la excepcion
     */
    public void setReserved( RandomAccessFile ff ) throws tinySQLException {
        try {
            ff.seek( DBFHeader.RESERVED_INDEX );
            byte[] reserved = Utils.forceToSize( null,
                DBFHeader.BULK_SIZE - DBFHeader.RESERVED_INDEX, (byte)0 );
            ff.write( reserved );  // padding with \0!
        } catch( Exception e ) {
            String deDonde = "DBFHeader.setReserved():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    }

    /**
     * Borra una tabla
     * 
     * @param dataDir directorio de los datos
     * @param fname nombre del archivo
     * 
     * @throws tinySQLException lanza la excepcion
     */
    static void dropTable( String dataDir, String fname ) 
        throws tinySQLException {
        try {
            // delFile(fname);
            Utils.delFile( dataDir, fname + dbfFileTable.dbfExtension );
        } catch( Exception e ) {
            String deDonde = "DBFHeader.dropTable():\n";
            throw new tinySQLException( deDonde + " " + e.getMessage() );
        }
    } 
}
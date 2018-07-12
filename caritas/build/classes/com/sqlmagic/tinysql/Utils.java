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
 * Utils.java
 * tinySQL, some helper methods
 *
 * $Author: davis $
 * $Date: 2004/12/18 21:27:20 $
 * $Revision: 1.1 $
 *
 * Some helper methods for tinySQL
 * 
 * Revised by Saul De La O Torres in Septiembre, 2013.
 * 
 * @author Brian Jepson <bjepson@home.com>
 * @author Marcel Ruff <ruff@swand.lake.de> Added write access to dBase and 
 * JDK 2 support
 */
public class Utils {
    /**
     * JLex (the lexical analyzer) doesn't support unicode
     * so we must play around with the different code pages:
     * "Cp437"  = 7 bit MS-DOS, US-ASCII
     * "Cp850"  = 8 bit MS-DOS, Multilingual Latin 1,   &auml; = 0x83 = 131
     * "Cp1252" = 8 bit Windows Multilingual,           &auml; = 0xe4 = 228
     * In future the code page should be passed at connection time using the URL
     */
    final static String encode = "Cp1252"; // dBase encoding

    /**
     * Converts a long to a little-endian four-byte array
     *
     * @param val el valor que se convierte s litte endian
     * 
     * @return devuelve el arreglo de cuatro bytes convertido
     */
    public static byte [] intToLittleEndian( int val ) {
        byte[] b = new byte[4];
        for( int i=0; i<4; i++ ) {
            b[i] = (byte)(val % 256);
            val = val / 256;
            }
        return b;
    }
    /**
     * Converts a long to a little-endian two-byte array
     *
     * @param val el valor corto que se convierte a little endian
     * 
     * @return devuelve el valor convertido en un arreglo de bytes
     */
    public static byte[] shortToLittleEndian( short val ) {
        byte[] b = new byte[2];
        for( int i = 0; i < 2; i++ ) {
            b[i] = (byte)(val % 256);
            val = (short)(val / 256);
            }
        return b;
    }
    /**
     * Converts a little-endian four-byte array to a long,
     * represented as a double, since long is signed.
     *
     * I don't know why Java doesn't supply this. It could
     * be that it's there somewhere, but I looked and couldn't
     * find it.
     *
     * @param b el arreglo que es convertido
     */
    public static double vaxToLong( byte [] b ) {
        //existing code that has been commented out
        //return fixByte(b[0]) + ( fixByte(b[1]) * 256) + 
        //( fixByte(b[2]) * (256^2)) + ( fixByte(b[3]) * (256^3));

        // Fix courtesy Preetha Suri <Preetha.Suri@sisl.co.in>
        long lngTmp = (long)(0x0ffL & b[0])
                  | ( (0x0ffL & (long)b[1]) << 8 )
                  | ( (0x0ffL & (long)b[2]) << 16 )
                  | ( (0x0ffL & (long)b[3]) << 24 );
        return((double)lngTmp);    
    }
    /**
     *
     * Converts a little-endian four-byte array to a short,
     * represented as an int, since short is signed.
     *
     * I don't know why Java doesn't supply this. It could
     * be that it's there somewhere, but I looked and couldn't
     * find it.
     *
     * @param b el valor que es convertido
     * 
     * @return devuelve el valor convertido
     */
    public static int vaxToShort( byte [] b ) {
        return (int) ( fixByte(b[0]) + ( fixByte(b[1]) * 256));
    }

    /**
     * bytes are signed; let's fix them...
     *
     * @param b el byte que es arreglado
     * 
     * @return devuelve el valor convertido
     */
    public static short fixByte( byte b ) {
        if( b<0 ) {
            return (short) ( b + 256);
            }
        return b;
    }

    /**
     * Cut or padd the string to the given size
     * 
     * @param str a string
     * @param size the wanted length
     * @param padChar char to use for padding (must be of length()==1!)
     * 
     * @return the string with correct lenght, padded with pad if necessary
     */
    public static String forceToSize( String str, int size, String padChar ) {
        if( str!=null && str.length()==size ) {
            return str;
            }
        StringBuffer tmp;
        if( str==null ) {
            tmp = new StringBuffer( size );
            }
        else {
            tmp = new StringBuffer( str );
            }

        if( tmp.length()>size ) {
            return tmp.toString().substring(0, size);  // do cutting
            }
        else {
            // or add some padding to the end of the string
            StringBuffer pad = new StringBuffer( size );
            int numBlanks = size - tmp.length();
            for( int p = 0; p<numBlanks; p++ ) {
            pad.append(padChar);
            }
        return tmp.append(pad).toString();
        }
    }
    /** 
     * Cut or padd the string to the given size
     * 
     * @param str a string
     * @param size the wanted length
     * @param padByte char to use for padding
     * 
     * @return the string with correct lenght, padded with pad if necessary
     * 
     * @exception UnsupportedEncodingException lanza la excepcion
     */
    public static byte[] forceToSize( String str, int size, byte padByte ) 
        throws java.io.UnsupportedEncodingException {
        if( str!=null && str.length()==size ) {
            return str.getBytes( encode );
            }
        byte[] result = new byte[size];

        if( str==null ) {
            for( int ii=0; ii<size; ii++ ) {
                result[ii] = padByte;
                }
            return result;
            }
        if( str.length()>size ) {
            return str.substring( 0, size ).getBytes( encode );  // do cutting
            }
        // do padding
        byte [] tmp = str.getBytes( encode );
        for( int jj=0; jj<tmp.length; jj++ ) {
            result[jj] = tmp[jj];
            }
        for (int kk=tmp.length; kk<size; kk++ ) {
            result[kk] = padByte;
            }
        return result;
    }
    /**
     * Delete a file in the data directory
     * 
     * @param fname el nombre del archivo a borrar
     * 
     * @exception NullPointerException por si da null pointer
     * @exception IOException por si no hay flujos
     */
    public static void delFile( String fname ) 
        throws NullPointerException, IOException {
        File f = new File( fname );

        // only delete a file that exists
        if( f.exists() ) {
            // try the delete. If it fails, complain
            if( !f.delete() ) {
                throw new IOException( 
                    "Could not delete: " + f.getAbsolutePath() + "." );
                }
            }
    }
    /**
     * Prueba a borrar un archivo en el directorio
     * 
     * @param dataDir directorio
     * @param fname archivo a borrar
     * 
     * @exception NullPointerException por si da null pointer
     * @exception IOException por si no hay flujos
     */
    public static void delFile( String dataDir, String fname ) 
        throws NullPointerException, IOException {
        File f = new File( dataDir + File.separator + fname );
        // only delete a file that exists
        if( f.exists() ) {
            // try the delete. If it fails, complain
            if( !f.delete() ) {
                throw new IOException( "Could not delete file: " + 
                               dataDir + "/" + fname + "." );
                }
            }
    }
    /**
     * Rename a file
     * 
     * @param oldName nombre anterior
     * @param newName nombre nuevo
     * 
     * @return true if succeeded
     */
    public static boolean renameFile( String oldName, String newName ) {
        File f_old = new File( oldName );
        File f_new = new File( newName );
        boolean ret = f_old.renameTo(f_new);
        return ret;
    }
    /**
     * Strip the path and suffix of a file name
     * 
     * @param file   "/usr/local/dbase/test.DBF"
     * 
     * @return "test"
     */
    public static String stripPathAndExtension( final String file ) {
        String sep = File.separator;
        int begin = file.lastIndexOf( sep );
        if( begin<0 ) {
            begin = 0;
            }
        else {
            begin++;
            }
        int end = file.lastIndexOf( "." );
        if( end<0 ) {
            end = file.length();
            }
        String str = file.substring(begin, end);
        return str;
    }


    /**
     * Scan the given directory for files containing the substrMatch<br> 
     * Small case extensions '.dbf' are recognized and returned as '.DBF'
     * 
     * @param path la ruta de acceso
     * @param suffix el subfijo
     * 
     * @return devuelve el vector de archivos encontrado
     */
    public static Vector getAllFiles( final String path, final String suffix ) {
        Vector vec = (Vector)null;
        String[] fileNameList;
        File currentDir,f;
        String fileName,upperSuffix;
        int i;
        upperSuffix = suffix.toUpperCase();
        currentDir = new File( path );
        fileNameList = currentDir.list();
        if( fileNameList==null ) {
            System.out.println( "*** null for " + path );
            } 
        else {
            vec = new Vector(fileNameList.length);
            for( i=0; i<fileNameList.length; i++ ) {
                f = new File(fileNameList[i]);
                if( !f.isDirectory() ) {
                    fileName = f.getPath().toString().toUpperCase();
                    //lastModified = new java.util.Date(f.lastModified());
                    if( upperSuffix == null | 
                        fileName.endsWith( upperSuffix ) ) {
                        vec.addElement( f );
                        }
                    }
                }
            }
        return vec;
    }
    /**
     * Pregunta si la fecha es una columna
     * 
     * @param columnType el tipo de dato de la columna
     * 
     * @return devuelve true si lo es y false en caso contrario
     */
    public static boolean isDateColumn( int columnType ) {
        if( columnType==Types.DATE | 
            columnType==Types.TIMESTAMP ) {
            return true;
            }
        return false;
    }
    /**
     * Pregunta si es char la columna
     * 
     * @param columnType el tipo de dato de la columna
     * 
     * @return devuelve true si lo es y false en caso contrario
     */
    public static boolean isCharColumn( int columnType ) {
        if( columnType==Types.CHAR    | 
            columnType==Types.VARCHAR |
            columnType==Types.LONGVARCHAR ) {
            return true;
            }
        return false;
    }
    /**
     * Pregunta si es nulero la columna
     * 
     * @param columnType el tipo de dato de la columna
     * 
     * @return devuelve true si lo es y false en caso contrario
     */
    public static boolean isNumberColumn( int columnType ) { 
        if( columnType==Types.NUMERIC | columnType==Types.INTEGER  |
            columnType==Types.TINYINT | columnType==Types.SMALLINT |
            columnType==Types.BIGINT  | columnType==Types.FLOAT    |
            columnType==Types.DOUBLE  | columnType==Types.REAL ) {
            return true;
            }
        return false;
    }
    /**
     * Pregunta si el nombre enviado es el nombre de una funcion
     * 
     * @param inputName el nombre buscado
     * 
     * @return devuelve true si lo es y false en caso contrario
     */
    public static boolean isFunctionName( String inputName ) {
        int i;
        String [] functionNames = {
            "COUNT","SUM","MIN","MAX","UPPER","TRIM",
            "SUBSTR","CONCAT","TO_DATE"};
        for ( i=0; i<functionNames.length; i++ ) {
            if (inputName.equalsIgnoreCase(functionNames[i]) ) {
                return true;
                } 
            }
        return false;
    }
    /**
     * Busca una funcion
     * 
     * @param inputName el nombre de la funcion
     * 
     * @return devuelve true si la encuentra y false en caso contrario
     */
    public static boolean endsWithFunctionName( String inputName ) {
        int i;
        String upperName;
        String [] functionNames = {
            "COUNT","SUM","MIN","MAX","UPPER","TRIM",
            "SUBSTR","CONCAT","TO_DATE"};
        upperName = inputName.toUpperCase();
        for ( i=0; i<functionNames.length; i++ ) {
            if (upperName.endsWith(functionNames[i]) ) {
                return true;
                }
            }
        return false;
    }
    /**
     * This function indicates which functions should be set to null if any
     * of its arguments are null.
     * 
     * @param inputName nombre de entrada
     * 
     * @return devuelve false si no encuentra la cadena y true en caso contrario
     */
    public static boolean clearFunction( String inputName ) {
        int i;
        String [] functionNames = {
            "UPPER",
            "TRIM",
            "SUBSTR"
            };
        for( i=0; i<functionNames.length; i++ )
            if( inputName.equalsIgnoreCase( functionNames[i] ) ) {
                return true;
                }
        return false;
    }
    /**
     * Move the input table to the top of the selection list.
     * 
     * @param inputList lista de entrada
     * @param inputTable tabla de entrada
     */
    public static void setPriority( Vector inputList, String inputTable ) {
        String tableName;
        int i;
        if( inputList==(Vector)null ) {
            return;
            }
        for( i=0; i<inputList.size(); i++ ) {
            tableName = (String)inputList.elementAt( i );
            if( tableName.equals( inputTable ) ) {
                if( i>0 ) {
                    inputList.removeElementAt( i );
                    inputList.insertElementAt( tableName, 0 );
                    }
                break;
            }
        }
    }
    /**
     * For debugging/tracing
     * Switch the debug mode on/off:
     */
    final static boolean debug=false;
    /**
     * Imprime una cadena con identificador
     * 
     * @param id el identificador del mensaje
     * @param str la cadena de mensaje
     */
    static void log( String id, String str ) {
        if( debug ) {
            log( id + ": " + str );
            }
    }
    /**
     * Imprime una cadena si esta en modo de depuracion
     * 
     * @param str la cadena de mensaje
     */
    static void log( String str ) {
        if( debug ) {
            System.out.println( str );
            }
    }
}
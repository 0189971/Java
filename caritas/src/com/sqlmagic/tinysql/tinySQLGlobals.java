/*
 * Paquete al que pertenece la clase
 */
package com.sqlmagic.tinysql;

/**
 * Librerias para que trabaje la clase
 */
import java.io.*;
import java.util.*;

/**
 * tinySQLGlobals
 * 
 * $Author: $
 * $Date:  $
 * $Revision:  $
 *
 * Static class to hold global values.
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
 * Revision History;
 *
 * Written by Davis Swan in October, 2006.
 * Revised by Saul De La O Torres in Septiembre, 2013.
 */
public class tinySQLGlobals {
    /**
     * Directorio de datos
     */
    static String dataDir = (String)null;
    /**
     * Nombres largos de columnas
     */
    static Vector longColumnNames;
    /**
     * Separador de campo
     */
    static String fileSep = System.getProperty("file.separator");
    /**
     * Separador de nueva linea
     */
    static String newLine = System.getProperty("line.separator");
    /**
     * Indices de las tablas
     */
    static Hashtable DB_INDEX = new Hashtable();
    /**
     * Version de tiny
     */
    static String VERSION = "3.0h";
    //static String VERSION = "2.26h";
    /**
     * Bandera de depuracion
     */
    static boolean DEBUG = false;
    /**
     * Bandera de depuracion del parser
     */
    static boolean PARSER_DEBUG = false;
    /**
     * Bandera de debug de la clausula WHERE
     */
    static boolean WHERE_DEBUG = false;
    /**
     * Bandera de exdepuracion
     */
    static boolean EX_DEBUG = false;
    /**
     * Contador de archivos con nombres de columnas largos
     */
    static int longNamesInFileCount;
    /**
     * Bandera de otra depuracion
     */
    static boolean debug = false;
    /**
     * Lee el directorio con los datos de entrada de nombres largos
     * 
     * @param inputDataDir la cadena que se lee
     */
    public static void readLongNames( String inputDataDir ) {
      String fullPath,longNameRecord;
      String[] fields;
      FieldTokenizer ft;
      File longColumnNameFile;
      dataDir = inputDataDir;
      BufferedReader longNameReader = (BufferedReader)null;
      fullPath = dataDir + fileSep + "TINYSQL_LONG_COLUMN_NAMES.dat";
      longColumnNames = new Vector();
      longColumnNameFile = new File(fullPath);
      if( longColumnNameFile.exists() ) {
         try {
            longNameReader = new BufferedReader(new FileReader(fullPath));
            while ( ( longNameRecord = longNameReader.readLine()) != null ) {
               ft = new FieldTokenizer(longNameRecord,'|',false);
               fields = ft.getFields();
               longColumnNames.addElement(fields[0]);
               longColumnNames.addElement(fields[1]);
                }
            longNameReader.close();
            longNamesInFileCount = longColumnNames.size()/2;
            if ( debug ) {
                System.out.println("Long Names read: " + longNamesInFileCount);
                }
         } catch ( Exception readEx ) {
             String deDonde = "tinySQLGlobals.readLongNames() :\n";
             System.out.println( deDonde + 
                    " Reader exception " + readEx.getMessage());
            longNamesInFileCount = 0;
         }
      }
   }
    /**
     * Method to add a long column name to the global Vector.  Note that
     * the entries are keyed by the short column name so that there is always
     * one and only one short name for any long name.
     * @param inputColumnName el nombre de la columna
     * 
     * @return devuelve el nombre corto
     */
    public static String addLongName( String inputColumnName ) {
        String shortColumnName,countString;
        countString = "0000" + Integer.toString(longColumnNames.size()/2);
        shortColumnName = "COL" + countString.substring(countString.length() - 5);
        
        if ( debug ) {
            System.out.println( 
                "Add " + shortColumnName + "|" + inputColumnName );
            }
        longColumnNames.addElement(shortColumnName);
        longColumnNames.addElement(inputColumnName);
        return shortColumnName;
    }  
    /**
     * This method checks for the existence of a short column name for the
     * input name.  If one does not exist it is created.
     * 
     * @param inputColumnName nombre de la columna
     * 
     * @return devuelve el nombre corto
     */ 
    public static String getShortName( String inputColumnName ) {
        System.out.println( " IN COLUMNA: " + inputColumnName );
        String shortColumnName=(String)null,longColumnName;
        int i;
        if( inputColumnName.length() < 12 ) { 
            return inputColumnName;
            }
        for( i=0; i<longColumnNames.size(); i+=2 ) {
            longColumnName = (String)longColumnNames.elementAt(i+1);
            System.out.println( "LCN " + longColumnName + " ICN " + inputColumnName );
            if ( longColumnName.equalsIgnoreCase(inputColumnName) ) {
                shortColumnName = (String)longColumnNames.elementAt(i);
                System.out.println("Return " + shortColumnName);
                if( debug ) {
                    System.out.println("Return " + shortColumnName);
                    }
                return shortColumnName;
                }
            }
      if( shortColumnName == (String)null ) {
        /*
         *       A short name has not been set up for this long name yet. 
         */
         if ( debug ) {
            System.out.println("Generate short name for " + inputColumnName);
            }
         return addLongName( inputColumnName );
      }
      return inputColumnName;
   }
    /**
     * This method checks for the existence of a short column name for the
     * input name.  If one does not exist it is created.
     * 
     * @param inputColumnName el nombre de la columna
     * 
     * @return devuelve el nombre largo
     */
    public static String getLongName(String inputColumnName) {
        String longColumnName,shortColumnName;
        int i;
        for( i = 0; i < longColumnNames.size(); i+=2 ) {
            shortColumnName = (String)longColumnNames.elementAt(i);
            if( shortColumnName.equalsIgnoreCase(inputColumnName) ) {
                longColumnName = (String)longColumnNames.elementAt(i+1);
                if ( debug ) {
                    System.out.println("Return " + longColumnName);
                    }
                return longColumnName;
                }
            }
        return inputColumnName;
   }
    /**
     * Escribe los nombres largos
     */
    public static void writeLongNames() {
        FileWriter longNameWriter = (FileWriter)null;
        String fullPath,longColumnName,shortColumnName;
        int i;
        if( longColumnNames.size() > longNamesInFileCount * 2 ) {
            /*
             *       The file needs to be updated.
             */
            fullPath = dataDir + fileSep + "TINYSQL_LONG_COLUMN_NAMES.dat";
            try {
                longNameWriter = new FileWriter(fullPath);
                if( longNameWriter != (FileWriter)null ) {
                    for( i = 0; i < longColumnNames.size(); i+=2 ) {
                       shortColumnName = (String)longColumnNames.elementAt(i);
                       longColumnName = (String)longColumnNames.elementAt(i+1);
                       longNameWriter.write(shortColumnName + "|" + longColumnName
                       + newLine);
                    }
                    longNameWriter.close();
                    longNamesInFileCount = longColumnNames.size()/2;
                    } 
                else {
                    System.out.println("Unable to update long column names.");
                }
         } catch ( Exception writeEx ) {
             String deDonde = "tinySQLGlobals.writeLongNames() :\n";
            System.out.println( deDonde + 
                " Write exception " + writeEx.getMessage() );
         }
      }
   }
}

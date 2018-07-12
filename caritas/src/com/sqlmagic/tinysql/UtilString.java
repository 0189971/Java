/*
 * Paquete al que pertenece la clase 
 */
package com.sqlmagic.tinysql;

/**
 * Librerias para que trabaje la clase
 */
import java.sql.Types;
import java.util.*;

/**
 * This class provides string manipulation methods.
 *
 * $Author: davis $
 * $Date: 2004/12/18 21:23:31 $
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
 * Revision History:
 *
 * Written by Davis Swan in February, 2004.
 * Revised by Saul De La O Torres in Septiembre, 2013.
 */
public class UtilString {
    /**
     * Is this a quoted string?
     * 
     * @param inputString cadena de entrada
     * 
     * @return devuelve true si es un String y false en caso contrario
     */
    public static boolean isQuotedString( String inputString ) {
        String trimString;
        int trimLength;
        if( inputString==(String)null )  {
            return false;
            }
        trimString = inputString.trim();
        trimLength = trimString.length();
        if( trimString.length() == 0 ) {
            return false;
            }
        if( ( trimString.charAt(0) == '\'' &
              trimString.charAt(trimLength - 1) == '\'' ) |
            ( trimString.charAt(0) == '"' & 
              trimString.charAt(trimLength - 1) == '"' ) ) {
             return true;
            }
        return false;
    }
    /**
     * Remove enclosing quotes from a string.
     * 
     * @param inputString cadena de entrada
     * 
     * @return devuelve la cadena sin comillas
     */
    public static String removeQuotes( String inputString ) {
        String trimString;
        int trimLength;
        if( inputString==(String)null ) {
            return inputString;
            }
        trimString = inputString.trim();
        trimLength = trimString.length();
        if( trimString.length()==0 ) {
            return inputString;
            }
        if( ( trimString.charAt(0) == '\'' &
              trimString.charAt(trimLength - 1) == '\'' ) |
            ( trimString.charAt(0) == '"' & 
              trimString.charAt(trimLength - 1) == '"' ) ) {
            return trimString.substring(1,trimString.length() - 1);
            }
        return inputString;
    }
    /**
     * Convert a string to a double or return a default value.
     * 
     * @param inputString cadena de entrada
     * 
     * @return devuelve el valor doble de la cadena numerica
     */
    public static double doubleValue( String inputString ) {
        return doubleValue( inputString, Double.MIN_VALUE );
    }
    /**
     * Convierte una cadena a un double
     * 
     * @param inputString la cadena numerica a convertir
     * @param defaultValue el valor por defecto
     * 
     * @return devuelve el valor double de la cadena convertida
     */
    public static double doubleValue( String inputString, 
        double defaultValue ) {
        try {
            return Double.parseDouble(inputString);
        } catch ( Exception e ) {
            String deDonde = "UtilString.parseDouble():\n";
            System.out.println( deDonde + " " + e.getMessage() );
            return defaultValue;
        }
   }
    /**
     * Convert a date string in the format YYYYMMDD to the standard
     * date output YYYY-MM-DD
     * 
     * @param inputDateString cadena de fecha de entrada
     */
   public static String toStandardDate( String inputDateString )
        throws tinySQLException {
        String dateString, stdDateString;
        int month;
        if( inputDateString==(String)null ) {
            //throw new tinySQLException ( "Cannot format NULL date" );
            throw new tinySQLException ( 
                "No se puede dar formato a una fecha NULL" );
            }
        if ( inputDateString.length()<8 ) {
            //throw new tinySQLException( "Date " + inputDateString
            //    + " not in YYYYMMDD format" );
            throw new tinySQLException( "Fecha " + inputDateString
                + " no esta en el formato YYYYMMDD" );
            }
        /*
         * Convert the input to YYYYMMDD - this is required because 
         * versions of tinySQL before 2.26d incorrectly stored dates in several
         * different character string representations.
         */
        dateString = dateValue(inputDateString);
        stdDateString = dateString.substring(0,4) + "-" 
            + dateString.substring(4,6) + "-"
            + dateString.substring(6,8); 
        return stdDateString;
    }
    /**
     * Convert a date string in the format DD-MON-YY, DD-MON-YYYY, or YYYYMMDD
     * to the output YYYYMMDD after checking the validity of all subfields. 
     * A tinySQLException is thrown if there are problems.
     * 
     * @param inputString cadena de entrada
     * 
     * @return devuelve la cadena formateada a la fecha
     */
    public static String dateValue( String inputString ) 
        throws tinySQLException {
        String months = "-JAN-FEB-MAR-APR-MAY-JUN-JUL-AUG-SEP-OCT-NOV-DEC-";
        int [] daysInMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String dateString;
        String dayField;
        String monthName;
        String monthField;
        String yearField;
        String[] ftFields;
        FieldTokenizer ft;
        int year;
        int month;
        int day;
        int monthAt;
        dateString = inputString.toUpperCase().trim();
        if ( dateString.length() < 8 ) {
            //throw new tinySQLException( dateString + " is less than 8 characters.");
            throw new tinySQLException( dateString + 
                " es menor de 8 caracteres.");
            }
        /*
         * Check for YYYY-MM-DD format - convert to YYYYMMDD if found.
         */
        if( dateString.length() == 10 & dateString.charAt(4) == '-' &
           dateString.charAt(7) == '-' ) {
            dateString =  dateString.substring(0,4) + dateString.substring(5,7)
                        + dateString.substring(8,10);
            }
        /*
         * First check for an 8 character field properly formatted.
         */
        if( dateString.length() == 8 & isInteger(dateString) ) {
            try {
                year = Integer.parseInt(dateString.substring(0,4));
                if ( year < 0 | year > 2100 ) { 
                    //throw new tinySQLException( dateString + " year not " 
                    //    + "recognized." );
                    throw new tinySQLException( dateString + " anio no " 
                        + "reconocido." );
                    }
                month = Integer.parseInt(dateString.substring(4,6));
                if ( month < 1 | month > 12 ) { 
                    throw new tinySQLException( dateString + " mes no " 
                        + "reconocido." );
                    }
                day = Integer.parseInt( dateString.substring( 6, 8 ) );
                if ( day < 1 | day > daysInMonth[month-1] ) { 
                    throw new tinySQLException( dateString + " dia no " 
                        + "reconocido." );
                    }
                return dateString;
            } catch ( Exception dateEx ) {
                throw new tinySQLException( dateEx.getMessage() );
            }
        }
        /*
         * Check for dd-MON-YY formats - strip off TO_DATE if it exists.
         */
        if( dateString.startsWith( "TO_DATE" ) ) {
            dateString = dateString.substring(8,dateString.length()-1);
            dateString = removeQuotes(dateString);
            }
        ft = new FieldTokenizer(dateString,'-',false);
        ftFields = ft.getFields();
        if( ftFields.length < 3 ) { 
            //throw new tinySQLException(dateString + " is not a date with "
            //    + "format DD-MON-YY!" );
            throw new tinySQLException( dateString + " no es una fecha con "
            + "formato DD-MON-YY!" );
            } 
        else {
            try {
                day = Integer.parseInt( ftFields[0] );
                monthName = ftFields[1];
                monthAt = months.indexOf( "-" + monthName + "-" );
                if( monthAt == -1 ) {
                    //throw new tinySQLException( dateString + " month not " 
                    //    + "recognized." );
                    throw new tinySQLException( dateString + " mes no " 
                        + "reconocido.");
                    }
                month = (monthAt + 4)/4;
                if( day < 1 | day > daysInMonth[month-1] ) {
                    throw new tinySQLException( dateString + " dia no " 
                        + "esta entre 1 y " + daysInMonth[month-1] );
                    }
                year = Integer.parseInt( ftFields[2] );
                if( year<0 | year>2100 ) {
                    //throw new tinySQLException( dateString + " year not " 
                    //    + "recognized." );
                    throw new tinySQLException( dateString + " anio no " 
                        + "reconocido." );
                    }
                /*
                 *  Assume that years < 50 are in the 21st century, otherwise 
                 *  the 20th.
                 */
                if ( year < 50 ) {
                    year = 2000 + year;
                    }
                else {
                    year = 1900 + year;
                    }
                dayField = Integer.toString( day );
                if ( dayField.length() < 2 ) {
                    dayField = "0" + dayField;
                    }
                monthField = Integer.toString( month );
                if ( monthField.length()<2 ) {
                    monthField = "0" + monthField;
                    }
                yearField = Integer.toString(year);
                return yearField + monthField + dayField; 
            } catch( Exception dayEx ) {
                //throw new tinySQLException( dateString + " exception " 
                //    + dayEx.getMessage() );
                String deDonde = "UtilString.dateValue():\n";
                throw new tinySQLException( deDonde + " " 
                    + dateString + " excepcion " 
                        + dayEx.getMessage() );
            }
        }
    }
    /**
     * The following method replaces all occurrences of oldString with newString
     * in the inputString.  This function can be replaced with the native
     * String method replaceAll in JDK 1.4 and above but is provide to support
     * earlier versions of the JRE.
     * 
     * @param inputString cadena de entrada
     * @param oldString cadena vieja
     * @param newString cadena nueva
     * 
     * @return remplazo de cadenas
     */
    public static String replaceAll( String inputString, String oldString,
        String newString ) {
        StringBuffer outputString = new StringBuffer(100);
        int startIndex=0,nextIndex;
        while( inputString.substring( startIndex ).indexOf( oldString )>-1 ) {
            nextIndex = startIndex + 
                inputString.substring( startIndex ).indexOf( oldString );
            if( nextIndex>startIndex ) { 
                outputString.append( 
                    inputString.substring( startIndex, nextIndex ) );
                }
            outputString.append(newString);
            startIndex = nextIndex + oldString.length();
            }
        if ( startIndex<=inputString.length()-1 ) {
            outputString.append( inputString.substring( startIndex ) );
            }
        return outputString.toString();
    }
    /**
     * Check to see if the input string is an integer.
     * 
     * @param inputString la cadena que se prueba si es entero
     * 
     * @return devuelve true si es enetro y false en caso contrario
     */
    public static boolean isInteger( String inputString ) {
        int testInt;
        try {
            testInt = Integer.parseInt(inputString);
            return true;
        } catch( Exception e ) {
            String deDonde = "UtilString.isInteger():\n";
            System.out.println( deDonde + " " + e.getMessage() );
            return false;
        }
   }
    /**
     * Convert a string to an int or return a default value.
     * 
     * @param inputString la cadena que se convierte
     * @param defaultValue el valor por defecto
     * 
     * @return devuelve la conversion de la cadena a un entero
     */
    public static int intValue( String inputString, int defaultValue ) {
        try {
            return Integer.parseInt(inputString);
        } catch( Exception e ) {
            String deDonde = "UtilString.intValue():\n";
            System.out.println( deDonde + " " + e.getMessage() );
            return defaultValue;
        }
    }
    /**
     * Convert a date in the format MM/DD/YYYY to YYYYMMDD
     * 
     * @param inputDate fecha de entrada
     * 
     * @return devuelve la fecha con formato
     */
    public static String toYMD( String inputDate ) {
        String day,month;
        FieldTokenizer ft;
        String[] ftFields;
        ft = new FieldTokenizer(inputDate,'/',false);
        ftFields = ft.getFields();
        if( ftFields.length == 1 ) {
            return inputDate;
            } 
        else 
        if( ftFields.length == 3 ) {
            month = ftFields[0];
            if( month.length() == 1 ) {
                month = "0" + month;
                }
            day = ftFields[1];
            if( day.length() == 1 ) {
                day = "0" + day;
                }
            return ftFields[2] + month + day;
            }
        return inputDate;
    }     
    /**
     * This method formats an action Hashtable for display.
     * 
     * @param displayAction tabla hash
     */
    public static String actionToString( Hashtable displayAction ) {
        StringBuffer displayBuffer = new StringBuffer();
        String displayType,tableName;
        tinySQLWhere displayWhere;
        tsColumn createColumn,displayColumn;
        boolean groupBy=false,orderBy=false;
        int i;
        Vector displayTables,displayColumns,columnDefs,displayValues,
        displayContext;
        Hashtable tables;
        displayType = (String)displayAction.get("TYPE");
        displayBuffer.append(displayType + " ");
        displayWhere = (tinySQLWhere)null;
        displayContext = (Vector)null;
        displayColumns = (Vector)null;
        if( displayType.equals( "SELECT" ) ) {
            tables = (Hashtable)displayAction.get( "TABLES" );
            displayTables = (Vector)tables.get( "TABLE_SELECT_ORDER" );
            displayColumns = (Vector)displayAction.get("COLUMNS" );
            displayWhere = (tinySQLWhere)displayAction.get( "WHERE" );
            for( i=0; i<displayColumns.size(); i++ ) {
                displayColumn = (tsColumn)displayColumns.elementAt( i );
                if( displayColumn.getContext( "GROUP" ) ) {
                    groupBy = true;
                    continue;
                    } 
                else 
                if( displayColumn.getContext( "ORDER" ) ) {
                    orderBy = true;
                    continue;
                    }
                if( i>0 ) { 
                    displayBuffer.append( "," );
                    }
                displayBuffer.append((String)displayColumn.name);
                }
            displayBuffer.append( " FROM " );
            for ( i=0; i<displayTables.size(); i++ ) {
                if( i>0 ) { 
                    displayBuffer.append( "," );
                    }
                displayBuffer.append( (String)displayTables.elementAt( i ) );
                }
            } 
        else 
        if( displayType.equals( "DROP_TABLE" ) ) {
            tableName = (String)displayAction.get( "TABLE" );
            displayBuffer.append( tableName );
            } 
        else 
        if( displayType.equals( "CREATE_TABLE" ) ) {
            tableName = (String)displayAction.get("TABLE");
            displayBuffer.append(tableName + " (");
            columnDefs = (Vector)displayAction.get("COLUMN_DEF");
            for( i=0; i<columnDefs.size(); i++ ) {
                if( i>0 ) { 
                    displayBuffer.append( "," );
                    }
                createColumn = (tsColumn)columnDefs.elementAt( i );
                displayBuffer.append( 
                    createColumn.name + " " + createColumn.type
                        + "( " + createColumn.size + "," 
                            + createColumn.decimalPlaces + ")");
                }
            displayBuffer.append(")");
            } 
        else 
        if ( displayType.equals( "INSERT" ) ) {
            tableName = (String)displayAction.get( "TABLE" );
            displayBuffer.append( "INTO " + tableName + "(" );
            displayColumns = (Vector)displayAction.get("COLUMNS");
            for( i=0; i<displayColumns.size(); i++ ) {
                if( i>0 ) { 
                    displayBuffer.append( "," );
                    }
                displayBuffer.append((String)displayColumns.elementAt(i));
                }
                displayBuffer.append( ") VALUES (" );
                displayValues = (Vector)displayAction.get( "VALUES" );
            for( i=0; i<displayValues.size(); i++ ) {
                if( i>0 ) { 
                    displayBuffer.append( "," );
                    }
                displayBuffer.append( (String)displayValues.elementAt( i ) );
                }
            displayBuffer.append( ")" );
            } 
        else 
        if( displayType.equals( "UPDATE" ) ) {
            tableName = (String)displayAction.get( "TABLE" );
            displayBuffer.append(tableName + " SET " );
            displayColumns = (Vector)displayAction.get( "COLUMNS" );
            displayValues = (Vector)displayAction.get( "VALUES" );
            displayWhere = (tinySQLWhere)displayAction.get( "WHERE" );
            for( i= 0; i < displayColumns.size(); i++ ) {
                if( i>0 ) {
                    displayBuffer.append(",");
                    }
                    displayBuffer.append( (String)displayColumns.elementAt( i )
                        + "=" + (String)displayValues.elementAt( i ) );
                }
            } 
        else 
        if ( displayType.equals( "DELETE" ) ) {
            tableName = (String)displayAction.get( "TABLE" );
            displayBuffer.append( " FROM " + tableName );
            displayWhere = (tinySQLWhere)displayAction.get( "WHERE" );
            }
        if ( displayWhere != (tinySQLWhere)null ) {
            displayBuffer.append( displayWhere.toString() );
            }
        if ( groupBy ) {
            displayBuffer.append( " GROUP BY " );
            for ( i=0; i<displayColumns.size(); i++ ) {
                displayColumn = (tsColumn)displayColumns.elementAt(i);
                if ( !displayColumn.getContext( "GROUP" ) ) {
                    continue;
                    }
                if ( !displayBuffer.toString().endsWith( " GROUP BY " ) ) { 
                    displayBuffer.append( "," );
                    }
                displayBuffer.append(displayColumn.name);
                }
            }
        if( orderBy ) {
            displayBuffer.append(" ORDER BY ");
            for( i=0; i<displayColumns.size(); i++ ) {
                displayColumn = (tsColumn)displayColumns.elementAt( i );
                if ( !displayColumn.getContext( "ORDER" ) ) {
                    continue;
                    }
                if ( !displayBuffer.toString().endsWith( " ORDER BY " ) ) {
                    displayBuffer.append( "," );
                    }
                displayBuffer.append(displayColumn.name);
                }
            }
        return displayBuffer.toString();
    }
    /**
     * Find the input table alias in the list provided and return the table 
     * name.
     * 
     * @param inputAlias cadena alias
     * @param tableList lista de tablas
     * 
     * @exception tinySQLException la excepcion que maneja
     */
    public static String findTableForAlias( String inputAlias, 
        Vector tableList ) throws tinySQLException {
        int i;
        int aliasAt;
        String tableAndAlias;
        tableAndAlias = findTableAlias( inputAlias, tableList );
        aliasAt = tableAndAlias.indexOf( "->" );
        return tableAndAlias.substring( 0, aliasAt );
    }
    /**
     * Find the input table alias in the list provided and return the table name
     * and alias in the form tableName=tableAlias.
     * 
     * @param inputAlias cadena alias
     * @param tableList lista de tablas
     * 
     * @exception tinySQLException la excepcion que maneja
     */
    public static String findTableAlias( String inputAlias, Vector tableList )
        throws tinySQLException {
        int i;
        int aliasAt;
        String tableAndAlias,tableName,tableAlias;
        for( i=0; i<tableList.size(); i++ ) {
            tableAndAlias = (String)tableList.elementAt( i );
            aliasAt = tableAndAlias.indexOf( "->" );
            tableName = tableAndAlias.substring( 0, aliasAt );
            tableAlias = tableAndAlias.substring( aliasAt + 2 );
            if( inputAlias.equals( tableAlias ) ) {
                return tableAndAlias;
                }
            }
        String deDonde = "UtilString.findTableAlias():\n";
        //throw new tinySQLException( "Unable to identify table alias "
        //    + inputAlias );
        throw new tinySQLException( deDonde + " " + 
                "Inabilitado para identificar el alias " + 
                    "de la tabla " + inputAlias );
   }
    /**
     * Determine a type for the input string. 
     * 
     * @param inputValue el valor de entrada
     * 
     * @return devuelve el tipo del valor de entreda
     */
    public static int getValueType( String inputValue ) {
        double doubleValue;
        long intValue;
        if ( inputValue.startsWith("\"") |
            inputValue.startsWith("'") ) {
            return Types.CHAR;
            }
        try {
            /*
             * If the parse methods don't generate an exception this is a 
             * valid number
             */
            if ( inputValue.trim().indexOf( "." )>-1 ) {
                doubleValue = Double.parseDouble(inputValue.trim());
                return Types.FLOAT;
                } 
            else {
                intValue = Long.parseLong(inputValue.trim());
                return Types.INTEGER;
                }
        } catch( Exception e ) {
            //String deDonde = "UtilString.getValueType():\n";
            //System.out.println( deDonde + " " + e.getMessage() );
            return Types.CHAR;
        }
    }
}
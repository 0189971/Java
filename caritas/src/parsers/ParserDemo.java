/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parsers;

import java.io.*;

/**
 * Demuestra el funcionamiento del parser
 * 
 * @author Saul De La O Torres
 * @version 1.0
 */
public class ParserDemo {
    public static void main( String [] args ) throws IOException {
        String expresion;
        BufferedReader br = 
            new BufferedReader( new InputStreamReader( System.in ) );
        Parser p = new Parser();
        System.out.println( "Pulse Enter para detener el programa.");
        for( ; ; ) {
            System.out.print( "Introduzca la expresion: ");
            expresion = br.readLine();
            if( expresion.equals( "" ) ) {
                break;
                }
            try {
                System.out.println( "Resultado: " + p.evaluar( expresion ) );
                System.out.println();
            } catch( ParserException pe ) {
                System.out.println( pe );
            }
            }
    }
}

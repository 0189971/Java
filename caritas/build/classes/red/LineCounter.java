/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package red;

/**
 *
 * @author sdelaot
 */
import java.io.*;

public class LineCounter {

    static LineNumberInputStream m_istreamLineNum ;
    
    public static void main( String [] args ) {

        if( args.length!=1 ) {

            System.err.println( "Error de utilización: \n LineCounter " +
                "<arch - entrada >" );
            System.exit(-1);
            }
        try {
            FileInputStream is = new FileInputStream(args[0]);
            m_istreamLineNum = new LineNumberInputStream(is);
        } catch (Exception e) {
            System.err.println(
            "Error:\n Al leer el archivo de entrada " + args[0] );
            System.exit(-1);
            
            try {
                while( m_istreamLineNum.read()!=-1 ) {
                    
                    }
            } catch ( Exception eo ) {
                System.err.println( "Error:\n Al leer del archivo de entrada." );
                System.exit(-1);
            }

        System.out.println( "Recuento de líneas terminado. El número de líneas es:"
            + m_istreamLineNum.getLineNumber() );

        }
    }
}

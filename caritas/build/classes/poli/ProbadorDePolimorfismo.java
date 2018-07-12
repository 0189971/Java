/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poli;

/**
 *
 * @author sdelaot
 */
public class ProbadorDePolimorfismo {
    public static void realizarPolimorfismo( SerHumano ser ) {
        System.out.println( " " + ser.caminar() );
    }
    public static void realizarPolimorfismo( SerHumano [] seres ) {
        for( int n=0; n<seres.length; n++ ) {
            realizarPolimorfismo( seres[n] );
            if( n==3 ) {
                seres[n].pensar( "Como llego a casa?" );
                }
            }
    }
    public static void main( String [] args ) {
        SerHumano  [] personas = { 
            new Persona(),
            new Estudiante(),
            new NMS(),
            new NS()
            };
        realizarPolimorfismo( personas );
        Estudiante unEstudiante = new Estudiante();
        Persona alguien = unEstudiante;
        alguien.pensar( "Pienso en comida" );
        Persona otraPersona = new Persona();
        unEstudiante = (Estudiante)otraPersona;
        //unEstudiante = otraPersona;
        unEstudiante.pensar( "Funcionara?" );
    }
}

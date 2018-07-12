/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tercerdeppoo;

/**
 *
 * @author sdelaot
 */
public class TercerDepPoo {
    public static void upCasting( Empleado e ) {
        e.verPropiedades();
        e.trabaja();
        System.out.println();
    }
    public static void upCasting( Empleado [] empresa ) {
        for( int n=0; n<empresa.length; n++ ) {
            upCasting( empresa[n] );
            }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado miEmpresa [] = {
            new Programador( "Juan Rodriguez", 27, 15500.30, "Programador Java", 
                "Desarrollo Web Cliente-Servidor" ),
            new Secretaria( "Irma Juarez", 25, 10000.50, "Bilingue", 
                "Capital humano" ),
            new Administrativo( "Ernesto Perez", 33, 12000.00, 
                "Director de departamento", 15000.6, "Capital Humano" )
            };
        upCasting( miEmpresa );
    }
}

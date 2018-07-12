/*
 * Paquete al que pertenece la clase.
 */
package polimorfismo;

/**
 *
 * @author sdelaot
 */
public class ProbadorDePolimorfismo {
    public static void realizarUPCASTING( SerHumano ser ) {
        System.out.println( ser.comer() );
    }
    public static void realizarUPCASTING( SerHumano [] personas ) {
        for( int n=0; n<personas.length; n++ ) {
            realizarUPCASTING( personas[n] );
            }
    }
    public static void main( String [] args ) {
        SerHumano [] gente = { 
            new Persona(),
            new Empleado(),
            new Administrativo(),
            new Profesor(),
            new Empleado(),
            new Administrativo(),
            new Profesor()
            };
        realizarUPCASTING( gente );
        try {
            //realizarDOWNCASTING( (Administrativo)gente[0] );
            //realizarDOWNCASTING( (Profesor)gente[0] );
            //realizarDOWNCASTING( (Empleado)gente[0] );
            //realizarDOWNCASTING( (Administrativo)gente[1] );
            realizarDOWNCASTING( (Profesor)gente[1] );
        } catch( ClassCastException cce ) {
            System.out.println( "ERROR: " + cce.getMessage() );
        }
    }
    public static void realizarDOWNCASTING( Administrativo admin ) {
        admin.comer();
    }
    public static void realizarDOWNCASTING( Profesor profe ) {
        profe.comer();
    }
    public static void realizarDOWNCASTING( Empleado empleado ) {
        empleado.comer();
    }
}

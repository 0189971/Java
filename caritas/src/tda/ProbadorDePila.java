/*
 * Paquete al que pertenece la clase.
 */
package tda;

/**
 *
 * @author sdelaot
 */
public class ProbadorDePila {
    public static void main( String [] args ) {
        Pila miPila = new Pila();
        miPila.push(   10 );
        miPila.push(    4 );
        miPila.push( -  2 );
        miPila.push(  200 );
        miPila.push( - 23 );
        miPila.push(  900 );
        miPila.push( -234 );
        miPila.push(   90 );
        miPila.push( -890 );
        miPila.push(  100 );
        miPila.push( -  4 );
        int cap = miPila.getCapacidad();
        for( int n=0; n<cap+1; n++ ) {
            System.out.println( " " + miPila.pop() );
            }
    }
}

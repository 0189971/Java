/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author sdelaot
 */
public class Factorial {
    /**
     * Procesa  el factorial de un número
     * @param n es un entero positivo
     * @return n! = 1 * 2 n
     */
    public int calcularFactorial( int n ) {
        System.out.println( " factorial( " + n + " ): " );
        Throwable t = new Throwable();
        StackTraceElement [] frames = t.getStackTrace();
        for (int i = 0; i < frames.length; i++ ) {
            System.out.println( frames[i] );
            }
        int r;
        if( n<=1 ) {
            r = 1;
            }
        else {
            r = n * calcularFactorial( n - 1 );
            }
        System.out.println( " return " + r );
        return r;
    }
}

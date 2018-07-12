/*
 * Paquete al que pertenece la clase.
 */
package tda;

/**
 *
 * @author sdelaot
 */
public class Pila {
    private final int TOPE = 10;
    private int [] datos = new int[TOPE];
    private int contador = 0;
    public void push( int dato ) {
        if( !estaLlena() ) {
            datos[contador++] = dato;
            }
        else {
            System.out.println( "Pila llena" );
            }
    }
    private boolean estaLlena() {
        if( contador==TOPE ) {
            return true;
            }
        return false;
    }
    public int pop() {
        if( !estaVacia() ) {
            return datos[--contador];
            }
        else {
            System.out.println( "Pila vacia" );
            contador = 0;
            }
        return 0;
    }
    private boolean estaVacia() {
        if( contador<=0 ) {
            return true;
            }
        return false;
    }
    public int getCapacidad() {
        return contador;
    }
}

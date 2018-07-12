/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public class SinconizadorDeHilos {
    public static void main( String [] args ) {
        Q unQ = new Q();
        Productor p = new Productor( unQ );
        p.start();
        Consumidor c = new Consumidor( unQ );
        c.start();
    }
}

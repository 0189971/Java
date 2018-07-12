/*
 * Paquete al que pertenece la clase.
 */
package modularidad;

/**
 *
 * @author sdelaot
 */
public class Dado {
    private int numero;
    public int tirarDado() {
        numero = (int)(Math.random()*6.0+1.0);
        return numero;
    }
}

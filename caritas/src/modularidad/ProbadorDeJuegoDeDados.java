/*
 * Paquete al que pertenece la clase.
 */
package modularidad;

/**
 *
 * @author sdelaot
 */
public class ProbadorDeJuegoDeDados {
    public static void main( String [] args ) {
        JuegoDeDados juego = new JuegoDeDados();
        juego.setNombreDelJugador( "Saul" );
        juego.setNumeroDelJugador( 10 );
        juego.jugarJuego();
    }
}

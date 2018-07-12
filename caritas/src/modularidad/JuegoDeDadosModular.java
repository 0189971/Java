/*
 * Paquete al que pertenece la clase.
 */
package modularidad;

/**
 *
 * @author sdelaot
 */
public class JuegoDeDadosModular {
    private Dado [] dados = new Dado[3];
    private Jugador unJugador;
    private void crearDados() {
//        dados[0] = new Dado();
//        dados[1] = new Dado();
        for( int n=0; n<dados.length; n++ ) {
            dados[n] = new Dado();
            }
    }
    private void crearJugador( String nombre, int suNumero ) {
        unJugador = new Jugador();
        unJugador.setNombreDelJugador(nombre);
        unJugador.setNumeroDelJugador(suNumero);
        unJugador.tomarDados(dados);
    }
    public void jugarElJuego( String nombre, int suNumero ) {
        crearDados();
        crearJugador( nombre, suNumero );
        int sumaDeDados = unJugador.tirarDados();
        if( sumaDeDados==unJugador.getNumeroDelJugador() ) {
            System.out.println( 
                " Ganaste : " + unJugador.getNombreDelJugador() + 
                    " su numero " + sumaDeDados );
            }
        else {
            System.out.println( 
                " Ha perdido " + unJugador.getNombreDelJugador() + 
                    " su numero : " + unJugador.getNumeroDelJugador() + 
                    " y el de los dados : " + sumaDeDados );
            }
    }
}

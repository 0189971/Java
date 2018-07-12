/*
 * Paquete al que pertenece la clase.
 */
package modularidad;

/**
 *
 * @author sdelaot
 */
public class Jugador {
    private String nombreDelJugador;
    private int numeroDelJugador;
    private Dado [] dados;
    public void setNombreDelJugador( String nombre ) {
        nombreDelJugador = nombre;
    }
    public void setNumeroDelJugador( int numero ) {
        numeroDelJugador = numero;
    }
    public String getNombreDelJugador( ) {
        return nombreDelJugador;
    }
    public int getNumeroDelJugador( ) {
        return numeroDelJugador;
    }
    public void tomarDados( Dado[] losDados ) {
        dados = losDados;
    }
    public int tirarDados() {
//        int numeroUno = dados[0].tirarDado();
//        int numeroDos = dados[1].tirarDado();
//        System.out.println( " D1 : " + numeroUno + 
//            "  D2 : " + numeroDos );
        int sumatoria = 0;
        for( int n=0; n<dados.length; n++ ) {
            sumatoria += dados[n].tirarDado();
            }
        //return numeroUno + numeroDos;
        return sumatoria;
    }
}

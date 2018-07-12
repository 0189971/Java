/*
 * Paquete al que pertenece la clase.
 */
package modularidad;

/**
 *
 * @author sdelaot
 */
public class JuegoDeDados {
    private String nombreDelJugador;
    private int numeroDelJugador;
    private int sumaDeDados;
    public void setNombreDelJugador( String nombre ) {
        nombreDelJugador = nombre;
    }
    public void setNumeroDelJugador( int numero ) {
        numeroDelJugador = numero;
    }
    public void tirarDados() {
        int numeroUno = (int)(Math.random()*6.0+1.0);
        int numeroDos = (int)(Math.random()*6.0+1.0);
        System.out.println( " D1 : " + numeroUno + 
                " D2 : " + numeroDos );
        sumaDeDados =  numeroUno + numeroDos;
    }
    public void jugarJuego() {
        tirarDados();
        if( sumaDeDados==numeroDelJugador ) {
            System.out.println( " Ganaste : " + nombreDelJugador+ 
                    " su numero " + sumaDeDados );
            }
        else {
            System.out.println( " Ha perdido " + nombreDelJugador + 
                    " su numero : " + numeroDelJugador + 
                    " y el de los dados : " + sumaDeDados );
            }
    }
}

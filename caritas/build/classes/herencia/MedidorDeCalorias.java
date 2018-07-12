/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author sdelaot
 */
public class MedidorDeCalorias extends Thread {
    private int caloriasAQuemar;
    private String como;
    private int tiempo;
    public MedidorDeCalorias() {
        this( 0, "" );
    }
    public MedidorDeCalorias( int calorias, String como ) {
        super( "Medidor de calorias" );
        this.caloriasAQuemar = calorias;
        this.como = como;
    }
    public MedidorDeCalorias( MedidorDeCalorias medidor ) {
        this.caloriasAQuemar = medidor.caloriasAQuemar;
    }
    @Override
    public void run() {
        System.out.println( this.getName() );
        int contador = 0;
        tiempo = 0;
        if( como.equals( "correr" ) ) {
            tiempo = 5;
            }
        else
        if( como.equals( "nadar" ) ) {
            tiempo = 1;
            }
        else
        if( como.equals( "cargar pesas" ) ) {
            tiempo = 2;
            }
        while( contador<=caloriasAQuemar ) {
            try {
                Thread.sleep(tiempo*100);
            } catch( InterruptedException ie ) {
                ie.printStackTrace();
            }
            contador++;
            System.out.println( " Calorias quemadas " + contador + " " + como );
            }
    }
    public int getTiempo() {
        return tiempo;
    }
}

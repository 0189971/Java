/*
 * Paquete al que pertenece la clase.
 */
package red;

/**
 *
 * @author sdelaot
 */
public class ProbadorDeIP {
    public static void main( String [] args ) {
        ConsultorDeIPEnWeb consultor = 
            new ConsultorDeIPEnWeb( "www.starwave.com" );
        consultor.consultarMiIP();
        consultor.consultarIP();
        consultor.consultarIPPorSegmento();
    }
}
/*
MacBook-Pro-de-Saul-De-La-O-Torres-2.local/10.0.1.10
www.oracle.com/23.67.230.140
www.oracle.com/23.67.230.140
 */
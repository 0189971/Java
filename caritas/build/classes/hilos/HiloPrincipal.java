/*
 * Paquete al que pertenece la clase.
 */
package hilos;

/**
 *
 * @author sdelaot
 */
public class HiloPrincipal {
    public static void main( String [] args ) {
        crearHilos();
//        sincronizarHilos();
//        comunicarHilos();
    }
    public static void sincronizarHilos( ) {
          Llamame destino = new Llamame();
          ElQueLlama ob1 = new ElQueLlama( destino, "Hola" );
          ElQueLlama ob2 = new ElQueLlama( destino, "Mundo" );
          ElQueLlama ob3 = new ElQueLlama( destino, "Sincronizado" );
          ob1.start();
          ob2.start();
          ob3.start();
          //Espera hasta que terminen los hilos
          try {
                 ob1.join();
                 ob2.join();
                 ob3.join();
          } catch( InterruptedException e ) {
                 System.out.println( "Interrumpido" );
          }
    }
    public static void comunicarHilos() {
        Q q = new Q();
        new Productor( q ).start();
        new Consumidor( q ).start();
        System.out.println( "Pulse Control C para finalizar." );
    }
    public static void crearHilos( ) {
        Thread hiloPrincipal = Thread.currentThread();
        System.out.println( hiloPrincipal.getName() );
        hiloPrincipal.setName( "Hilo Principal" );
        System.out.println( hiloPrincipal.getName() + 
            " " + hiloPrincipal.isAlive());
        MiHiloHerencia [] mhh = new MiHiloHerencia[50];
        MiHiloEmulado [] mhe = new MiHiloEmulado[50];
        for( int n=0; n<mhh.length; n++ ) {
            mhh[n] = new MiHiloHerencia(n+1);
            mhe[n] = new MiHiloEmulado(n+1);
            mhh[n].start();
            mhe[n].start();
            }
        int contador;
        try {
            for( contador=5; contador>=0; contador-- ) {
                System.out.println( hiloPrincipal.getName() + 
                        " : " + contador );
                Thread.sleep( 1500 );
                }
        }catch( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }
}

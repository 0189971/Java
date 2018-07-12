package patron;
import java.io.*;

public class ProbadorDeFlujos {
	public static void main( String [] args ) {
		FlujosFactory flujoFac = new FlujosFactory();
		FlujosDeEntrada fdin = flujoFac.creaFlujoDeEntrada();
		DataInputStream din = fdin.getFlujo( 
        "/Users/sdelaot/Desktop/proyjava/caritas/src/patron/PruebaFlujos1.java" );
		FlujosDeSalida fdout = flujoFac.creaFlujoDeSalida();
		DataOutputStream dout = fdout.getFlujo( 
        "/Users/sdelaot/Desktop/proyjava/caritas/src/patron/PruebaFlujos1.ccc" );
		try {
			String linea = din.readLine();
			System.out.println( linea );
			while( linea!=null ) {
				//if( linea!=null ) {
					System.out.println( linea );
					dout.writeBytes( linea );
					dout.writeByte( '\n' );
				//	}
				linea = din.readLine();
				}
			din.close();
			dout.close();
		} catch( EOFException error ) {
			error.printStackTrace();
		} catch( IOException error ) {
			error.printStackTrace();
		}
	}
}
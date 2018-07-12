package patron;
import java.io.*;

class PruebaFlujos3 {
	public static void main( String [] args ) {
		FlujosFactory ff = new FlujosFactory();
		FlujoDeEntrada fde = ff.creaFlujoDeEntrada1();
		BufferedReader br = fde.getFlujo( "c:\\scandisk.bak" );
		FlujoDeSalida fds = ff.creaFlujoDeSalida1();
		BufferedWriter bw = fds.getFlujo( "c:\\scandisk.bbb" );
		try {
			String linea = br.readLine();
			System.out.println( linea );
			bw.write( linea );
			br.close();
			bw.close();
		} catch( IOException e ) {
			e.printStackTrace();
			}
	}
}
package patron;
import java.io.*;

public class PruebaFlujos2 {
	public static void main( String [] args ) {
		FlujosFactory ff = new FlujosFactory();
		FlujoAleatorio fa = ff.creaFlujoAleatorio();
		RandomAccessFile rafin = fa.getFlujoAleatorio( "c:\\scandisk.bbb", "r" );
		RandomAccessFile rafout = fa.getFlujoAleatorio( "c:\\scandisk.bb1", "rw" );
		try {
			String linea = rafin.readLine();
			while( linea!=null ) {
				if( linea!=null ) {
					System.out.println( linea );
					rafout.writeBytes( linea );
					rafout.writeByte( '\n' );
					}
				linea = rafin.readLine();
				}
			rafin.close();
			rafout.close();
		} catch( IOException error ) {
			error.printStackTrace();
			}
	}
}
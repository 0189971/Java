package patron;
import java.io.*;

public class PruebaFlujos1 {
	public static void main( String [] args ) { 
		FlujosFactory ff = new FlujosFactory();
		FlujosDeEntradaTexto fintxt = ff.creaFlujoDeEntradaTexto();
		FileReader fr = fintxt.getFlujoTexto( "c:\\autoexec.bbk" );
		
		FlujosDeSalidaTexto fouttxt = ff.creaFlujoDeSalidaTexto();
		FileWriter fw = fouttxt.getFlujoTexto( "c:\\autoexec.bb1" );
		try {
			int ica = fr.read();
			while( ica!=-1 ) {
				if( ica!=-1 ) {
					System.out.print( (char)ica );
					fw.write( ica );
					}
				ica = fr.read();
				}
			fr.close();
			fw.close();
		} catch( IOException error ) {
			error.printStackTrace();
			}
	}
}
package patron;
import java.io.*;

class FlujoBufferedReader extends FlujoDeEntrada {
    @Override
	public BufferedReader getFlujo( String nombreArchivo ) {
		BufferedReader elFlujo = null;
		try {
			setNombreArchivo( nombreArchivo );
			elFlujo = new BufferedReader( getFlujoArchivo() );
		} catch( FileNotFoundException error ) {
			error.printStackTrace();
		}
		return new BufferedReader( elFlujo );
	}
}
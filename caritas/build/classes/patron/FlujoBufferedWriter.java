package patron;
import java.io.*;

public class FlujoBufferedWriter extends FlujoDeSalida {
	public BufferedWriter getFlujo( String nombreArchivo ) {
		BufferedWriter elFlujo = null;
		try {
			setNombreArchivo( nombreArchivo );
			elFlujo = new BufferedWriter( getFlujoArchivo() );
		} catch( FileNotFoundException error ) {
			error.printStackTrace();
			}
		return new BufferedWriter( elFlujo );
	}
}
package patron;
import java.io.*;
public class FlujoFileReader extends FlujosDeEntradaTexto {
	public FileReader getFlujoTexto( String archivo ) {
		setNombreArchivo( archivo );
		FileReader lector = null;
		try {
			lector = new FileReader( getNombreArchivo() );
		} catch( FileNotFoundException error ) {
			error.printStackTrace();
		}
		return lector;
	}
} 
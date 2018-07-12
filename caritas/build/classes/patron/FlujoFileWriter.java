package patron;
import java.io.*;
public class FlujoFileWriter extends FlujosDeSalidaTexto {
	public FileWriter getFlujoTexto( String archivo ) {
		setNombreArchivo( archivo );
		FileWriter escritor = null;
		try {
			escritor = new FileWriter( getNombreArchivo() );
		} catch( IOException error ) {
			error.printStackTrace();
		}
		return escritor;
	}
} 
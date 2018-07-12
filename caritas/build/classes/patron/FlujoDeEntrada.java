package patron;
import java.io.*;
public abstract class FlujoDeEntrada {
	private BufferedReader lector;
	private String nombreArchivo;
	private FileReader fr;
	FileReader getFlujoArchivo() throws FileNotFoundException {
	 	fr = new FileReader( nombreArchivo );
	 	return fr;
	}
	String getNombreArchivo() {
		return nombreArchivo;
	}
	BufferedReader getBufferedReader() throws FileNotFoundException {
		fr = new FileReader( nombreArchivo );
		lector = new BufferedReader( fr );
		return lector;
	}
	void setNombreArchivo( String nombreAr ) {
		nombreArchivo = nombreAr;
	}
	void setFileReader( FileReader otroFile ) {
		fr = otroFile;
	}
	void setBufferedReader( BufferedReader otroDOut ) {
		lector = otroDOut;
	}
	public abstract BufferedReader getFlujo( String nombreArchivo );
}
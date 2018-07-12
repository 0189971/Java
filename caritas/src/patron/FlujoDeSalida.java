package patron;
import java.io.*;
public abstract class FlujoDeSalida {
	private BufferedWriter escritor;
	private String nombreArchivo;
	private FileWriter fw;
	FileWriter getFlujoArchivo() throws FileNotFoundException {
		try {
	 		fw = new FileWriter( nombreArchivo );
	 	} catch( IOException e ) { e.printStackTrace(); }
	 	return fw;
	}
	String getNombreArchivo() { return nombreArchivo; }
	BufferedWriter getBufferedWriter() throws FileNotFoundException {
		try {
			fw = new FileWriter( nombreArchivo );
			escritor = new BufferedWriter( fw );
		} catch( IOException e ) { e.printStackTrace(); }
		return escritor;
	}
	void setNombreArchivo( String nombreAr ) {
		nombreArchivo = nombreAr;
	}
	void setFileWriter( FileWriter otroFile ) { fw = otroFile; }
	void setBufferedWriter( BufferedWriter otroDOut ) {
		escritor = otroDOut;
	}
	public abstract BufferedWriter getFlujo( String nombreArchivo );
}
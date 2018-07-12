package patron;
import java.io.*;

public abstract class FlujosDeSalida {
	private DataOutputStream dOut;
	private String nombreArchivo;
	private FileOutputStream fOutStr;
    public FlujosDeSalida() {
        super();
    }
	FileOutputStream getFlujoArchivo() throws FileNotFoundException {
		fOutStr = new FileOutputStream( nombreArchivo );
		return fOutStr;
	}
	String getNombreArchivo() {
		return nombreArchivo;
	}
	DataOutputStream getDataOutputStream() throws FileNotFoundException {
		fOutStr = new FileOutputStream( nombreArchivo );
		dOut = new DataOutputStream( fOutStr );
		return dOut;
	}
	void setNombreArchivo( String nombreAr ) {
		nombreArchivo = nombreAr;
	}
	void setFile( FileOutputStream otroFile ) {
		fOutStr = otroFile;
	}
	void setDataOutputStream( DataOutputStream otroDOut ) {
		dOut = otroDOut;
	}
	public abstract DataOutputStream getFlujo( String nombreArchivo );
}
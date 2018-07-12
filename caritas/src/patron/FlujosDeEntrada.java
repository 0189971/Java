package patron;
import java.io.*;
public abstract class FlujosDeEntrada {
	private DataInputStream dIn;
	private String nombreArchivo;
	private FileInputStream fInStr;
    public FlujosDeEntrada() {
        super();
    }
	public FileInputStream getFlujoArchivo() throws FileNotFoundException {
		fInStr = new FileInputStream( nombreArchivo );
		return fInStr;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public DataInputStream getDataInputStream() throws FileNotFoundException {
		fInStr = new FileInputStream( nombreArchivo );
		dIn = new DataInputStream( fInStr );
		return dIn;
	}
	public void setNombreArchivo( String nombreAr ) {
		nombreArchivo = nombreAr;
	}
	public void setFileInputStream( FileInputStream otroFile ) {
		fInStr = otroFile;
	}
	public void setDataInputStream( DataInputStream otroDOut ) {
		dIn = otroDOut;
	}
	public abstract DataInputStream getFlujo( String nombreArchivo );
}
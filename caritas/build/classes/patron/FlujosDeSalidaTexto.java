package patron;
import java.io.*;
public abstract class FlujosDeSalidaTexto {
	private String nombreArchivo;
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo( String otroArchivo ) {
		nombreArchivo = otroArchivo;
	}
	public abstract FileWriter getFlujoTexto( String archivo );
}
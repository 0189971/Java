package patron;
import java.io.*;
public abstract class FlujosDeEntradaTexto {
	private String nombreArchivo;
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public void setNombreArchivo( String otroArchivo ) {
		nombreArchivo = otroArchivo;
	}
	public abstract FileReader getFlujoTexto( String archivo );
}
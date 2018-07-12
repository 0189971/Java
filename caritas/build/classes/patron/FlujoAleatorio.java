package patron;
import java.io.*;
public abstract class FlujoAleatorio {
	private String nombreArchivo;
	private String modo;
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	public String getModo() {
		return modo;
	}
	public void setNombreYModo( String archivo, String mod ) {
		nombreArchivo = archivo;
		modo = mod;
	}
	public abstract RandomAccessFile getFlujoAleatorio( 
            String archivo, String mod );
}
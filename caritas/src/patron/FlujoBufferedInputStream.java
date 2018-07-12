package patron;
import java.io.*;
public class FlujoBufferedInputStream extends FlujosDeEntrada {
    public FlujoBufferedInputStream() {
        super();
    }
    @Override
	public DataInputStream getFlujo( String nombreArchivo ) {
		BufferedInputStream elFlujo = null;
		try {
			setNombreArchivo( nombreArchivo );
			elFlujo = new BufferedInputStream( getFlujoArchivo() );
		} catch( FileNotFoundException error ) {
			error.printStackTrace();
			}
		return new DataInputStream( elFlujo );
	}
}
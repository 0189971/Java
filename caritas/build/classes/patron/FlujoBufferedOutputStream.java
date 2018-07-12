package patron;

import java.io.*;

public class FlujoBufferedOutputStream extends FlujosDeSalida {
    public FlujoBufferedOutputStream() {
        super();
    }
    @Override
	public DataOutputStream getFlujo( String nombreArchivo ) {
		BufferedOutputStream elFlujo = null;
		try {
			setNombreArchivo( nombreArchivo );
			elFlujo = new BufferedOutputStream( getFlujoArchivo() );
		} catch( FileNotFoundException error ) {
			error.printStackTrace();
			}
		return new DataOutputStream( elFlujo );
	}
}
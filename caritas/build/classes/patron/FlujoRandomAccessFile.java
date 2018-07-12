package patron;
import java.io.*;
public class FlujoRandomAccessFile extends FlujoAleatorio {
	public RandomAccessFile getFlujoAleatorio( String archivo, 
            String mod ) {
		setNombreYModo( archivo, mod );
		RandomAccessFile flujo = null;
		try {
			flujo = new RandomAccessFile( getNombreArchivo(), 
                    getModo() );
		} catch( FileNotFoundException error ) {
			error.printStackTrace();
			}
		return flujo;
	}
}
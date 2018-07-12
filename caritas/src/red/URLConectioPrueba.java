import java.net.*;
import java.io.*;
import java.util.*;

class URLConectioPrueba {
	public static void main( String [] args ) throws Exception {
		int c = 0;
		URL hp = new URL( "http://www.starwave.com/people/naughton" );
		URLConnection hpCon = hp.openConnection();
		
		System.out.println( " Fecha               : " + new Date( hpCon.getDate() ) );
		System.out.println( " Tipo de contenido   : " + hpCon.getContentType() );
		System.out.println( " Espira              : " + hpCon.getExpiration() );
		System.out.println( " Ultima modificacion : " + new Date( hpCon.getLastModified() ) );
		int len = hpCon.getContentLength();
		System.out.println( " Longitud contenido  : " + len );
		if( len>0 ) {
			System.out.println( " Contenido " );
			InputStream input = hpCon.getInputStream();
			int i = len;
			while( ((c=input.read())!=-1) && (--i>0) )
				System.out.print( (char)c );
			input.close();
			}
		else {
			System.out.println( " Contenido no disponible " );
			}
	}
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package red;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author sdelaot
 */
public class QuienEsEnRed {
    private String direccionWeb1; // "internic.net"
    private String direccionWeb2; // "starwave.com"
    public void preguntar( ) throws IOException {
		int c = 0;
		Socket s = new Socket( direccionWeb1, 43 );
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		String str = direccionWeb2 + "\n";
		byte [] buf = new byte[str.length()];
		out.write( buf );
		while( (c=in.read())!=-1 ) {
			System.out.print( (char)c );
			}
		s.close();
	}
}

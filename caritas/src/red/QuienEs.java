import java.net.*;
import java.io.*;

class QuienEs {
	public static void main( String [] args ) throws IOException {
		int c = 0;
		Socket s = new Socket( "internic.net", 43 );
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		String str = (args.length==0?"starwave.com": args[0]) + "\n";
		byte [] buf = new byte[str.length()];
		out.write( buf );
		while( (c=in.read())!=-1 ) {
			System.out.print( (char)c );
			}
		s.close();
	}
}
import java.net.*;
import java.io.*;

public class CHM{
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Escribe la direccion del servidor al que se conectara la aplicacion:");
			String host = br.readLine();
			System.out.println("Indica el puerto:");
			int pto = Integer.parseInt(br.readLine());
			Socket cl = new Socket(host,pto);
			System.out.println("Conexion establecida");

			DataInputStream dis = new DataInputStream(cl.getInputStream());
			String datos = dis.readUTF();
			int v2 = dis.readInt();
			System.out.println("Datos recibidos: "+datos+"\t"+v2);
			dis.close();
			cl.close();	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
import java.net.*;
import java.io.*;

public class SHM{
	public static void main(String[] args) {
		try{
			ServerSocket s = new ServerSocket(4000);
			System.out.println("Servicio iniciado... esperando clientes");
			for (; ; ) {
			  	Socket cl = s.accept();
			
                                System.out.println("Conexion recibida desde:"+cl.getInetAddress().getHostAddress()+":"+cl.getPort());
			  	String msj = "Hola...Mundo";
			  	int v = 5;

			  	DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
			  	dos.writeUTF(msj);
			  	dos.writeInt(v);
			  	dos.flush();

			  	dos.close();
			  	cl.close();	
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
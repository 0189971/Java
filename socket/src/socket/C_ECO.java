package socket;
import java.net.*;
import java.io.*;

public class C_ECO{
	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Escribe la direccion IP del servidor:");
			String ip = br.readLine();
			System.out.print("Ingresa el puerto:");
			int pto = Integer.parseInt(br.readLine());
			Socket cl = new Socket(ip,pto);
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(cl.getOutputStream()));
			BufferedReader br1 = new BufferedReader(new InputStreamReader(cl.getInputStream()));
			System.out.println("Conexion establecida... escribe texto para enviar <enter> para salir \"Adios\" o \"salir\" para terminar");
			String datos = " ";
			while(true){
				datos=br.readLine();
				System.out.println("Datos enviados: "+datos);
				if(datos.indexOf("Adios")>=0 || datos.indexOf("salir")>=0){
					System.out.println("Finaliza programa");
					pw.println(datos);
					pw.flush();
					br.close(); //checar
					br1.close();
					pw.close();
					System.exit(0);
				}else{
					pw.println(datos);
					pw.flush();
					String eco = br1.readLine();
					System.out.println("ECO: "+ eco);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
import java.net.*;
import java.io.*;

public class Recibe{
	public static void main(String[] args) {
		try{
			int pto = 5678;			
			String arch = "archivo.zip";
			ServerSocket s = new ServerSocket(pto);
			System.out.println("Servicio iniciado... esperando clientes");
			for (; ; ) {
				Socket cl = s.accept();	
				System.out.println("Cliente conectado desde:" + cl.getInetAddress().getHostAddress()+":"+cl.getPort());
				System.out.println("Inicia Descarga...");
				
				DataOutputStream dos = null;
				DataInputStream dis = new DataInputStream(cl.getInputStream());

				int n = 0;
				
				//BufferedOutputStream bos = new BufferedOutputStream(new FileInputStream(arch));
				//BufferedInputStream bis = new BufferedInputStream(cl.getInputStream());
							
				//File f = new File("archivo.zip");
				//long tam = f.lenght;

				long leidos=0;
				String nombre = dis.readUTF();
				long tam = dis.readLong();
				dos = new DataOutputStream(new FileOutputStream(nombre));
						
				byte[] buf = new byte[1024];
					
					/*while(n=bis.read(buf)!=-1){						
						bos.write(buf,0,n);
						bos.flush();
					}*/

					while(leidos < tam){
						n = dis.read(buf);
						dos.write(buf,0,n);
						dos.flush();
						leidos=leidos+n;
					}

			System.out.println("Archivo Recibido...\n");
			dis.close();
			dos.close();
			cl.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
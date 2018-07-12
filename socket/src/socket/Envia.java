import java.net.*;
import javax.swing.JFileChooser;
import java.io.*;

public class Envia{
	public static void main(String[] args) {
		try{
			//String arch = "archivo.zip";
			String ip = "127.0.0.1";
			int pto = 5678;
			JFileChooser fc = new JFileChooser();
			//fc.setMultiSelectionEnabled(true);
			int r = fc.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION){
			/*File[]*/File f = fc.getSelectedFile();
				String nombre = f.getName();
				long tam = f.length();
				String path = f.getAbsolutePath();
			Socket cl = new Socket(ip,pto);
			System.out.println("Conexion establecida comienza envia");
			
			DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
			DataInputStream dis = new DataInputStream(new FileInputStream(path));

			dos.writeUTF(nombre);
			dos.flush();
			dos.writeLong(tam);
			dos.flush();


			//BufferedOutputStream bos = new BufferedOutputStream(cl.getOutputStream());
			//BufferedInputStream bis = new BufferedInputStream( new FileInputStream(arch));
			//long tam = (long)bis.available();
			//File f = new File("archivo.zip");
			//long tam = f.lenght;

			int enviados = 0;
			int n = 0;

			byte[] buf = new byte[1024];
			while(enviados < tam){
				n = dis.read(buf);
				dos.write(buf,0,n);
				dos.flush();
				enviados=enviados+n;
				int p = (int)((enviados*100)/tam);
				System.out.println("Se ha enviado"+p+"% del archivo");
			}
			System.out.println("Archivo enviado...\n");
			dis.close();
			dos.close();
			cl.close();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
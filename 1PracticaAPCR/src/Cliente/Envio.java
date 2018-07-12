package Cliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Envio implements Runnable {
    
    private File[] archivos;
    private JLabel etiqueta;
    private JProgressBar barra;
    
    public Envio(File[] archivos, JLabel etiqueta, JProgressBar barra) {
        this.archivos = archivos;
        this.etiqueta = etiqueta;
        this.barra = barra;
    }
    
    @Override
    public void run() {
        //Inicio del envio de los archivos
        System.out.println("Inicio del envio de los archivos");
        for (File archivo : archivos) {
            try {
                etiqueta.setText("Enviando: " + archivo.getName());
                enviarArchivo(archivo);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void enviarArchivo(File archivo) throws IOException {
        //Socket para enviar todos los archivos
        Socket cl = new Socket("127.0.0.1", 9000);
        DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
        //envio del nombre de cada archivo
        dos.writeUTF(archivo.getName());
        System.out.println("Enviar nombre: " + archivo.getName());
        //envio del tamaño del archivo
        dos.writeInt((int) archivo.length());
        System.out.println("Enviar tamano: " + archivo.length());
        
        FileInputStream fis = new FileInputStream(archivo);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(cl.getOutputStream());
        
        byte[] buffer = new byte[1024];
        int len;
        int enviado = 0;
        int acumulador = 0;
        
        while ((len = bis.read(buffer, 0, buffer.length)) != -1) {
            bos.write(buffer, 0, len);
            bos.flush();
            acumulador += len;
            if (((double) acumulador * 100 / (double) archivo.length()) > enviado + 1) {
                enviado = (int) ((double) acumulador * 100 / (double) archivo.length()) + 1;
                System.out.println("Enviado: " + enviado + "%");
                if (enviado >= 100) {
                    barra.setString("Completo");
                } else {
                    barra.setString(enviado + "%");
                    barra.setValue(enviado);
                }
            }
        }
        bis.close();
        bos.close();
        dos.close();
        cl.close();
    }
    
}


package Servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Recibo implements Runnable{
    
    private JLabel etiqueta;
    private JProgressBar barra;
    private JTable tabla;

    public Recibo(JLabel etiqueta, JProgressBar barra, JTable tabla) {
        this.etiqueta = etiqueta;
        this.barra = barra;
        this.tabla = tabla;
    }

    @Override
    public void run() {
        //Recibo de archivos
        System.out.println("Recibir archivos ");
        try {
            Recibir();
        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Error al enviar", "Servidor", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    void Recibir() throws IOException {
        try{
            //Recibe la cantidad de archivos
            ServerSocket s = new ServerSocket(9000);
            System.out.println("Servidor listo... Esperando Clientes:");
            Socket cl = s.accept();
            DataInputStream dis = new DataInputStream(cl.getInputStream());
            int numeroArchivos = dis.readInt();
            System.out.println("numero de archivos a recibir: " + numeroArchivos );
            JOptionPane.showMessageDialog(null, "Total de archivos a recibir " + numeroArchivos,"Mensaje del servidor",JOptionPane.OK_OPTION);
            dimensionarTabla(numeroArchivos);
            //cl.setSoTimeout(3000);
            cl.close();
           // for(;;){
            for(int cont = 0; cont < numeroArchivos ; cont++){
                cl = s.accept();
                dis = new DataInputStream(cl.getInputStream());
                System.out.println("\nNo: " + (cont + 1));
                String nombre =  dis.readUTF();
                System.out.println("nombre: " + "copy_"+ cont +"_"+ nombre);
                int tamano = dis.readInt();
                System.out.println("Tamano: " + tamano);
                escribirRecibidoTabla(cont,"copy_"+ nombre,tamano );
                etiqueta.setText("Archivo: " + nombre + ", " + tamano/100 + " Bytes");
                FileOutputStream fos = new FileOutputStream("datosRecibidos/" +  "copy_"+ nombre);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                BufferedInputStream bis = new BufferedInputStream(cl.getInputStream());
                
                byte[] buffer = new byte[1024];
               
                int len;
                int acumulador=0;
                int recibido=0;

                while((len = bis.read(buffer,0,buffer.length))!=-1){
                        bos.write(buffer, 0, len);
                        bos.flush();
                        
                        acumulador+=len;   
                        if(((double)acumulador*100/(double)tamano)>recibido+1){
                        recibido = (int)((double)acumulador*100/(double)tamano) + 1;
                        System.out.println("Recibido: "+recibido+"%");
                        if(recibido >= 100){
                            barra.setString("Completo");
                        }
                        else{
                            barra.setString(recibido + "%");
                            barra.setValue(recibido);
                        }
                        }
                    }
                
                bis.close();
                bos.close();
                }
                     
                cl.close();
            
            //}//end for
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error el en recibo de datos", "Servidor", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    
    }

    private void dimensionarTabla(int numeroArchivos) {
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.setRowCount(numeroArchivos);
        model.setColumnIdentifiers(new String[]{"N°", "Nombre de archivo", "Tamaño"});
        tabla.setModel(model);
    }

    private void escribirRecibidoTabla(int cont, String nombre, int tamano) {
        tabla.setValueAt(cont, cont, 0);
        tabla.setValueAt(nombre, cont, 1);
        tabla.setValueAt(tamano/1024 + "Bytes", cont, 2);
    }
}

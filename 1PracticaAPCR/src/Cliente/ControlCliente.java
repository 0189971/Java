package Cliente;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControlCliente {

    public static File[] abrirMultiplesArchivos() {
        JFileChooser abrir = new JFileChooser();
        abrir.setMultiSelectionEnabled(true);
        if (abrir.showOpenDialog(null) != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "Error no se seleccionó ningun archivo");
            return null;
        }
        return abrir.getSelectedFiles();
    }

    public static DefaultTableModel llenarTabla(File[] archivos) {
        DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"N°", "Nombre de archivo", "Tamaño"});
        model.setColumnCount(3);
        model.setRowCount(archivos.length);
        for (int i = 0; i < archivos.length; i++) {
            model.setValueAt(i, i, 0);
            model.setValueAt(archivos[i].getName(), i, 1);
            model.setValueAt(archivos[i].length() / 1024 + " Bytes", i, 2);
        }
        return model;
    }

    public static String enviarTotalDeArchivos(int total) throws IOException {
      //Este método crea un socket temporal y envía la longitud de archivos como entero al servidor
        Socket cl = new Socket("127.0.0.1", 9000);
        String propiedad = "Conectado ip: " + cl.getInetAddress() + ", puerto: " + cl.getPort();
        System.out.println(propiedad);
        DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
        //envio del numero de archivos a enviar
        dos.writeInt(total);
        dos.close();
        cl.close();
        return propiedad;
    }

}

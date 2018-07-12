
package Cliente;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class IGCliente extends javax.swing.JFrame {
    
    //Objetos a usar un arreglo de archivos  y un hilo para mostrar graficos
    private File[] archivos;
    private Thread hilo;

    public IGCliente() {
        initComponents();
        deshabilitar(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        barraProgreso = new javax.swing.JProgressBar();
        botonSalir = new javax.swing.JButton();
        etiquetaDetalles = new javax.swing.JLabel();
        botonEnviar = new javax.swing.JButton();
        menuPrincipal = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuAbrir = new javax.swing.JMenuItem();
        menuMostrar = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        menuEnviar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);

        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Nombre de archivo", "Tamaño"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPrincipal);
        if (tablaPrincipal.getColumnModel().getColumnCount() > 0) {
            tablaPrincipal.getColumnModel().getColumn(0).setMaxWidth(30);
            tablaPrincipal.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        barraProgreso.setStringPainted(true);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        etiquetaDetalles.setText("Cargar archivos...");

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        menuFile.setText("File");

        menuAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuAbrir.setText("Abrir");
        menuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirActionPerformed(evt);
            }
        });
        menuFile.add(menuAbrir);

        menuMostrar.setText("Mostrar archivos");
        menuMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMostrarActionPerformed(evt);
            }
        });
        menuFile.add(menuMostrar);

        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuFile.add(menuSalir);

        menuPrincipal.add(menuFile);

        menuEditar.setText("Edit");

        menuEnviar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        menuEnviar.setText("Enviar");
        menuEditar.add(menuEnviar);

        menuPrincipal.add(menuEditar);

        setJMenuBar(menuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonEnviar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonSalir))
                    .addComponent(etiquetaDetalles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(etiquetaDetalles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonSalir)
                        .addComponent(botonEnviar)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // Cerrar interfaz
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void menuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirActionPerformed
        // Cargar archivos multiples y envio de total de archivos al servidor
        archivos = ControlCliente.abrirMultiplesArchivos();
        if(archivos == null){
            System.out.println("Ningun archivo");
            return;
        }
        deshabilitar(true);
        tablaPrincipal.setModel(ControlCliente.llenarTabla(archivos));
        //Aqui se envía la longitud de aechivos al servidor
        try {
            etiquetaDetalles.setText(ControlCliente.enviarTotalDeArchivos(archivos.length));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_menuAbrirActionPerformed

    private void menuMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMostrarActionPerformed
        //Mostrar archivos cada uno con su aplicacion
        for (File archivo : archivos) {
            try {
                Desktop.getDesktop().open(archivo);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_menuMostrarActionPerformed

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        // hilo que envia y muestra progreso en interfaz grafica
        hilo = new Thread(new Envio(archivos, etiquetaDetalles, barraProgreso));
        hilo.start();
        botonEnviar.setEnabled(false);
    }//GEN-LAST:event_botonEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IGCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IGCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IGCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IGCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IGCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel etiquetaDetalles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem menuAbrir;
    private javax.swing.JMenu menuEditar;
    private javax.swing.JMenuItem menuEnviar;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenuItem menuMostrar;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JTable tablaPrincipal;
    // End of variables declaration//GEN-END:variables

    private void deshabilitar(boolean b) {
        menuEditar.setEnabled(b);
        botonEnviar.setEnabled(b);
    }
}

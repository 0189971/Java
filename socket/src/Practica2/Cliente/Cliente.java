package Practica2.Cliente;

import java.awt.Container;
import javax.swing.*;

public class Cliente extends javax.swing.JFrame {

    //Container ContenedorFrame;    
    //PanelPrincipal panelPrincipal;    

    public Cliente() {

        initComponents();
        //  ContenedorFrame =getContentPane();
        setIconImage(new ImageIcon(getClass().getResource("/Practica2/Servidor/Imagenes/logo.png")).getImage());

        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Practica2/Servidor/Imagenes/fondo.jpg"));
        JLabel fondo = new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("Carrito de Compras");

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        verCatalogo = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Carrito de Compras");

        verCatalogo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        verCatalogo.setText("Ver Catálogo");
        verCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verCatalogoActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verCatalogo))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(verCatalogo)
                .addGap(18, 18, 18)
                .addComponent(Salir)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verCatalogoActionPerformed
        //le  mandamos la lista de articulos recibida del servidor
        //panelPrincipal= new PanelPrincipal();                
        //cambiarDePanel(ContenedorFrame,panelPrincipal);
        PanelPrincipal1 panelPrincipal = new PanelPrincipal1();
        dispose();
        panelPrincipal.setVisible(true);
    }//GEN-LAST:event_verCatalogoActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Cliente cl = new Cliente();
                cl.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton verCatalogo;
    // End of variables declaration//GEN-END:variables

    /*
     private void cambiarDePanel(Container padre,JPanel hijo) {
        
     padre.removeAll();
     hijo.setBounds(0,0,800,600);
     padre.add(hijo);
     this.repaint();
       
        
     }*/
}

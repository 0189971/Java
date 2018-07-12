
package Practica2;

import Practica2.Cliente.PanelCarrito;
import java.awt.*;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ArticuloCarrito extends javax.swing.JPanel {
    
    private ImageIcon img;
    JLabel etiquetaImagen;   
    
    
    private double subtotal;
    private int cantidad;
    private Articulo articulo;
    private PanelCarrito panelCarrito;
    private ArticuloCarritoS articulosCarritoS;
    public ArticuloCarrito(Articulo articulo,int cantidad,PanelCarrito panelCarrito) {
        
        this.articulo= articulo;
        this.panelCarrito= panelCarrito;
        
       
        initComponents();
        agregarImagen(img,etiquetaImagen);
        
        subtotal  = cantidad*(articulo.getPrecio());
        subTotal.setText(""+ subtotal);
        
        codigo.setText(""+ articulo.getIdArticulo());
        Cantidad.setText("" + cantidad);
        
        articulosCarritoS = new ArticuloCarritoS(articulo, subtotal, cantidad);
        
    }

    public ArticuloCarritoS getArticulosCarritoS() {
        return articulosCarritoS;
    }

    public void setArticulosCarritoS(ArticuloCarritoS articulosCarritoS) {
        this.articulosCarritoS = articulosCarritoS;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        subTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        deleteOfCarrito = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 153));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 153, 153), new java.awt.Color(255, 153, 153)));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("Subtotal: ");

        subTotal.setBackground(new java.awt.Color(0, 0, 0));
        subTotal.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        subTotal.setText("subtotal");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel3.setText("Codigo:");

        codigo.setBackground(new java.awt.Color(0, 0, 0));
        codigo.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        codigo.setText("codigo");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel2.setText("Cantidad:");

        Cantidad.setBackground(new java.awt.Color(0, 0, 0));
        Cantidad.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        Cantidad.setText("cantidad");

        deleteOfCarrito.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        deleteOfCarrito.setText("Quitar de Carrito");
        deleteOfCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOfCarritoActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        nombre.setText("nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteOfCarrito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(codigo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cantidad)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(subTotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(codigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Cantidad)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteOfCarrito)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    private void deleteOfCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOfCarritoActionPerformed
       panelCarrito.remove(this);
       panelCarrito.repaint();
    }//GEN-LAST:event_deleteOfCarritoActionPerformed

    private void agregarImagen(ImageIcon img, JLabel etiquetaImagen) {
         nombre.setText("" +articulo.getNombre());
        img  = new ImageIcon(articulo.getPathImagen());
        etiquetaImagen = new JLabel(img);
        etiquetaImagen.setSize(150, 150);
        etiquetaImagen.setBounds(20, 0, 170, 150);
        this.add(etiquetaImagen);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel codigo;
    private javax.swing.JButton deleteOfCarrito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel subTotal;
    // End of variables declaration//GEN-END:variables

    
}

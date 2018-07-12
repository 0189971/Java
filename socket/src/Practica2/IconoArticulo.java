package Practica2;
import Practica2.Cliente.*;
import java.io.Serializable;
import javax.swing.*;

public class IconoArticulo extends javax.swing.JPanel implements Serializable{
    
    private ImageIcon img;
    JLabel etiquetaImagen;           
    PanelCarrito panelCarrito;
    Articulo articulo;
    ArticuloCarrito articuloCarrito;
    int cantidadArticulo;
   
    public IconoArticulo( Articulo articulo,PanelCarrito panelCarrito ) {
        this.panelCarrito= panelCarrito;
        this.articulo = articulo;        
        initComponents();
        setVisible(true);
        agregarImagen(img,etiquetaImagen);
        
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addToCarrito = new javax.swing.JButton();
        cantidad = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();

        setBackground(new java.awt.Color(197, 197, 224));
        setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 204, 204), new java.awt.Color(255, 204, 255)));
        setPreferredSize(new java.awt.Dimension(271, 213));

        addToCarrito.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        addToCarrito.setText("Añadir a carrito");
        addToCarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCarritoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jLabel2.setText("Precio:");

        id.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        id.setText("jLabel3");

        precio.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        precio.setText("jLabel4");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        jButton1.setText("Ver");

        nombre.setFont(new java.awt.Font("Century Gothic", 0, 11)); // NOI18N
        nombre.setText("nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(35, 35, 35)))
                        .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addToCarrito))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(precio))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(id))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(nombre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(precio))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToCarrito)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public ArticuloCarrito getArticuloCarrito() {
        return articuloCarrito;
    }
   
   
    private void addToCarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCarritoActionPerformed
        cantidadArticulo=(int)cantidad.getValue();
        if(validarExistencias(cantidadArticulo)){
            
            System.out.println("Cantidad: " + cantidadArticulo);
            articuloCarrito = new ArticuloCarrito(articulo,cantidadArticulo, panelCarrito);
          
           panelCarrito.add(articuloCarrito);
           
           
           JOptionPane.showMessageDialog(this, "Agregado al carrito");
        }else{
            JOptionPane.showMessageDialog(this, "Incorrecto verifique la cantidad");
        }
        
        
    }//GEN-LAST:event_addToCarritoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCarrito;
    private javax.swing.JSpinner cantidad;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel precio;
    // End of variables declaration//GEN-END:variables

    private void agregarImagen(ImageIcon img, JLabel etiquetaImagen) {
        
        nombre.setText("" +articulo.getNombre());
        id.setText(""+articulo.getIdArticulo());
        precio.setText(""+articulo.getPrecio());
        img  = new ImageIcon(articulo.getPathImagen());
        etiquetaImagen = new JLabel(img);
        //etiquetaImagen.setSize(150, 150);
        etiquetaImagen.setBounds(20,0,90,160);
        this.add(etiquetaImagen);
    }

    private boolean validarExistencias(int cantidadArticulo) {
        System.out.println("cantidad de articulos solicitados"+ cantidadArticulo);
        if(cantidadArticulo > articulo.getExistencias() || cantidadArticulo<=0){
            return false;
        }
        return true;
    }

}

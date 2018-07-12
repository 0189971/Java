package Practica2.Cliente;

import Practica2.Articulo;
import Practica2.ArticuloCarrito;
import Practica2.ArticuloCarritoS;
import Practica2.Ticket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

public class PanelPrincipal1 extends JFrame{
    Socket cl;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    ArrayList<Articulo> listArticulos;     
    PanelProductos panelProductos;
    PanelCarrito panelCarrito;
    ArrayList<ArticuloCarritoS> listaArticulosCarrito= new ArrayList<ArticuloCarritoS>();
    String seleccionado;
    public PanelPrincipal1() {
        initComponents();
        conectarConServidor();
        establecerPaneles(listArticulos);
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Celulares");
        jComboBox1.addItem("Consolas");
        jComboBox1.addItem("Smart-Tv");
        
        setIconImage(new ImageIcon(getClass().getResource("/Practica2/Servidor/Imagenes/logo.png")).getImage());       
        ((JPanel)getContentPane()).setOpaque(false); 
        ImageIcon uno = new ImageIcon(this.getClass().getResource("/Practica2/Servidor/Imagenes/fondo.jpg")); 
        JLabel fondo = new JLabel(); 
        fondo.setIcon(uno); 
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER); 
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Escoge tus Articulos");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Salir = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        finalizaCompra = new javax.swing.JButton();
        finalizaCompra1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(244, 181, 181));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(600, 400));

        Salir.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        finalizaCompra.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        finalizaCompra.setText("Finalizar Compra");
        finalizaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaCompraActionPerformed(evt);
            }
        });

        finalizaCompra1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        finalizaCompra1.setText("Acerca de");
        finalizaCompra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaCompra1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Elige una categoria");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(finalizaCompra1)
                        .addGap(28, 28, 28)
                        .addComponent(finalizaCompra)
                        .addGap(37, 37, 37)
                        .addComponent(Salir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salir)
                    .addComponent(finalizaCompra)
                    .addComponent(finalizaCompra1))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);

    }//GEN-LAST:event_SalirActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        seleccionado="";
        seleccionado = (String)jComboBox1.getSelectedItem();
        System.out.println("seleccionado = "+ seleccionado);
        panelProductos.verProductos(seleccionado);

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void finalizaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaCompraActionPerformed

        System.out.println("numero de articulos "+panelCarrito.getComponents().length);

        for(int i = 0;i <panelCarrito.getComponents().length ;i++){
            listaArticulosCarrito.add( ((ArticuloCarrito)panelCarrito.getComponent(i)).getArticulosCarritoS());
            System.out.println("" +listaArticulosCarrito.get(i).getArticulo().getNombre());
        }
        JOptionPane.showMessageDialog(this, "Generando Ticket");
        enviaArticulosCarritoServidor();
        Ticket ticket = recibirTicketDeServidor();
        generarJFrameTicket(ticket);
    }//GEN-LAST:event_finalizaCompraActionPerformed

    private void finalizaCompra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizaCompra1ActionPerformed
        JOptionPane.showMessageDialog(this, "Hecho por:\n"
                + "Hernandez Sanchez Armando Alan\n"
                + "Armenta Garcia Guadalupe Javier\n"
                + "Zarate Castillo Ramses Edgar","Acerca del programa",1);
    }//GEN-LAST:event_finalizaCompra1ActionPerformed
    private void establecerPaneles(ArrayList<Articulo> listArticulos) {
        panelCarrito=new PanelCarrito();
        panelProductos=new PanelProductos(listArticulos,panelCarrito);
        

        JScrollPane scroll1 = new JScrollPane(); 
        JScrollPane scroll2 = new JScrollPane(); 
        
        scroll1.setViewportView(panelProductos);
        scroll2.setViewportView(panelCarrito);
        
        jTabbedPane1.addTab("Productos",scroll1);
        jTabbedPane1.addTab("Ver Carrito", scroll2);
        
    }

    private void enviaArticulosCarritoServidor(){
        
          try{
              
            ObjectOutputStream oos =new ObjectOutputStream(cl.getOutputStream());
            System.out.println("Enviado lista de articulos del carrito");
            oos.writeObject(listaArticulosCarrito);
                            
            }catch (Exception e) {
                        e.printStackTrace();
            }
    }
    
    private void conectarConServidor(){
        //Aqui se conecta al servidor local y se obtienen los articulos
       try{               
           cl = new Socket("127.0.0.1",1234); 
           ois =new ObjectInputStream(cl.getInputStream());
           System.out.println("Conexion establecida");
           listArticulos= new ArrayList<Articulo>() ;
           listArticulos = (ArrayList<Articulo>)ois.readObject();
           System.out.println("Articulos obtenidos");
           imprimirArticulosEnConsola(listArticulos);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
    private Ticket recibirTicketDeServidor() {
        try {
         
           Ticket ticket= (Ticket)ois.readObject();   
            System.out.println("Se recibio el ticket correctamente");
            
                return ticket;
        } catch (Exception e) {
        }
        
        return null;
    }
    
    private static void imprimirArticulosEnConsola(ArrayList<Articulo> listArticulos) {

        for (int i = 0; i < listArticulos.size(); i++) {                            
        Articulo a =  listArticulos.get(i);
        System.out.println("objeto : " + a.getDescripcion()+a.getNombre() +a.getPathImagen()+a.getExistencias());
        }
    }

    private void generarJFrameTicket() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void generarJFrameTicket(Ticket ticket) {
        final JFrameTicket ventana =new JFrameTicket(ticket);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ventana.setVisible(true);
            }
        });
    }
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
            java.util.logging.Logger.getLogger(PanelPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelPrincipal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelPrincipal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton finalizaCompra;
    private javax.swing.JButton finalizaCompra1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}

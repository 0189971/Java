package Practica2.Cliente;

import Practica2.Articulo;
import Practica2.ArticuloCarrito;
import Practica2.ArticuloCarritoS;
import Practica2.Ticket;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

public class PanelPrincipal extends javax.swing.JPanel {
    
    Socket cl;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    ArrayList<Articulo> listArticulos;
    
    
    PanelProductos panelProductos;
    PanelCarrito panelCarrito;
    ArrayList<ArticuloCarritoS> listaArticulosCarrito= new ArrayList<ArticuloCarritoS>();
    String seleccionado;
    public PanelPrincipal( ) {
        
        initComponents();
        conectarConServidor();
        establecerPaneles(listArticulos);
        jComboBox1.removeAllItems();
        jComboBox1.addItem("celulares");
        jComboBox1.addItem("Consolas");
        jComboBox1.addItem("Smart Tv");
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Salir = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        finalizaCompra = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 102));
        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(600, 400));

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        finalizaCompra.setText("Finalizar Compra");
        finalizaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizaCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(finalizaCompra)
                        .addGap(18, 18, 18)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salir))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
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

    private void agregarPanel(JPanel subPanel) {
        subPanel.setBounds(100,100,600,400); 
        this.add(subPanel);
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton finalizaCompra;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

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
    
    private void conectarConServidor() {
       try{
               
                    cl = new Socket("127.0.0.1",1234); 
                    ois =new ObjectInputStream(cl.getInputStream());
                    System.out.println("Conexion establecida");
                            listArticulos= new ArrayList<Articulo>() ;
                            listArticulos = (ArrayList<Articulo>)ois.readObject();
                            System.out.println("Articulos obtenidos");
                            imprimirArticulosEnConsola(listArticulos);
                }catch (Exception e) {
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

    
 


   
}

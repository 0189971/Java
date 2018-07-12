package Practica2.Cliente;
import Practica2.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.*;
public class PanelProductos extends JPanel {    
    ArrayList<IconoArticulo> iconos;
    ArrayList<Articulo> listArticulos;
    PanelCarrito panelCarrito;
  
    public PanelProductos(ArrayList<Articulo> listArticulos,PanelCarrito panelCarrito) {
        configurarPanel();
        this.listArticulos= listArticulos;
        this.panelCarrito = panelCarrito;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(197, 197, 224));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
    private void configurarPanel() {
        initComponents();
        this.setVisible(true);
        this.setLayout(new GridLayout(6,3));
    }

    void verProductos(String seleccionado) {
        this.removeAll(); //Quita lo que este en el panel
        iconos= new ArrayList<>() ;
        for (Articulo listArticulo : listArticulos) {
            if (listArticulo.getCategoria().equals(seleccionado)) {
                IconoArticulo icono = new IconoArticulo(listArticulo, panelCarrito);                                                             
                add(icono);
            }
        }
        repaint();
    }
}


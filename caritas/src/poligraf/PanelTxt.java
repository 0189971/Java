/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligraf;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sdelaot
 */
public class PanelTxt extends JPanel {
    private JTextField [] campos;
    private JLabel [] etiquetas;
    public PanelTxt() {
        super();
        setLayout( new GridLayout( 2, 2, 2, 2 ) );
        campos = new JTextField[2];
        etiquetas = new JLabel[2];
        etiquetas[0] = new JLabel( "Nombre  :" );
        campos[0] = new JTextField( 10 );
        etiquetas[1] = new JLabel( "Password:" );
        campos[1] = new JTextField( 10 );
        add( etiquetas[0] );
        add( campos[0] );
        add( etiquetas[1] );
        add( campos[1] );
        this.setSize( 400, 300 );
    }
}

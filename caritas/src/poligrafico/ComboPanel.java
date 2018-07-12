/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligrafico;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class ComboPanel extends JPanel {
    private JComboBox [] combos;
    private JLabel [] etiquetas;
    private JButton [] botones;
    public ComboPanel() {
        super();
        initComponents();
    }
    private void initComponents() {
        etiquetas = new JLabel[2];
        combos = new JComboBox[2];
        botones = new JButton[2];
        etiquetas[0] = new JLabel( " Pais" );
        etiquetas[1] = new JLabel( " Capital" );
        botones[0] = new JButton( "Borrar" );
        botones[1] = new JButton( "Comprobar" );
        
        this.setLayout( new GridLayout( 3, 2, 10, 10 ) );
        
        for( int n=0; n<combos.length; n++ ) {
            combos[n] = new JComboBox();
            add( etiquetas[n] );
            add( combos[n] );
            }
        combos[0].addItem("Mexico");
		combos[0].addItem("Estados Unidos");
		combos[0].addItem("Canada");
        combos[1].addItem("Distrito Federal");
		combos[1].addItem("Washinton");
		combos[1].addItem("Otawa");
        add( botones[0] );
        add( botones[1] );
        this.setSize( 400, 300 );
    }
}

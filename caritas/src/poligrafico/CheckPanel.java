/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligrafico;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */

public class CheckPanel extends JPanel {
    private JCheckBox [] checks;
    private JLabel [] etiquetas;
    private JButton [] botones;
    public CheckPanel() {
        super();
        initComponents();
    }
    private void initComponents() {
        etiquetas = new JLabel[2];
        checks = new JCheckBox[2];
        botones = new JButton[2];
        etiquetas[0] = new JLabel( " Rojo" );
        etiquetas[1] = new JLabel( " Azul" );
        botones[0] = new JButton( "Borrar" );
        botones[1] = new JButton( "Comprobar" );
        
        setLayout( new GridLayout( 3, 2, 10, 10 ) );
        
        for( int n=0; n<checks.length; n++ ) {
            checks[n] = new JCheckBox();
            add( etiquetas[n] );
            add( checks[n] );
            }
        
        add( botones[0] );
        add( botones[1] );
        this.setSize( 400, 300 );
    }
}

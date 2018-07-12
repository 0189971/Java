/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligrafico;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sdelaot
 */
public class LoginPanel extends JPanel {
    private JTextField [] campos;
    private JLabel [] etiquetas;
    private JButton [] botones;
    public LoginPanel() {
        super();
        initComponents();
    }
    private void initComponents() {
        etiquetas = new JLabel[2];
        campos = new JTextField[2];
        botones = new JButton[2];
        etiquetas[0] = new JLabel( " Usuario" );
        etiquetas[1] = new JLabel( " Password" );
        botones[0] = new JButton( "Borrar" );
        botones[1] = new JButton( "Acceder" );
        
        this.setLayout( new GridLayout( 3, 2, 10, 10 ) );
        
        for( int n=0; n<campos.length; n++ ) {
            campos[n] = new JTextField();
            add( etiquetas[n] );
            add( campos[n] );
            }
        add( botones[0] );
        add( botones[1] );
        this.setSize( 400, 300 );
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligraf;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class PanelBoton extends JPanel {
    private JButton [] botones;
    public PanelBoton() {
        super();
        setLayout( new GridLayout( 2, 2, 2, 2 ) );
        botones = new JButton[4];
        for( int n=0; n<botones.length; n++ ) {
            botones[n] = new JButton( "Boton " + (n+1) );
            add( botones[n] );
            }
        this.setSize( 400, 300 );
    }
}

/*
 * Paquete al que pertenece la clase.
 */
package polimorGUI;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author sdelaot
 */
public class PanelTexto extends JPanel {
    private JLabel lblTexto;
    private JTextField txtCampo;
    public PanelTexto( int posX, int posY ) {
        lblTexto = new JLabel( " Dime tu nombre: " );
        txtCampo = new JTextField( 20 );
        this.setLayout( null );
        this.add( lblTexto );
        lblTexto.setBounds( new Rectangle( new Point( posX, posY ), 
            lblTexto.getPreferredSize() ) );
        this.add( txtCampo );
        txtCampo.setBounds( new Rectangle( new Point( posX+110, posY-2 ), 
            txtCampo.getPreferredSize() ) );
    }
}

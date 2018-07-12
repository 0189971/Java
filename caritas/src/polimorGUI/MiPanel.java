/*
 * Paquete al que pertenece la clase.
 */
package polimorGUI;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class MiPanel extends JPanel {
    private JButton btnMensaje;
    public MiPanel( String texto, int posX, int posY ) {
        setLayout( null );
        btnMensaje = new JButton( texto );
        this.add( btnMensaje );
        btnMensaje.setBounds( 
            new Rectangle( new Point( posX, posY ), 
                btnMensaje.getPreferredSize() ) );
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

import java.awt.Container;
import javax.swing.JFrame;

/**
 * Un marco con un panel para comprobar varias excepciones
 * @author sdelaot
 */
public class FrameDePruebaDeExcepciones extends JFrame {
    public FrameDePruebaDeExcepciones() {
		setTitle( "PruebaExcepciones" );
		Container mensaje = getContentPane();
		PanelDePruebaDeExcepciones panel = 
                new PanelDePruebaDeExcepciones();
		mensaje.add( panel );
		pack();
	}
}

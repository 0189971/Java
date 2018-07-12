/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class MiPanel extends JPanel {
    private MiCanvas canvas;
    public MiPanel() {
        super();
        canvas = new MiCanvas();
        canvas.setBounds( 0, 0, 600, 600 );
        this.add( canvas );
    }
    public void dibujarCirculo( int x, int y, int radio ) {
        canvas.setCirculo(x, y, radio);
    }
    public void setColor( Color unColor ) {
        canvas.setColor( unColor );
    }
}

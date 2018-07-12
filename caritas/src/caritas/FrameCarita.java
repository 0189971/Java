/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caritas;

import javax.swing.JFrame;

/**
 *
 * @author sdelaot
 */
public class FrameCarita extends JFrame {
    private CaraAmarilla carita;
    public FrameCarita() {
        carita = new CaraAmarilla();
        carita.inicia();
        this.getContentPane().add(carita);
        this.setSize( 400, 310 );
        this.setVisible( true );
    }
}

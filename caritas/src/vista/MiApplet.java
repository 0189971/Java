/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.applet.Applet;

/**
 *
 * @author sdelaot
 */
public class MiApplet extends Applet {
    private JPanelLogin panelL;
    @Override
    public void init() {
        panelL = new JPanelLogin();
        this.add( panelL );
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligrafico;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class MiJFrame extends JFrame {
    private LoginPanel panel1;
    private JPanel panelBot;
    private JButton [] botones;
    private Container contenedor;
    public MiJFrame() {
        super( "Graficos polimorfico" );
        initComponents();
    }
    private void initComponents() {
        contenedor = this.getContentPane();
        contenedor.setLayout( new BorderLayout() );
        iniciaBotones();
        panel1 = new LoginPanel();
        contenedor.add( panel1, BorderLayout.CENTER );
        this.setSize( 400, 300 );
        this.setVisible( true );
    }
    private void iniciaBotones() {
        panelBot = new JPanel();
        panelBot.setLayout( new GridLayout( 3, 1, 4, 10 ) );
        botones = new JButton[3];
        botones[0] = new JButton( "Login" );
        botones[1] = new JButton( "Panel 1" );
        botones[2] = new JButton( "Panel 2" );
        for( int n=0; n<botones.length; n++ ) {
            panelBot.add( botones[n] );
            }
        contenedor.add( panelBot, BorderLayout.WEST );
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligraf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class MiFrame extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    private PanelBoton panelB;
    private PanelTxt panelT;
    private PanelCombo panelC;
    public MiFrame() {
        super( "Polimorfismo GUI" );
        setLayout( new BorderLayout() );
        Container contenedor = this.getContentPane();
        panelT = new PanelTxt();
        panelB = new PanelBoton();
        panelC = new PanelCombo();
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout( new CardLayout() );
        panelPrincipal.add( panelT, "Panel1" );
        panelPrincipal.add( panelB, "Panel2" );
        panelPrincipal.add( panelC, "Panel3" );
        contenedor.add( panelPrincipal, BorderLayout.CENTER );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        JButton btnMiPanel = new JButton( "Panel 1" );
        JButton btnPanelLed = new JButton( "Panel 2" );
        JButton btnPanelTxt = new JButton( "Panel 3" );
        panelBotones = new JPanel();
        panelBotones.setLayout( new GridLayout( 1, 3 ) );
        panelBotones.add(btnMiPanel);
        btnMiPanel.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent oAe ) {
                CardLayout cl = (CardLayout)panelPrincipal.getLayout();
                cl.show( panelPrincipal, "Panel1" );
            }
        });
        
        panelBotones.add(btnPanelLed);
        btnPanelLed.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent oAe ) {
                CardLayout cl = (CardLayout)panelPrincipal.getLayout();
                cl.show( panelPrincipal, "Panel2" );
            }
        });
        panelBotones.add(btnPanelTxt);
        btnPanelTxt.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent oAe ) {
                CardLayout cl = (CardLayout)panelPrincipal.getLayout();
                cl.show( panelPrincipal, "Panel3" );
            }
        });
        contenedor.add( BorderLayout.NORTH, panelBotones );
    }
}

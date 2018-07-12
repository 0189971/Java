/*
 * Paquete al que pertenece la clase.
 */
package polimorGUI;

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
public class FramePrincipal extends JFrame {
    private MiPanel panelUno;
    private PanelLED panelLed;
    private PanelTexto panelTXT;
    private Container contenedor;
    private JPanel panelPrincipal;
    private JPanel panelBotones;
    public FramePrincipal() {
        super( "Prueba de polimorfismo con interfaces" );
        panelPrincipal = new JPanel( );
        panelPrincipal.setLayout( new CardLayout() );
        contenedor = this.getContentPane();
        contenedor.setLayout( new BorderLayout() );
        panelUno = new MiPanel( "Hola Mundo Swing", 30, 90 );
        panelLed = new PanelLED( "Un led", 1, 24, 65 );
        panelTXT = new PanelTexto( 20, 90 );
        panelPrincipal.add( panelUno, "Panel1" );
        panelPrincipal.add( panelLed, "Panel2" );
        panelPrincipal.add( panelTXT, "Panel3" );
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

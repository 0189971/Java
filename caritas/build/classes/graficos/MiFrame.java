/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author sdelaot
 */
public class MiFrame extends JFrame {
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuDibujar = new JMenu( "Dibujar" );
    private JMenuItem menuItemAhora = new JMenuItem( "Ahora" );
    private JMenu menuColor = new JMenu( "Color" );
    private JMenuItem menuItemAzul = new JMenuItem( "Azul" );
    private JMenuItem menuItemAmarillo = new JMenuItem( "Amarillo" );
    private JMenuItem menuItemVerde = new JMenuItem( "Verde" );
    private JMenuItem menuItemNegro = new JMenuItem( "Negro" );
    private JMenuItem menuItemNaranja = new JMenuItem( "Naranja" );
    private JMenuItem menuItemSalir = new JMenuItem( "Salir" );
    private MiPanel panel;
    public MiFrame() {
        super( "Dibujar" );
        menuDibujar.add( menuItemAhora );
        menuDibujar.add( menuColor );
        menuColor.add( menuItemAzul );
        menuItemAzul.addActionListener( new ColocadorDeColor( 1 ) );
        menuColor.add( menuItemAmarillo );
        menuItemAmarillo.addActionListener( new ColocadorDeColor( 2 ) );
        menuColor.add( menuItemVerde );
        menuItemVerde.addActionListener( new ColocadorDeColor( 3 ) );
        menuColor.add( menuItemNegro );
        menuItemNegro.addActionListener( new ColocadorDeColor( 4 ) );
        menuColor.add( menuItemNaranja );
        menuItemNaranja.addActionListener( new ColocadorDeColor( 5 ) );
        menuDibujar.add( menuItemSalir );
        barraMenu.add(menuDibujar);
        menuItemAhora.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent oAe ) {
               dibujar();
            }
        } );
        menuItemSalir.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent oAe ) {
               System.exit( 0 );
            }
        } );
        
        panel = new MiPanel();
        this.getContentPane().add( panel );
        this.setJMenuBar(barraMenu);
    }
    public void dibujar(  ) {
        //panel.dibujarCirculo( 100, 100, 10 );
        
        panel.dibujarCirculo( 200, 150, 100 );
        //panel.dibujarCirculo( 150, 150, 20 );
        //panel.dibujarCirculo( 100, 100, 40 );
    }
    private class ColocadorDeColor implements ActionListener {
        private int color;
        public ColocadorDeColor( int cual ) {
            color = cual;
        }
        public void actionPerformed( ActionEvent oAe ) {
            switch( color ) {
                case 1:
                    panel.setColor(Color.blue);
                    break;
                case 2:
                    panel.setColor(Color.yellow);
                    break;
                case 3:
                    panel.setColor(Color.green);
                    break;
                case 4:
                    panel.setColor(Color.black);
                    break;
                case 5:
                    panel.setColor(Color.orange);
                    break;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poligraf;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class PanelCombo extends JPanel {
    private JComboBox [] combos;
    private JLabel [] etiquetas;
    public PanelCombo() {
        super();
        setLayout( new GridLayout( 2, 2, 2, 2 ) );
        combos = new JComboBox[2];
        etiquetas = new JLabel[2];
        etiquetas[0] = new JLabel( "Mascota:" );
        String[] mascotas = { "Ave", "Gato", "Perro", "Conejo", "Cerdo" };
        combos[0] = new JComboBox( mascotas );
        etiquetas[1] = new JLabel( "Alimento:" );
        String[] alimento = { "Alpiste", "Atun", "Hueso", "Alfalfa", "Maiz" };
        combos[1] = new JComboBox( alimento );
        add( etiquetas[0] );
        add( combos[0] );
        add( etiquetas[1] );
        add( combos[1] );
        this.setSize( 400, 300 );
    }
}

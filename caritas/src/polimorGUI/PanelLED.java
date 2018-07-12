/*
 * Paquete al que pertenece la clase.
 */
package polimorGUI;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class PanelLED extends JPanel {
    /**
     * Via de acceso de los leds
     */
    private String path = "./imagenes/";
    /**
     * Imagen del led rojo
     */
    private String ledRojo = "Red25.png";
    /**
     * Imagen del led verde
     */
    private String ledVerde = "Lime25.png";
    /**
     * Texto que acompana al led
     */
    private String textoLED;
    /**
     * Estado del led
     */
    private boolean estado;
    /**
     * Que panes
     */
    private int quePanel;
    /**
     * Etiqueta del led
     */
    private JLabel etiquetaLED;
    /**
     * Icono verde del led
     */
    private ImageIcon iconVerde;
    /**
     * Led
     */
    private JLabel lblLED;
    /**
     * Icono rojo del led
     */
    private ImageIcon iconRojo;
    /**
     * Crea el objeto
     * 
     * @param texto el testo del objeto
     * @param idPanel el identificador del panel
     */
    public PanelLED( String texto, int idPanel, int posX, int posY ) {
        textoLED = texto;
        this.setLayout(null);
        
        iconRojo  = new ImageIcon( getClass().getResource( path + ledRojo ) );
        iconVerde = new ImageIcon( getClass().getResource( path + ledVerde ) );
        lblLED = new JLabel();
        lblLED.setIcon( iconRojo );
        lblLED.setBounds( new Rectangle( new Point( posX, posY ), 
            lblLED.getPreferredSize() ) );
        this.add( lblLED );
        etiquetaLED = 
            new JLabel( textoLED );
        etiquetaLED.setBounds( new Rectangle( new Point( posX+25, posY+3 ), 
            etiquetaLED.getPreferredSize() ) );
        this.add( etiquetaLED );
        this.setSize( 80, 24 );
    }
    /**
     * Pone el estado del led
     * 
     * @param est si es true el led es verde y rojo en caso contrario
     */
    public void setEstado( boolean est ) {
        estado = est;
        if( estado ) {
            lblLED.setIcon(iconVerde);
            }
        else {
            lblLED.setIcon(iconRojo);
            }
    }
    /**
     * Devuelve el texto del led
     * 
     * @return devuelve el texto
     */
    public String getText() {
        return textoLED;
    }
    /**
     * Devuelve el estado del led
     * @return el estado del led
     */
    public boolean getEstado() {
        return estado;
    }
    /**
     * Devuelve el identificador del panel en el que se encuentra
     * 
     * @return el id del panel
     */
    public int getQuePanel() {
        return quePanel;
    }
}

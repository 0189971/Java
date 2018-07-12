/*
 * Paquete al que pertenece la clase.
 */
package graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author sdelaot
 */
public class MiCanvas extends Canvas {
    private int posX;
    private int posY;
    private int radio;
    private Color color;
    public MiCanvas( ) {
        super();
        color = Color.yellow;
    }
    @Override
    public void paint( Graphics g ) {
        dibujarCirculo( g );
    }
    public void dibujarCirculo( Graphics g ) {
        g.setColor( color );
        g.drawOval( posX, posY, radio, radio );
    }
    public void setCirculo( int x, int y, int radio ) {
        posX = x;
        posY = y;
        this.radio = radio;
        repaint();
    }
    public void setColor( Color unColor ) {
        color = unColor;
        repaint();
    }
}

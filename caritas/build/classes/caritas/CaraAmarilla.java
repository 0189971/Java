/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caritas;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author sdelaot
 */
public class CaraAmarilla extends JPanel implements Runnable {
    private Thread lampareado = new Thread( this, "Lampareado" );
    public static final int DIAMETRO_ROSTRO = 200;
    public static final int X_ROSTRO = 100;
    public static final int Y_ROSTRO = 50;

    //public static final 
            int ANCHO_OJO = 10;
    //public static final 
            int ALTO_OJO = 20;
    //public static final 
            int X_OJO_DERECHO = 155;
    //public static final 
            int Y_OJO_DERECHO = 100;
    //public static final 
            int X_OJO_IZQUIERDO = 230;
    //public static final 
            int Y_OJO_IZQUIERDO = Y_OJO_DERECHO;

    //public static final 
            int DIAMETRO_NARIZ = 14;
    public static final int X_NARIZ = 195;//Center of nose will be at 200
    public static final int Y_NARIZ = 135;

    public static final int ANCHO_BOCA = 100;
    public static final int ALTO_BOCA = 50;
    public static final int X_BOCA = 150;
    public static final int Y_BOCA = 160;
    public static final int ANGULO_INICIAL_BOCA = 180;
    public static final int GRADO_BOCA_MOSTRAR = 180;
    public void inicia() {
        lampareado.start();
    }

    public void paint( Graphics canvas ) {
        super.repaint();
        //Dibuja la cara:
        canvas.setColor(Color.YELLOW);
        canvas.fillOval(X_ROSTRO, Y_ROSTRO, DIAMETRO_ROSTRO, DIAMETRO_ROSTRO);
        canvas.setColor(Color.BLACK);
        canvas.drawOval(X_ROSTRO, Y_ROSTRO, DIAMETRO_ROSTRO, DIAMETRO_ROSTRO);
        //Dibuja los ojos:
        canvas.setColor(Color.BLUE);
        canvas.fillOval(X_OJO_DERECHO, Y_OJO_DERECHO, ANCHO_OJO, ALTO_OJO);
        canvas.fillOval(X_OJO_IZQUIERDO, Y_OJO_IZQUIERDO, ANCHO_OJO, ALTO_OJO);
        //Dibuja la nariz:
        canvas.setColor(Color.BLACK);
        canvas.fillOval(X_NARIZ, Y_NARIZ, DIAMETRO_NARIZ, DIAMETRO_NARIZ);
        //Dibuja la boca:
        canvas.setColor(Color.RED);
        canvas.drawArc(X_BOCA, Y_BOCA, ANCHO_BOCA, ALTO_BOCA,
                       ANGULO_INICIAL_BOCA, GRADO_BOCA_MOSTRAR);
    }
    @Override
    public void run() {
        try {
            while( true ) {
                ALTO_OJO        += 8;
                ANCHO_OJO       += 4;
                X_OJO_DERECHO   += 2;
                Y_OJO_DERECHO   += 4;
                X_OJO_IZQUIERDO += 2;
                Y_OJO_IZQUIERDO += 4;
                DIAMETRO_NARIZ  -= 5;
                this.repaint( );
                System.out.println( ALTO_OJO + "   " + ANCHO_OJO );
                Thread.sleep( 700 );
                ALTO_OJO        -= 8;
                ANCHO_OJO       -= 4;
                X_OJO_DERECHO   -= 2;
                Y_OJO_DERECHO   -= 4;
                X_OJO_IZQUIERDO -= 2;
                Y_OJO_IZQUIERDO -= 4;
                DIAMETRO_NARIZ  += 5;
                this.repaint( );
                System.out.println( ALTO_OJO + "   " + ANCHO_OJO );
                Thread.sleep( 700 );
                }
        } catch( InterruptedException ie ) {
            System.out.println(ie);
        }
    }
}

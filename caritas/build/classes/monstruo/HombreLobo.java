/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monstruo;

/**
 *
 * @author sdelaot
 */
public class HombreLobo implements ILobo {
    private String estado;
    public HombreLobo() {
        estado = "";
    }
    @Override
    public void destrozar() {
        estado += "Destrozando...";
    }

    @Override
    public void esconderse() {
        estado += "Escondiendose...";
    }

    @Override
    public void matar() throws Exception, MuertoException {
        int n = (int)(Math.random()*10.0);
        estado += "Matando...";
        if( n>=5 ) {
            throw new MuertoException( "Estas muerto" );
            }
    }

    public void actuar() {
        esconderse();
        try {
            matar();
        } catch( MuertoException me ) {
            me.printStackTrace();
        } catch( Exception e ) {
            e.printStackTrace();
        }
        destrozar();
    }
    @Override
    public String toString() { 
        return( "Hombre Lobo:"+ estado );
    }
}

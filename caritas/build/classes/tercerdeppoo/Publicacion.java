/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tercerdeppoo;

import java.util.Date;

/**
 *
 * @author sdelaot
 */
public abstract class Publicacion {
    private String editorial;
    private Date fechaDePublicacion;
    public Publicacion() {
        this( "", null );
    }
    public Publicacion( String editorial, Date fecha ) {
        this.editorial = editorial;
        this.fechaDePublicacion = fecha;
    }
    public Publicacion( Publicacion p ) {
        this.editorial = p.editorial;
        this.fechaDePublicacion = p.fechaDePublicacion;
    }
    public void verPropiedades() {
        System.out.println( " Editorial " + editorial );
        System.out.println( " Fecha   " + fechaDePublicacion );
    }
    public abstract void imprimiendo();
}

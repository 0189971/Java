/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apienseenjava.c02;

import java.util.Date;

/**
 *
 * @author sdelaot
 */
public class FechaDelSistema {
    private Date unaFecha;
    public FechaDelSistema() {
        unaFecha = new Date();
    }
    public void imprimirFecha( String mensaje ) {
        System.out.println( mensaje );
        System.out.println( unaFecha );
    }
}

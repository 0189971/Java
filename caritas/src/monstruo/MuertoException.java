/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monstruo;

/**
 *
 * @author sdelaot
 */
public class MuertoException extends Exception {
    public MuertoException() {
        super();
    }
    public MuertoException( String mensaje ) {
        super( mensaje );
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciainter;

/**
 *
 * @author sdelaot
 */
public interface IJugo {
    public String HOLA = "Hola mundo de interface en Java 8";
    public default void configurar() {
        System.out.print( "Hola" );
    }
}

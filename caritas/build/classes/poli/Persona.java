/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poli;

/**
 *
 * @author sdelaot
 */
public class Persona implements SerHumano {
    @Override
    public String caminar() {
        return "Normal";
    }
    @Override
    public void pensar( String pensamiento ) {
        System.out.println( " " + pensamiento );
    }
}

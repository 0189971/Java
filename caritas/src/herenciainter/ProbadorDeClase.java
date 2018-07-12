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
public class ProbadorDeClase {
    public static void main(String[] args) {
        UnaClase clase = new UnaClase();
        clase.configurar();
        System.out.println( clase.getHola() );
        IJugo jugo = new UnaClase();
        jugo.configurar();
        System.out.println( clase.getHola() );
    }
}

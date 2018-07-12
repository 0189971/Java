/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tercerdeppoo;

/**
 *
 * @author sdelaot
 */
public class Programador extends Empleado {
    private String tipoDeProgramador;
    private String proyectos;
    public Programador() {
        this( "", 0, 0.0, "", "" );
    }
    public Programador( String nombre, int edad, double sueldo, String tipo,
        String proy ) {
        super( nombre, edad, sueldo );
        this.tipoDeProgramador = tipo;
        this.proyectos = proy;
    }
    public Programador( Programador p ) {
        super( p );
        this.tipoDeProgramador = p.tipoDeProgramador;
        this.proyectos = p.proyectos;
    }
    @Override
    public void verPropiedades() {
        super.verPropiedades();
        System.out.println( " Tipo      " + tipoDeProgramador );
        System.out.println( " Proyectos " + proyectos );
    }
    @Override
    public void trabaja() {
        System.out.println( " Estoy trabajando como " + tipoDeProgramador );
    }
}

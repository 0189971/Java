/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author sdelaot
 */
public class Persona {
    private String nombre;
    private int edad;
    private String curp;
    public Persona() {
        this( "", 0, "" );
    }
    public Persona( String nombre, int edad, String curp ) {
        super();
        this.nombre = nombre;
        this.edad = edad;
        this.curp = curp;
    }
    public Persona( Persona alguien ) {
        super();
        nombre = alguien.nombre;
        edad = alguien.edad;
        curp = alguien.curp;
    }
    @Override
    public String toString() {
        return  " Nombre : " + nombre + "\n" +
                " Edad   : " + edad + "\n" +
                " CURP   : " + curp + "\n";
    }
}

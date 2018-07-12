/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tercerdeppoo;

/**
 *
 * @author sdelaot
 */
public abstract class Empleado {
    private String nombre;
    private int edad;
    private double sueldo;
    public Empleado() {
        this( "", 0, 0.0 );
    }
    public Empleado( String nombre, int edad, double sueldo ) {
        this.nombre = nombre;
        this.edad   = edad;
        this.sueldo = sueldo;
    }
    public Empleado( Empleado e ) {
        this.nombre = e.nombre;
        this.edad = e.edad;
        this.sueldo = e.sueldo;
    }
    public void verPropiedades() {
        System.out.println( " Nombre " + nombre );
        System.out.println( " Edad   " + edad );
        System.out.println( " Sueldo " + sueldo );
    }
    public abstract void trabaja();
}

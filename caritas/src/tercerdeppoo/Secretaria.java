/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tercerdeppoo;

/**
 *
 * @author sdelaot
 */
public class Secretaria extends Empleado {
    private String tipoDeSecretaria;
    private String departamento;
    public Secretaria() {
        this( "", 0, 0.0, "", "" );
    }
    public Secretaria( String nombre, int edad, double sueldo, String tipo,
        String depto ) {
        super( nombre, edad, sueldo );
        this.tipoDeSecretaria = tipo;
        this.departamento = depto;
    }
    public Secretaria( Secretaria s ) {
        super( s );
        this.tipoDeSecretaria = s.tipoDeSecretaria;
        this.departamento = s.departamento;
    }
    @Override
    public void verPropiedades() {
        super.verPropiedades();
        System.out.println( " Tipo         " + tipoDeSecretaria );
        System.out.println( " Departamento " + departamento );
    }
    public void trabaja() {
        System.out.println( " Estoy tomando dictado del director" );
    }
}

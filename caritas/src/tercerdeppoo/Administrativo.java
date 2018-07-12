/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tercerdeppoo;

/**
 *
 * @author sdelaot
 */
public class Administrativo extends Empleado {
    private String tipoDeAdministrativo;
    private double sobreSueldo;
    private String departamento;
    public Administrativo() {
        this( "", 0, 0.0, "", 0.0, "" );
    }
    public Administrativo( String nombre, int edad, double sueldo, String tipo,
        double sobreSueldo, String depto ) {
        super( nombre, edad, sueldo );
        this.tipoDeAdministrativo = tipo;
        this.sobreSueldo   = sobreSueldo;
        this.departamento = depto;
    }
    public Administrativo( Administrativo a ) {
        super( a );
        this.tipoDeAdministrativo = a.tipoDeAdministrativo;
        this.sobreSueldo = a.sobreSueldo;
        this.departamento = a.departamento;
    }
    @Override
    public void verPropiedades() {
        super.verPropiedades();
        System.out.println( " Tipo         " + tipoDeAdministrativo );
        System.out.println( " Sobre sueldo " + sobreSueldo );
        System.out.println( " Departamento    " + departamento );
    }
    public void trabaja() {
        System.out.println( " Estoy dirigiendo el departamento" );
    }
}

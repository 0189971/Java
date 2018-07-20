/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

import java.util.Date;

/**
 *
 * @author jchavezc1000
 */
public class Trabajador {
    private String nombre;
    private String puesto;
    private String direccion;
    private String telefono;
    private Date fecha_nacimiento;
    private Date fecha_Contrato;
    private String NSS;

    public Trabajador(String nombre, String NSS) {
        this.nombre = nombre;
        this.NSS = NSS;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNSS() {
        return NSS;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }
    
    //Comparación de objetos
    public boolean equals(Trabajador t){
        return this.NSS.equals(t.NSS);
    }
    //Conversion a string
    public String toString(){
        return nombre + "NSS: "+NSS;
    }
}

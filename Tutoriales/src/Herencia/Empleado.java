/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Herencia;

/**
 *
 * @author jchavezc1000
 */
public class Empleado extends Trabajador {
    private double sueldo;
    private double impuesto;
    private final int pagas =14;
    
    public Empleado (String nombre, String NSS, double sueldo){
        super(nombre, NSS);
        this.sueldo=sueldo;
        this.impuesto=0.3*sueldo;
    }
    //Nomina
    public double calcularPaga(){
        return (sueldo-impuesto)/pagas;
    }
    public String toString(){
        return "Empleado "+super.toString();
    }
}

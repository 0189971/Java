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
public class Consultor extends Trabajador{
    private int horas;
    private double tarifa;
    
    public Consultor (String nombre, String NSS, int horas, double tarifa){
        super(nombre, NSS);
        this.horas=horas;
        this.tarifa=tarifa;
    }
    //Paga por horas
    public double calcularPaga(){
        return horas*tarifa;
    }
    //to String
    public String toString(){
        return "Consultor "+super.toString();
    }
}

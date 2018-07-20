/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutoriales.Polimorfismo;

/**
 *
 * @author jchavezc1000
 */
public abstract class Vehiculo {
    /*Variables del objeto*/
    int llantas;
    int personas;
    
    
    public Vehiculo(int llantas, int personas) {
        this.llantas=llantas;
        this.personas=personas;
    }
    
    abstract public void tipo();
    
}

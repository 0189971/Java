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
public class Motocicleta extends Vehiculo{

    public Motocicleta(int llantas, int personas) {
        super(llantas, personas);
    }
    
    @Override
    public void tipo(){
        System.out.println("Es una moto");
    }
}

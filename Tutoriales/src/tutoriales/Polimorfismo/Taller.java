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
public class Taller {
    public static void main (String[] args){
        Vehiculo[] misvehiculos =new Vehiculo[2];
        misvehiculos[0]= new Coche(4,4);
        misvehiculos[1]= new Motocicleta(2,1);
        
        //Ejecutamos el metodo sobre el cual se le aplico el polimorfismo
        for(int i =0; i<misvehiculos.length; i++){
            misvehiculos[i].tipo();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaReflection;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jchavezc1000
 */
public class Principal {
    public static void main (String[] args){
        List <ComputadoraEscritorio> lista =new ArrayList<ComputadoraEscritorio>();
        ComputadoraEscritorio c0=new ComputadoraEscritorio("Ryzen 7 1700", "A1");
        ComputadoraEscritorio c1=new ComputadoraEscritorio("Ryzen 7 1700x", "A2");
        lista.add(c0);
        lista.add(c1);
        List <Laptop> lista2 = new ArrayList<Laptop>();
        Laptop l0=new Laptop("B1","Ryzen 1300x");
        Laptop l1=new Laptop("B1","Intel i3");
        lista2.add(l0);
        lista2.add(l1);
    }
}

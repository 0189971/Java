/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListObjects;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author jchavezc1000
 */
public class Principal {
    public static void main (String[] args){
        System.out.println("Creamos un ArrayList de nuestro objeto Figuras geometricas");
        ArrayList<FigurasGeometricas> figurageo = new ArrayList<FigurasGeometricas>();
        String [] nombres = new String[2];
        int [] caras = new int [2];
        int [] esquinas =new int[2];
        
        nombres[0] ="Triangulo";
        nombres[1] ="Cuadrado";
        caras[0]= 3;
        caras[1]=4;
        esquinas[0]=3;
        esquinas[1]=4;
        
        //Creamos un Objeto el cual vamos ir añadiendo al arraylist
        for(int i = 0; i<2; i++){
            //Instanceo un objeto de la clase FigurasGeometricas
            FigurasGeometricas fig = new FigurasGeometricas();
            fig.setNombre(nombres[i]);
            fig.setCaras(caras[i]);
            fig.setEsquinas(esquinas[i]);
            
            figurageo.add(fig);
        }
        //Recorremos el arraylist haciendo uso de un iterador 
        Iterator <FigurasGeometricas> itrfigurageo = figurageo.iterator();
        while (itrfigurageo.hasNext()){
            FigurasGeometricas fig =itrfigurageo.next();
            System.out.println("Los campos de cada objeto son: ");
            System.out.printf("Nombre: %s \nCaras: %d\nEsquinas: %d\n",fig.getNombre(),fig.getCaras(), fig.getEsquinas());
        }
    }
}

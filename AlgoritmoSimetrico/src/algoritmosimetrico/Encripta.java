/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosimetrico;

/**
 *
 * @author javis
 */
public class Encripta {
    //Implementaremos solamente un algoritmo de traslación 
    public String  EnCrypta(String entrada){
        char [] salida = null;
        int i=0;
        for(i=0; i < entrada.length(); i++){
            salida[i] = (char) (entrada.charAt(i)+2);
            System.out.println(salida[i]);
        }
        entrada=entrada+"-";
        
        return entrada;
    }

}

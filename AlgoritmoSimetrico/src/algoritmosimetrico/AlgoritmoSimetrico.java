/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosimetrico;

import java.util.StringTokenizer;
 

public class AlgoritmoSimetrico {
    
    public static void main(String[] args) {
        Encripta msj=new Encripta();
        String cadena="<javier> - Como estas?";
        String cadenaEncryptada ="";
        StringTokenizer st= new StringTokenizer(cadena);
        System.out.printf("La cantidad de Tokens es %d \n", st.countTokens());
        int j=st.countTokens();
        int i=0;
        while(st.hasMoreElements()){
            cadenaEncryptada = st.nextToken();
            if(i >= 2){
                System.out.println("Agregamos "+cadenaEncryptada);
            }
            System.out.println(i);
            i++;
            //EnCrypta(cadenaEncryptada);
        }
    }
}

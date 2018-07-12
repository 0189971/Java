/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Metodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Ingresa la ecuacion (z)");
            System.out.print("z=");
            System.out.println("Ingresa el numero de varibles: ");
            int var =  Integer.parseInt(br.readLine());
            //ArrayList <int> users = new ArrayList<int>();
            int z[] = new int[var];
            for (int i=0; i<var; i++){
                System.out.println("Ingresa el valor de la variable "+(i));
                z[i]= Integer.parseInt(br.readLine());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        // TODO code application logic here
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;

import java.io.IOException;

/**
 *
 * @author javis
 */
public class prueba2 {
    public static void main(String[] args) throws IOException {
        new prueba2();
        
    }
    public prueba2()throws IOException{
        byte [] hola =new byte[31];
        System.out.println(hola.length);
        for(int i=0; i<hola.length;i++)
        System.out.println(hola[i]);
    }
}

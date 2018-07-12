/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author javis
 */
public class GLc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena;
        Scanner cad=new Scanner(System.in);
        System.out.println("INTRODUCE LA CADENA A VALIDAR");
        cadena=cad.nextLine();
     Pattern pat = Pattern.compile("^a+b+$");
     Matcher mat = pat.matcher(cadena);
     if (mat.matches()) {
         System.out.println("SI ES VALIDA");
     } else {
         System.out.println("NO ES VALIDA");
     }
    }
    
}

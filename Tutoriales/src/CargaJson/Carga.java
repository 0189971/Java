/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CargaJson;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.*;
/**
 *
 * @author jchavezc1000
 */
public class Carga {
    public static void main (String[] args){
        System.out.println("Carga de un archivo JSON");
        
        JsonParser parser = new JsonParser();
        System.out.println(args.length);
        
        /*//Obtenemos el arreglo
        
        JsonArray gsonArr = parser.parse(args[0]).getAsJsonArray();
        for(JsonElement obj : gsonArr){
            System.out.println(obj);
        }*/
    }
}

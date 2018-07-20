/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaReflection;

/**
 *
 * @author jchavezc1000
 */
public class Laptop {
    private String id;
    private String procesador;
    private int panatalla;
    private String teclado;

    public Laptop(String id, String procesador) {
        super();
        this.id = id;
        this.procesador = procesador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }


    
    
}

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
public class ComputadoraEscritorio {
    private String procesador;
    private String gabinete;
    private String tarjetag;
    private String fuente;
    private String id;

    public ComputadoraEscritorio(String procesador, String id) {
        super();
        this.procesador = procesador;
        this.id = id;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProcesador() {
        return procesador;
    }

    public String getId() {
        return id;
    }
   
}

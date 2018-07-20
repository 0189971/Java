/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayListObjects;

/**
 *
 * @author jchavezc1000
 */
//Creamos un objeto con las propiredades de una figura geometrica
public class FigurasGeometricas {
    private String Nombre;
    private int caras;
    private int esquinas;

    public String getNombre() {
        return Nombre;
    }

    public int getCaras() {
        return caras;
    }

    public int getEsquinas() {
        return esquinas;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public void setEsquinas(int esquinas) {
        this.esquinas = esquinas;
    }

}

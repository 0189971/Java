package Practica2;
import java.io.*;
public class Articulo implements Serializable{
    private int idArticulo;
    private  String nombre;
    private String descripcion;
    private  int existencias;
    private String pathImagen;
    private double precio;
    private String categoria;

    public Articulo(int idArticulo, String nombre, String descripcion, int existencias, String pathImagen, double precio, String categoria) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.existencias = existencias;
        this.pathImagen = pathImagen;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public int getExistencias() {
        return existencias;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public String getPathImagen() {
        return pathImagen;
    }

  

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
}

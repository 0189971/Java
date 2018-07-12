package Practica2;

import java.io.Serializable;

public class ArticuloCarritoS implements Serializable{
    
    Articulo articulo;
    private double subtotal;
    private int cantidad;
  
    public ArticuloCarritoS(Articulo articulo,double subtotal,int cantidad){
       this.articulo= articulo;
       this.cantidad = cantidad;
       this.subtotal= subtotal;    
    }
    public Articulo getArticulo() {
        return articulo;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    } 
}

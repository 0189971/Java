package Practica2;
import java.io.Serializable;
import java.util.ArrayList;
public class Ticket implements Serializable{
    private ArrayList<ArticuloCarritoS> listaCarrito;
    private String[] DatosArticulo;
    private String Total;
    
    public Ticket(ArrayList<ArticuloCarritoS> listaCarrito){
        this.listaCarrito = listaCarrito;
       
        establecerDatos();
    }
    private void establecerDatos() {
        DatosArticulo= new String[ listaCarrito.size()] ;
        double total=0.0;
        for (int i = 0; i < listaCarrito.size(); i++) {
            DatosArticulo[i]=""+listaCarrito.get(i).getArticulo().getNombre() +"\t" +listaCarrito.get(i).getCantidad() +"\t"+ listaCarrito.get(i).getSubtotal()+"\n";
            total += listaCarrito.get(i).getSubtotal();
        }
       Total ="" + total;
    }

    public String[] getDatosArticulo() {
        return DatosArticulo;
    }

    public ArrayList<ArticuloCarritoS> getListaCarrito() {
        return listaCarrito;
    }

    public String getTotal() {
        return Total;
    }

    public void setDatosArticulo(String[] DatosArticulo) {
        this.DatosArticulo = DatosArticulo;
    }

    public void setListaCarrito(ArrayList<ArticuloCarritoS> listaCarrito) {
        this.listaCarrito = listaCarrito;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }
    
}

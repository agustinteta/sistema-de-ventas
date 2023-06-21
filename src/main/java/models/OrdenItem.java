package models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDEN_ITEM")
public class OrdenItem implements Serializable {

    private static final long serialVersionUID = 1L;
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem", updatable = false, nullable = false, unique = true)
    private int idItem;
    
    @JoinColumn(name = "idOrdenDeVenta")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private OrdenDeVenta orden;
    
    @JoinColumn(name = "idProducto")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Producto producto;
    
    @Column(name = "cantidad")
    private int cantidad;
    
    @Column(name = "precio")
    private double precio;
    

    public OrdenItem() {
    }

    public OrdenItem(Producto producto, OrdenDeVenta orden, int cantidad, double precio) {
        this.producto = producto;
        this.orden = orden;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getId() {
        return idItem;
    }

    public void setId(int idItem) {
        this.idItem = idItem;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public OrdenDeVenta getOrden() {
        return orden;
    }

    public void setOrden(OrdenDeVenta orden) {
        this.orden = orden;
    }

    public int getIdItem() {
        return idItem;
    }

    
    @Override
    public String toString() {
        return "OrdenItem{" + "idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

}

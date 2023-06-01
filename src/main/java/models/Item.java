package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item implements Serializable {
    
    //atributos
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idItem", updatable = false, nullable = false, unique = true)
    private int idItem;
    @JoinColumn(name = "idProducto")
    @OneToOne
    private Producto producto;
    @Column(name="cantidad")
    private int cantidad;

    public Item(){}

    public Item(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
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

    @Override
    public String toString() {
        return "Item{" + "id=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
    
}

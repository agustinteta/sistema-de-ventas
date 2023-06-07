package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    @JoinColumn(name = "idProducto")
    @ManyToMany
    private List<Producto> producto;
    @Column(name = "cantidad")
    private int cantidad;

    public OrdenItem() {
    }

    public OrdenItem(Producto producto, int cantidad) {
        this.producto = (List<Producto>) producto;
        this.cantidad = cantidad;
    }

    public int getId() {
        return idItem;
    }

    public void setId(int idItem) {
        this.idItem = idItem;
    }

    public Producto getProducto() {
        return (Producto) producto;
    }

    public void setProducto(Producto producto) {
        this.producto = (List<Producto>) producto;
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

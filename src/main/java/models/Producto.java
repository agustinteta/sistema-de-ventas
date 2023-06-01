package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto", updatable = false, nullable = false, unique = true)
    private int idProducto;
    @JoinColumn
    private Proveedor proveedor;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private int stock;
    @Column
    private double precio;

    public Producto() {
    }

    public Producto(Proveedor proveedor, String nombre, String descripcion, int stock, double precio) {
        this.proveedor = proveedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
    }

    public int getId() {
        return idProducto;
    }

    public void setId(int idProducto) {
        this.idProducto = idProducto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + idProducto + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio + '}';
    }

}

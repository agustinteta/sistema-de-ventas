package models;


public class Item {
    
    //atributos
    private int id;
    private Producto producto;
    private int cantidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Item{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }
    
    
}

package models;
import java.util.Date;


public class Orden {
    
    //atributos
    private int id;
    private Date fecha_creacion;
    private TipoOrden tipo;
    private PuntoDeVenta punto_de_venta;
    private Item[] items;
    private double precio_total;
    private Persona destinatario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public TipoOrden getTipo() {
        return tipo;
    }

    public void setTipo(TipoOrden tipo) {
        this.tipo = tipo;
    }

    public PuntoDeVenta getPunto_de_venta() {
        return punto_de_venta;
    }

    public void setPunto_de_venta(PuntoDeVenta punto_de_venta) {
        this.punto_de_venta = punto_de_venta;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public Persona getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Persona destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "Orden{" + "id=" + id + ", fecha_creacion=" + fecha_creacion + ", tipo=" + tipo + ", punto_de_venta=" + punto_de_venta + ", items=" + items + ", precio_total=" + precio_total + ", destinatario=" + destinatario + '}';
    }
    
    
    
}

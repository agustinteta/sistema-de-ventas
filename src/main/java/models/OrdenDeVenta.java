package models;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ORDEN_DE_VENTA")
public class OrdenDeVenta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrden", updatable = false, nullable = false, unique = true)
    private int id;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;
    @JoinColumn(name = "idTipoOrden")
    @OneToMany
    private List<TipoOrden> tipo;
    @JoinColumn(name = "idPuntoDeVenta")
    @ManyToOne
    private PuntoDeVenta punto_de_venta;
    @ElementCollection
    @ManyToMany
    private List<OrdenItem> items;
    @Column(name = "precio_total")
    private double precio_total;
    @JoinColumn(name = "idCliente")
    @OneToMany
    private List<Cliente> cliente;
    
    public OrdenDeVenta(){}

    public OrdenDeVenta(Date fecha_creacion, List<TipoOrden> tipo, PuntoDeVenta punto_de_venta, List<OrdenItem> items, double precio_total, List<Cliente> cliente) {
        this.fecha_creacion = fecha_creacion;
        this.tipo = tipo;
        this.punto_de_venta = punto_de_venta;
        this.items = items;
        this.precio_total = precio_total;
        this.cliente = cliente;
    }

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

    public List<TipoOrden> getTipo() {
        return tipo;
    }

    public void setTipo(List<TipoOrden> tipo) {
        this.tipo = tipo;
    }

    public PuntoDeVenta getPunto_de_venta() {
        return punto_de_venta;
    }

    public void setPunto_de_venta(PuntoDeVenta punto_de_venta) {
        this.punto_de_venta = punto_de_venta;
    }

    public List<OrdenItem> getItems() {
        return items;
    }

    public void setItems(List<OrdenItem> items) {
        this.items = items;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "OrdenDeVenta{" + "id=" + id + ", fecha_creacion=" + fecha_creacion + ", tipo=" + tipo + ", punto_de_venta=" + punto_de_venta + ", items=" + items + ", precio_total=" + precio_total + ", cliente=" + cliente + '}';
    }

    
    
}

package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PUNTO_DE_VENTA")
public class PuntoDeVenta implements Serializable {

    //atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPuntoDeVenta", updatable = false, nullable = false, unique = true)
    private int idPuntoDeVenta;
    @JoinColumn(name = "idEmpresa")
    @OneToMany
    private List<Empresa> empresa;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public int getId() {
        return idPuntoDeVenta;
    }

    public void setId(int idPuntoDeVenta) {
        this.idPuntoDeVenta = idPuntoDeVenta;
    }

    public Empresa getEmpresa() {
        return (Empresa) empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = (List<Empresa>) empresa;
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

    @Override
    public String toString() {
        return "PuntoDeVenta{" + "id=" + idPuntoDeVenta + ", empresa=" + empresa + ", nombre=" + nombre + '}';
    }

}

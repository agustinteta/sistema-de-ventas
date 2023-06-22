package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_ORDEN")
public class TipoOrden implements Serializable {
    
    //atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoOrden", updatable = false, nullable = false, unique = true)
    private int idTipoOrden;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "descripcion", length = 250)
    private String descripcion;

    public TipoOrden(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    public TipoOrden(){}

    public int getId() {
        return idTipoOrden;
    }

    public void setId(int idTipoOrden) {
        this.idTipoOrden = idTipoOrden;
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
        return nombre;
    }
    
    
    
}

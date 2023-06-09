package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario implements Serializable {
    
    //atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoUsuario", updatable = false, nullable = false, unique = true)
    private int idTipoUsuario;
    @Column(name = "nombre", length = 50)
    private String nombre;

    public TipoUsuario(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public TipoUsuario(){}
    
    public int getId() {
        return idTipoUsuario;
    }

    public void setId(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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
    private String descripcion;

    @Override
    public String toString() {
        return idTipoUsuario + " - " + nombre;
    }
    
    
    
}

package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

    //atributos
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idEmpresa", updatable = false, nullable = false, unique = true)
    private int idEmpresa;
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "razon_social", length = 50)
    private String razon_social;
    @Column(name = "direccion", length = 100)
    private String direccion;
    
    public Empresa(){}

    public Empresa(String nombre, String razon_social, String direccion) {
        this.nombre = nombre;
        this.razon_social = razon_social;
        this.direccion = direccion;
    }

    public int getId() {
        return idEmpresa;
    }

    public void setId(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nombre=" + nombre + '}';
    }

}

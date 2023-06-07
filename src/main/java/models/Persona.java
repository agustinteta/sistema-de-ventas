package models;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {

    //atributos
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Column(name = "apellido", length = 50)
    private String apellido;
    @Column(name = "identificacion", length = 50)
    private String identificacion;
    @Column(name = "celular", length = 50)
    private String celular;
    @Column(name = "correo", length = 50)
    private String correo;

    public Persona(){}
    
    public Persona(String nombre, String apellido, String identificacion, String celular, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.celular = celular;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Persona{nombre=" + nombre + ", apellido=" + apellido + '}';
    }

}

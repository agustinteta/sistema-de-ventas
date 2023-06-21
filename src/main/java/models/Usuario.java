package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario extends Persona implements Serializable {

    //atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente", updatable = false, nullable = false, unique = true)
    private int idUsuario;
    @Column(name = "nombre_usuario", length = 50, unique = true)
    private String nombre_usuario;
    @Column(name = "password", length = 300)
    private String password;
    @ManyToOne
    @JoinColumn(name = "idTipoUsuario")
    private TipoUsuario tipo_usuario;
    @ManyToOne
    @JoinColumn(name = "idPuntoDeVenta")
    private PuntoDeVenta punto_de_venta;

    public Usuario() {
    }

    public Usuario(String nombre_usuario, String password, TipoUsuario tipo_usuario, PuntoDeVenta punto_de_venta, String nombre, String apellido, String identificacion, String celular, String correo) {
        super(nombre, apellido, identificacion, celular, correo);
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
        this.punto_de_venta = punto_de_venta;
    }

    public Usuario(String nombre_usuario, String password, TipoUsuario tipo_usuario, String nombre, String apellido, String identificacion, String celular, String correo) {
        super(nombre, apellido, identificacion, celular, correo);
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + "nombre=" + getNombre() + '}';
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipo_usuario() {
        return (TipoUsuario) tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public PuntoDeVenta getPunto_de_venta() {
        return (PuntoDeVenta) punto_de_venta;
    }

    public void setPunto_de_venta(PuntoDeVenta punto_de_venta) {
        this.punto_de_venta = punto_de_venta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

}

package models;

import java.awt.HeadlessException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

@Entity
@Table(name = "USUARIO")
public class Usuario extends Persona implements Serializable {

    //atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente", updatable = false, nullable = false, unique = true)
    private int idUsuario;
    @Column(name = "nombre_usuario", length = 50)
    private String nombre_usuario;
    @Column(name = "password", length = 50)
    private String password;
    @JoinColumn(name = "idTipoUsuario")
    @OneToMany
    private List<TipoUsuario> tipo_usuario;
    @OneToMany
    @JoinColumn(name = "idPuntoDeVenta")
    private List<PuntoDeVenta> punto_de_venta;

    public Usuario() {
    }

    public Usuario(String nombre_usuario, String password, TipoUsuario tipo_usuario, PuntoDeVenta punto_de_venta, String nombre, String apellido, String identificacion, String celular, String correo) {
        super(nombre, apellido, identificacion, celular, correo);
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = (List<TipoUsuario>) tipo_usuario;
        this.punto_de_venta = (List<PuntoDeVenta>) punto_de_venta;
    }

    public Usuario(String nombre_usuario, String password, String nombre, String apellido, String identificacion, String celular, String correo) {
        super(nombre, apellido, identificacion, celular, correo);
        this.nombre_usuario = nombre_usuario;
        this.password = password;
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
        this.tipo_usuario = (List<TipoUsuario>) tipo_usuario;
    }

    public PuntoDeVenta getPunto_de_venta() {
        return (PuntoDeVenta) punto_de_venta;
    }

    public void setPunto_de_venta(PuntoDeVenta punto_de_venta) {
        this.punto_de_venta = (List<PuntoDeVenta>) punto_de_venta;
    }

    public Usuario validarUsuario(String nombre_usuario, String password) {
        System.out.println("VALIDACION DE USUARIO.");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.nombre_usuario = :nombre_usuario AND u.password = :password", Usuario.class);
            query.setParameter("nombre_usuario", nombre_usuario);
            query.setParameter("password", password);

            List<Usuario> resultados = query.getResultList();

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun Usuario. Por favor registrese o reingrese las credenciales.");
                return null; // No se encontró ningún usuario con ese nombre y apellido
            } else {
                System.out.println("USUARIO ENCONTRADO.");
                return resultados.get(0); // Devuelve el primer resultado (puedes ajustarlo según tus necesidades)
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun Usuario. Por favor registrese o reingrese las credenciales." + e);
        }
        return null;
    }

    public boolean agregarUsuario(Usuario u) {
        System.out.println("AGREGAR USUARIO :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(u);
            manager.getTransaction().commit();
            System.out.println("USUARIO AGREGADO");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo durante el registro de usuario, vuelva a intentarlo");
            manager.getTransaction().rollback();
            return false;
        }
    }

}

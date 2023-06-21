package controller;

import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import models.PuntoDeVenta;
import models.TipoUsuario;
import models.Usuario;

public class ControladorUsuario {

    private Usuario usuario;

    public ControladorUsuario() {
        usuario = new Usuario();
    }

    public boolean agregarUsuario(String nombre_usuario, String password, TipoUsuario tipo_usuario, String nombre, String apellido, String identificacion, String celular, String correo) {
        usuario.setNombre_usuario(nombre_usuario);
        usuario.setPassword(password);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setIdentificacion(identificacion);
        usuario.setCelular(celular);
        usuario.setCorreo(correo);
        usuario.setTipo_usuario(tipo_usuario);

        System.out.println("AGREGAR USUARIO :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
            System.out.println("USUARIO AGREGADO");
            manager.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de usuario: " + e);
            manager.getTransaction().rollback();
        }
        return false;
    }

    public boolean validarUsuario(String nombre_usuario, String password) {
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
                return false; // No se encontró ningún usuario con ese nombre y apellido
            } else {
                System.out.println("USUARIO ENCONTRADO.");
                return true; // Devuelve el primer resultado (puedes ajustarlo según tus necesidades)
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun Usuario. Por favor registrese o reingrese las credenciales." + e);
        }
        return false;
    }
    
    public Usuario obtenerUsuarioNombre(String nombre_usuario, String password){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.nombre_usuario = :nombre_usuario AND u.password = :password", Usuario.class);
            query.setParameter("nombre_usuario", nombre_usuario);
            query.setParameter("password", password);

            List<Usuario> resultados = query.getResultList();
            return resultados.get(0);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun Usuario. Por favor registrese o reingrese las credenciales." + e);
            Usuario user = null;
            return user;
        }
    }
    
    public Usuario buscarUsuario(int idUsuario) {
        System.out.println("BUSCAR USUARIO: " + idUsuario);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Usuario user = null;

        try {
            manager.getTransaction().begin();
            user = manager.find(Usuario.class, idUsuario);
            manager.getTransaction().commit();
            manager.close();
            return user;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun proveedor con el id proporcionado. " + e);
            return user;
        }
    }

    public void actualizarUsuario(int idUsuario, String nombre, String apellido, String identificacion, String celular, String correo, TipoUsuario tipo_usuario, PuntoDeVenta pos) {
        System.out.println("ACTUALIZAR USUARIO: " + idUsuario);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Usuario user = manager.find(Usuario.class, idUsuario);
            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setIdentificacion(identificacion);
            user.setCelular(celular);
            user.setCorreo(correo);
            user.setTipo_usuario(tipo_usuario);
            user.setPunto_de_venta(pos);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar." + e);
            manager.getTransaction().rollback();
        }
    }

    public void eliminarUsuario(int idUsuario) {
        System.out.println("ELIMINAR USUARIO: " + idUsuario);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Usuario user = manager.find(Usuario.class, idUsuario);
            manager.remove(user);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
            manager.getTransaction().rollback();
        }
    }
    
    public List<Usuario> obtenerListaUsuarios() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        List<Usuario> resultados = null;
        try {
            resultados = (List<Usuario>) manager.createQuery("SELECT u FROM Usuario u").getResultList();
            return resultados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista." + e);
            return resultados;
        }
    }
}

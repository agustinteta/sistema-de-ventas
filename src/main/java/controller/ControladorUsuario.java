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

    public boolean agregarUsuario(String nombre_usuario, String password, TipoUsuario tipo_usuario, PuntoDeVenta pos, String nombre, String apellido, String identificacion, String celular, String correo) {
        System.out.println("AGREGAR USUARIO:");

        Usuario user = new Usuario();
        user.setNombre_usuario(nombre_usuario);
        user.setPassword(password);
        user.setTipo_usuario(tipo_usuario);
        user.setPunto_de_venta(pos);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setIdentificacion(identificacion);
        user.setCelular(celular);
        user.setCorreo(correo);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(user);
            manager.getTransaction().commit();
            System.out.println("USUARIO AGREGADO");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de usuario: " + e);
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return false;
    }

    public boolean validarUsuario(String nombre_usuario, String password) {
        System.out.println("VALIDACION DE USUARIO.");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            TypedQuery<Long> query = manager.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.nombre_usuario = :nombre_usuario AND u.password = :password", Long.class);
            query.setParameter("nombre_usuario", nombre_usuario);
            query.setParameter("password", password);

            Long count = query.getSingleResult();

            if (count == 0) {
                JOptionPane.showMessageDialog(null, "No se encontró ningún usuario. Por favor regístrese o reintroduzca las credenciales.");
                return false; // No se encontró ningún usuario con ese nombre y contraseña
            } else {
                System.out.println("USUARIO ENCONTRADO.");
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al validar el usuario: " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return false;
    }

    public Usuario obtenerUsuarioNombre(String nombre_usuario, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u WHERE u.nombre_usuario = :nombre_usuario AND u.password = :password", Usuario.class);
            query.setParameter("nombre_usuario", nombre_usuario);
            query.setParameter("password", password);
            List<Usuario> resultados = query.getResultList();
            return resultados.get(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún Usuario. Por favor registrese o reingrese las credenciales." + e);
            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public Usuario buscarUsuario(int idUsuario) {
        System.out.println("BUSCAR USUARIO: " + idUsuario);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Usuario user = null;

        try {
            user = manager.find(Usuario.class, idUsuario);
            return user;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con el id proporcionado. " + e);
            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar: " + e);
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void eliminarUsuario(int idUsuario) {
        System.out.println("ELIMINAR USUARIO: " + idUsuario);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Usuario user = manager.find(Usuario.class, idUsuario);
            if (user != null) {
                manager.remove(user);
                manager.getTransaction().commit();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e);
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public List<Usuario> obtenerListaUsuarios() {
        System.out.println("OBTENER LISTA DE USUARIOS");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        List<Usuario> resultados = null;
        try {
            TypedQuery<Usuario> query = manager.createQuery("SELECT u FROM Usuario u", Usuario.class);
            resultados = query.getResultList();
            return resultados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista: " + e);
            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

}

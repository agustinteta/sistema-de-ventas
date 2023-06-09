package controller;

import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
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
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de usuario: "+e);
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

}

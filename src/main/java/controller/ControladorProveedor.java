package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import models.Proveedor;

public class ControladorProveedor {

    private Proveedor proveedor;

    public ControladorProveedor() {
        proveedor = new Proveedor();
    }

    public boolean agregarProveedor(String nombre, String apellido, String identificacion, String celular, String correo) {
        proveedor.setNombre(nombre);
        proveedor.setApellido(apellido);
        proveedor.setIdentificacion(identificacion);
        proveedor.setCelular(celular);
        proveedor.setCorreo(correo);

        System.out.println("AGREGAR PROVEEDOR :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(proveedor);
            manager.getTransaction().commit();
            System.out.println("PROVEEDOR AGREGADO");
            manager.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de proveedor: " + e);
            manager.getTransaction().rollback();
        }
        return false;
    }

    public Proveedor buscarProveedor(int idProveedor) {
        System.out.println("BUSCAR PROVEEDOR :" + idProveedor);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Proveedor pro = null;

        try {
            manager.getTransaction().begin();
            pro = manager.find(Proveedor.class, idProveedor);
            manager.getTransaction().commit();
            manager.close();
            return pro;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun proveedor con el id proporcionado. " + e);
            return pro;
        }
    }

    public void actualizarProveedor(int idProveedor, String nombre, String apellido, String identificacion, String celular, String correo) {
        System.out.println("ACTUALIZAR PROVEEDOR :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Proveedor pro = manager.find(Proveedor.class, idProveedor);
            pro.setNombre(nombre);
            pro.setApellido(apellido);
            pro.setIdentificacion(identificacion);
            pro.setCelular(celular);
            pro.setCorreo(correo);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar." + e);
            manager.getTransaction().rollback();
        }
    }

    public void eliminarProveedor(int idProveedor) {
        System.out.println("ELIMINAR PROVEEDOR :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Proveedor pro = manager.find(Proveedor.class, idProveedor);
            manager.remove(pro);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
            manager.getTransaction().rollback();
        }
    }

    public List<Proveedor> obtenerListaProveedores() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        List<Proveedor> resultados = null;
        try {
            resultados = (List<Proveedor>) manager.createQuery("SELECT p FROM Proveedor p").getResultList();
            return resultados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista." + e);
            return resultados;
        }
    }

}

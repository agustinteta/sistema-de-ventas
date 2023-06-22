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
        System.out.println("AGREGAR PROVEEDOR :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            Proveedor proveedor = new Proveedor();
            proveedor.setNombre(nombre);
            proveedor.setApellido(apellido);
            proveedor.setIdentificacion(identificacion);
            proveedor.setCelular(celular);
            proveedor.setCorreo(correo);

            manager.getTransaction().begin();
            manager.persist(proveedor);
            manager.getTransaction().commit();
            System.out.println("PROVEEDOR AGREGADO");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de proveedor: " + e);
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

    public Proveedor buscarProveedor(int idProveedor) {
        System.out.println("BUSCAR PROVEEDOR :" + idProveedor);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Proveedor pro = null;

        try {
            manager.getTransaction().begin();
            pro = manager.find(Proveedor.class, idProveedor);
            manager.getTransaction().commit();
            return pro;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun proveedor con el id proporcionado. " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return pro;
    }

    public void actualizarProveedor(int idProveedor, String nombre, String apellido, String identificacion, String celular, String correo) {
        System.out.println("ACTUALIZAR PROVEEDOR :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Proveedor pro = manager.find(Proveedor.class, idProveedor);
            if (pro != null) {
                pro.setNombre(nombre);
                pro.setApellido(apellido);
                pro.setIdentificacion(identificacion);
                pro.setCelular(celular);
                pro.setCorreo(correo);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar." + e);
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public void eliminarProveedor(int idProveedor) {
        System.out.println("ELIMINAR PROVEEDOR :");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Proveedor pro = manager.find(Proveedor.class, idProveedor);
            if (pro != null) {
                manager.remove(pro);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
            if (manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public List<Proveedor> obtenerListaProveedores() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        List<Proveedor> resultados = null;
        try {
            manager.getTransaction().begin();
            resultados = manager.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
            manager.getTransaction().commit();
            return resultados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista." + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return resultados;
    }

}

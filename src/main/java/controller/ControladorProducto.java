package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import models.Cliente;
import models.Producto;
import models.Proveedor;

public class ControladorProducto {

    private Producto producto;

    public ControladorProducto() {
        producto = new Producto();
    }

    public boolean agregarProducto(String nombre, String descripcion, Proveedor proveedor, int stock, double precio) {
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setProveedor(proveedor);
        producto.setStock(stock);
        producto.setPrecio(precio);

        System.out.println("AGREGAR PRODUCTO:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            manager.getTransaction().begin();
            manager.persist(producto);
            manager.getTransaction().commit();
            System.out.println("PRODUCTO AGREGADO");
            manager.close();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro del producto: " + e);
            manager.getTransaction().rollback();
        }
        return false;
    }

    public Producto buscarProducto(int idProducto) {
        System.out.println("BUSCAR PRODUCTO:" + idProducto);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Producto pro = null;

        try {
            manager.getTransaction().begin();
            String jpql = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto";
            TypedQuery<Producto> query = manager.createQuery(jpql, Producto.class);
            query.setParameter("idProducto", idProducto);
            pro = query.getSingleResult();
            manager.getTransaction().commit();
            manager.close();
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun producto con el id proporcionado. " + e);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar producto por ID: " + e);
        }
        return pro;
    }

    public void actualizarProducto(int idProducto, String nombre, String descripcion, Proveedor proveedor, int stock, double precio) {
        System.out.println("ACTUALIZAR PRODUCTO:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Producto pro = manager.find(Producto.class, idProducto);
            pro.setNombre(nombre);
            pro.setDescripcion(descripcion);
            pro.setProveedor(proveedor);
            pro.setStock(stock);
            pro.setPrecio(precio);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar actualizar." + e);
            manager.getTransaction().rollback();
        }
    }

    public void eliminarProducto(int idProducto) {
        System.out.println("ELIMINAR PRODUCTO:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Producto pro = manager.find(Producto.class, idProducto);
            manager.remove(pro);
            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar" + e);
            manager.getTransaction().rollback();
        }
    }

    public List<Producto> obtenerListaProductos() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        List<Producto> resultados = null;
        try {
            resultados = (List<Producto>) manager.createQuery("SELECT p FROM Producto p").getResultList();
            return resultados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista." + e);
            return resultados;
        }
    }

}

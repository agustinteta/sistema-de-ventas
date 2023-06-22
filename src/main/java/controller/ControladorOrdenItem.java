package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import models.OrdenDeVenta;
import models.OrdenItem;
import models.Producto;

public class ControladorOrdenItem {

    private OrdenItem ordenitem;

    public ControladorOrdenItem() {
        ordenitem = new OrdenItem();
    }

    public boolean agregarOrdenItem(Producto producto, OrdenDeVenta orden, int cantidad, double precio) {
        System.out.println("AGREGAR ORDENITEM:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            OrdenItem ordenitem = new OrdenItem();
            ordenitem.setProducto(producto);
            ordenitem.setOrden(orden);
            ordenitem.setCantidad(cantidad);
            ordenitem.setPrecio(precio);

            manager.getTransaction().begin();
            manager.persist(ordenitem);
            manager.getTransaction().commit();
            System.out.println("ORDENITEM AGREGADO");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro del orden item: " + e);
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

    public OrdenItem buscarOrdenItem(int idOrdenItem) {
        System.out.println("BUSCAR PRODUCTO:" + idOrdenItem);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        OrdenItem pro = null;

        try {
            manager.getTransaction().begin();
            String jpql = "SELECT o FROM OrdenItem o WHERE o.idItem = :idOrdenItem";
            TypedQuery<OrdenItem> query = manager.createQuery(jpql, OrdenItem.class);
            query.setParameter("idOrdenItem", idOrdenItem);
            pro = query.getSingleResult();
            manager.getTransaction().commit();
            return pro;
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun OrdenItem con el id proporcionado. " + e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar OrdenItem por ID: " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return pro;
    }

}

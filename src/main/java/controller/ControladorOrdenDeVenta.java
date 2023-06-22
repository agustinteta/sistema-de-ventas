package controller;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import models.Cliente;
import models.OrdenDeVenta;
import models.OrdenItem;
import models.PuntoDeVenta;
import models.TipoOrden;

public class ControladorOrdenDeVenta {

    private OrdenDeVenta orden;

    public ControladorOrdenDeVenta() {
        orden = new OrdenDeVenta();
    }

    public boolean agregarOrden(Date fecha_creacion, TipoOrden tipo, PuntoDeVenta punto_de_venta, double precio_total, Cliente cliente) {
        System.out.println("AGREGAR ORDEN DE VENTA:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            OrdenDeVenta orden = new OrdenDeVenta();
            orden.setFecha_creacion(fecha_creacion);
            orden.setTipo((TipoOrden) tipo);
            orden.setPunto_de_venta(punto_de_venta);
            orden.setPrecio_total(precio_total);
            orden.setCliente((Cliente) cliente);

            manager.getTransaction().begin();
            manager.persist(orden);
            manager.getTransaction().commit();
            System.out.println("ORDEN DE VENTA AGREGADA");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de la orden: " + e);
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

    public OrdenDeVenta obtenerUltimaOrden() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        OrdenDeVenta ultimaOrden = null;

        try {
            manager.getTransaction().begin();
            TypedQuery<OrdenDeVenta> query = manager.createQuery(
                    "SELECT o FROM OrdenDeVenta o WHERE o.id = (SELECT MAX(o2.id) FROM OrdenDeVenta o2)", OrdenDeVenta.class);

            ultimaOrden = query.getSingleResult();
            manager.getTransaction().commit();
            return ultimaOrden;
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return ultimaOrden;
    }

}

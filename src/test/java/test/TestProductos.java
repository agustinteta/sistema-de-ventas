package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Producto;
import models.Proveedor;

public class TestProductos {

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();

        //CREAR UN PRODUCTO
        Proveedor pro = manager.find(Proveedor.class, 1);
        Producto p = new Producto(pro, "Producto 2", "Descripcion del producto", 90, 150);
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();

        imprimirTodo();
    }

    private static void imprimirTodo() {
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<Producto> pros = (List<Producto>) manager.createQuery("SELECT r FROM Producto r").getResultList();
        for (Producto pro : pros) {
            System.out.println(pro.toString());
        }
    }
}

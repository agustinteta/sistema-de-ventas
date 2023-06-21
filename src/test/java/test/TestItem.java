
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.OrdenItem;
import models.Producto;
import controller.ControladorOrdenDeVenta;
import models.OrdenDeVenta;



public class TestItem {
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;
    private static ControladorOrdenDeVenta controladorOrden = new ControladorOrdenDeVenta();

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();
        
        //CREAR UN ITEM PARA UNA ORDEN
        Producto producto = manager.find(Producto.class, 1);
        OrdenDeVenta orden = controladorOrden.obtenerUltimaOrden();
        OrdenItem item = new OrdenItem(producto, orden, 3, 100);
        manager.getTransaction().begin();
        manager.persist(item);
        manager.getTransaction().commit();
        
        imprimirTodo();
    }
    
    private static void imprimirTodo(){
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<OrdenItem> items = (List<OrdenItem>) manager.createQuery("SELECT r FROM Item r").getResultList();
        for (OrdenItem item: items){
            System.out.println(item.toString());
        }
    }
}

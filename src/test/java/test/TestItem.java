
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Item;
import models.Producto;



public class TestItem {
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();
        
        //CREAR UN ITEM PARA UNA ORDEN
        Producto producto = manager.find(Producto.class, 1);
        Item item = new Item(producto, 3);
        manager.getTransaction().begin();
        manager.persist(item);
        manager.getTransaction().commit();
        
        imprimirTodo();
    }
    
    private static void imprimirTodo(){
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<Item> items = (List<Item>) manager.createQuery("SELECT r FROM Item r").getResultList();
        for (Item item: items){
            System.out.println(item.toString());
        }
    }
}

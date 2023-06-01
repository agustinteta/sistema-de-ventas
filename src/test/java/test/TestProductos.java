/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Producto;
import models.Proveedor;

/**
 *
 * @author agustin
 */
public class TestProductos {
    private static EntityManager manager;

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();

        //CREAR UN PRODUCTO
        Proveedor pro = manager.find(Proveedor.class, "1");
        Producto p = new Producto("Agustin", "Teta", "40978022", "2257536674", "agustinteta@hotmail.com");
        manager.getTransaction().begin();
        manager.persist(p);
        manager.getTransaction().commit();

        imprimirTodo();
    }

    private static void imprimirTodo() {
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<Producto> pros = (List<Producto>) manager.createQuery("SELECT r FROM Cliente r").getResultList();
        for (Producto pro : pros) {
            System.out.println(pro.toString());
        }
    }
}

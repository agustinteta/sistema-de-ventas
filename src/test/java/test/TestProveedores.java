/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Proveedor;

/**
 *
 * @author agustin
 */
public class TestProveedores {
    private static EntityManager manager;

    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();

        //CREAR UN CLIENTE
        Proveedor c = new Proveedor("Proveedor", "1", "11122233", "12345678", "proveedor@proveedores.com");
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();

        imprimirTodo();
    }

    private static void imprimirTodo() {
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<Proveedor> proveedores = (List<Proveedor>) manager.createQuery("SELECT r FROM Proveedor r").getResultList();
        for (Proveedor proveedor : proveedores) {
            System.out.println(proveedor.toString());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Cliente;


public class TestClientes {

    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();

        //CREAR UN CLIENTE
        Cliente c = new Cliente("Agustin", "Teta", "40978022", "2257536674", "agustinteta@hotmail.com");
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();

        imprimirTodo();
    }

    private static void imprimirTodo() {
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<Cliente> clis = (List<Cliente>) manager.createQuery("SELECT r FROM Cliente r").getResultList();
        for (Cliente cli : clis) {
            System.out.println(cli.toString());
        }
    }
}

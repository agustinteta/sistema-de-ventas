/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import models.Cliente;

/**
 *
 * @author agust
 */
public class ControladorCliente {

    private Cliente cliente;

    public ControladorCliente() {
        cliente = new Cliente();
    }

    public boolean agregarCliente(String nombre, String apellido, String identificacion, String celular, String correo) {
        System.out.println("AGREGAR CLIENTE:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();

        try {
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setIdentificacion(identificacion);
            cliente.setCelular(celular);
            cliente.setCorreo(correo);

            manager.getTransaction().begin();
            manager.persist(cliente);
            manager.getTransaction().commit();
            System.out.println("CLIENTE AGREGADO");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro de cliente: " + e);
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

    public Cliente buscarCliente(int idCliente) {
        System.out.println("BUSCAR CLIENTE:" + idCliente);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Cliente pro = null;

        try {
            manager.getTransaction().begin();
            pro = manager.find(Cliente.class, idCliente);
            manager.getTransaction().commit();
            return pro;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontro ningun cliente con el id proporcionado. " + e);
            return pro;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    public Cliente buscarClienteDNI(String dni) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Cliente cliente = null;
        try {
            manager.getTransaction().begin();
            String jpql = "SELECT c FROM Cliente c WHERE c.identificacion = :dni";
            TypedQuery<Cliente> query = manager.createQuery(jpql, Cliente.class);
            query.setParameter("dni", dni);
            cliente = query.getSingleResult();
            manager.getTransaction().commit();
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con el DNI proporcionado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar cliente por DNI: " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return cliente;
    }

    public void actualizarCliente(int idCliente, String nombre, String apellido, String identificacion, String celular, String correo) {
        System.out.println("ACTUALIZAR CLIENTE:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Cliente pro = manager.find(Cliente.class, idCliente);
            pro.setNombre(nombre);
            pro.setApellido(apellido);
            pro.setIdentificacion(identificacion);
            pro.setCelular(celular);
            pro.setCorreo(correo);
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

    public void eliminarCliente(int idCliente) {
        System.out.println("ELIMINAR CLIENTE:");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        try {
            manager.getTransaction().begin();
            Cliente pro = manager.find(Cliente.class, idCliente);
            manager.remove(pro);
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

    public List<Cliente> obtenerListaClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        List<Cliente> resultados = null;
        try {
            resultados = (List<Cliente>) manager.createQuery("SELECT c FROM Cliente c").getResultList();
            return resultados;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista." + e);
            return resultados;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

}

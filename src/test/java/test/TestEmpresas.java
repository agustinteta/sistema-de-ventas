package test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Empresa;

public class TestEmpresas {

    private static EntityManager manager;
    
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();
        
        //CREAR UNA EMPRESA
        Empresa e = new Empresa("Empresa 2", "CUIT 00112233", "Direccion muy lejana");
        manager.getTransaction().begin();
        manager.persist(e);
        manager.getTransaction().commit();
        
        imprimirTodo();
    }
    
    private static void imprimirTodo(){
        //TRAER TODAS LAS EMPRESAS DE LA TABLA
        List<Empresa> emps = (List<Empresa>) manager.createQuery("SELECT r FROM Empresa r").getResultList();
        for (Empresa emp: emps){
            System.out.println(emp.toString());
        }
    }
}

package uaa.tif;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Empresa;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager em = emf.createEntityManager();

        Empresa e = em.find(Empresa.class, 1);
        System.out.println(e);
        em.close();
        emf.close();
    }
}

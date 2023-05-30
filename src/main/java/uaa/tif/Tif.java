package uaa.tif;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Empresa;

public class Tif {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myConnectionDB");
        EntityManager em = emf.createEntityManager();

        Empresa e = em.find(Empresa.class, 1);
        System.out.println(e);
        em.close();
        emf.close();
    }
}

package scripts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.*;

import java.util.Arrays;
import java.util.List;

public class ConfiguracionInicial {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BDD");
        EntityManager manager = emf.createEntityManager();
        Empresa e;
        List<Object> objetosPersistir = Arrays.asList(
            e = new Empresa("Insumos Tecnologicos S.A", "10-12345678-9", "Buenos Aires"),
            new Proveedor("Juan", "Perez", "11122233", "12345678", "proveedor@proveedores.com"),
            new PuntoDeVenta(e, "Stand principal", "Stand de la entrada para atencion al publico."),
            new PuntoDeVenta(e, "Servicio Tecnico", "Taller de servicio tecnico."),
            new TipoUsuario("Vendedor", "Empleado que se encarga de la atencion al publico"),
            new TipoUsuario("Servicio Tecnico", "Empleado que se encarga de reparaciones en el area de Servicio Tecnico"),
            new TipoUsuario("Administrador", "Administrador del sistema"),
            new TipoOrden("A", "Tipo de orden A"),
            new TipoOrden("B", "Tipo de orden B"),
            new TipoOrden("C", "Tipo de orden C")
        );

        manager.getTransaction().begin();
        for (Object objeto : objetosPersistir) {
            manager.persist(objeto);
        }
        manager.getTransaction().commit();

        manager.close();
    }
}
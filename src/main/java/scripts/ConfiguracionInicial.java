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
        Proveedor p, p1;
        List<Object> objetosPersistir = Arrays.asList(
                e = new Empresa("Insumos Tecnologicos S.A", "10-12345678-9", "Buenos Aires"),
                p = new Proveedor("Juan", "Perez", "11122233", "12345678", "proveedor@proveedores.com"),
                p1 = new Proveedor("Roman", "Riquelme", "33222111", "87654321", "proveedor.cabj@proveedores.com"),
                new PuntoDeVenta(e, "Stand principal", "Stand de la entrada para atencion al publico."),
                new PuntoDeVenta(e, "Servicio Tecnico", "Taller de servicio tecnico."),
                new TipoUsuario("Vendedor", "Empleado que se encarga de la atencion al publico"),
                new TipoUsuario("Servicio Tecnico", "Empleado que se encarga de reparaciones en el area de Servicio Tecnico"),
                new TipoUsuario("Administrador", "Administrador del sistema"),
                new TipoOrden("A", "Tipo de orden A"),
                new TipoOrden("B", "Tipo de orden B"),
                new TipoOrden("C", "Tipo de orden C"),
                new Producto(p, "Mouse Logitech", "Mouse para pc", 100, 350),
                new Producto(p1, "Teclado Logitech", "Teclado para pc", 100, 550),
                new Producto(p, "Monitor 24'", "Monitor con HDMI", 100, 15000),
                new Producto(p1, "Auricular", "Auricular para pc", 100, 450),
                new Cliente("Alfredo", "Gutierrez", "19182020", "2246303132", "alfre.gutierrez@cliente.com"),
                new Cliente("Pedro", "Gonzales", "30333110", "2246444342", "pedro.gonzales@cliente.com"),
                new Cliente("Rodrigo", "Teta", "43040597", "2252412502", "rodri.teta@cliente.com")
        );

        manager.getTransaction().begin();
        for (Object objeto : objetosPersistir) {
            manager.persist(objeto);
        }
        manager.getTransaction().commit();

        manager.close();
    }
}

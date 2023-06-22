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
                new PuntoDeVenta(e, "Taller de reparaciones", "Taller de servicio tecnico."),
                new TipoUsuario("Vendedor", "Empleado que se encarga de la atencion al publico"),
                new TipoUsuario("Servicio Tecnico", "Empleado que se encarga de reparaciones en el area de Servicio Tecnico"),
                new TipoUsuario("Administrador", "Administrador del sistema"),
                new TipoOrden("A", "Tipo de orden A"),
                new TipoOrden("B", "Tipo de orden B"),
                new TipoOrden("C", "Tipo de orden C"),
                new Producto(p, "Mouse Logitech", "Mouse para pc", 100, 12000),
                new Producto(p1, "Teclado Logitech", "Teclado para pc", 100, 22000),
                new Producto(p, "Monitor 24'", "Monitor con HDMI", 100, 55000),
                new Producto(p1, "Auricular", "Auricular para pc", 100, 17000),
                new Producto(p, "Memoria 16GB DDR4", "Memoria RAM de 3200mhz", 20, 32000),
                new Producto(p1, "Barra de sonido", "Barra de sonido para pc", 5, 120000),
                new Producto(p, "Notebook ASUS", "Notebook para estudiantes", 5, 320000),
                new Producto(p1, "Notebook Lenovo", "Notebook para profesionales", 5, 450000),
                new Producto(p, "Joystick PC", "Joystick generico de pc", 15, 16000),
                new Producto(p1, "Disco SSD 240GB", "Disco SSD Gigabyte", 10, 24000),
                new Producto(p, "Gabinete PC", "Gabinete Corsair Carbide 400c", 5, 60000),
                new Cliente("Alfredo", "Gutierrez", "19182020", "2246303132", "alfre.gutierrez@cliente.com"),
                new Cliente("Pedro", "Gonzales", "30333110", "2246444342", "pedro.gonzales@cliente.com"),
                new Cliente("Robert John", "Downey ", "12345678", "2252412502", "ironman@cliente.com")
        );

        manager.getTransaction().begin();
        for (Object objeto : objetosPersistir) {
            manager.persist(objeto);
        }
        manager.getTransaction().commit();

        manager.close();
    }
}

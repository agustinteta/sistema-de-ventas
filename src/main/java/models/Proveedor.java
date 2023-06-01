package models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PROVEEDOR")
public class Proveedor extends Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idProveedor", updatable = false, nullable = false, unique = true)
    private int idProveedor;
    
    public Proveedor(){}
    
    public Proveedor(String nombre, String apellido, String identificacion, String celular, String correo) {
        super(nombre, apellido, identificacion, celular, correo);
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + '}';
    }
    
}

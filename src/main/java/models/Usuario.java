package models;


public class Usuario extends Persona{
    
    //atributos
    private String nombre_usuario;
    private String password;
    private TipoUsuario tipo_usuario;
    private PuntoDeVenta punto_de_venta;

    public Usuario(String nombre_usuario, String password, TipoUsuario tipo_usuario, PuntoDeVenta punto_de_venta, String nombre, String apellido, String identificacion, String celular, String correo) {
        super(nombre, apellido, identificacion, celular, correo);
        this.nombre_usuario = nombre_usuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
        this.punto_de_venta = punto_de_venta;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(TipoUsuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public PuntoDeVenta getPunto_de_venta() {
        return punto_de_venta;
    }

    public void setPunto_de_venta(PuntoDeVenta punto_de_venta) {
        this.punto_de_venta = punto_de_venta;
    }
    
    
    
}

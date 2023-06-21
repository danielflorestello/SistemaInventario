
package Modelo;

public class Usuarios {
    private int idUsuario;
    private String Nombre;
    private String Apellido;
    private int DNI;
    private String Usuario;
    private String Clave;
    private int idRol;
    private String NombreRol;

    public Usuarios() {
    }

    public Usuarios(int idUsuario, String Nombre, String Apellido, int DNI, String Usuario, String Clave, int idRol, String NombreRol) {
        this.idUsuario = idUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.idRol = idRol;
        this.NombreRol = NombreRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }
}

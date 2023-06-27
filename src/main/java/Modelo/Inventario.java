
package Modelo;

public class Inventario {
    private int idInventario;
    private double cantidadDisponible;
    private int idMercaderia;
    private String Nombre;

    public Inventario() {
    }

    public Inventario(int idInventario, double cantidadDisponible, int idMercaderia, String Nombre) {
        this.idInventario = idInventario;
        this.cantidadDisponible = cantidadDisponible;
        this.idMercaderia = idMercaderia;
        this.Nombre = Nombre;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public double getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(double cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(int idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}

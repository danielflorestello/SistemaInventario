package Modelo;

public class Mercaderia {
    private int idMercaderia;
    private String Nombre;

    public Mercaderia() {
        
    }

    public Mercaderia(int idMercaderia, String Nombre) {
        this.idMercaderia = idMercaderia;
        this.Nombre = Nombre;
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


package Modelo;

public class DetalleOperacion {
    private int idDetalle;
    private double Cantidad;
    private double Precio;
    private int idOperacion;
    private int idMercaderia;
    private String Participante;
    private double Monto;
    private String Fecha;
    private int idTipo;
    private String Nombre;

    public DetalleOperacion() {
        
    }

    public DetalleOperacion(int idDetalle, double Cantidad, double Precio, int idOperacion, int idMercaderia, String Participante, double Monto, String Fecha, int idTipo, String Nombre) {
        this.idDetalle = idDetalle;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
        this.idOperacion = idOperacion;
        this.idMercaderia = idMercaderia;
        this.Participante = Participante;
        this.Monto = Monto;
        this.Fecha = Fecha;
        this.idTipo = idTipo;
        this.Nombre = Nombre;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(int idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public String getParticipante() {
        return Participante;
    }

    public void setParticipante(String Participante) {
        this.Participante = Participante;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}

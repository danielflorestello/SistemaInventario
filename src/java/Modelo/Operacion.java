package Modelo;

public class Operacion {
    private int idOperacion;
    private String Participante;
    private double Monto;
    private String Fecha;
    private int idUsuario;
    private int idTipo;
    
    private String Nombre;
    private String nombreTipo;
    
    private int item;
    private int idMercaderia;
    private String nombreMercaderia;
    private double Precio;
    private double Cantidad;
    private double subTotal;

    public Operacion() {
        
    }

    public Operacion(int idOperacion, String Participante, double Monto, String Fecha, int idUsuario, int idTipo, String Nombre, String nombreTipo, int item, int idMercaderia, String nombreMercaderia, double Precio, double Cantidad, double subTotal) {
        this.idOperacion = idOperacion;
        this.Participante = Participante;
        this.Monto = Monto;
        this.Fecha = Fecha;
        this.idUsuario = idUsuario;
        this.idTipo = idTipo;
        this.Nombre = Nombre;
        this.nombreTipo = nombreTipo;
        this.item = item;
        this.idMercaderia = idMercaderia;
        this.nombreMercaderia = nombreMercaderia;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.subTotal = subTotal;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(int idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public String getNombreMercaderia() {
        return nombreMercaderia;
    }

    public void setNombreMercaderia(String nombreMercaderia) {
        this.nombreMercaderia = nombreMercaderia;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
}

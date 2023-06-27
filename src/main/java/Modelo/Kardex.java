package Modelo;

public class Kardex {
    private int idKardex;
    private int idMercaderia;
    private String fechaIngreso;
    private double Ingreso;
    private String fechaSalida;
    private double Salida;
    private double Saldo;
    
    private String Nombre;

    public Kardex() {
        
    }

    public Kardex(int idKardex, int idMercaderia, String fechaIngreso, double Ingreso, String fechaSalida, double Salida, double Saldo, String Nombre) {
        this.idKardex = idKardex;
        this.idMercaderia = idMercaderia;
        this.fechaIngreso = fechaIngreso;
        this.Ingreso = Ingreso;
        this.fechaSalida = fechaSalida;
        this.Salida = Salida;
        this.Saldo = Saldo;
        this.Nombre = Nombre;
    }

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public int getIdMercaderia() {
        return idMercaderia;
    }

    public void setIdMercaderia(int idMercaderia) {
        this.idMercaderia = idMercaderia;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getIngreso() {
        return Ingreso;
    }

    public void setIngreso(double Ingreso) {
        this.Ingreso = Ingreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getSalida() {
        return Salida;
    }

    public void setSalida(double Salida) {
        this.Salida = Salida;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}

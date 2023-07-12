
package Modelo;

public class Calculo {
    private double totalCosto;
    private double totalIngreso;
    private double totalGanancia;
    
    private String Fecha;
    private String Nombre;
    private double margenBruto;
    private double rotacion;
    
    public Calculo() {
        
    }

    public Calculo(double totalCosto, double totalIngreso, double totalGanancia, String Fecha, String Nombre, double margenBruto, double rotacion) {
        this.totalCosto = totalCosto;
        this.totalIngreso = totalIngreso;
        this.totalGanancia = totalGanancia;
        this.Fecha = Fecha;
        this.Nombre = Nombre;
        this.margenBruto = margenBruto;
        this.rotacion = rotacion;
    }

    public double getTotalCosto() {
        return totalCosto;
    }

    public void setTotalCosto(double totalCosto) {
        this.totalCosto = totalCosto;
    }

    public double getTotalIngreso() {
        return totalIngreso;
    }

    public void setTotalIngreso(double totalIngreso) {
        this.totalIngreso = totalIngreso;
    }

    public double getTotalGanancia() {
        return totalGanancia;
    }

    public void setTotalGanancia(double totalGanancia) {
        this.totalGanancia = totalGanancia;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public double getMargenBruto() {
        return margenBruto;
    }

    public void setMargenBruto(double margenBruto) {
        this.margenBruto = margenBruto;
    }

    public double getRotacion() {
        return rotacion;
    }

    public void setRotacion(double rotacion) {
        this.rotacion = rotacion;
    }
    
    
}

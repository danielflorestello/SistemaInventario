package Modelo;

public class Calculo {
    private double totalCosto;
    private double totalIngreso;
    private double totalGanancia;

    public Calculo() {
        
    }

    public Calculo(double totalCosto, double totalIngreso, double totalGanancia) {
        this.totalCosto = totalCosto;
        this.totalIngreso = totalIngreso;
        this.totalGanancia = totalGanancia;
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
}

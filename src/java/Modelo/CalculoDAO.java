package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public double totalCosto() {
        double totalCosto = 0;
        
        String sql = "CALL totalCosto()";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                totalCosto = rs.getDouble(1);
                System.out.println(totalCosto);
            }
            
        } catch (SQLException e) {
        }
        return totalCosto;
    }
    
    public double totalIngresos() {
        double totalIngresos = 0;
        
        String sql = "CALL totalIngresos()";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {     
                totalIngresos = rs.getDouble(1);
            }
            
        } catch (SQLException e) {
        }
        return totalIngresos;
    }
    
    public double totalGanancia() {
        double totalGanancia;
        
        totalGanancia = totalIngresos() - totalCosto();
        
        return totalGanancia;
    }
    
    public double margenBruto() {
        return 0;  
    }
    
    public static void main(String[] args) {
        CalculoDAO c = new CalculoDAO();
        c.totalCosto();
    }
}

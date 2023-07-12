package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public List margenBruto() {
        String sql = "CALL margenBruto()";
        
        List<Calculo> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {     
                Calculo c = new Calculo();
                c.setNombre(rs.getString("Nombre"));
                c.setFecha(rs.getString("Mes"));
                c.setMargenBruto(rs.getDouble("margenBruto"));
                lista.add(c);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
    
    public List rotacionInventario() {
        String sql = "CALL rotacionInventario()";
        
        List<Calculo> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {     
                Calculo c = new Calculo();
                c.setNombre(rs.getString("Nombre"));
                c.setFecha(rs.getString("Mes"));
                c.setRotacion(rs.getDouble("rotacion"));
                lista.add(c);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
}

package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KardexDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarKardex() {
        String sql = "select * from kardex";
        
        List<Kardex> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                Kardex k = new Kardex();
                k.setIdKardex(rs.getInt(1));
                k.setIdMercaderia(rs.getInt(2));
                k.setFechaIngreso(rs.getString(3));
                k.setIngreso(rs.getDouble(4));
                k.setFechaSalida(rs.getString(5));
                k.setSalida(rs.getDouble(6));
                k.setSaldo(rs.getDouble(7));
                lista.add(k);
            }
            
        } catch (SQLException e) {
            
        }       
        return lista;
    }
    
    public String idKardex(int id) {
        String sql = "CALL idKardex(?)";
        
        String idKardex = "";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                idKardex = rs.getString(1);
            }
        } catch (SQLException e) {

        }
        return idKardex;
    }
    
    public String saldoActual(int id) {
        String sql = "CALL saldoActual(?)";
        
        String saldoActual = "";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                saldoActual = rs.getString(1);
            }
        } catch (SQLException e) {

        }
        return saldoActual;
    }
    
    public int insertarKardex(Kardex k) {
        String sql = "CALL insertarKardex(?, ?, ?, ?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, k.getIdMercaderia());
            ps.setString(2, k.getFechaIngreso());
            ps.setDouble(3, k.getIngreso());
            ps.setDouble(4, k.getSaldo());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        
        return r;
    }
    
    public int actualizarKardex(Kardex k) {
        String sql = "CALL actualizarKardex(?, ?, ?, ?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, k.getIdKardex());
            ps.setString(2, k.getFechaSalida());
            ps.setDouble(3, k.getSalida());
            ps.setDouble(4, k.getSaldo());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        
        return r;
    }
}

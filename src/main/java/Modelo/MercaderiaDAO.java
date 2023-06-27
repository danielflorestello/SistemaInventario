package Modelo;

import Config.Conexion;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MercaderiaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public List listarMercaderia() {
        String sql = "CALL listarMercaderia()";
        
        List<Mercaderia> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Mercaderia m = new Mercaderia();
                m.setIdMercaderia(rs.getInt(1));
                m.setNombre(rs.getString(2));
                lista.add(m);
            }
            
        } catch (SQLException e) {
            
        }
        return lista;
    }
    
    public String nombreMercaderia(int idMercaderia) {
        String nombreMercaderia = "";
        String sql = "CALL nombreMercaderia(?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idMercaderia);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                nombreMercaderia = rs.getString(1);
            }
            
        } catch (SQLException e) {
            
        }
        return nombreMercaderia;
    }
}

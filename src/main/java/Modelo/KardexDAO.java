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
    
    
}

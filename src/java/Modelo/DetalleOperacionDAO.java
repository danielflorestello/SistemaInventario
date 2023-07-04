package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DetalleOperacionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    DetalleOperacion de;
    
    public List listarDetalle(int idTipo) {
        String sql = "CALL listarDetalle(?)";
        
        List<DetalleOperacion> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, idTipo);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                de = new DetalleOperacion();
                de.setIdDetalle(rs.getInt(1));
                de.setCantidad(rs.getDouble(2));
                de.setPrecio(rs.getDouble(3));
                de.setSubTotal(rs.getDouble(4));
                de.setIdOperacion(rs.getInt(5));
                de.setIdMercaderia(rs.getInt(6));
                de.setParticipante(rs.getString(7));
                de.setMonto(rs.getDouble(8));
                de.setFecha(rs.getString(9));
                de.setIdTipo(rs.getInt(10));
                de.setNombre(rs.getString(11));
                lista.add(de);
            }
            
        } catch (SQLException e) {
            
        }
        
        return lista;
    }
    
    public int agregarDetalleOperacion(DetalleOperacion de) {
        String sql = "CALL agregarDetalleOperacion(?, ?, ?, ?, ?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setDouble(1, de.getCantidad());
            ps.setDouble(2, de.getPrecio());
            ps.setDouble(3, de.getSubTotal());
            ps.setInt(4, de.getIdOperacion());
            ps.setInt(5, de.getIdMercaderia());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        
        return r;
    }
    
    public void eliminarDetalle(int idOperacion) {
        String sql = "CALL eliminarDetalle(?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setInt(1, idOperacion);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
    }
}

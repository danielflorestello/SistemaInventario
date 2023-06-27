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
                de.setIdOperacion(rs.getInt(4));
                de.setIdMercaderia(rs.getInt(5));
                de.setParticipante(rs.getString(6));
                de.setMonto(rs.getDouble(7));
                de.setFecha(rs.getString(8));
                de.setIdTipo(rs.getInt(9));
                de.setNombre(rs.getString(10));
                lista.add(de);
            }
            
        } catch (SQLException e) {
            
        }
        
        return lista;
    }
    
    public int agregarDetalleOperacion(DetalleOperacion de) {
        String sql = "CALL agregarDetalleOperacion(?, ?, ?, ?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setDouble(1, de.getCantidad());
            ps.setDouble(2, de.getPrecio());
            ps.setInt(3, de.getIdOperacion());
            ps.setInt(4, de.getIdMercaderia());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        
        return r;
    }
}

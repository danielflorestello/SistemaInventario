package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public Usuarios validar(String Usuario, String Clave) {
        Usuarios u = new Usuarios();
        
        String sql = "CALL validarUsuario(?, ?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareCall(sql);
            ps.setString(1, Usuario);
            ps.setString(2, Clave);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                u.setIdUsuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setDNI(rs.getInt(4));
                u.setUsuario(rs.getString(5));
                u.setClave(rs.getString(6));
                u.setIdRol(rs.getInt(7));
                u.setNombreRol(rs.getString(8));
            }
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return u;
    }
}

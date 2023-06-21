package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperacionDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    Operacion o;
    
    public List listarOperacion(int idTipo) {
        String sql = "select O.idOperacion, O.Participante, O.Monto, O.Fecha, O.idUsuario, O.idTipo,"
                + " U.Nombre, T.nombreTipo"
                + " from operacion O"
                + " inner join usuarios U on U.idUsuario = O.idUsuario"
                + " inner join tipo_operacion T on T.idTipo = O.idTipo"
                + " where O.idTipo=" +idTipo;
        
        List<Operacion> lista = new ArrayList<>();
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                o = new Operacion();
                o.setIdOperacion(rs.getInt(1));
                o.setParticipante(rs.getString(2));
                o.setMonto(rs.getDouble(3));
                o.setFecha(rs.getString(4));
                o.setIdUsuario(rs.getInt(5));
                o.setIdTipo(rs.getInt(6));
                o.setNombre(rs.getString(7));
                o.setNombreTipo(rs.getString(8));
                lista.add(o);
            }
            
        } catch (SQLException e) {
            
        }
        
        return lista;
    }
    
    public String idOperacion() {
        String idOperacion = "";
        String sql = "select max(idOperacion) from operacion";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                idOperacion = rs.getString(1);
            }
            
        } catch (SQLException e) {
            
        }
        return idOperacion;
    }
    
    public int agregarOperacion(Operacion op) {
        String sql = "insert into operacion(Participante, Monto, Fecha, idUsuario, idTipo) values (?,?,?,?,?)";
        
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, op.getParticipante());
            ps.setDouble(2, op.getMonto());
            ps.setString(3, op.getFecha());
            ps.setInt(4, op.getIdUsuario());
            ps.setInt(5, op.getIdTipo());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            
        }
        return r;
    }
    
}

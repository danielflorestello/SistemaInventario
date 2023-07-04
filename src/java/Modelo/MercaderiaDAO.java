package Modelo;

import Config.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class MercaderiaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    CallableStatement cs;
    int r;

    public List listarMercaderia() {
        String sql = "CALL listarMercaderia()";

        List<Mercaderia> lista = new ArrayList<>();

        try {
            con = cn.Conexion();
            cs = con.prepareCall(sql);
            rs = cs.executeQuery();

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
        String sql = "CALL nombreMercaderia(?, ?)";
        String nombreMercaderia = "";

        try {
            con = cn.Conexion();
            cs = con.prepareCall(sql);
            cs.setInt(1, idMercaderia);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.executeQuery();
            
            nombreMercaderia = cs.getString(2);

        } catch (SQLException e) {

        }
        return nombreMercaderia;
    }
    
}

package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    public Connection Conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_inventario","root","");
            System.out.println("Conexion exitosa");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR " +e);
        }
        return con;
    }
}

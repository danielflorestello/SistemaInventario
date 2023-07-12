package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    public Connection Conexion(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://blouol3ohheo3l2jf0kj-mysql.services.clever-cloud.com:3306/blouol3ohheo3l2jf0kj", "uupse590majkctuz", "SH3yTKOVdDfPaFTdweI9");
            System.out.println("Conexion exitosa");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ERROR " +e);
        }
        return con;
    }
    
}

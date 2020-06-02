package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Inserciones {
    public Inserciones(){
        
    }
    
    public Boolean InsercionEmpleado() throws SQLException{
        Conectar con;
        con = new Conectar();
        Connection conn = con.getConnection();
        Statement s = conn.createStatement();        
        s.executeUpdate("INSERT INTO `prueba` (`Nombre`) VALUES ('Ana')");
        
        return false;
    }
}

package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    
    
    public Consultas(){
        
    }
    
    public Boolean ConsultaLogIn(String Usuario, String Password){
        
        System.out.print(Usuario + " " + Password);
        Conectar con;
        con = new Conectar();
        
        Connection conn = con.getConnection();
        
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT * FROM `empleado` WHERE `Correo` = '" + Usuario + "' AND `Password` = '" + Password + "' ");
            while (rs.next())
            {
                System.out.println (rs.getString(1) + rs.getNString(2));
            }
        }catch(SQLException e){
            System.out.println("Error "+e);
        }
        return false;
    }
    
}

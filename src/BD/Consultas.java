package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    
    Conectar con;
    Connection conn;
    public Consultas(){
        con = new Conectar();
        conn = con.getConnection();
    }
    
    public int ConsultaLogIn(String Usuario, String Password){
        
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT id_Empleado FROM `empleado` WHERE `id_Empleado` = '" + Usuario + "' AND `Password` = '" + Password + "' ");
            
            if(rs.next() == false){
                return 0;
            }else
                return rs.getInt("id_Empleado"); 
        }catch(SQLException e){
            System.out.println("Error "+e);
            return 0;
        }
    }
    
}

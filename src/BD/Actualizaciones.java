package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actualizaciones {

    Conectar con;
    Connection conn;

    public Actualizaciones() {
        con = new Conectar();
        conn = con.getConnection();
    }

    public boolean ActInv(String IdProd){
        try {
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery("SELECT Inventario "
                               +"FROM producto "
                               +"WHERE id_Producto = '"+IdProd+"' ");

            if (rs.next()) {
                
                int inv = rs.getInt("Inventario");
                if(inv <= 0)
                    return false;
                int x;
                x = s.executeUpdate("UPDATE `producto` "
                                   +"SET `Inventario` = '"+inv+"' "
                                   +"WHERE `producto`.`id_Producto` = '"+IdProd+"'");
                if (x == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }
    }
}

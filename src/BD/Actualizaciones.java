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

    public int ActInv(String IdProd, int cant){
        try {
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery("SELECT Inventario "
                               +"FROM producto "
                               +"WHERE id_Producto = '"+IdProd+"' ");

            if (rs.next()) {
                
                int inv = rs.getInt("Inventario") - cant;
                if(inv < 0 )
                    return 1;
                int x;
                x = s.executeUpdate("UPDATE `producto` "
                                   +"SET `Inventario` = '"+inv+"' "
                                   +"WHERE `producto`.`id_Producto` = '"+IdProd+"'");
                if (x == 1) {
                    return 0;
                } else {
                    return 2;
                }
            } else {
                return 2;
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 2;
        }
    }
    
    public Boolean ActVendedor(String IdUsuario, String fecha, int horaExtra, int ventas){
        try {
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery("SELECT Horas_laboradas "
                               +"FROM vendedor "
                               +"WHERE id_Empleado = '"+IdUsuario+"' AND fecha = '"+fecha+"' ");

            if (rs.next()) {
                int horas = rs.getInt("Horas_laboradas") + horaExtra;
                int x;
                x = s.executeUpdate("UPDATE `vendedor` "
                                   +"SET `Ventas` = '"+ventas+"', `Horas_laboradas` = '"+horas+"' "
                                   +"WHERE `vendedor`.`id_Empleado` = '"+IdUsuario+"' AND `vendedor`.`fecha` = '"+fecha+"'");
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
    
    public Boolean ActGerente(String IdUsuario, String fecha, int horaExtra){
        try {
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery("SELECT Horas_laboradas "
                               +"FROM gerente "
                               +"WHERE id_Empleado = '"+IdUsuario+"' AND fecha = '"+fecha+"' ");

            if (rs.next()) {
                int horas = rs.getInt("Horas_laboradas") + horaExtra;
                int x;
                x = s.executeUpdate("UPDATE `gerente` \n" +
                                    "SET `Horas_laboradas` = '"+horas+"' \n" +
                                    "WHERE `gerente`.`id_Empleado` = '"+IdUsuario+"' AND `gerente`.`fecha` = '"+fecha+"';");
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

package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Altas {

    Conectar con;
    Connection conn;

    public Altas() {
        con = new Conectar();
        conn = con.getConnection();
    }

    public Boolean InsertProd(String Id_Producto, String Descripcion, float Costo, int Inventario, String Fecha_ult_compra, String id_Proveedor, String Fecha_caducidad, String subcategoría) {
        try {
            Statement s = conn.createStatement();
            int x;
            x = s.executeUpdate("INSERT INTO producto (id_Producto, Descripcion, Costo, Inventario, Fecha_ult_compra, id_Proveedor, Fecha_caducidad, subcategoría) "
                    + "VALUES ('" + Id_Producto + "', '" + Descripcion + "', " + Costo + ", " + Inventario + ", '" + Fecha_ult_compra + "', '" + id_Proveedor + "', '" + Fecha_caducidad + "', '" + subcategoría + "')");
            if (x == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean InsertGer(String Id_Gerente) {
        try {
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery("SELECT empleado.id_Empleado\n" +
                                "from empleado\n" +
                                "WHERE empleado.id_Empleado = '"+Id_Gerente+"'");

            if (rs.next()) {
                int x;
                x = s.executeUpdate("INSERT INTO `gerente` (`id_Empleado`, `Horas_laboradas`) "
                                   +"VALUES ('"+Id_Gerente+"', '0')");
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
    
    public Boolean InsertEmp(String id_Empleado, String	Nombre, String Telefono, String Correo, char Turno, String Puesto, String Fecha_ingreso, String	Password) {
        try {
            Statement s = conn.createStatement();
                int x;
                x = s.executeUpdate("INSERT INTO `empleado` (`id_Empleado`, `Nombre`, `Telefono`, `Correo`, `Turno`, `Puesto`, `Fecha_ingreso`, `Password`) "
                                   +"VALUES ('"+id_Empleado+"', '"+Nombre+"', '"+Telefono+"', '"+Correo+"', '"+Turno+"', '"+Puesto+"', '"+Fecha_ingreso+"', '"+Password+"')");
                if (x == 1) {
                    return true;
                } else {
                    return false;
                }
            
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }
    }
    
    public Boolean InsertProv(String id_Proveedor, String Nombre, String Correo, String	Telefono) {
        try {
            Statement s = conn.createStatement();
                int x;
                x = s.executeUpdate("INSERT INTO `proveedor` (`id_Proveedor`, `Nombre`, `Correo`, `Telefono`) "
                                   +"VALUES ('"+id_Proveedor+"', '"+Nombre+"', '"+Correo+"', '"+Telefono+"')");
                if (x == 1) {
                    return true;
                } else {
                    return false;
                }
            
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return false;
        }
    }
    
    public boolean InsertVenta(String IdUsuario, String IdProd, int cant, float total){
        
        try {
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery("SELECT MAX(id_Venta) FROM venta");

            if (rs.next()) {
                int x;
                String cadena = rs.getString("MAX(id_Venta)");
                String subcadena = cadena.substring(2, cadena.length());
                int idVenta = Integer.parseInt(subcadena) + 1;
                x = s.executeUpdate("INSERT INTO `venta` (`id_Venta`, `id_Empleado`, `id_Producto`, `Cantidad`, `Total`) "
                                   +"VALUES ('VL0"+idVenta+"', '"+IdUsuario+"', '"+IdProd+"', '"+cant+"', '"+total+"')");
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

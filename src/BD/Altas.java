package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Altas {
    
    Conectar con;
    Connection conn;
    
    public Altas(){
        con = new Conectar();
        conn = con.getConnection();
    }
    
    public Boolean InsertProd(String Id_Producto,String Descripcion, float Costo, int Inventario, String Fecha_ult_compra, String id_Proveedor, String Fecha_caducidad, String subcategoría){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("INSERT INTO producto (id_Producto, Descripcion, Costo, Inventario, Fecha_ult_compra, id_Proveedor, Fecha_caducidad, subcategoría) "
                            + "VALUES ('"+Id_Producto+"', '"+Descripcion+"', "+Costo+", "+Inventario+", '"+Fecha_ult_compra+"', '"+id_Proveedor+"', '"+Fecha_caducidad+"', '"+subcategoría+"')");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
}

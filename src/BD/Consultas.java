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
    
    public String ConsultaLogIn(String Usuario, String Password){
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT id_Empleado FROM `empleado` WHERE `id_Empleado` = '" + Usuario + "' AND `Password` = '" + Password + "' ");
            
            if(rs.next() == false){
                return "404-Not";
            }else
                return rs.getString("id_Empleado"); 
        }catch(SQLException e){
            System.out.println("Error "+e);
            return "404-Not";
        }
    }
    
    public String ConsultarNombreGerente(String IdUsuario){
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT Nombre FROM `empleado` WHERE `id_Empleado` = '"+IdUsuario+"' ");
            
            if(rs.next() == false){
                return "Sin nombre";
            }else
                return rs.getString("Nombre"); 
        }catch(SQLException e){
            System.out.println("Error "+e);
            return "Sin nombre";
        }
    }
    
    public ResultSet ConsultarProdProv(String IdProvProd){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("select proveedor.id_Proveedor, proveedor.Nombre, producto.Descripcion, proveedor.Telefono\n" +
"from producto inner join  proveedor on producto.id_Proveedor = proveedor.id_Proveedor\n" +
"where proveedor.id_Proveedor = '"+IdProvProd+"' OR producto.id_Producto = '"+IdProvProd+"'");
            
            return rs;
            /*if(rs.next() == false){
                return "Sin nombre";
            }else{
                System.out.println(rs.getString("proveedor.id_Proveedor")+rs.getString("proveedor.Nombre")+rs.getString("producto.Descripcion")+rs.getString("proveedor.Telefono"));
                 
            }*/
                
        }catch(SQLException e){
            System.out.println("Error "+e);
            return rs;
        }
        
    }
    
}

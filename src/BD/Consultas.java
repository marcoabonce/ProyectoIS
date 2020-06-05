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
    
    public String ConsultaLogInGerente(String Usuario, String Password){
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT empleado.id_Empleado\n" +
"from empleado INNER JOIN gerente ON empleado.id_Empleado = gerente.id_Empleado\n" +
"where empleado.id_Empleado = '"+Usuario+"' AND empleado.Password = '"+Password+"' ");
            
            if(rs.next() == false){
                return "404-Not";
            }else
                return rs.getString("empleado.id_Empleado"); 
        }catch(SQLException e){
            System.out.println("Error "+e);
            return "404-Not";
        }
    }
    
    public String ConsultarNombreEmpleado(String IdUsuario){
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
    
    public String ConsultaLogInAdmin(String Usuario, String Password){
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT empleado.id_Empleado\n" +
                                 "from empleado\n" +
                                 "where empleado.id_Empleado = '"+Usuario+"' AND empleado.Password = '"+Password+"' AND empleado.Puesto = 'Admin'");
            
            if(rs.next() == false){
                return "404-Not";
            }else
                return rs.getString("empleado.id_Empleado"); 
        }catch(SQLException e){
            System.out.println("Error "+e);
            return "404-Not";
        }
    }
    
    public ResultSet ConsultarAllProd(){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("select *\n" +
                                 "from producto \n");
            
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
    
    public ResultSet ConsultarProd(String IdProd){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("select *\n" +
                                 "from producto "+
                                 "where id_Producto = '"+IdProd+"'\n");
            
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
    
    public ResultSet ConsultarAllGer(){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("SELECT empleado.id_Empleado, empleado.Nombre, empleado.Telefono\n" +
                                 "FROM gerente INNER JOIN empleado on gerente.id_Empleado = empleado.id_Empleado");
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
    
    public ResultSet ConsultarGer(String IdGer){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("SELECT empleado.id_Empleado, empleado.Nombre, empleado.Telefono "
                    + "FROM gerente INNER JOIN empleado on gerente.id_Empleado = empleado.id_Empleado "
                    + "WHERE empleado.id_Empleado = '"+IdGer+"' ");
            
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

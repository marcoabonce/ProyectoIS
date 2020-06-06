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
    
    public ResultSet ConsultarAllEmp(){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("SELECT id_Empleado, Nombre, Telefono\n" +
                                 "FROM empleado");
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
    
    public ResultSet ConsultarEmp(String IdEmp){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("SELECT id_Empleado, Nombre, Telefono "
                                +"FROM empleado "
                                +"WHERE empleado.id_Empleado = '"+IdEmp+"' ");
            
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
    
    public ResultSet ConsultarAllProv(){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("SELECT proveedor.id_Proveedor, proveedor.Nombre, producto.Descripcion, proveedor.Telefono\n" +
                                 "FROM proveedor LEFT JOIN producto ON proveedor.id_Proveedor = producto.id_Proveedor\n" +
                                 "ORDER BY proveedor.id_Proveedor");
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
    
    public ResultSet ConsultarProv(String IdProv){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            
            rs = s.executeQuery ("SELECT proveedor.id_Proveedor, proveedor.Nombre, producto.Descripcion, proveedor.Telefono\n" +
                                 "FROM proveedor LEFT JOIN producto ON proveedor.id_Proveedor = producto.id_Proveedor"
                                +"WHERE proveedor.id_Proveedor = '"+IdProv+"' ");
            
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
    
    public String ConsultaLogInEmpleado(String Usuario, String Password){
        try{
            Statement s = conn.createStatement();
            ResultSet rs;
            rs = s.executeQuery ("SELECT id_Empleado\n" +
                                 "from empleado\n" +
                                 "where id_Empleado = '"+Usuario+"' AND Password = '"+Password+"'");
            
            if(rs.next() == false){
                return "404-Not";
            }else
                return rs.getString("id_Empleado"); 
        }catch(SQLException e){
            System.out.println("Error "+e);
            return "404-Not";
        }
    }
    
    public ResultSet ConsultaVentaProd(String IdProd){
        ResultSet rs = null;
        try{
            Statement s = conn.createStatement();
            rs = s.executeQuery ("SELECT id_Producto, Descripcion, Costo "
                                +"FROM producto "
                                +"WHERE id_Producto = '"+IdProd+"' ");
            
            return rs;
        }catch(SQLException e){
            System.out.println("Error "+e);
            return rs;
        }
    }
    
}

package BD;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bajas {
    
    Conectar con;
    Connection conn;
    
    public Bajas(){
        con = new Conectar();
        conn = con.getConnection();
    }
    
    public Boolean DeleteProd(String Id_Producto){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `producto` WHERE `producto`.`id_Producto` = '"+Id_Producto+"'");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteAllProd(){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `producto`");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteGer(String Id_Gerente){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `gerente` WHERE `gerente`.`id_Empleado` = '"+Id_Gerente+"'");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteAllGer(){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `gerente`");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteEmp(String Id_Empleado){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `empleado` WHERE `id_Empleado` = '"+Id_Empleado+"'");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteAllEmp(){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `empleado`");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteProv(String Id_Proveedor){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `proveedor` WHERE `id_Proveedor` = '"+Id_Proveedor+"'");
            if(x == 1)
                return true;
            else 
                return false;
        }catch(SQLException e){
            System.out.println(e);
            return false;
        }
    }
    
    public Boolean DeleteAllProv(){
        try{
            Statement s = conn.createStatement();        
            int x;
            x = s.executeUpdate("DELETE FROM `proveedor`");
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


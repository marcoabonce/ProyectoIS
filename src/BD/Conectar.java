package BD;


import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
/**
 *
 * @author PC
 */
public class Conectar {
    
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/tienda";
    
    public Conectar(){
        conn = null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if(conn != null){
                //System.out.println("Conexion Establecida");
            }
            
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error al conectar "+e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void Desconectar(){
        conn = null;
        if(conn == null){
            System.out.println("Conexion terminada");
        }
    }
}
    


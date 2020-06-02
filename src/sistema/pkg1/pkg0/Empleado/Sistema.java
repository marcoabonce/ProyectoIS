package sistema.pkg1.pkg0.Empleado;

import BD.Conectar;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sistema {
     public static void main(String[] args) throws SQLException {     
        
        Empleado e1 = new Empleado();
        e1.setVisible(false); //cambie los colores
        
        AvCerrarSesión2 Av1 = new AvCerrarSesión2();
        Av1.setVisible(false);
        
        InicioEmpleado e2 = new InicioEmpleado();
        e2.setVisible(false);
        
        Pedido P1 = new Pedido();
        P1.setVisible(false);
        
        AvEliminar Av2 = new AvEliminar();
        Av2.setVisible(false);
        
        AvTerminarPedido Av3 = new AvTerminarPedido();
        Av3.setVisible(false);
        
        Terminar Av4 = new Terminar();
        Av4.setVisible(false);
        
        AvCobrar Av5 = new AvCobrar();
        Av5.setVisible(false);
       
    }
}

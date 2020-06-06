package sistema.pkg1.pkg0.Empleado;

import sistema.pkg1.pkg0.*;
import BD.Consultas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class DatosProveedor extends JFrame implements ActionListener{
    
    public JPanel panel, panel2;
    String IdProdProv;
    JButton boton1;
    Consultas con;
    
    public DatosProveedor(String IdProdProv){
        this.IdProdProv = IdProdProv;
        this.setSize(500,400); //Establecemos el tamañno de la ventana (b,h)
        this.setTitle("Datos");//poner titulo
        this.setLocationRelativeTo(null);//establecemos la ventana en el centro de la pantalla
        this.setResizable(false);//la ventana puede cambiar de tamaño o no 
        Componente();        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE); /*Que hacer al cerrar la ventanta
                                                        (DO_NOTHING_ON_CLOSE/HIDE_ON_CLOSE
                                                        /DISPOSE_ON_CLOSE/EXIT_ON_CLOSE)*/
       
    }
    
    private void Componente(){
        Paneles();
        Labels();
        Tabla();
        BOTON();
               
        
    }

    private void Paneles() {
        panel = new JPanel(); //creación de un panel
        panel.setLayout(null);//desactivar el diseño predeterminado
        this.getContentPane().add(panel); //agregamos el panel a la ventana 
        panel.setBackground(new java.awt.Color(250, 250, 210));//establecemos el color del panel
    }

    private void Labels() {
        //Etiqueta tipo texto
        JLabel name = new JLabel(); //creación de una etiqueta
        name.setBounds(150, 0, 200, 35);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("Datos de Proveedor"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.black);//cambiar color de letra
        name.setBackground(new java.awt.Color(250, 250, 210));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", 1, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel
    }
    
    private void Tabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Producto");
        modelo.addColumn("Contacto");
        
        con = new Consultas();
        ResultSet rs = con.ConsultarProdProv(IdProdProv);
        try{
            while(rs.next()){
                System.out.println(rs.getString("proveedor.id_Proveedor")+rs.getString("proveedor.Nombre")+rs.getString("producto.Descripcion")+rs.getString("proveedor.Telefono"));
                String [] producto1 = {rs.getString("proveedor.id_Proveedor"), rs.getString("proveedor.Nombre"), rs.getString("producto.Descripcion"), rs.getString("proveedor.Telefono")};
                modelo.addRow(producto1);
            }
        }catch(SQLException e){
            
        }
               
        //String [] producto1 = {"00", "XXX", "XXX", "55 XXXXX"};
        
        //modelo.addRow(producto1);
        
        JTable tabla = new JTable(modelo);  
        
        tabla.setBounds(50, 50, 400, 200 );
        panel.add(tabla);
        
        JScrollPane scroll = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(50, 50, 400, 200 );
        panel.add(scroll);
    }
    
    private void BOTON() {
        //Boton de texto
        boton1 = new JButton();
        boton1.setText("Aceptar");//establecemos texto al boton
        boton1.setBounds(150, 300, 200, 50);//posición y tamaño boton
        boton1.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton1.setFont(new Font("chiller", Font.ITALIC, 20));//establecemos fuente, tipo y tamaño de letra del boton
        panel.add(boton1);//agregar boton al panel
        boton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            this.dispose();
        }
    }
   
}

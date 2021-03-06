package sistema.pkg1.pkg0;


import BD.Consultas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class InicioGerente extends JFrame implements ActionListener{
    
    public JPanel panel, panel2;
    String IdUsuario;
    Consultas con;
    JTextArea areaTexto;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    JButton boton6;
    int horaInicio;
    
    
    public InicioGerente(String IdUsuario, int horaInicio){
        this.horaInicio = horaInicio;
        this.setTitle("Sistema 1.0");//poner titulo
        this.setResizable(true);//la ventana puede cambiar de tamaño o no 
        this.setExtendedState(MAXIMIZED_BOTH);//Maximizar ventana automaticamente
        //this.getContentPane().setBackground(Color.blue);//color de la ventana
        Componente();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); /*Que hacer al cerrar la ventanta
                                                        (DO_NOTHING_ON_CLOSE/HIDE_ON_CLOSE
                                                        /DISPOSE_ON_CLOSE/EXIT_ON_CLOSE)*/
        this.IdUsuario = IdUsuario;
        con = new Consultas();
        areaTexto.setText(con.ConsultarNombreEmpleado(IdUsuario));
    }
    
    private void Componente(){
        Paneles();
        Labels();
        AreadeTexto();
        Boton();
    }

    private void Paneles() {
        panel = new JPanel(); //creación de un panel
        panel.setLayout(null);//desactivar el diseño predeterminado
        this.getContentPane().add(panel); //agregamos el panel a la ventana 
        panel.setBackground(new java.awt.Color(255, 99, 71));//establecemos el color del panel
        
        panel2 = new JPanel(); //creación de un panel
        panel2.setLayout(null);//desactivar el diseño predeterminado
        panel2.setBackground(new java.awt.Color(255, 140, 0));//establecemos el color del panel
        panel2.setBounds( 0, 50, 2000, 600 );
        panel.add(panel2);
    }

    private void Labels() {
        //Etiqueta tipo texto
        JLabel name = new JLabel(); //creación de una etiqueta
        name.setBounds(0, 0, 150, 35);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("Inicio Gerente"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.black);//cambiar color de letra
        name.setBackground(new java.awt.Color(255, 99, 71));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel
        
        //Etiqueta tipo Imagen
        ImageIcon imagen = new ImageIcon("Imagenes/Gerente.png");//definir la imagen
        JLabel icon = new JLabel(); //agregar una imagen
        icon.setBounds(50, 50, 100 , 100);
        icon.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH))); //imagen escalada (ancho, alto, tipo de escalado)
        panel2.add(icon);
    }
    
    private void AreadeTexto() {
        areaTexto = new JTextArea(); //instanciamos area de texto
        areaTexto.setBounds(170 , 50, 300, 35);
        areaTexto.setText("Sin nombre");
        areaTexto.setEditable(false);//permiso de editar contenido
        areaTexto.setBackground(new java.awt.Color(255, 140, 0));
        areaTexto.setFont(new Font("arial", 1, 20));
        panel2.add(areaTexto);
    }
    
    private void Boton() {
        //Boton de texto
        boton1 = new JButton();
        boton1.setText("Home");//establecemos texto al boton
        boton1.setBounds(1090, 10, 100, 30);//posición y tamaño boton
        boton1.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton1.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton1);//agregar boton al panel
        boton1.addActionListener(this);
        
        boton2 = new JButton();
        boton2.setText("Cerrar Sesión");//establecemos texto al boton
        boton2.setBounds(1200, 10, 150, 30);//posición y tamaño boton
        boton2.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton2.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton2);//agregar boton al panel
        boton2.addActionListener(this);
        
        boton3 = new JButton();
        boton3.setText("Consultar stock");//establecemos texto al boton
        boton3.setBounds(520, 205, 300, 30);//posición y tamaño boton
        boton3.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton3.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton3);//agregar boton al panel
        boton3.addActionListener(this);
        
        boton4 = new JButton();
        boton4.setText("Consultar ventas del día");//establecemos texto al boton
        boton4.setBounds(520, 255, 300, 30);//posición y tamaño boton
        boton4.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton4.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton4);//agregar boton al panel
        boton4.addActionListener(this);
        
        boton5 = new JButton();
        boton5.setText("Consultar adherencia de empleados");//establecemos texto al boton
        boton5.setBounds(520, 305, 300, 30);//posición y tamaño boton
        boton5.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton5.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton5);//agregar boton al panel
        boton5.addActionListener(this);
        
        boton6 = new JButton();
        boton6.setText("Contacto Proveedor");//establecemos texto al boton
        boton6.setBounds(520, 355, 300, 30);//posición y tamaño boton
        boton6.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton6.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton6);//agregar boton al panel
        boton6.addActionListener(this);
    }
    
    //if(con.DifDias(fecha, rs.getString("Fecha_caducidad")) <= 3)
    
    public void checarInv(){
        try{
            ResultSet rs = con.ConsultarAllProd();
            while(rs.next()){
                if(rs.getInt("Inventario") <= 4){
                    AvPocoInventario Av5 = new AvPocoInventario(rs.getString("Descripcion"), rs.getString("Inventario"), rs.getString("id_Proveedor"));
                    Av5.setVisible(true);
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void checarCad(){
        try{
            Calendar cal = Calendar.getInstance(); 
            int mes = cal.get(Calendar.MONTH) +1 ;
            String fecha = cal.get(Calendar.YEAR)+"-"+mes+"-"+cal.get(Calendar.DATE);
            ResultSet rs = con.ConsultarAllProd();
            while(rs.next()){
                if(con.DifDias(rs.getString("Fecha_caducidad"),fecha) <= 3){
                    AvCaducidad Av6 = new AvCaducidad(rs.getString("Descripcion"), rs.getString("Fecha_caducidad"), rs.getString("id_Proveedor"));
                    Av6.setVisible(true);
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            
        }else if (e.getSource() == boton2){
            AvCerrarSesión Av4 = new AvCerrarSesión(IdUsuario, this, horaInicio);
            Av4.setVisible(true);
        }else if (e.getSource() == boton3){
            AvDescargarExcelStock Av2 = new AvDescargarExcelStock();
            Av2.setVisible(true);
        }else if (e.getSource() == boton4){
            AvDescargarExcelVentas Av1 = new AvDescargarExcelVentas();
            Av1.setVisible(true);
        }else if (e.getSource() == boton5){
            AvDescargarAdherenciaEmpleados Av3 = new AvDescargarAdherenciaEmpleados();
            Av3.setVisible(true);
        }else if(e.getSource() == boton6){
            Proveedor P1 = new Proveedor(IdUsuario, horaInicio);
            P1.setVisible(true);
            this.dispose();
        }
    }
   
}   


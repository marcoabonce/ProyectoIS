package sistema.pkg1.pkg0.Admin;

import BD.Consultas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Gerentes extends JFrame implements ActionListener {
    
    public JPanel panel, panel2;
    JTextArea areaTexto;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    JButton boton6;
    String IdUsuario;
    Consultas con;
    
    public Gerentes(String IdUsuario){
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
        Producto();
        Tabla();
        
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
        name.setBounds(0, 0, 200, 35);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("Inicio Administrador"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.black);//cambiar color de letra
        name.setBackground(new java.awt.Color(255, 99, 71));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel
        
        JLabel etiqueta = new JLabel(); //creación de una etiqueta
        etiqueta.setBounds(800, 200, 350, 35);
        etiqueta.setOpaque(true);//permiso para pintar etiqueta
        etiqueta.setText("Ingresa el ID del Gerente a buscar"); //establecemos texto en la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        etiqueta.setForeground(Color.black);//cambiar color de letra
        etiqueta.setBackground(new java.awt.Color(255, 140, 0));//cambiar fondo de etiqueta
        etiqueta.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel2.add(etiqueta); //Agregamos la etiqueta al panel
        
        //Etiqueta tipo Imagen
        ImageIcon imagen = new ImageIcon("Imagenes/admin.png");//definir la imagen
        JLabel icon = new JLabel(); //agregar una imagen
        icon.setBounds(50, 30, 100 , 150);
        icon.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH))); //imagen escalada (ancho, alto, tipo de escalado)
        panel2.add(icon);
    }
    
    private void Producto(){
        JTextField cajatexto = new JTextField();
        cajatexto.setBounds(890, 255, 200, 30);
        cajatexto.setText("ID Gerente");
        panel2.add(cajatexto);
    }
    
    private void AreadeTexto() {
        areaTexto = new JTextArea(); //instanciamos area de texto
        areaTexto.setBounds(170 , 50, 300, 35);
        areaTexto.setText("Nombre Administrador");
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
        boton3.setText("Agregar Gerente");//establecemos texto al boton
        boton3.setBounds(800 , 400, 300, 30);//posición y tamaño boton
        boton3.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton3.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton3);//agregar boton al panel
        boton3.addActionListener(this);
        
        boton4 = new JButton();
        boton4.setText("Buscar");//establecemos texto al boton
        boton4.setBounds(1100, 255, 100, 30);//posición y tamaño boton
        boton4.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton4.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton4);//agregar boton al panel
        boton4.addActionListener(this);
        
        boton5 = new JButton();
        boton5.setText("Eliminar");//establecemos texto al boton
        boton5.setBounds(100, 455, 100, 30);//posición y tamaño boton
        boton5.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton5.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton5);//agregar boton al panel
        boton5.addActionListener(this);
        
        boton6 = new JButton();
        boton6.setText("Eliminar Todo");//establecemos texto al boton
        boton6.setBounds(300, 455, 200, 30);//posición y tamaño boton
        boton6.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton6.setFont(new Font("chiller", Font.ITALIC, 25));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton6);//agregar boton al panel
        boton6.addActionListener(this);
        
    }
    
   private void Tabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Contacto");
        
        String [] gerente1 = {"000", "XXX", "55 XXXXXX"};
        
        modelo.addRow(gerente1);
        
        JTable tabla = new JTable(modelo);  
        
        tabla.setBounds(100, 200, 400, 250 );
        panel2.add(tabla);
        
        JScrollPane scroll = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(100, 200, 400, 250 );
        panel2.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            InicioAdmin a2 = new InicioAdmin(IdUsuario);
            a2.setVisible(true);
            this.dispose();
        }else if (e.getSource() == boton2){
            AvCerrarSesión3 Av1 = new AvCerrarSesión3(IdUsuario, 1);
            Av1.setVisible(true);
            this.dispose();
        }else if (e.getSource() == boton3){
            NuevoGerente N2 = new NuevoGerente();
            N2.setVisible(true);
        }else if (e.getSource() == boton4){
            
        }else if (e.getSource() == boton5){
            
        }else if (e.getSource() == boton6){
            
        }
    }
}

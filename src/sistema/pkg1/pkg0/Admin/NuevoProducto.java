package sistema.pkg1.pkg0.Admin;

import BD.Altas;
import BD.Consultas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


public class NuevoProducto extends JFrame implements ActionListener {
    
    public JPanel panel, panel2;
    JButton boton1;
    JButton boton2;
    DefaultTableModel modelo;
    JTable tabla;
    Altas Alt;
    
    public NuevoProducto(){
        this.setSize(500,500); //Establecemos el tamañno de la ventana (b,h)
        this.setTitle("Aviso");//poner titulo
        this.setLocationRelativeTo(null);//establecemos la ventana en el centro de la pantalla
        this.setResizable(false);//la ventana puede cambiar de tamaño o no 
        Componente();        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE); /*Que hacer al cerrar la ventanta
                                                        (DO_NOTHING_ON_CLOSE/HIDE_ON_CLOSE
                                                        /DISPOSE_ON_CLOSE/EXIT_ON_CLOSE)*/
        Alt = new Altas();
    }
    
    private void Componente(){
        Paneles();
        Labels();
        BOTON();
        Tabla();
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
        name.setBounds(150, 40, 200, 35);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("Agregar Producto"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.black);//cambiar color de letra
        name.setBackground(new java.awt.Color(250, 250, 210));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", 1, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel
    }
   
    
    private void BOTON() {
        //Boton de texto
        boton1 = new JButton();
        boton1.setText("Aceptar");//establecemos texto al boton
        boton1.setBounds(40, 300, 200, 50);//posición y tamaño boton
        boton1.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton1.setFont(new Font("chiller", Font.ITALIC, 20));//establecemos fuente, tipo y tamaño de letra del boton
        panel.add(boton1);//agregar boton al panel
        boton1.addActionListener(this);
        
        boton2 = new JButton();
        boton2.setText("Cancelar");//establecemos texto al boton
        boton2.setBounds(260, 300, 200, 50);//posición y tamaño boton
        boton2.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton2.setFont(new Font("chiller", Font.ITALIC, 20));//establecemos fuente, tipo y tamaño de letra del boton
        panel.add(boton2);//agregar boton al panel
        boton2.addActionListener(this);
    }
    
    private void Tabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Descripción");
        modelo.addColumn("Costo");
        modelo.addColumn("Inventario");
        modelo.addColumn("Fecha Ultima Compra");
        modelo.addColumn("ID Proveedor");
        modelo.addColumn("Fecha Caducidad");
        modelo.addColumn("Subcategoría");
        
        
        String [] producto1 = {"000", "XXX", "XXX", "XXX", "xxxx-xx-xx", "xxxx", "xxxx-xx-xx", "xxxxx"};
        
        modelo.addRow(producto1);
        
        tabla = new JTable(modelo);
        tabla.setAutoResizeMode(AUTO_RESIZE_OFF);
        tabla.setBounds(25, 150, 450, 100 );
        panel.add(tabla);
        
        JScrollPane scroll = new JScrollPane(tabla,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(25, 150, 450, 100 );
        panel.add(scroll);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            Boolean a;
            modelo = (DefaultTableModel) tabla.getModel();
            a = Alt.InsertProd((String) modelo.getValueAt(0, 0), (String) modelo.getValueAt(0, 1), Float.parseFloat((String) modelo.getValueAt(0, 2)), Integer.parseInt((String) modelo.getValueAt(0, 3)), (String) modelo.getValueAt(0, 4), (String) modelo.getValueAt(0, 5), (String) modelo.getValueAt(0, 6), (String) modelo.getValueAt(0, 7));
            if(a)
                System.out.println("exito");
            else 
                System.out.println("Fracaso");
            this.dispose();
        }else if (e.getSource() == boton2){
            this.dispose();
        }
    }
}

package sistema.pkg1.pkg0.Empleado;

import BD.Actualizaciones;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class AvCobrar extends JFrame implements ActionListener, KeyListener{
    
    public JPanel panel, panel2;
    JTable tabla;
    JFrame frame;
    JButton boton1;
    JButton boton2;
    JTextField cajatexto;
    JTextField cajatexto2;
    JTextArea total;
    Actualizaciones act;
    
    public AvCobrar(JTable tabla, JFrame frame){
        this.frame = frame;
        this.tabla = tabla;
        this.setSize(500,400); //Establecemos el tamañno de la ventana (b,h)
        this.setTitle("Aviso");//poner titulo
        this.setLocationRelativeTo(null);//establecemos la ventana en el centro de la pantalla
        this.setResizable(false);//la ventana puede cambiar de tamaño o no 
        Componente();        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE); /*Que hacer al cerrar la ventanta
                                                        (DO_NOTHING_ON_CLOSE/HIDE_ON_CLOSE
                                                        /DISPOSE_ON_CLOSE/EXIT_ON_CLOSE)*/
        act = new Actualizaciones();
    }
    
    private void Componente(){
        Paneles();
        Labels();
        AreadeTexto();
        BOTON(); 
        CajadeTexto();
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
        name.setBounds(170, 40, 150, 95);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("Aviso"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.RED);//cambiar color de letra
        name.setBackground(new java.awt.Color(250, 250, 210));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", 1, 30));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel
    }
    
    private void AreadeTexto() {
        JTextArea areaTexto = new JTextArea(); //instanciamos area de texto
        areaTexto.setBounds(170 , 140, 70, 30);
        areaTexto.setText("Cobrar:");
        areaTexto.setEditable(false);//permiso de editar contenido
        areaTexto.setBackground(new java.awt.Color(250, 250, 210));
        areaTexto.setFont(new Font("arial", 1, 20));
        panel.add(areaTexto);
        
        JTextArea areaTexto1 = new JTextArea(); //instanciamos area de texto
        areaTexto1.setBounds(50 , 200, 90, 30);
        areaTexto1.setText("Recibido:");
        areaTexto1.setEditable(false);//permiso de editar contenido
        areaTexto1.setBackground(new java.awt.Color(250, 250, 210));
        areaTexto1.setFont(new Font("arial", 1, 20));
        panel.add(areaTexto1);
        
        JTextArea areaTexto2 = new JTextArea(); //instanciamos area de texto
        areaTexto2.setBounds(350 , 200, 80, 30);
        areaTexto2.setText("Cambio:");
        areaTexto2.setEditable(false);//permiso de editar contenido
        areaTexto2.setBackground(new java.awt.Color(250, 250, 210));
        areaTexto2.setFont(new Font("arial", 1, 20));
        panel.add(areaTexto2);
        
        total = new JTextArea(); //instanciamos area de texto
        total.setBounds(250 , 140, 100, 40);
        
        total.setText("$"+ObtTotal());
        total.setEditable(false);//permiso de editar contenido
        total.setBackground(new java.awt.Color(250, 250, 210));
        total.setFont(new Font("arial", 1, 25));
        panel.add(total);
    }
    
    private void CajadeTexto(){
        cajatexto = new JTextField();
        cajatexto.setBounds(50 , 230, 100, 30);
        cajatexto.setText("");
        panel.add(cajatexto);
        cajatexto.addKeyListener(this);
        
        cajatexto2 = new JTextField();
        cajatexto2.setBounds(350 , 230, 100, 30);
        cajatexto2.setText("");
        panel.add(cajatexto2);
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

    public float ObtTotal(){
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        float resultado = 0;
        for(int i=0;i<modelo.getRowCount();i++){
            resultado+=Float.parseFloat((String) modelo.getValueAt(i, 2));
        }
        return resultado;
    }
    
    public Boolean Venta(){
        Boolean z = false;
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        for(int i=0;i<modelo.getRowCount();i++){
            z = act.ActInv((String) modelo.getValueAt(i, 0));
            if(!z)
                return z;
        }
        return z;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            float cambio;
            cambio = Float.parseFloat(cajatexto.getText()) - ObtTotal();
            if(cambio >= 0)
                if(!Venta())
                    System.out.println("Error");
                else{
                    
                }
            this.dispose();
        }else if (e.getSource() == boton2){
            this.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        float cambio;
        if(!cajatexto.getText().isEmpty()){
            cambio = Float.parseFloat(cajatexto.getText()) - ObtTotal();
            cajatexto2.setText("$"+cambio);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}

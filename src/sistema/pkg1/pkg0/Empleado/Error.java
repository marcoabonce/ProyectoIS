package sistema.pkg1.pkg0.Empleado;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author dn_as
 */
public class Error extends JFrame implements ActionListener{
    
    public JPanel panel, panel2;
    JButton boton1;
    JLabel name1;
    JTextArea areaTexto;
    JFrame frame;
    
    public Error(String mensaje1, String mensaje2, JFrame frame){
        this.setSize(500,400); //Establecemos el tamañno de la ventana (b,h)
        this.setTitle("Aviso");//poner titulo
        this.setLocationRelativeTo(null);//establecemos la ventana en el centro de la pantalla
        this.setResizable(false);//la ventana puede cambiar de tamaño o no 
        Componente();        
        this.setDefaultCloseOperation(HIDE_ON_CLOSE); /*Que hacer al cerrar la ventanta
                                                        (DO_NOTHING_ON_CLOSE/HIDE_ON_CLOSE
                                                        /DISPOSE_ON_CLOSE/EXIT_ON_CLOSE)*/
        this.name1.setText(mensaje1);
        this.areaTexto.setText(mensaje2);
        this.frame = frame;
    }
    
    private void Componente(){
        Paneles();
        Labels();
        AreadeTexto();
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
        name.setBounds(190, 50, 120, 35);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("ERROR"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.RED);//cambiar color de letra
        name.setBackground(new java.awt.Color(250, 250, 210));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", 1, 30));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel
        
        name1 = new JLabel(); //creación de una etiqueta
        name1.setBounds(215, 100, 70, 20);
        name1.setOpaque(true);//permiso para pintar etiqueta
        name1.setText("ERROR"); //establecemos texto en la etiqueta
        name1.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name1.setForeground(Color.RED);//cambiar color de letra
        name1.setBackground(new java.awt.Color(250, 250, 210));//cambiar fondo de etiqueta
        name1.setFont(new Font("arial", 1, 15));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name1); //Agregamos la etiqueta al panel
    }
    
    private void AreadeTexto() {
        areaTexto = new JTextArea(); //instanciamos area de texto
        areaTexto.setBounds(100 , 150, 300, 50);
        areaTexto.setText("                         Colocar Error");//colocar error
        areaTexto.setEditable(false);//permiso de editar contenido
        areaTexto.setBackground(new java.awt.Color(250, 250, 210));
        areaTexto.setFont(new Font("arial", 1, 15));
        panel.add(areaTexto);
    }
    
    private void BOTON() {
        //Boton de texto
        boton1 = new JButton();
        boton1.setText("Aceptar");//establecemos texto al boton
        boton1.setBounds(40, 300, 200, 50);//posición y tamaño boton
        boton1.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton1.setFont(new Font("Georgia", Font.ITALIC, 20));//establecemos fuente, tipo y tamaño de letra del boton
        panel.add(boton1);//agregar boton al panel
        boton1.addActionListener(this);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            frame.dispose();
            this.dispose();
        }
    }
}

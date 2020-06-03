package sistema.pkg1.pkg0;

import BD.Consultas;
import com.mysql.jdbc.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gerente extends JFrame implements ActionListener {

    public JPanel panel, panel2;
    JButton boton1;
    JTextField cajatexto;
    JPasswordField password;
    String IdUsuario;

    public Gerente() {
        this.setTitle("Sistema 1.0");//poner titulo
        this.setResizable(true);//la ventana puede cambiar de tamaño o no 
        this.setExtendedState(MAXIMIZED_BOTH);//Maximizar ventana automaticamente
        //this.getContentPane().setBackground(Color.blue);//color de la ventana
        Componente();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*Que hacer al cerrar la ventanta
                                                        (DO_NOTHING_ON_CLOSE/HIDE_ON_CLOSE
                                                        /DISPOSE_ON_CLOSE/EXIT_ON_CLOSE)*/
    }

    private void Componente() {
        Paneles();
        Labels();
        Credencial();
        Contraseña();
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
        panel2.setBounds(0, 50, 2000, 600);
        panel.add(panel2);
    }

    private void Labels() {
        //Etiqueta tipo texto
        JLabel name = new JLabel(); //creación de una etiqueta
        name.setBounds(0, 0, 200, 35);
        name.setOpaque(true);//permiso para pintar etiqueta
        name.setText("Credenciales Gerente"); //establecemos texto en la etiqueta
        name.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        name.setForeground(Color.black);//cambiar color de letra
        name.setBackground(new java.awt.Color(255, 99, 71));//cambiar fondo de etiqueta
        name.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel.add(name); //Agregamos la etiqueta al panel

        JLabel etiqueta = new JLabel(); //creación de una etiqueta
        etiqueta.setBounds(500, 200, 400, 30);
        etiqueta.setOpaque(true);//permiso para pintar etiqueta
        etiqueta.setText("Ingresa tus credenciales para iniciar sesión:"); //establecemos texto en la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        etiqueta.setForeground(Color.black);//cambiar color de letra
        etiqueta.setBackground(new java.awt.Color(255, 140, 0));//cambiar fondo de etiqueta
        etiqueta.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel2.add(etiqueta); //Agregamos la etiqueta al panel

        JLabel ID = new JLabel(); //creación de una etiqueta
        ID.setBounds(470, 250, 40, 40);
        ID.setOpaque(true);//permiso para pintar etiqueta
        ID.setText("ID:"); //establecemos texto en la etiqueta
        ID.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        ID.setForeground(Color.black);//cambiar color de letra
        ID.setBackground(new java.awt.Color(255, 140, 0));//cambiar fondo de etiqueta
        ID.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel2.add(ID); //Agregamos la etiqueta al panel

        JLabel Password = new JLabel(); //creación de una etiqueta
        Password.setBounds(405, 300, 100, 40);
        Password.setOpaque(true);//permiso para pintar etiqueta
        Password.setText("Password:"); //establecemos texto en la etiqueta
        Password.setHorizontalAlignment(SwingConstants.CENTER);//alineación de texto
        Password.setForeground(Color.black);//cambiar color de letra
        Password.setBackground(new java.awt.Color(255, 140, 0));//cambiar fondo de etiqueta
        Password.setFont(new Font("arial", Font.PLAIN, 20));/*establecemos la fuente del texto
                                    (nombre del estilo, tipo [negritas, italita, etc o 
                                    0 sin estilo, 1 negritas, 2 cursiva, 3 negriyas y cursiva], tamaño)*/
        panel2.add(Password); //Agregamos la etiqueta al panel

        //Etiqueta tipo Imagen
        ImageIcon imagen = new ImageIcon("Imagenes/Gerente.png");//definir la imagen
        JLabel icon = new JLabel(); //agregar una imagen
        icon.setBounds(50, 50, 100, 100);
        icon.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH))); //imagen escalada (ancho, alto, tipo de escalado)
        panel2.add(icon);
    }

    private void Credencial() {
        cajatexto = new JTextField();
        cajatexto.setBounds(590, 255, 200, 20);
        cajatexto.setText("hola");
        panel2.add(cajatexto);
    }

    private void Contraseña() {
        password = new JPasswordField();
        password.setBounds(590, 305, 200, 20);
        password.setText("CONTRASEÑA");
        panel2.add(password);
    }

    private void Boton() {
        //Boton de texto
        boton1 = new JButton("Ingresar");
        boton1.setText("Ingresar");//establecemos texto al boton
        boton1.setBounds(590, 405, 200, 30);//posición y tamaño boton
        boton1.setForeground(Color.blue);//establecemos el color de la letra del boton
        boton1.setFont(new Font("chiller", Font.ITALIC, 20));//establecemos fuente, tipo y tamaño de letra del boton
        panel2.add(boton1);//agregar boton al panel
        boton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            Consultas consulta = new Consultas();

            IdUsuario = consulta.ConsultaLogIn(cajatexto.getText(), String.valueOf(password.getPassword()));
            if (IdUsuario == "404-Not") {
                ErrorCredencialGerente E1 = new ErrorCredencialGerente();
                E1.setVisible(true);
            } else {
                panel.setVisible(false);
                panel2.setVisible(false);
                InicioGerente g2 = new InicioGerente(IdUsuario);
                g2.setVisible(true);
                this.dispose();
            }

        }
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

}


package sistema.pkg1.pkg0;

import BD.Consultas;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class AvDescargarExcelVentas extends JFrame implements ActionListener{
    
    public JPanel panel, panel2;
    JButton boton1;
    JButton boton2;
    Consultas con;
    
    public AvDescargarExcelVentas(){
        con = new Consultas();
        this.setSize(500,400); //Establecemos el tamañno de la ventana (b,h)
        this.setTitle("Aviso");//poner titulo
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
        name.setBounds(170, 50, 150, 95);
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
        areaTexto.setBounds(100 , 150, 300, 50);
        areaTexto.setText("                ¿Desea descargar Excel ");
        areaTexto.append("\r\n");//añade más texto al area de texto
        areaTexto.append("                     de Ventas del día?");//añade más texto al area de texto
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
    
    public void generarVentas() {
        try {
            Calendar cal = Calendar.getInstance(); 
            int mes = cal.get(Calendar.MONTH) +1 ;
            String fecha = cal.get(Calendar.YEAR)+"-"+mes+"-"+cal.get(Calendar.DATE);
            ResultSet rs = con.ConsultarAllVentas(fecha);
            int cantFilas = 0;
            if (rs.last()) {//Nos posicionamos al final
                cantFilas = rs.getRow();//sacamos la cantidad de filas/registros
                
            }
            rs = con.ConsultarAllVentas(fecha);
            System.out.println(cantFilas);
            String[][] entrada = new String[cantFilas+1][6];
            entrada[0][0] = "Id Venta";
            entrada[0][1] = "Id Empleado";
            entrada[0][2] = "Id Producto";
            entrada[0][3] = "Cantidad";
            entrada[0][4] = "Total";
            entrada[0][5] = "Fecha";
            int i = 1;
            
            rs.beforeFirst();
            while (rs.next()) {
                entrada[i][0] = rs.getString("id_Venta");
                entrada[i][1] = rs.getString("id_Empleado");
                entrada[i][2] = rs.getString("id_Producto");
                entrada[i][3] = String.valueOf(rs.getInt("Cantidad"));
                entrada[i][4] = String.valueOf(rs.getFloat("Total"));
                entrada[i][5] = rs.getString("fecha");
                i++;
            }

            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("USO-8859-1");
            File file = new File("C:\\Users\\PC\\Desktop\\Ventas.xls");
            WritableWorkbook woorbook = Workbook.createWorkbook(file, conf);

            WritableSheet sheet = woorbook.createSheet("Resultado", 0);

            WritableFont h = new WritableFont(WritableFont.COURIER, 16, WritableFont.NO_BOLD);
            WritableCellFormat hFormat = new WritableCellFormat(h);

            for (i = 0; i < entrada.length; i++) {
                for (int j = 0; j < entrada[i].length; j++) {
                    WritableCell w;
                    sheet.addCell(new jxl.write.Label(j, i, entrada[i][j], hFormat));
                }
            }
            woorbook.write();
            woorbook.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (WriteException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1){
            generarVentas();
            this.dispose();
        }else if (e.getSource() == boton2){
            this.dispose();
        }
    }
   
}

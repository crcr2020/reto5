package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.IllegalFormatConversionException;
import controller.ControladorRequerimientosReto4;
import model.vo.MaterialNacional;
import model.vo.ProyectoRankeadoCompras;
import model.vo.CargoAsignacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;


//Interfaz gráfica GUI
public class Requerimiento1GUI extends JFrame {
    
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    //Atributos interfaz
    //JButton btnRequerimiento1;
    //JButton btnRequerimiento2;
    //JButton btnRequerimiento3;
    private JTable jtTablaRequerimiento1;

    public Requerimiento1GUI(ArrayList<MaterialNacional> materiales, ControladorRequerimientosReto4 controlador){
        
        setLayout(new GridLayout());
        //Título
        setTitle("--------------Materiales Producción Nacional Más Comprados--------------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] encabezados = {"Nombre_Material","Importado","No_Compras"};
        jtTablaRequerimiento1 = new JTable(this.formatoMaterialesNacionales(materiales, encabezados.length), encabezados);
        
        JScrollPane sp1 = new JScrollPane(jtTablaRequerimiento1);
        JPanel panel1 = new JPanel();
        panel1.add(sp1);
        panel1.setBorder(new TitledBorder("Materiales Nacionales"));
        getContentPane().add(panel1);
        
        //getContentPane().add(jtTablaRequerimiento1);
        setSize(550,300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoMaterialesNacionales(ArrayList<MaterialNacional> materiales, int numeroColumnas){
        String[][] registros = new String[materiales.size()][numeroColumnas];

        for (int i = 0; i < registros.length; i++) {
            registros[i][0] = materiales.get(i).getNombreMaterial();
            registros[i][1] = materiales.get(i).getImportado();
            registros[i][2] = String.valueOf(materiales.get(i).getNoCompras());
            
        }
                
        return registros;

    }
    
    
}

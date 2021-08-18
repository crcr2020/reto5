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
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;


//Interfaz gráfica GUI
public class Requerimiento2GUI extends JFrame {
    
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    //Atributos interfaz
    //JButton btnRequerimiento1;
    //JButton btnRequerimiento2;
    //JButton btnRequerimiento3;
    private JTable jtTablaRequerimiento2;

    public Requerimiento2GUI(ArrayList<ProyectoRankeadoCompras> proyectos, ControladorRequerimientosReto4 controlador){
                
        setLayout(new GridLayout());
        
        //Título
        setTitle("--------------Proyectos Mayor Compra Granito--------------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] encabezados = {"ID_Proyecto","Clasificación","Area_Max","No_Compras_Granito"};
        jtTablaRequerimiento2 = new JTable(this.formatoRegistro(proyectos, encabezados.length), encabezados);
        
        JScrollPane sp = new JScrollPane(jtTablaRequerimiento2);
        JPanel panel = new JPanel();
        panel.add(sp);
        panel.setBorder(new TitledBorder("Compras Granito"));
        getContentPane().add(panel);
        
        //getContentPane().add(jtTablaRequerimiento1);
        setSize(550,200);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoRegistro(ArrayList<ProyectoRankeadoCompras> proyectos, int numeroColumnas){
        String[][] registros = new String[proyectos.size()][numeroColumnas];

        for (int i = 0; i < registros.length; i++) {
            registros[i][0] = String.valueOf(proyectos.get(i).getIdProyecto());
            registros[i][1] = proyectos.get(i).getClasificacion();
            registros[i][2] = String.valueOf(proyectos.get(i).getAreaMaxima());
            registros[i][3] = String.valueOf(proyectos.get(i).getNoComprasGranito());
        }
                
        return registros;

    }
    
    
}

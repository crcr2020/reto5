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
public class Requerimiento3GUI extends JFrame {
    
    //public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    //Atributos interfaz
    //JButton btnRequerimiento1;
    //JButton btnRequerimiento2;
    //JButton btnRequerimiento3;
    private JTable jtTablaRequerimiento3;

    public Requerimiento3GUI(ArrayList<CargoAsignacion> cargosAsignados, ControladorRequerimientosReto4 controlador){
        setLayout(new GridLayout());
        //Título
        setTitle("--------------Cargos Menos Asignados--------------");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        String[] encabezados = {"Cargo","No. Proyectos"};
        jtTablaRequerimiento3 = new JTable(this.formatoRegistro(cargosAsignados, encabezados.length), encabezados);
        
        JScrollPane sp = new JScrollPane(jtTablaRequerimiento3);
        JPanel panel = new JPanel();
        panel.add(sp);
        panel.setBorder(new TitledBorder("Cargos Menos Asignados"));
        getContentPane().add(panel);
        
        //getContentPane().add(jtTablaRequerimiento1);
        setSize(550,150);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String[][] formatoRegistro(ArrayList<CargoAsignacion> cargosAsignados, int numeroColumnas){
        String[][] registros = new String[cargosAsignados.size()][numeroColumnas];

        for (int i = 0; i < registros.length; i++) {
            registros[i][0] = cargosAsignados.get(i).getCargo();
            registros[i][1] = String.valueOf(cargosAsignados.get(i).getNoProyectos());
            

        }
                
        return registros;

    }
    
    
}

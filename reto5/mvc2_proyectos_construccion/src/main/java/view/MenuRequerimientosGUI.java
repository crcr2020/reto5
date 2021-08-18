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
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridLayout;


//Interfaz gráfica GUI
public class MenuRequerimientosGUI extends JFrame {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    
    //Atributos interfaz
    private JButton btnRequerimiento1;
    private JButton btnRequerimiento2;
    private JButton btnRequerimiento3;
    
    //Método para generar la ventana: constructor o específico 
    public void iniciarGUI(){
        //Título
        setTitle("MENÚ INICIAL REQUERIMIENTOS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Componentes
        ImageIcon icono1 = new ImageIcon("imagenes/materiales.png");
        Image img1 = icono1.getImage();
        icono1 = new ImageIcon(img1.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        btnRequerimiento1 = new JButton(icono1);
        btnRequerimiento1.setText("Materiales más comprados");
        btnRequerimiento1.setFont(new Font("Arial", Font.PLAIN, 16));
        btnRequerimiento1.addActionListener(controlador);
        btnRequerimiento1.setActionCommand("requerimiento1");

        ImageIcon icono2 = new ImageIcon("imagenes/compras.png");
        Image img2 = icono2.getImage();
        icono2 = new ImageIcon(img2.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        btnRequerimiento2 = new JButton(icono2);
        btnRequerimiento2.setText("Ranking Granito");
        btnRequerimiento2.setFont(new Font("Arial", Font.PLAIN, 16));
        btnRequerimiento2.addActionListener(controlador);
        btnRequerimiento2.setActionCommand("requerimiento2");

        ImageIcon icono3 = new ImageIcon("imagenes/cargo.png");
        Image img3 = icono3.getImage();
        icono3 = new ImageIcon(img3.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
        btnRequerimiento3 = new JButton(icono3); 
        btnRequerimiento3.setText("Cargos Liderando Menos");
        btnRequerimiento3.setFont(new Font("Arial", Font.PLAIN, 16));
        btnRequerimiento3.addActionListener(controlador);
        btnRequerimiento3.setActionCommand("requerimiento3");

        //Añadir compenentes a los contenedores
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        panel.add(btnRequerimiento1);
        panel.add(btnRequerimiento2);
        panel.add(btnRequerimiento3);

        getContentPane().add(panel);

        //Establecer las propiedades finales del frame
        setSize(900,150);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void requerimiento3(){

        System.out.println("-----Materiales Producción Nacional Más Comprados-------");       

        try{

            ArrayList<MaterialNacional> rankingMaterialesNacionales = controlador.consultarMaterialesNacionalesComprados();

            //Encabezado del resultado
            System.out.println("Nombre_Material Importado No_Compras");
            
            for (MaterialNacional materialNacional : rankingMaterialesNacionales) {
                System.out.printf("%s %s %d %n",
                materialNacional.getNombreMaterial(),
                materialNacional.getImportado(),
                materialNacional.getNoCompras()                
                                
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error"+e.getMessage());
        }

    }
    public static void requerimiento4(){

        System.out.println("-----Proyectos Mayor Compra de Granito-------");       

        try{

            ArrayList<ProyectoRankeadoCompras> rankingProyectosGranito = controlador.consultarProyectosComprasGranito();

            //Encabezado del resultado
            System.out.println("ID_Proyecto Clasificacion Area_Max No_Compras_Granito");
            
            for (ProyectoRankeadoCompras proyecto : rankingProyectosGranito) {
                System.out.printf("%d %s %d %d %n",
                    proyecto.getIdProyecto(),
                    proyecto.getClasificacion(),
                    proyecto.getAreaMaxima(),
                    proyecto.getNoComprasGranito()
                
                );
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error"+e.getMessage());
        }

    }
    public static void requerimiento5(){

        System.out.println("-----Cargos Menos Asignados-------");       

        try{

            ArrayList<CargoAsignacion> cargosMenosAsignados = controlador.consultarCargosMenosAsignados();

            //Encabezado del resultado
            System.out.println("Cargo Número_Proyectos");
            
            for (CargoAsignacion cargo : cargosMenosAsignados) {
                System.out.printf("%s %d %n",
                    cargo.getCargo(),
                    cargo.getNoProyectos()
                              
                );
               
            }

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }

    }
    
    
}

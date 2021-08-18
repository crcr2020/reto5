import util.JDBCUtilities;

import java.io.IOException;
//Librerías para el manejo de la base de datos
import java.sql.Connection;
import java.sql.SQLException;
import java.util.IllegalFormatConversionException;

import view.VistaRequerimientosReto4;
import controller.ControladorRequerimientosReto4;

public class App 
{
    public static void main( String[] args ) {

        // Instanciar e iniciar controlador
        ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
        controlador.inicio();


        /*Casos de prueba 

        //Requerimiento 3 - Reto3
        VistaRequerimientosReto4.requerimiento3();
        System.out.println();

        //Requerimiento 4 - Reto3
        VistaRequerimientosReto4.requerimiento4();
        System.out.println();

        //Requerimiento 5 - Reto3
        VistaRequerimientosReto4.requerimiento5();
        System.out.println();*/

        /*MenuLider.menuInicial();
        try( Connection conexion = JDBCUtilities.getConnection() ){
            
            if(JDBCUtilities.estaVacia()){
                System.out.println("La base de datos está vacía!");
            }else{
                System.out.println("Conexión exitosa a la base de datos específica");
            }

            //Iniciar mainloop de la aplicación
            MenuLider.menuInicial();

        }catch(SQLException objetoError){
            System.err.println("Error conectándose a la base de datos " + objetoError);  
        }*/

    }
}          

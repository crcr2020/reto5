package util;

//Paquete para los archivos
import java.io.File;

//Paquetes para la interacción con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtilities {

    ////Ubicación de la Base de datos. Para windows con backslash
    private static final String UBICACION_BD = "ProyectosConstruccion.db";    

    //Hacer Conexión con la BD
    public static Connection getConnection() throws SQLException {  //O retorna la conexión o la excepción      
        String url = "jdbc:sqlite:" + JDBCUtilities.UBICACION_BD;
        return DriverManager.getConnection(url);
    }

    //Función para validar si estamos en BD vacía
    public static boolean estaVacia(){
        File archivo = new File(JDBCUtilities.UBICACION_BD);

        //Salida de diagnóstico
        System.out.println("Líneas identificadas: "+archivo.length());

        return archivo.length() == 0;
    }

    
}
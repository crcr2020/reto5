package model.dao;

import java.util.ArrayList;

import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.vo.CargoAsignacion;

public class CargoAsignacionDao {

    //Requerimiento 5 del reto 3
    
    //Los dos cargos que tienen menos proyectos asignados
    public ArrayList<CargoAsignacion> cargosMenosAsignados() throws SQLException {

        //Preparar colección que tiene la respuesta
        ArrayList<CargoAsignacion> respuesta = new ArrayList<CargoAsignacion>();
        
        //Declarar conexión
        Connection conexion = null;
        
        //Intentar conexión y extraer la información de la BD
        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT l.Cargo, COUNT (Pr.ID_Proyecto) as Numero_Proyectos "+
                                "FROM Proyecto Pr "+
                                "JOIN Lider l ON Pr.ID_Lider = l.ID_Lider "+
                                "GROUP BY l.Cargo "+
                                "ORDER BY Numero_Proyectos "+
                                "LIMIT 2 ";
            
            //Construcción de objeto que hara la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            //Realizar ya la consulta
            ResultSet resultSet = statement.executeQuery();

            //Recorrer Resultsel mientras tenga registros
            while(resultSet.next()){
               CargoAsignacion cargo = new CargoAsignacion();
               cargo.setCargo(resultSet.getString("Cargo"));
               cargo.setNoProyectos(resultSet.getInt("Numero_Proyectos"));

               respuesta.add(cargo);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){

            System.err.println("Error consultando los cargos menos asignados"+e);

        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }    
}
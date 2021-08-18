package model.dao;

import java.util.ArrayList;

import util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import model.vo.ProyectoRankeadoCompras;

public class ProyectoRankeadoComprasDao {

    //Requerimiento 4 del reto 3

    //Obtener los 5 proyectos rankeados según las compras
    public ArrayList<ProyectoRankeadoCompras> topProyectosComprasGranito() throws SQLException {
        
        //Preparar colección que tiene la respuesta
        ArrayList<ProyectoRankeadoCompras> respuesta = new ArrayList<ProyectoRankeadoCompras>();
        
        //Declarar conexión
        Connection conexion = null;
        
        //Intentar conexión y extraer la información de la BD
        try{
            conexion = JDBCUtilities.getConnection();

            String consulta = "SELECT  p.ID_Proyecto, "+
                                "p.Clasificacion, "+
                                "t.Area_Max, "+
                                "COUNT(m.Nombre_Material) as No_Compras_Granito "+
                                "FROM Proyecto p "+
                                "JOIN Compra c ON "+
                                "p.ID_Proyecto = c.ID_Proyecto "+
                                "JOIN MaterialConstruccion m ON "+
                                "m.ID_MaterialConstruccion = c.ID_MaterialConstruccion "+
                                "JOIN Tipo t ON "+
                                "p.ID_Tipo = t.ID_Tipo "+
                                "WHERE m.Nombre_Material LIKE 'Granito' "+
                                "GROUP BY p.ID_Proyecto "+
                                "ORDER BY No_Compras_Granito DESC "+
                                "LIMIT 5 ";
                        
            //Construcción de objeto que hará la consulta
            PreparedStatement statement = conexion.prepareStatement(consulta);

            //Realizar ya la consulta
            ResultSet resultSet = statement.executeQuery();

            //Recorrer Resultsel mientras tenga registros
            while(resultSet.next()){
                ProyectoRankeadoCompras proyecto = new ProyectoRankeadoCompras();
                proyecto.setIdProyecto(resultSet.getInt("ID_Proyecto"));
                proyecto.setClasificacion(resultSet.getString("Clasificacion"));
                proyecto.setAreaMaxima(resultSet.getInt("Area_Max"));
                proyecto.setNoComprasGranito(resultSet.getInt("No_Compras_Granito"));

                respuesta.add(proyecto);
            }

            resultSet.close();
            statement.close();

        }catch(SQLException e){

            System.out.println("Error consultando ranking de proyectos que compran más Granito"+e);

        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
            
    }
   
}
package conectar;

import java.sql.*;
/**
 *
 * @author peter
 */
public class Procedimientos {
    //Metodo para introducir datos al Servidor de SQL
    public static void EntradaDatos(String nombre, String apellido,
            String ci, String ciudad) throws SQLException{
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaDatos(?,?,?,?)}");
        entrada.setString (1, nombre);
        entrada.setString(2, apellido);
        entrada.setString(3, ci);
        entrada.setString(4, ciudad);
        entrada.execute();   
    }
    //Metodo para eliminar datos del Servidor SQL
    public static void EliminarDatos(int id) throws SQLException{
        CallableStatement eliminar = Conexion.getConexion().prepareCall("{call EliminarDatos(?)}");
        eliminar.setInt (1, id);
        eliminar.execute();
    }
    
    //Metodo para buscar Registro de la Base de Datos
    public static void BuscarDatos(int id) throws SQLException{
        CallableStatement buscar = Conexion.getConexion().prepareCall("{call BuscarDatos(?)}");
        buscar.setInt (1, id);
        buscar.execute();
    }
}

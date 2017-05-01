package conectar;

import java.sql.*;
/**
 *
 * @author peter
 */
public class Procedimientos {
    
    public static void EntradaDatos(String nombre, String apellido,
            String ci, String ciudad) throws SQLException{
        CallableStatement entrada = Conexion.getConexion().prepareCall("{call EntradaDatos(?,?,?,?)}");
        entrada.setString (1, nombre);
        entrada.setString(2, apellido);
        entrada.setString(3, ci);
        entrada.setString(4, ciudad);
        entrada.execute();
        
    }
}

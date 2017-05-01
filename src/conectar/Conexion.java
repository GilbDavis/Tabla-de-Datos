/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectar;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    
    static Connection contacto = null;
    public static String usuario;
    public static String password;
    public static boolean status = false;
    
    public static Connection getConexion(){
        
        status = false;
        String url = "jdbc:sqlserver://Davis:49692;databaseName=Prueba";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Nose pudo establecer la conexion... revisar driver "+
                    e.getMessage() + " Error de conexion" + JOptionPane.ERROR_MESSAGE);
        }
        try{
            contacto = DriverManager.getConnection(url, Conexion.usuario, Conexion.password);
            status = true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
    
    public static void setCuenta(String usuario, String password){
        Conexion.usuario = usuario;
        Conexion.password = password;
    }
    
    public static boolean getStatus(){
        return status;
    }
    
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error de conexion", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}

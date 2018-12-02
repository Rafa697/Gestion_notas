    
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {
    static String bd ="gestion_notas";
    static String user ="root";
    static String pass="root";
    static String url="jdbc:mysql://localhost:3306/"+bd;
  
    public Connection conn = null;
     public ResultSet rs;
    public  Statement st;
    
    public Conexion(){
       
    try {
    Class.forName("com.mysql.jdbc.Driver");
    conn =   DriverManager.getConnection(url, user, pass);
        if (conn != null) {
            System.out.println("Conexion exitosa");
        }
    }catch(Exception e){
        System.err.println("Error de conexion");
    }
    }
    public Connection conectar() throws Exception{
    return conn;
    }
    public void desconectar()throws Exception{
    conn.close();
    }
    public ResultSet getDatos(String com){
        ResultSet rs = null;
        PreparedStatement ps= null;
        try {
            this.conectar();
            this.rs =  ps.executeQuery(com);
           
        } catch (Exception e) {
        
        }return null;
    }
    public static void main (String[] args){
    Conexion con= new Conexion();
    
    }
    
}

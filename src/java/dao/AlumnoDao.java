        
package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.AlumnoBean;


public class AlumnoDao {
    Conexion conn;

    public AlumnoDao(Conexion conn) {
        this.conn = conn;
    }

    public AlumnoDao() {
    }

   

   

    

    
    public boolean insertar(AlumnoBean alub){
    String sql ="INSERT INTO tbl_alumnos VALUES(?,?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, alub.getId_alumno());
        ps.setString(2, alub.getId_persona());
        ps.setString(3, alub.getId_carrera());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<AlumnoBean> consultar(){
        String sql ="SELECT * FROM tbl_alumnos";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            AlumnoBean alub;
            List<AlumnoBean> lista = new LinkedList<>();
            while(rs.next()){
                alub = new AlumnoBean(rs.getString("id_alumno"));
                alub.setId_persona(rs.getString("id_persona"));
                alub.setId_carrera(rs.getString("id_carrera"));
                
                lista.add(alub);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(AlumnoBean alub){
         String sql ="UPDATE tbl_alumnos SET id_persona =?, id_carrera=?  WHERE id_alumno=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             ps.setString(1, alub.getId_persona());
             ps.setString(2, alub.getId_carrera());
             ps.setString(3, alub.getId_alumno());
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(String id_alumno)   throws Exception{
         String sql="DELETE FROM tbl_alumnos WHERE id_alumno=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setString(1, id_alumno);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<AlumnoBean> consultarById(String id_alumno) {
         String sql ="SELECT * FROM tbl_alumnos WHERE id_alumno =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setString(1, id_alumno);
         ResultSet rs = ps.executeQuery();
         List<AlumnoBean> listar = new ArrayList<>();
        AlumnoBean alub;
         while(rs.next()){
         alub = new AlumnoBean(rs.getString("id_alumno"));
        alub.setId_persona(rs.getString("id_persona"));
        alub.setId_carrera(rs.getString("id_carrera"));
         listar.add(alub);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
         
        
}

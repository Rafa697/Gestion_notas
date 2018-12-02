        
package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CarreraBean;


public class CarreraDao {
    Conexion conn;

    public CarreraDao(Conexion conn) {
        this.conn = conn;
    }

    public CarreraDao() {
    }

    

    
    public boolean insertar(CarreraBean carb){
    String sql ="INSERT INTO tbl_carrera VALUES(?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, carb.getId_carrera());
        ps.setString(2, carb.getCarrera());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<CarreraBean> consultar(){
        String sql ="SELECT * FROM tbl_carrera";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            CarreraBean carb;
            List<CarreraBean> lista = new LinkedList<>();
            while(rs.next()){
                carb = new CarreraBean(rs.getString("id_carrera"));
                carb.setCarrera(rs.getString("carrera"));
                
                lista.add(carb);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(CarreraBean carb){
         String sql ="UPDATE tbl_carrera SET carrera =?  WHERE id_carrera=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             ps.setString(1, carb.getCarrera());
             ps.setString(2, carb.getId_carrera());
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(String id_carrera)   throws Exception{
         String sql="DELETE FROM tbl_carrera WHERE id_carrera=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setString(1, id_carrera);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<CarreraBean> consultarById(String id_carrera) {
         String sql ="SELECT * FROM tbl_carrera WHERE id_carrera =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setString(1, id_carrera);
         ResultSet rs = ps.executeQuery();
         List<CarreraBean> listar = new ArrayList<>();
        CarreraBean carb;
         while(rs.next()){
         carb = new CarreraBean(rs.getString("id_carrera"));
        carb.setCarrera(rs.getString("carrera"));
         listar.add(carb);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
}

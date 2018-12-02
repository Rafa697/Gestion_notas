        
package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.RolBean;


public class RolDao {
    Conexion conn;

    public RolDao(Conexion conn) {
        this.conn = conn;
    }

    public RolDao() {
        
    }
    public boolean insertar(RolBean rolb){
    String sql ="INSERT INTO tbl_rol VALUES(?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setInt(1, rolb.getId_rol());
        ps.setString(2, rolb.getRol());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<RolBean> consultar(){
        String sql ="SELECT * FROM tbl_rol";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            RolBean rolb;
            List<RolBean> lista = new LinkedList<>();
            while(rs.next()){
                rolb = new RolBean(rs.getInt("id_rol"));
                rolb.setRol(rs.getString("rol"));
                
                lista.add(rolb);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(RolBean rolb){
         String sql ="UPDATE tbl_rol SET rol =?  WHERE id_rol=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             ps.setString(1, rolb.getRol());
             ps.setInt(2, rolb.getId_rol());
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(int id)   throws Exception{
         String sql="DELETE FROM tbl_rol WHERE id_rol=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setInt(1, id);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<RolBean> consultarById(int id_rol) {
         String sql ="SELECT * FROM tbl_rol WHERE id_rol =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setInt(1, id_rol);
         ResultSet rs = ps.executeQuery();
         List<RolBean> listar = new ArrayList<>();
        RolBean rolb;
         while(rs.next()){
         rolb = new RolBean(rs.getInt("id_rol"));
        rolb.setRol(rs.getString("rol"));
         listar.add(rolb);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
}

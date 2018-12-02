        
package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.MateriaBean;


public class MateriaDao {
    Conexion conn;

    public MateriaDao(Conexion conn) {
        this.conn = conn;
    }

    public MateriaDao() {
    }

   
    public boolean insertar(MateriaBean matb){
    String sql ="INSERT INTO tbl_materia VALUES(?,?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, matb.getId_materia());
        ps.setString(2, matb.getMateria());
        ps.setString(3, matb.getId_catedratico());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<MateriaBean> consultar(){
        String sql ="SELECT * FROM tbl_materia";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            MateriaBean matb;
            List<MateriaBean> lista = new LinkedList<>();
            while(rs.next()){
                matb = new MateriaBean(rs.getString("id_materia"));
                matb.setMateria(rs.getString("materia"));
                matb.setId_catedratico(rs.getString("id_catedratico"));
                
                lista.add(matb);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(MateriaBean rolb){
         String sql ="UPDATE tbl_materia SET materia =?, id_catedratico=?  WHERE id_materia=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             ps.setString(1, rolb.getMateria());
             ps.setString(2, rolb.getId_catedratico());
             ps.setString(3, rolb.getId_materia());
            
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(String id_materia)   throws Exception{
         String sql="DELETE FROM tbl_materia WHERE id_materia=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setString(1, id_materia);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<MateriaBean> consultarById(String id_materia) {
         String sql ="SELECT * FROM tbl_materia WHERE id_materia =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setString(1, id_materia);
         ResultSet rs = ps.executeQuery();
         List<MateriaBean> listar = new ArrayList<>();
        MateriaBean matb;
         while(rs.next()){
         matb = new MateriaBean(rs.getString("id_materia"));
        matb.setMateria(rs.getString("materia"));
        matb.setId_catedratico(rs.getString("id_catedratico"));
         listar.add(matb);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
         
}

        
package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CicloBean;


public class CicloDao {
    Conexion conn;

    public CicloDao(Conexion conn) {
        this.conn = conn;
    }

    public CicloDao() {
    }

    
    public boolean insertar(CicloBean cicb){
    String sql ="INSERT INTO tbl_ciclo VALUES(?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, cicb.getId_ciclo());
        ps.setString(2, cicb.getCiclo());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<CicloBean> consultar(){
        String sql ="SELECT * FROM tbl_ciclo";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            CicloBean cicb;
            List<CicloBean> lista = new LinkedList<>();
            while(rs.next()){
                cicb = new CicloBean(rs.getString("id_ciclo"));
                cicb.setCiclo(rs.getString("ciclo"));
                
                lista.add(cicb);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(CicloBean cicb){
         String sql ="UPDATE tbl_ciclo SET ciclo =?  WHERE id_ciclo=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             ps.setString(1, cicb.getCiclo());
             ps.setString(2, cicb.getId_ciclo());
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(String id_ciclo)   throws Exception{
         String sql="DELETE FROM tbl_ciclo WHERE id_ciclo=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setString(1, id_ciclo);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<CicloBean> consultarById(String id_ciclo) {
         String sql ="SELECT * FROM tbl_ciclo WHERE id_ciclo =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setString(1, id_ciclo);
         ResultSet rs = ps.executeQuery();
         List<CicloBean> listar = new ArrayList<>();
        CicloBean cicb;
         while(rs.next()){
         cicb = new CicloBean(rs.getString("id_ciclo"));
        cicb.setCiclo(rs.getString("ciclo"));
         listar.add(cicb);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
}

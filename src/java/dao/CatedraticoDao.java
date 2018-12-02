        
package dao;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.CatedraticoBean;


public class CatedraticoDao {
    Conexion conn;

    public CatedraticoDao(Conexion conn) {
        this.conn = conn;
    }

    public CatedraticoDao() {
    }

   

    

    
    public boolean insertar(CatedraticoBean catb){
    String sql ="INSERT INTO tbl_catedratico VALUES(?,?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, catb.getId_catedratico());
        ps.setString(2, catb.getId_persona());
        ps.setString(3, catb.getTitulo());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<CatedraticoBean> consultar(){
        String sql ="SELECT * FROM tbl_catedratico";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            CatedraticoBean catb;
            List<CatedraticoBean> lista = new LinkedList<>();
            while(rs.next()){
                catb = new CatedraticoBean(rs.getString("id_catedratico"));
                catb.setId_persona(rs.getString("id_persona"));
                catb.setTitulo(rs.getString("titulo"));
                
                lista.add(catb);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(CatedraticoBean catb){
         String sql ="UPDATE tbl_catedratico SET id_persona =?, titulo=?  WHERE id_catedratico=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             ps.setString(1, catb.getId_persona());
             ps.setString(2, catb.getTitulo());
             ps.setString(3, catb.getId_catedratico());
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(String id_catedratico)   throws Exception{
         String sql="DELETE FROM tbl_catedratico WHERE id_catedratico=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setString(1, id_catedratico);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<CatedraticoBean> consultarById(String id_catedratico) {
         String sql ="SELECT * FROM tbl_catedratico WHERE id_catedratico =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setString(1, id_catedratico);
         ResultSet rs = ps.executeQuery();
         List<CatedraticoBean> listar = new ArrayList<>();
        CatedraticoBean catb;
         while(rs.next()){
         catb = new CatedraticoBean(rs.getString("id_catedratico"));
        catb.setId_persona(rs.getString("id_persona"));
        catb.setTitulo(rs.getString("titulo"));
         listar.add(catb);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
         
        
}

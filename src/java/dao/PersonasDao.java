        
package dao;
 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PersonasBean;

public class PersonasDao {
    Conexion conn;

    public PersonasDao(Conexion conn) {
        this.conn = conn;
    }

    public PersonasDao() {
    }

   
        public int login(String usuario, String contra){
        Conexion conn = null;
        int nivel=0;
       String sql ="select id_rol from tbl_personas where correo='"+usuario+"' and id_persona='"+contra+"' ";
            try {
                PreparedStatement ps = conn.conectar().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {                    
                    nivel = rs.getInt(1);
                }
            } catch (Exception e) {
            }
        return nivel;
        }
    
    public boolean insertar(PersonasBean perb){
    String sql ="INSERT INTO tbl_personas VALUES(?,?,?,?,?,?,?,?,?)";
    try{
        PreparedStatement ps = conn.conectar().prepareStatement(sql);
        ps.setString(1, perb.getId_persona());
        ps.setString(2, perb.getNombre());
        ps.setString(3, perb.getApellido());
        ps.setInt(4, perb.getDui());
        ps.setInt(5, perb.getNit());
        ps.setString(6, perb.getDireccion());
        ps.setInt(7, perb.getTelefono());
        ps.setString(8, perb.getCorreo());
        ps.setInt(9, perb.getId_rol());
        ps.executeUpdate();
        return true;
    
    }catch(Exception e){
    return false;
    
    }
    
   
    
    }
         public List<PersonasBean> consultar(){
//        String sql ="SELECT tp.id_persona, tp.nombre, tp.apellido, tp.dui, tp.nit, tp.direccion, tp.telefono, "
//                + "tp.correo tr.rol FROM tbl_personas tp INNER JOIN tbl_rol ON tp.id_rol=tr.id_rol";
       String sql ="SELECT * FROM tbl_personas";
        try{
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PersonasBean perb;
            List<PersonasBean> lista = new LinkedList<>();
            while(rs.next()){
         perb = new PersonasBean(rs.getString("id_persona"));
         perb.setNombre(rs.getString("nombre"));
         perb.setApellido(rs.getString("apellido"));
         perb.setDui(rs.getInt("dui"));
         perb.setNit(rs.getInt("nit"));
         perb.setDireccion(rs.getString("direccion"));
         perb.setTelefono(rs.getInt("telefono"));
         perb.setCorreo(rs.getString("correo"));
         perb.setId_rol(rs.getInt("id_rol"));
         lista.add(perb);
            }return lista;
        }catch(Exception e){
            e.printStackTrace();
        return null;
        }
        
    
         }
         public boolean actualizar(PersonasBean perb){
         String sql ="UPDATE tbl_personas SET nombre =?, apellido=?, dui=?, nit=?, direccion=?,telefono=?, correo=?, id_rol= ? WHERE id_persona=?";
         try{
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             
             
        ps.setString(1, perb.getNombre());
        ps.setString(2, perb.getApellido());
        ps.setInt(3, perb.getDui());
        ps.setInt(4, perb.getNit());
        ps.setString(5, perb.getDireccion());
        ps.setInt(6, perb.getTelefono());
        ps.setString(7, perb.getCorreo());
        ps.setInt(8, perb.getId_rol());
        ps.setString(9, perb.getId_persona());
             ps.executeUpdate();
             return true;
         }catch(Exception e){
        e.printStackTrace();
         }
        return false;
         }
         public boolean eliminar(String id_persona)   throws Exception{
         String sql="DELETE FROM tbl_personas WHERE id_persona=?";
         try  {
             PreparedStatement ps = conn.conectar().prepareStatement(sql);
             ps.setString(1, id_persona);
             ps.executeUpdate();
             return true;
             
         }catch(SQLException e){
         e.printStackTrace();
         }
        return false;
         }
         public List<PersonasBean> consultarById(String id_persona) {
         String sql ="SELECT tp.* FROM tbl_personas tp INNER JOIN tbl_rol tr ON tr.id_rol=tp.id_rol WHERE id_persona =?";
         try{
         PreparedStatement ps = conn.conectar().prepareStatement(sql);
         ps.setString(1, id_persona);
         ResultSet rs = ps.executeQuery();
         List<PersonasBean> listar = new ArrayList<>();
         PersonasBean perb;
         while(rs.next()){
         perb = new PersonasBean(rs.getString("id_persona"));
         perb.setNombre(rs.getString("nombre"));
         perb.setApellido(rs.getString("apellido"));
         perb.setDui(rs.getInt("dui"));
         perb.setNit(rs.getInt("nit"));
         perb.setDireccion(rs.getString("direccion"));
         perb.setTelefono(rs.getInt("telefono"));
         perb.setCorreo(rs.getString("correo"));
         perb.setId_rol(rs.getInt("id_rol"));
         listar.add(perb);
         }
        return listar;
         
         } catch (Exception e) {
             return null;
        }
        
         }
          public ResultSet mostrar(){
         Conexion conn = new Conexion();
         String com = "select nombre, apellido from tbl_personas where id_rol=1";
         ResultSet rs =  conn.getDatos(com);
         return rs;
         }
}

package dao;

import modelo.ParcialBean;
import modelo.PruebaIntermediaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParcialDao {

    Conexion conn;

    public ParcialDao(Conexion conn) {
        this.conn = conn;
    }

    public ParcialDao() {

    }

    public boolean insertar(ParcialBean parb) {
        String sql = "INSERT INTO tbl_parcial VALUES(?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, parb.getId_parcial());
            ps.setString(2, parb.getNombre());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;

        }

    }

    public List<ParcialBean> consultar() {
        String sql = "SELECT * FROM tbl_parcial";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ParcialBean parb;
            List<ParcialBean> lista = new LinkedList<>();
            while (rs.next()) {
                parb = new ParcialBean(rs.getString("id_parcial"));
                parb.setNombre(rs.getString("nombre"));
                lista.add(parb);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean actualizar(ParcialBean parb) {
        String sql = "UPDATE tbl_parcial SET nombre =? WHERE id_parcial=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, parb.getNombre());
            ps.setString(2, parb.getId_parcial());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(String id_parcial) throws Exception {
        String sql = "DELETE FROM tbl_parcial WHERE id_parcial=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, id_parcial);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ParcialBean> consultarById(String id_parcial) {
        String sql = "SELECT * FROM tbl_parcial WHERE id_parcial =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, id_parcial);
            ResultSet rs = ps.executeQuery();
            List<ParcialBean> listar = new ArrayList<>();
            ParcialBean parb;
            while (rs.next()) {
                parb = new ParcialBean(rs.getString("id_parcial"));
                parb.setNombre(rs.getString("nombre"));
                listar.add(parb);
            }
            return listar;

        } catch (Exception e) {
            return null;
        }

    }
    
}

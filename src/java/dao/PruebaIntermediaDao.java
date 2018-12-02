package dao;

import modelo.PruebaIntermediaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PruebaIntermediaDao {

    Conexion conn;

    public PruebaIntermediaDao(Conexion conn) {
        this.conn = conn;
    }

    public PruebaIntermediaDao() {

    }

    public boolean insertar(PruebaIntermediaBean prib) {
        String sql = "INSERT INTO tbl_pi VALUES(?,?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, prib.getId_pi());
            ps.setString(2, prib.getNombre());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;

        }

    }

    public List<PruebaIntermediaBean> consultar() {
        String sql = "SELECT * FROM tbl_pi";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            PruebaIntermediaBean prib;
            List<PruebaIntermediaBean> lista = new LinkedList<>();
            while (rs.next()) {
                prib = new PruebaIntermediaBean(rs.getString("id_pi"));
                prib.setNombre(rs.getString("nombre"));
                lista.add(prib);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean actualizar(PruebaIntermediaBean prib) {
        String sql = "UPDATE tbl_pi SET nombre =? WHERE id_pi=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, prib.getNombre());
            ps.setString(2, prib.getId_pi());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(String id_pi) throws Exception {
        String sql = "DELETE FROM tbl_pi WHERE id_pi=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, id_pi);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<PruebaIntermediaBean> consultarById(String id_pi) {
        String sql = "SELECT * FROM tbl_pi WHERE id_pi =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setString(1, id_pi);
            ResultSet rs = ps.executeQuery();
            List<PruebaIntermediaBean> listar = new ArrayList<>();
            PruebaIntermediaBean prib;
            while (rs.next()) {
                prib = new PruebaIntermediaBean(rs.getString("id_pi"));
                prib.setNombre(rs.getString("nombre"));
                listar.add(prib);
            }
            return listar;

        } catch (Exception e) {
            return null;
        }

    }

}

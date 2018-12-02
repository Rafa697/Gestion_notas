package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import modelo.NotaPIBean;
import modelo.PruebaIntermediaBean;

public class NotaPIDao {

    Conexion conn;

    public NotaPIDao(Conexion conn) {
        this.conn = conn;
    }

    public NotaPIDao() {

    }

    public boolean insertar(NotaPIBean npib) {
        String sql = "INSERT INTO tbl_notapi VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, npib.getId_notapi());
            ps.setString(2, npib.getId_pi());
            ps.setInt(3, npib.getId_coleccion());
            ps.setDouble(4, npib.getNota());
            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            return false;

        }

    }

    public List<NotaPIBean> consultar() {
        String sql = "SELECT * FROM tbl_notapi";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            NotaPIBean npib;
            List<NotaPIBean> lista = new LinkedList<>();
            while (rs.next()) {
                npib = new NotaPIBean(rs.getInt("id_notapi"));
                npib.setId_pi(rs.getString("id_pi"));
                npib.setId_coleccion(rs.getInt("id_coleccion"));
                npib.setNota(rs.getDouble("nota"));
                lista.add(npib);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean actualizar(NotaPIBean npib) {
        String sql = "UPDATE tbl_notapi SET id_pi =?, id_coleccion = ?, nota = ? WHERE id_notapi=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);

            ps.setString(1, npib.getId_pi());
            ps.setInt(2, npib.getId_coleccion());
            ps.setDouble(3, npib.getNota());
            ps.setInt(4, npib.getId_notapi());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id_notapi) throws Exception {
        String sql = "DELETE FROM tbl_notapi WHERE id_notapi=?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_notapi);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<NotaPIBean> consultarById(int id_notapi) {
        String sql = "SELECT * FROM tbl_notapi WHERE id_notapi =?";
        try {
            PreparedStatement ps = conn.conectar().prepareStatement(sql);
            ps.setInt(1, id_notapi);
            ResultSet rs = ps.executeQuery();
            List<NotaPIBean> listar = new ArrayList<>();
            NotaPIBean npib;
            while (rs.next()) {
                npib = new NotaPIBean(rs.getInt("id_notapi"));
                npib.setId_pi(rs.getString("id_pi"));
                npib.setId_coleccion(rs.getInt("id_coleccion"));
                npib.setNota(rs.getDouble("nota"));
                listar.add(npib);
            }
            return listar;

        } catch (Exception e) {
            return null;
        }

    }
    
}

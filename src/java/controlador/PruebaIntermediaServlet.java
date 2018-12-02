package controlador;

import dao.Conexion;
import dao.PruebaIntermediaDao;
import modelo.PruebaIntermediaBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PruebaIntermediaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "insertar":
                    insertar(request, response);
                    break;
                case "consultar":
                    consultar(request, response);
                    break;
                case "consultarById":
                    consultarById(request, response);
                    break;
                case "eliminar":
                    eliminar(request, response);
                    break;
                case "editar":
                    editar(request, response);
                    break;
                case "actualizar":
                    actualizar(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    private void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_pi = request.getParameter("id_pi");
        String nombre = request.getParameter("nombre");
        PruebaIntermediaBean prib = new PruebaIntermediaBean();
        prib.setId_pi(id_pi);
        prib.setNombre(nombre);
        Conexion conn = new Conexion();
        PruebaIntermediaDao prid = new PruebaIntermediaDao(conn);
        boolean res = prid.insertar(prib);
        String msg;
        if (res) {
            msg = "Exito al ingresar";
        } else {
            msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("PruebaIntermedia/insertar.jsp");
        rd.forward(request, response);
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        PruebaIntermediaDao prid = new PruebaIntermediaDao(conn);
        List<PruebaIntermediaBean> lista = prid.consultar();

        request.setAttribute("listar", lista);
        request.getRequestDispatcher("PruebaIntermedia/datos.jsp");
        request.getRequestDispatcher("catedratico/PruebaIntermedia/datos.jsp").forward(request, response);
        System.out.println(lista);

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String id_pi = request.getParameter("id_pi");
        Conexion conn = new Conexion();
        PruebaIntermediaDao prid = new PruebaIntermediaDao(conn);

        boolean resp = prid.eliminar(id_pi);
        String msg;
        if (resp) {
            msg = "Exito al eliminar";
        } else {
            msg = "Error";
        }
        List<PruebaIntermediaBean> lista = prid.consultar();

        request.setAttribute("msg", msg);
        request.setAttribute("listar", lista);
        request.getRequestDispatcher("PruebaIntermedia/datos.jsp").forward(request, response);

    }

    private void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String id_pi = request.getParameter("id_pi");
        Conexion conn = new Conexion();
        PruebaIntermediaDao prid = new PruebaIntermediaDao(conn);
        List<PruebaIntermediaBean> listar = prid.consultarById(id_pi);

        request.setAttribute("listar", listar);
        request.getRequestDispatcher("PruebaIntermedia/modificar.jsp").forward(request, response);

    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        PruebaIntermediaDao prid = new PruebaIntermediaDao(conn);
        String id_pi = request.getParameter("id_pi");

        List<PruebaIntermediaBean> listar = prid.consultarById(id_pi);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("PruebaIntermedia/modificar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_pi = request.getParameter("id_pi");
        String nombre = request.getParameter("nombre");
        PruebaIntermediaBean prib = new PruebaIntermediaBean();
        prib.setNombre(nombre);
        prib.setId_pi(id_pi);
        Conexion conn = new Conexion();
        PruebaIntermediaDao prid = new PruebaIntermediaDao(conn);
        boolean res = prid.actualizar(prib);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        } else {
            msj = "error al actualizar";
        }
        List<PruebaIntermediaBean> listar = prid.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("PruebaIntermedia/datos.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}

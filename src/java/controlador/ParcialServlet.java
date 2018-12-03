package controlador;

import dao.Conexion;
import dao.ParcialDao;
import dao.PruebaIntermediaDao;
import modelo.ParcialBean;
import modelo.PruebaIntermediaBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParcialServlet extends HttpServlet {

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
        String id_parcial = request.getParameter("id_parcial");
        String nombre = request.getParameter("nombre");
        ParcialBean parb = new ParcialBean();
        parb.setId_parcial(id_parcial);
        parb.setNombre(nombre);
        Conexion conn = new Conexion();
        ParcialDao pard = new ParcialDao(conn);
        boolean res = pard.insertar(parb);
        String msg;
        if (res) {
            msg = "Exito al ingresar";
        } else {
            msg = "Error al ingresar";
        }
       
        request.setAttribute("msg", msg);
       request.getRequestDispatcher("Parcial/insertar.jsp").forward(request, response);
       request.getRequestDispatcher("catedratico/Parcial/insertar.jsp").forward(request, response);
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        ParcialDao pard = new ParcialDao(conn);
        List<ParcialBean> lista = pard.consultar();

        request.setAttribute("listar", lista);
        request.getRequestDispatcher("Parcial/datos.jsp").forward(request, response);
        request.getRequestDispatcher("catedratico/Parcial/datos.jsp").forward(request, response);
        System.out.println(lista);

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String id_parcial = request.getParameter("id_parcial");
        Conexion conn = new Conexion();
        ParcialDao pard = new ParcialDao(conn);

        boolean resp = pard.eliminar(id_parcial);
        String msg;
        if (resp) {
            msg = "Exito al eliminar";
        } else {
            msg = "Error";
        }
        List<ParcialBean> lista = pard.consultar();

        request.setAttribute("msg", msg);
        request.setAttribute("listar", lista);
        request.getRequestDispatcher("Parcial/datos.jsp").forward(request, response);
        request.getRequestDispatcher("catedratico/Parcial/datos.jsp").forward(request, response);

    }

    private void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        String id_parcial = request.getParameter("id_parcial");
        Conexion conn = new Conexion();
        ParcialDao pard = new ParcialDao(conn);
        List<ParcialBean> listar = pard.consultarById(id_parcial);

        request.setAttribute("listar", listar);
        request.getRequestDispatcher("Parcial/modificar.jsp").forward(request, response);
        request.getRequestDispatcher("catedratico/Parcial/modificar.jsp").forward(request, response);

    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        ParcialDao pard = new ParcialDao(conn);
        String id_parcial = request.getParameter("id_parcial");

        List<ParcialBean> listar = pard.consultarById(id_parcial);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("Parcial/modificar.jsp").forward(request, response);
        request.getRequestDispatcher("catedratico/Parcial/modificar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_parcial = request.getParameter("id_parcial");
        String nombre = request.getParameter("nombre");
        ParcialBean parb = new ParcialBean();
        parb.setNombre(nombre);
        parb.setId_parcial(id_parcial);
        Conexion conn = new Conexion();
        ParcialDao pard = new ParcialDao(conn);
        boolean res = pard.actualizar(parb);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        } else {
            msj = "error al actualizar";
        }
        List<ParcialBean> listar = pard.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
       
        request.getRequestDispatcher("Parcial/datos.jsp").forward(request, response);
         request.getRequestDispatcher("Parcial/datos.jsp").forward(request, response);
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

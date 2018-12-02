package controlador;

import dao.Conexion;
import dao.NotaPIDao;
import dao.PruebaIntermediaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.NotaPIBean;
import modelo.PruebaIntermediaBean;

public class NotaPruebaIntermediaServlet extends HttpServlet {

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
        int id_coleccion = Integer.parseInt(request.getParameter("id_coleccion"));
        
        Double nota = Double.parseDouble(request.getParameter("nota"));
        NotaPIBean npib = new NotaPIBean(0);
        npib.setId_pi(id_pi);
        npib.setId_coleccion(id_coleccion);
        npib.setNota(nota);
        Conexion conn = new Conexion();
        NotaPIDao npid = new NotaPIDao(conn);
        boolean res = npid.insertar(npib);
        String msg;
        if (res) {
            msg = "Exito al ingresar";
        } else {
            msg = "Error al ingresar";
        }
       
        request.setAttribute("msg", msg);
         request.getRequestDispatcher("NotaPruebaIntermedia/insertar.jsp").forward(request, response);
          request.getRequestDispatcher("catedratico/NotaPruebaIntermedia/insertar.jsp").forward(request, response);
    }

    private void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conn = new Conexion();
        NotaPIDao npid = new NotaPIDao(conn);
        List<NotaPIBean> lista = npid.consultar();

        request.setAttribute("listar", lista);
        request.getRequestDispatcher("NotaPruebaIntermedia/datos.jsp").forward(request, response);
        request.getRequestDispatcher("catedratico/NotaPruebaIntermedia/datos.jsp").forward(request, response);
        System.out.println(lista);

    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        int id_notapi = Integer.parseInt(request.getParameter("id_notapi"));
        Conexion conn = new Conexion();
        NotaPIDao npid = new NotaPIDao(conn);

        boolean resp = npid.eliminar(id_notapi);
        String msg;
        if (resp) {
            msg = "Exito al eliminar";
        } else {
            msg = "Error";
        }
        List<NotaPIBean> lista = npid.consultar();

        request.setAttribute("msg", msg);
        request.setAttribute("listar", lista);
        request.getRequestDispatcher("NotaPruebaIntermedia/datos.jsp").forward(request, response);

    }

    private void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        int id_notapi = Integer.parseInt(request.getParameter("id_notapi"));
        Conexion conn = new Conexion();
        NotaPIDao npid = new NotaPIDao(conn);
        List<NotaPIBean> listar = npid.consultarById(id_notapi);

        request.setAttribute("listar", listar);
        request.getRequestDispatcher("NotaPruebaIntermedia/modificar.jsp").forward(request, response);

    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        NotaPIDao npid = new NotaPIDao(conn);
        int id_notapi = Integer.parseInt(request.getParameter("id_notapi"));

        List<NotaPIBean> listar = npid.consultarById(id_notapi);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("NotaPruebaIntermedia/modificar.jsp").forward(request, response);
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_pi = request.getParameter("id_pi");
        int id_coleccion = Integer.parseInt(request.getParameter("id_coleccion"));
        Double nota = Double.parseDouble(request.getParameter("nota"));
        NotaPIBean npib = new NotaPIBean();
        npib.setId_pi(id_pi);
        npib.setId_coleccion(id_coleccion);
        npib.setNota(nota);
        Conexion conn = new Conexion();
        NotaPIDao npid = new NotaPIDao(conn);
        boolean res = npid.actualizar(npib);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        } else {
            msj = "error al actualizar";
        }
        List<NotaPIBean> listar = npid.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("NotaPruebaIntermedia/datos.jsp");
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

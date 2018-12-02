
package controlador;


import dao.Conexion;
import dao.CatedraticoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CatedraticoBean;



public class CatedraticoServlet extends HttpServlet {
    private CatedraticoDao catd = new CatedraticoDao();
   
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
            throws ServletException, IOException{
    String id_catedratico = request.getParameter("id_catedratico");
    String id_persona = request.getParameter("id_persona");
    String titulo = request.getParameter("titulo");
    CatedraticoBean catb = new CatedraticoBean();
   catb.setId_catedratico(id_catedratico);
   catb.setId_persona(id_persona);
   catb.setTitulo(titulo);
   
   
    Conexion conn = new Conexion(); 
     CatedraticoDao catd = new CatedraticoDao(conn);
    boolean res = catd.insertar(catb);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("catedratico/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
       CatedraticoDao catd = new CatedraticoDao(conn);
        List<CatedraticoBean> lista = catd.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("catedratico/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       String id_catedratico =request.getParameter("id_catedratico");
       String id_persona =request.getParameter("id_persona");
       String titulo =request.getParameter("titulo");
       Conexion conn = new Conexion();
       CatedraticoDao catd = new CatedraticoDao(conn);
       
       boolean resp = catd.eliminar(id_catedratico);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<CatedraticoBean> lista = catd.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("catedratico/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    String id_catedratico =request.getParameter("id_catedratico");
       Conexion conn = new Conexion();
       CatedraticoDao catd = new CatedraticoDao(conn);
       List<CatedraticoBean> listar = catd.consultarById(id_catedratico);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("catedratico/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
       CatedraticoDao catd = new CatedraticoDao(conn);
        String id_catedratico =request.getParameter("id_catedratico");
        
        List<CatedraticoBean> listar = catd.consultarById(id_catedratico);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("catedratico/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_catedratico = request.getParameter("id_catedratico");
    String id_persona = request.getParameter("id_persona");
    String titulo = request.getParameter("titulo");
   CatedraticoBean catb = new CatedraticoBean();
   catb.setId_persona(id_persona);
   catb.setTitulo(titulo);
   catb.setId_catedratico(id_catedratico);
    Conexion conn = new Conexion(); 
  CatedraticoDao catd = new CatedraticoDao(conn);
    boolean res = catd.actualizar(catb);
    String msg;
        if (res) {
            msg ="Exito al actulizar";
        }else{
        msg = "Error al actualizar";
        }
        List<CatedraticoBean> listar = catd.consultar();
        request.setAttribute("msg", msg);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("catedratico/datos.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        processRequest(request, response);
    
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
    processRequest(request, response);
    }
    }

    
   


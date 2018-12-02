
package controlador;


import dao.CicloDao;
import dao.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.CicloBean;



public class CicloServlet extends HttpServlet {
    private CicloDao cicd = new CicloDao();
   
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
    String id_ciclo = request.getParameter("id_ciclo");
    String ciclo = request.getParameter("ciclo");
    CicloBean cicb = new CicloBean();
    cicb.setId_ciclo(id_ciclo);
    cicb.setCiclo(ciclo);
   
    Conexion conn = new Conexion(); 
    CicloDao cicd = new CicloDao(conn);
    boolean res = cicd.insertar(cicb);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("ciclo/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
        CicloDao cicd = new CicloDao(conn);
        List<CicloBean> lista = cicd.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("ciclo/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       String id_ciclo = request.getParameter("id_ciclo");
       Conexion conn = new Conexion();
       CicloDao cicd = new CicloDao(conn);
       
       boolean resp = cicd.eliminar(id_ciclo);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<CicloBean> lista = cicd.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("ciclo/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    String  id_ciclo = request.getParameter("id_ciclo");
       Conexion conn = new Conexion();
       CicloDao cicd = new CicloDao(conn);
       List<CicloBean> listar = cicd.consultarById(id_ciclo);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("ciclo/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        CicloDao cicd = new CicloDao(conn);
        String id_ciclo = request.getParameter("id_ciclo");
        
        List<CicloBean> listar = cicd.consultarById(id_ciclo);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("ciclo/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_ciclo = request.getParameter("id_ciclo");
        String ciclo = request.getParameter("ciclo");
       CicloBean  cicb = new CicloBean();
        cicb.setCiclo(ciclo);
        cicb.setId_ciclo(id_ciclo);
        Conexion conn = new Conexion();
        CicloDao cicd = new CicloDao(conn);
        boolean res = cicd.actualizar(cicb);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        }else{
            msj = "error al actualizar";
        }
        List<CicloBean> listar = cicd.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("ciclo/datos.jsp");
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

    
   


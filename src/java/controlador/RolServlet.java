
package controlador;


import dao.Conexion;
import dao.RolDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RolBean;



public class RolServlet extends HttpServlet {
    private RolDao rold = new RolDao();
   
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
    String rol = request.getParameter("rol");
    RolBean rolb = new RolBean(0);
    rolb.setRol(rol);
   
    Conexion conn = new Conexion(); 
    RolDao rold = new RolDao(conn);
    boolean res = rold.insertar(rolb);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("rol/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
        RolDao rold = new RolDao(conn);
        List<RolBean> lista = rold.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("rol/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       int id_rol = Integer.parseInt(request.getParameter("id_rol"));
       Conexion conn = new Conexion();
       RolDao rold = new RolDao(conn);
       
       boolean resp = rold.eliminar(id_rol);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<RolBean> lista = rold.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("rol/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    int id_rol = Integer.parseInt(request.getParameter("id_rol"));
       Conexion conn = new Conexion();
       RolDao rold = new RolDao(conn);
       List<RolBean> listar = rold.consultarById(id_rol);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("rol/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        RolDao rold = new RolDao(conn);
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));
        
        List<RolBean> listar = rold.consultarById(id_rol);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("rol/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_rol = Integer.parseInt(request.getParameter("id_rol"));
        String rol = request.getParameter("rol");
       RolBean  rolb = new RolBean();
        rolb.setRol(rol);
        rolb.setId_rol(id_rol);
        Conexion conn = new Conexion();
        RolDao rold = new RolDao(conn);
        boolean res = rold.actualizar(rolb);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        }else{
            msj = "error al actualizar";
        }
        List<RolBean> listar = rold.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("rol/datos.jsp");
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

    
   


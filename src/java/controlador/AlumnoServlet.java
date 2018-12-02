
package controlador;


import dao.Conexion;
import dao.AlumnoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.AlumnoBean;



public class AlumnoServlet extends HttpServlet {
    private AlumnoDao alud = new AlumnoDao();
   
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
    String id_alumno = request.getParameter("id_alumno");
    String id_persona = request.getParameter("id_persona");
    String id_carrera = request.getParameter("id_carrera");
    AlumnoBean alub = new AlumnoBean();
   alub.setId_alumno(id_alumno);
   alub.setId_persona(id_persona);
   alub.setId_carrera(id_carrera);
   
   
    Conexion conn = new Conexion(); 
    AlumnoDao alud = new AlumnoDao(conn);
    boolean res = alud.insertar(alub);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("alumno/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
       AlumnoDao alud = new AlumnoDao(conn);
        List<AlumnoBean> lista = alud.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("alumno/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       String id_alumno =request.getParameter("id_alumno");
       String id_persona =request.getParameter("id_persona");
       String id_carrera =request.getParameter("id_carrera");
       Conexion conn = new Conexion();
      AlumnoDao alud = new AlumnoDao(conn);
       
       boolean resp = alud.eliminar(id_alumno);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<AlumnoBean> lista = alud.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("alumno/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    String id_alumno =request.getParameter("id_alumno");
       Conexion conn = new Conexion();
       AlumnoDao alud = new AlumnoDao(conn);
       List<AlumnoBean> listar = alud.consultarById(id_alumno);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("alumno/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
     AlumnoDao alud = new AlumnoDao(conn);
        String id_alumno =request.getParameter("id_alumno");
        
        List<AlumnoBean> listar = alud.consultarById(id_alumno);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("alumno/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_alumno = request.getParameter("id_alumno");
    String id_persona = request.getParameter("id_persona");
    String id_carrera = request.getParameter("id_carrera");
   AlumnoBean alub = new AlumnoBean();
   alub.setId_persona(id_persona);
   alub.setId_carrera(id_carrera);
   alub.setId_alumno(id_alumno);
    Conexion conn = new Conexion(); 
 AlumnoDao alud = new AlumnoDao(conn);
    boolean res = alud.actualizar(alub);
    String msg;
        if (res) {
            msg ="Exito al actulizar";
        }else{
        msg = "Error al actualizar";
        }
        List<AlumnoBean> listar = alud.consultar();
        request.setAttribute("msg", msg);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("alumno/datos.jsp");
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

    
   


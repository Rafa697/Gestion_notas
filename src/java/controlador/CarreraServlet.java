
package controlador;


import dao.CarreraDao;
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
import modelo.CarreraBean;



public class CarreraServlet extends HttpServlet {
    private CarreraDao card = new CarreraDao();
   
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
    String id_carrera = request.getParameter("id_carrera");
    String carrera = request.getParameter("carrera");
    CarreraBean carb = new CarreraBean();
    carb.setId_carrera(id_carrera);
    carb.setCarrera(carrera);
   
    Conexion conn = new Conexion(); 
    CarreraDao card = new CarreraDao(conn);
    boolean res = card.insertar(carb);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("carrera/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
        CarreraDao card = new CarreraDao(conn);
        List<CarreraBean> lista = card.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("carrera/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       String id_carrera = request.getParameter("id_carrera");
       Conexion conn = new Conexion();
       CarreraDao card = new CarreraDao(conn);
       
       boolean resp = card.eliminar(id_carrera);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<CarreraBean> lista = card.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("carrera/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    String  id_carrera = request.getParameter("id_carrera");
       Conexion conn = new Conexion();
       CarreraDao card = new CarreraDao(conn);
       List<CarreraBean> listar = card.consultarById(id_carrera);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("carrera/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
       CarreraDao card = new CarreraDao(conn);
        String id_carrera = request.getParameter("id_carrera");
        
        List<CarreraBean> listar = card.consultarById(id_carrera);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("carrera/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_carrera = request.getParameter("id_carrera");
        String carrera = request.getParameter("carrera");
       CarreraBean  carb = new CarreraBean();
        carb.setCarrera(carrera);
        carb.setId_carrera(id_carrera);
        Conexion conn = new Conexion();
        CarreraDao card = new CarreraDao(conn);
        boolean res = card.actualizar(carb);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        }else{
            msj = "error al actualizar";
        }
        List<CarreraBean> listar =  card.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("carrera/datos.jsp");
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

    
   


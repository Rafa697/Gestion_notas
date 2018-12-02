
package controlador;


import dao.Conexion;
import dao.MateriaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.MateriaBean;



public class MateriaServlet extends HttpServlet {
    private MateriaDao matd = new MateriaDao();
   
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
    String id_materia = request.getParameter("id_materia");
    String materia = request.getParameter("materia");
    String id_catedratico = request.getParameter("id_catedratico");
    MateriaBean matb = new MateriaBean();
    matb.setId_materia(id_materia);
    matb.setMateria(materia);
    matb.setId_catedratico(id_catedratico);
   
    Conexion conn = new Conexion(); 
    MateriaDao matd = new MateriaDao(conn);
    boolean res = matd.insertar(matb);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("materia/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
        MateriaDao matd = new MateriaDao(conn);
        List<MateriaBean> lista = matd.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("materia/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       String id_materia =request.getParameter("id_materia");
       String materia =request.getParameter("materia");
       String catedratico =request.getParameter("id_catedratico");
       Conexion conn = new Conexion();
       MateriaDao matd = new MateriaDao(conn);
       
       boolean resp = matd.eliminar(id_materia);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<MateriaBean> lista = matd.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("materia/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    String id_materia =request.getParameter("id_materia");
       Conexion conn = new Conexion();
       MateriaDao matd = new MateriaDao(conn);
       List<MateriaBean> listar = matd.consultarById(id_materia);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("materia/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        MateriaDao matd = new MateriaDao(conn);
        String id_materia =request.getParameter("id_materia");
        
        List<MateriaBean> listar = matd.consultarById(id_materia);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("materia/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_materia = request.getParameter("id_materia");
    String materia = request.getParameter("materia");
    String id_catedratico = request.getParameter("id_catedratico");
    MateriaBean matb = new MateriaBean();
    matb.setMateria(materia);
    matb.setId_catedratico(id_catedratico);
   matb.setId_materia(id_materia);
    Conexion conn = new Conexion(); 
    MateriaDao matd = new MateriaDao(conn);
    boolean res = matd.actualizar(matb);
    String msg;
        if (res) {
            msg ="Exito al actulizar";
        }else{
        msg = "Error al actualizar";
        }
        List<MateriaBean> listar = matd.consultar();
        request.setAttribute("msg", msg);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("materia/datos.jsp");
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

    
   


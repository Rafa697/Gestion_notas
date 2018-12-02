
package controlador;


import dao.Conexion;
import dao.PersonasDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.PersonasBean;




public class PersonasServlet extends HttpServlet {
    private PersonasDao perd = new PersonasDao();
   
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
        String id_persona = request.getParameter("id_persona");
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    int dui = Integer.parseInt(request.getParameter("dui"));
    int nit= Integer.parseInt(request.getParameter("nit"));
    String direccion = request.getParameter("direccion");
    int telefono= Integer.parseInt(request.getParameter("telefono"));
    String correo = request.getParameter("correo");
    int id_rol = Integer.parseInt(request.getParameter("id_rol"));
    
    PersonasBean perb = new PersonasBean();
    perb.setId_persona(id_persona);
    perb.setNombre(nombre);
    perb.setApellido(apellido);
    perb.setDui(dui);
    perb.setNit(nit);
    perb.setDireccion(direccion);
    perb.setTelefono(telefono);
    perb.setCorreo(correo);
    perb.setId_rol(id_rol);
   
    Conexion conn = new Conexion(); 
    PersonasDao perd = new PersonasDao(conn);
    boolean res = perd.insertar(perb);
    String msg;
        if (res) {
            msg ="Exito al ingresar";
        }else{
        msg = "Error al ingresar";
        }
        RequestDispatcher rd;
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("personas/insertar.jsp");
        rd.forward(request, response);
    }
        private void consultar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
        Conexion conn = new Conexion();
        PersonasDao perd = new PersonasDao(conn);
        List<PersonasBean> lista = perd.consultar();
        
        
        request.setAttribute("listar", lista);
         request.getRequestDispatcher("personas/datos.jsp").forward(request, response);
            System.out.println(lista);
    
    }
        
private void eliminar(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
       String id_persona = request.getParameter("id_persona");
       Conexion conn = new Conexion();
       PersonasDao perd = new PersonasDao(conn);
       
       boolean resp = perd.eliminar(id_persona);
       String msg;
       if (resp) {
        msg="Exito al eliminar";
    }else{
       msg="error";
       }
       List<PersonasBean> lista = perd.consultar();
    
    request.setAttribute("msg", msg);
    request.setAttribute("listar", lista);
     request.getRequestDispatcher("personas/datos.jsp").forward(request, response);
   
    
    }
private void consultarById(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
    String id_persona = request.getParameter("id_persona");
       Conexion conn = new Conexion();
       PersonasDao perd = new PersonasDao(conn);
       List<PersonasBean> listar = perd.consultarById(id_persona);
       
        
    request.setAttribute("listar", listar);
    request.getRequestDispatcher("personas/modificar.jsp").forward(request, response);
       

}
 private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        Conexion conn = new Conexion();
        PersonasDao perd = new PersonasDao(conn);
        String id_persona = request.getParameter("id_persona");
        
        List<PersonasBean> listar = perd.consultarById(id_persona);
        request.setAttribute("listar", listar);
        request.getRequestDispatcher("personas/modificar.jsp").forward(request, response);
    }

    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String id_persona = request.getParameter("id_persona");
       String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    int dui = Integer.parseInt(request.getParameter("dui"));
    int nit= Integer.parseInt(request.getParameter("nit"));
    String direccion = request.getParameter("direccion");
    int telefono= Integer.parseInt(request.getParameter("telefono"));
    String correo = request.getParameter("correo");
    int id_rol = Integer.parseInt(request.getParameter("id_rol"));
    
    
    PersonasBean perb = new PersonasBean();
    perb.setNombre(nombre);
    perb.setApellido(apellido);
    perb.setDui(dui);
    perb.setNit(nit);
    perb.setDireccion(direccion);
    perb.setTelefono(telefono);
    perb.setCorreo(correo);
    perb.setId_rol(id_rol);
    perb.setId_persona(id_persona);
        Conexion conn = new Conexion();
        PersonasDao perd = new PersonasDao(conn);
        boolean res = perd.actualizar(perb);
        String msj;
        if (res) {
            msj = "Actualizado con exito!";
        }else{
            msj = "error al actualizar";
        }
        List<PersonasBean> listar = perd.consultar();
        request.setAttribute("msg", msj);
        request.setAttribute("listar", listar);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("personas/datos.jsp");
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

    
   


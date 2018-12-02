<%-- 
    Document   : insertar
    Created on : 11-26-2018, 03:39:30 PM
    Author     : Alumno 35
--%>

<%@page import="dao.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-4">
                </div>
                <div class="col-4">
                    <form action="../notaPI?action=insertar" method="POST" >
                        <h1> Notas Pruebas Intermedias</h1>
                        <label for="nombre">Id_pi</label>
                       <select name="id_pi">
            <%
            Conexion cn = new Conexion();
            try {
                    cn.conectar();
                    String sql="select id_pi from tbl_pi";
                    cn.st=cn.conn.createStatement();
                    cn.rs=cn.st.executeQuery(sql);
                    while(cn.rs.next()){
                    out.println("<option>"+cn.rs.getString(1)+"</option>");
                    }
                } catch (Exception e) {
                    out.print(e.toString());
                }
            %>
                        </select><br>
                        <label for="nombre">Id_coleccion</label>
                        <select name="id_coleccion">
            <%
             cn = new Conexion();
            try {
                    cn.conectar();
                    String sql="select * from tbl_coleccion";
                    cn.st=cn.conn.createStatement();
                    cn.rs=cn.st.executeQuery(sql);
                    while(cn.rs.next()){
                    out.println("<option>"+cn.rs.getString(1)+"</option>");
                    }
                } catch (Exception e) {
                    out.print(e.toString());
                }
            %>
                        </select><br>
                        
                        <label for="nombre">Nota</label>
                        <input class="form-control" name="nota" required="">
                        <br>
                        <button class="form-control btn badge-light btn-dark" >Enviar</button>
                    </form>
                    ${msg}
                    <br>
                    <br>
                    <center> <a class="btn btn-dark btn-light" href="../index.jsp" >↩ Volver a inicio</a> </center>
                </div>
            </div>
        </div>
    </body>
</html>

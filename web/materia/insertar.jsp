<%-- 
    Document   : index
    Created on : 10-16-2018, 07:23:10 PM
    Author     : Alumno 08
--%>

<%@page import="dao.Conexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Inicio</title>
    </head>
    <body>
        <div class="container">
             <div class="row">
                 <div class="col-4">
                     
                 </div>
                 <div class="col-4">
                     <form action="../materia?action=insertar" method="POST">
                         <h1> Maaterias </h1>
            <label for="nombre">Id Materia</label>
            <input class="form-control " name="id_materia" required="">
            <label for="nombre">Materia</label>
            <input class="form-control " name="materia" required="">
            <label for="nombre">Id Catedratico</label>
            <select name="id_catedratico">
            <%
            Conexion cn = new Conexion();
            try {
                    cn.conectar();
                    String sql="select id_catedratico from tbl_catedratico";
                    cn.st=cn.conn.createStatement();
                    cn.rs=cn.st.executeQuery(sql);
                    while(cn.rs.next()){
                    out.println("<option>"+cn.rs.getString(1)+"</option>");
                    }
                } catch (Exception e) {
                    out.print(e.toString());
                }
            %>
            </select>
            

            <br>
            <button class="form-control btn badge-light btn-dark" >Enviar</button>
                     </form>
                     ${msg}
                     <br>
                     <br>
                     <center> <a class="btn btn-dark btn-light" href="/Gestion_notas/index.jsp" >↩ Volver a inicio</a> </center>
        </div>
                     
                    
                    
             </div>
        </div>
</body>
</html>

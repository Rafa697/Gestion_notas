<%-- 
    Document   : Datos.jsp
    Created on : 10-23-2018, 06:43:42 PM
    Author     : Alumno 08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <title>Materias</title>
    </head>
    <body>
        <div class="container">
            <form action="catedratico?action=insertar" method="POST"> 
                    <h1>Materias </h1>
                    <a class="btn btn-dark btn-light" href="/Gestion_notas/index.jsp" >↩ Volver a inicio</a>
                    <a class="btn btn-success " href="catedratico/insertar.jsp">➕ Nuevo</a>
                    
                    </br>
                    </br>
        <table class="table table-bordered table-hover ">
            <thead>
                <tr>
                    <th>ID Catedratico</th>
                    <th>ID Persona</th>
                    <th>Titulo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ver" items="${listar}">
                <tr>
                    <td>${ver.id_catedratico}</td>
                    <td>${ver.id_persona}</td>
                    <td>${ver.titulo}</td>
                    <td>
                <center>
                        <a class="btn btn-success " href="catedratico?action=consultarById&id_catedratico=${ver.id_catedratico}" >✎ Editar</a>
                        <a class="btn btn-danger  " href="catedratico?action=eliminar&id_catedratico=${ver.id_catedratico}">✐ Borrar </a>
                </center>    
                </td>
                </tr>
                </c:forEach>
            </tbody>
                    </table>
                    </form>
                    ${msg}
            
        
                      </div>
        
</html>

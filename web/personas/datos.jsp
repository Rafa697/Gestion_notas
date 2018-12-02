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
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <title>Datos personas</title>
    </head>
    <body>
        <div class="container">
            <form action="personas?action=insertar" method="POST"> 
                    <h1>Personas </h1>
                    <a class="btn btn-dark btn-light" href="/Gestion_notas/index.jsp" >↩ Volver a inicio</a>
                    <a class="btn btn-success " href="personas/insertar.jsp">➕ Nuevo</a>
                    
                    </br>
                    </br>
        <table class="table table-bordered table-hover ">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>APELLIDO</th>
                    <th>DUI</th>
                    <th>NIT</th>
                    <th>DIRECCION</th>
                    <th>TELEFONO</th>
                    <th>CORREO</th>
                    <th>ROL</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ver" items="${listar}">
                <tr>
                    <td>${ver.id_persona}</td>
                    <td>${ver.nombre}</td>
                    <td>${ver.apellido}</td>
                    <td>${ver.dui}</td>
                    <td>${ver.nit}</td>
                    <td>${ver.direccion}</td>
                    <td>${ver.telefono}</td>
                    <td>${ver.correo}</td>
                    <td>${ver.id_rol}</td>
                    <td>
                <center>
                        <a class="btn btn-success " href="personas?action=consultarById&id_persona=${ver.id_persona}" >✎ Editar</a>
                        <a class="btn btn-danger  " href="personas?action=eliminar&id_persona=${ver.id_persona}">✐ Borrar </a>
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

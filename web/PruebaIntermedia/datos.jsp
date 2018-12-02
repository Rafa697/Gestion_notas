<%-- 
    Document   : datos
    Created on : 11-22-2018, 05:53:24 PM
    Author     : Alumno 07
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Pruebas Intermedias</title>
    </head>
    <body>
        <div class="container">
            <form action="pruebaIntermedia?action=insertar" method="POST"> 
                <h1> Pruebas Intermedias </h1>
                <a class="btn btn-dark btn-light" href="index.jsp" >↩ Volver a inicio</a>
                <a class="btn btn-success " href="PruebaIntermedia/insertar.jsp">➕ Nuevo</a>
                </br>
                </br>
                <table class="table table-bordered table-hover ">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ver" items="${listar}">
                            <tr>
                                <td>${ver.id_pi}</td>
                                <td>${ver.nombre}</td>
                                <td>
                        <center>
                            <a class="btn btn-success " href="pruebaIntermedia?action=consultarById&id_pi=${ver.id_pi}" >✎ Editar</a>
                            <a class="btn btn-danger  " href="pruebaIntermedia?action=eliminar&id_pi=${ver.id_pi}">✐ Borrar </a>
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

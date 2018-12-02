<%-- 
    Document   : datos
    Created on : 11-22-2018, 06:42:44 PM
    Author     : Alumno 07
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Parciales</title>
    </head>
    <body>
        <div class="container">
            <form action="parcial?action=insertar" method="POST"> 
                <h1> Parciales </h1>
                <a class="btn btn-dark btn-light" href="index_catedratico.jsp" >↩ Volver a inicio</a>
                <a class="btn btn-success " href="catedratico/Parcial/insertar.jsp">➕ Nuevo</a>
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
                                <td>${ver.id_parcial}</td>
                                <td>${ver.nombre}</td>
                                <td>
                        <center>
                            <a class="btn btn-success " href="parcial?action=consultarById&id_parcial=${ver.id_parcial}" >✎ Editar</a>
                            <a class="btn btn-danger  " href="parcial?action=eliminar&id_parcial=${ver.id_parcial}">✐ Borrar </a>
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

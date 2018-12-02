<%-- 
    Document   : datos
    Created on : 11-26-2018, 03:39:17 PM
    Author     : Alumno 35
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Notas Pruebas Intermedias</title>
    </head>
    <body>
        <div class="container">
            <form action="notaPI?action=insertar" method="POST"> 
                <h1> Notas Pruebas Intermedias </h1>
                <a class="btn btn-dark btn-light" href="index_catedratico.jsp" >↩ Volver a inicio</a>
                <a class="btn btn-success " href="catedratico/NotaPruebaIntermedia/insertar.jsp">➕ Nuevo</a>
                </br>
                </br>
                <table class="table table-bordered table-hover ">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ID_PI</th>
                            <th>ID_COLECCION</th>
                            <th>Nota</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ver" items="${listar}">
                            <tr>
                                <td>${ver.id_notapi}</td>
                                <td>${ver.id_pi}</td>
                                <td>${ver.id_coleccion}</td>
                                <td>${ver.nota}</td>
                                <td>
                        <center>
                            <a class="btn btn-success " href="notaPI?action=consultarById&id_notapi=${ver.id_notapi}" >✎ Editar</a>
                            <a class="btn btn-danger  " href="notaPI?action=eliminar&id_notapi=${ver.id_notapi}">✐ Borrar </a>
                        </center>    
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </form>
            ${msg}
        </div>
    </body>
</html>

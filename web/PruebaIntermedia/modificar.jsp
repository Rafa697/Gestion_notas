<%-- 
    Document   : modificar
    Created on : 11-22-2018, 05:57:32 PM
    Author     : Alumno 07
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
        <title>Modificar Pruebas Intermedias</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-4">
                    <form action="pruebaIntermedia?action=actualizar" method="POST"  >
                        <c:forEach items="${listar}" var="ver">
                            <label for="label">ID</label>
                            <input class="form-control" type="text" name="id_pi" value="${ver.id_pi}" readonly="">
                            <label for="label">Nombre</label>
                            <input class="form-control" type="text" name="nombre" value="${ver.nombre}">
                        </c:forEach>
                        <br>
                        <button class="btn btn-success btn-flat" >Enviar</button>            
                        <a href="pruebaIntermedia?action=consultar" class="btn badge-danger">Cancelar</a>
                        ${msj}
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
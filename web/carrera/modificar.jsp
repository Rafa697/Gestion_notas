<%-- 
    Document   : modificar
    Created on : 11-06-2018, 07:39:47 PM
    Author     : Alumno 08
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" />
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Modificar carreras</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-4">
                    
                    <form action="carrera?action=actualizar" method="POST"  >
                    <c:forEach items="${listar}" var="ver">
                    
                        <label for="label">ID Carrera</label>
                        <input class="form-control" type="text" name="id_carrera" value="${ver.id_carrera}" readonly="" >
                        <label for="label">Carrera</label>
                        <input class="form-control" type="text" name="carrera" value="${ver.carrera}">
                  </c:forEach>
                    
                       <br>
                    <button class="btn btn-success btn-flat" >Enviar</button>            
                    <a href="carrera?action=consultar" class="btn badge-danger">Cancelar</a>
                    ${msj}
             </form>
               </div>
             
             
             </div>
        </div>
    </body>
</html>

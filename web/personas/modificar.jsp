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

        <title>Modificar roles</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-3"></div>
                <div class="col-4">
                    
                    <form action="personas?action=actualizar" method="POST"  >
                    <c:forEach items="${listar}" var="ver">
                    
                        <label for="label">ID</label>
                        <input class="form-control" type="text" name="id_persona" value="${ver.id_persona}" readonly="">
                        <label for="label">Nombre</label>
                        <input class="form-control" type="text" name="nombre" value="${ver.nombre}">
                        <label for="label">Apellido</label>
                        <input class="form-control" type="text" name="apellido" value="${ver.apellido}">
                        <label for="label">DUI</label>
                        <input class="form-control" type="text" name="dui" value="${ver.dui}">
                        <label for="label">NIT</label>
                        <input class="form-control" type="text" name="nit" value="${ver.nit}">
                        <label for="label">Direccion</label>
                        <input class="form-control" type="text" name="direccion" value="${ver.direccion}">
                        <label for="label">Telefono</label>
                        <input class="form-control" type="text" name="telefono" value="${ver.telefono}">
                        <label for="label">Correo</label>
                        <input class="form-control" type="text" name="correo" value="${ver.correo}">
                        <label for="label">ROL</label>
                        <select name="id_rol" class="form-control">
                <option value="1" >Administrador&nbsp;-&nbsp;1</option>
                <option value="2">Catedratico&nbsp;-&nbsp;2</option>
                <option value="3">Estudiante&nbsp;-&nbsp;3</option>

            </select>
                        
                  </c:forEach>
                    
                       <br>
                    <button class="btn btn-success btn-flat" >Enviar</button>            
                    <a href="personas?action=consultar" class="btn badge-danger">Cancelar</a>
                    ${msj}
             </form>
               </div>
             
             
             </div>
        </div>
    </body>
</html>

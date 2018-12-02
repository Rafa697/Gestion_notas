<%-- 
    Document   : Inicio
    Created on : 25-nov-2018, 10:12:44
    Author     : Rafita Jr
--%>

<%@page import="dao.PersonasDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="icon" type="image/png" href="img/gn.png" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/estilo.css" rel="stylesheet" type="text/css"/>
        <title>Gestion notas</title>
    </head>
    <body>
        
        <div class="container well" id="containerLogin" style="background-color: rgba(255, 255, 255, 0.5)">

            <hr>
            <center><h1>Ingresa tus datos</h1></center>
            <hr>
            <center> <img src="img/users.png" alt="" width="100" height="100" class="img-circle"/></center>
            <form action="validarusuario.jsp" method="POST" id="form1">
                <div class="form-group">
                    <label for="exampleInputEmail1">Usuario</label>
                    
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="usuario@example.com" name="txtcorreo" required="" >
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Contraseña</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Contraseña" name="txtclave" required="" maxlength="8">
                </div>
                
                <button type="submit" class="btn btn-primary"  id="botonLogin" value="" name="btnEnviar">Enviar</button>
            </form>
           
        </div>


       
    </body>
</html>

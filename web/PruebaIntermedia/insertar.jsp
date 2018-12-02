<%-- 
    Document   : Insertar
    Created on : 11-22-2018, 05:48:26 PM
    Author     : Alumno 07
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>Inicio</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-4">
                </div>
                <div class="col-4">
                    <form action="../pruebaIntermedia?action=insertar" method="POST"  >
                        <h1> Pruebas Intermedias</h1>
                        <label for="nombre">ID</label>
                        <input class="form-control" name="id_pi" required="">
                        <label for="nombre">Nombre</label>
                        <input class="form-control" name="nombre" required="">
                        <br>
                        <button class="form-control btn badge-light btn-dark" >Enviar</button>
                    </form>
                    ${msg}
                    <br>
                    <br>
                    <center> <a class="btn btn-dark btn-light" href="../index.jsp" >↩ Volver a inicio</a> </center>
                </div>
            </div>
        </div>
    </body>
</html>

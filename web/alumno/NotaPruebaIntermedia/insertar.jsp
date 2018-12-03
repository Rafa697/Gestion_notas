<%-- 
    Document   : insertar
    Created on : 11-26-2018, 03:39:30 PM
    Author     : Alumno 35
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
                        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-4">
                </div>
                <div class="col-4">
                    <form action="../../notaPI?action=insertar" method="POST" >
                        <h1> Notas Pruebas Intermedias</h1>
                        <label for="nombre">Id_pi</label>
                        <input class="form-control " name="id_pi" required="">
                        <label for="nombre">Id_coleccion</label>
                        <input class="form-control" name="id_coleccion" required="">
                        <label for="nombre">Nota</label>
                        <input class="form-control" name="nota" required="">
                        <br>
                        <button class="form-control btn badge-light btn-dark" >Enviar</button>
                    </form>
                    ${msg}
                    <br>
                    <br>
                    <center> <a class="btn btn-dark btn-light" href="../../index_catedratico.jsp" >↩ Volver a inicio</a> </center>
                </div>
            </div>
        </div>
    </body>
</html>

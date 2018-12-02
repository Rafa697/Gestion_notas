<%-- 
    Document   : index
    Created on : 10-16-2018, 07:23:10 PM
    Author     : Alumno 08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Inicio</title>
    </head>
    <body>
        <div class="container">
             <div class="row">
                 <div class="col-4">
                     
                 </div>
                 <div class="col-4">
                     <form action="../personas?action=insertar" method="POST" >
                         <h1> Datos de Personas</h1>
            <label for="nombre">ID</label>
            <input class="form-control " name="id_persona" required="">
            <label for="nombre">Nombre</label>
            <input class="form-control " name="nombre" required="">
            <label for="nombre">Apellido</label>
            <input class="form-control " name="apellido" required="">
            <label for="nombre">DUI</label>
            <input class="form-control " name="dui" required="">
            <label for="nombre">NIT</label>
            <input class="form-control " name="nit" required="">
            <label for="nombre">Direccion</label>
            <input class="form-control " name="direccion" required="">
            <label for="nombre">Telefono</label>
            <input class="form-control " name="telefono" required="">
            <label for="nombre">Correo</label>
            <input class="form-control " name="correo" required="">
            <label for="nombre">Rol</label>
            <select name="id_rol" class="form-control">
                <option value="1" >Administrador&nbsp;-&nbsp;1</option>
                <option value="2">Catedratico&nbsp;-&nbsp;2</option>
                <option value="3">Estudiante&nbsp;-&nbsp;3</option>

            </select>
                
              

            <br>
            <button class="form-control btn badge-light btn-dark" >Enviar</button>
                     </form>
                     ${msg}
                     <br>
                     <br>
                     <center> <a class="btn btn-dark btn-light" href="/Gestion_notas/index.jsp" >↩ Volver a inicio</a> </center>
        </div>
                     
                    
                    
             </div>
        </div>
</body>
</html>

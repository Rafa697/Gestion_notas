<%-- 
    Document   : Inicio
    Created on : 11-12-2018, 09:35:56 AM
    Author     : Alumno 08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="img/gn.png" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
    <link href="css/sb-admin.css" rel="stylesheet">
        <title>Notas</title>
    </head>
    <body>
        <nav class="navbar navbar-dark bg-dark">
            <a style="color: white"class="navbar-toggler" ><span class="navbar-toggler-icon"></span>Home</a>
            <div class="dropdown">
                <a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Sesion</a>
                <div class="dropdown-menu text-center">
                    <a><img src="img/user.png" height="80" width="80"></a><br>
                    <a>
                        <%
                        HttpSession sesion = request.getSession();
                        String usuario;
                        if(sesion.getAttribute("txtcorreo")!=null){
                        usuario =sesion.getAttribute("txtcorreo").toString();
                        out.print(usuario);
                        
                        }
                        %>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a href="login.jsp" class="dropdown-item" >Salir</a>
                </div>
            </div>
        </nav> 
        <div class="container">
            <div class="row">
                <div class="col-14">
                
                
        
        <div class="container mt-4">
            <div class="row">
                <div class="col-4">
                    
                </div>
                <div class="col-4">
                   
                </div>
                
                </div>
            </div>
          <div id="content-wrapper">

        <div class="container-fluid">

          <!-- Breadcrumbs-->
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Gestion de Notas</a>
            </li>
            <li class="breadcrumb-item active">Personas</li>
          </ol>

          <!-- Icon Cards-->
          <div class="row">
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-ruler-horizontal"></i>
                  </div>
                  <div class="mr-5">Roles</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="rol/insertar.jsp">
                  <span class="float-left">Agregar Rol</span>
                  <span class="float-right">
                    <i class="fas fa-ruler"></i>
                  </span>
                </a>
              </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-ruler-combined"></i>
                  </div>
                  <div class="mr-5">Roles</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="rol?action=consultar">
                  <span class="float-left">Ver listado de Roles</span>
                  <span class="float-right">
                    <i class="fas fa-ruler-vertical"></i>
                  </span>
                </a>
              </div>
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-users"></i>
                  </div>
                  <div class="mr-5">Personas</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="personas/insertar.jsp">
                  <span class="float-left">Agregar persona</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-users"></i>
                  </span>
                </a>
              </div>
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-users-cog"></i>
                  </div>
                  <div class="mr-5">Personas</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="personas?action=consultar">
                  <span class="float-left">Ver listado de Personas</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-users-cog"></i>
                  </span>
                </a>
              </div>
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-user-friends"></i>
                  </div>
                  <div class="mr-5">Alumnos</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="alumno/insertar.jsp">
                  <span class="float-left">Agregar Alumno</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-user-edit"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-user-edit"></i>
                  </div>
                  <div class="mr-5">Alumnos</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="alumno?action=consultar">
                  <span class="float-left">Ver listado de Alumnos</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-user-edit"></i>
                  </span>
                </a>
              </div>
                    
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-user-tie"></i>
                  </div>
                  <div class="mr-5">Catedraticos</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="catedratico/insertar.jsp">
                  <span class="float-left">Agregar Catedratico</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-user-cog"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-user-tie"></i>
                  </div>
                  <div class="mr-5">Catedraticos</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="catedratico?action=consultar">
                  <span class="float-left">Ver listado de Catedraticos</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-user-check"></i>
                  </span>
                </a>
              </div>
                    
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-user-circle"></i>
                  </div>
                  <div class="mr-5">Coordinadores de Carrera</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="#">
                  <span class="float-left">Agregar Coordinador</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-user-circle"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-primary o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-user-secret"></i>
                  </div>
                  <div class="mr-5">Coordinadores de Carrera</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="#">
                  <span class="float-left">Ver listado de Coordinadores</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-user-secret"></i>
                  </span>
                </a>
              </div>
                    
            </div>
          </div>
          <br>
          <br>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="#">Gestion de Notas</a>
            </li>
            <li class="breadcrumb-item active">Materias</li>
          </ol>
          <br>
          <br>
          <div class="row"> 
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-ruler-horizontal"></i>
                  </div>
                  <div class="mr-5">Materias</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="materia/insertar.jsp">
                  <span class="float-left">Agregar Materia</span>
                  <span class="float-right">
                    <i class="fas fa-ruler"></i>
                  </span>
                </a>
              </div>
            </div>
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-ruler-combined"></i>
                  </div>
                  <div class="mr-5">Materias</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="materia?action=consultar">
                  <span class="float-left">Ver listado de Materias</span>
                  <span class="float-right">
                    <i class="fas fa-ruler-vertical"></i>
                  </span>
                </a>
              </div>
            </div>
               <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-list-alt"></i>
                  </div>
                  <div class="mr-5">Pruebas Intermedias</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="PruebaIntermedia/insertar.jsp">
                  <span class="float-left">Agregar Prueba Intermedia</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-list"></i>
                  </span>
                </a>
              </div>
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-list-alt"></i>
                  </div>
                  <div class="mr-5">Pruebas Intermedias</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="pruebaIntermedia?action=consultar">
                  <span class="float-left">Ver listado de Pruebas Intermedias</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-archive"></i>
                  </span>
                </a>
              </div>
            </div>
               <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-alt"></i>
                  </div>
                  <div class="mr-5">Parciales</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="Parcial/insertar.jsp">
                  <span class="float-left">Agregar Parcial</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file"></i>
                  </span>
                </a>
              </div>
            </div>
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-alt"></i>
                  </div>
                  <div class="mr-5">Parciales</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="parcial?action=consultar">
                  <span class="float-left">Ver listado de Parciales</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-code"></i>
                  </span>
                </a>
              </div>
            </div>
                
              <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-folder-plus"></i>
                  </div>
                  <div class="mr-5">Notas Prueba Intermedia</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="NotaPruebaIntermedia/insertar.jsp">
                  <span class="float-left">Agregar Notas de Pruebas Intermedia</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-folder-plus"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-folder-open"></i>
                  </div>
                  <div class="mr-5">Notas  Prueba Intermedia</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="notaPI?action=consultar">
                  <span class="float-left">Ver listado de Notas PI</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-folder-open"></i>
                  </span>
                </a>
              </div>
                    
                    
            </div>
               <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-excel"></i>
                  </div>
                  <div class="mr-5">Notas Parciales</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="NotasParcial/insertar.jsp">
                  <span class="float-left">Agregar Notas de Parciales</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-excel"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-info o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-pdf"></i>
                  </div>
                  <div class="mr-5">Notas  Parciales</div>
                </div>
                <a class="card-footer text-dark clearfix small z-1" href="notasparcial?action=consultar">
                  <span class="float-left">Ver listado de Notas de Parciales</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-pdf"></i>
                  </span>
                </a>
              </div>
                    
            </div>
              
          </div>
          <br>
          <br>
          <ol class="breadcrumb ">
            <li class="breadcrumb-item">
              <a href="#">Gestion de Notas</a>
            </li>
            <li class="breadcrumb-item active">Ciclo</li>
          </ol>
          <br>
          <br>
          <div class="row">
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-dark o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-excel"></i>
                  </div>
                  <div class="mr-5">Ciclos</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="ciclo/insertar.jsp">
                  <span class="float-left">Agregar Ciclo</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-excel"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-dark o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-pdf"></i>
                  </div>
                  <div class="mr-5">Ciclos</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="ciclo?action=consultar">
                  <span class="float-left">Ver listado de Ciclos</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-pdf"></i>
                  </span>
                </a>
              </div>
                    
            </div>   
            <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-dark o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-excel"></i>
                  </div>
                  <div class="mr-5">Carreras</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="carrera/insertar.jsp">
                  <span class="float-left">Agregar Carrera</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-excel"></i>
                  </span>
                </a>
              </div>
            </div>
                <div class="col-xl-3 col-sm-6 mb-3">
              <div class="card text-white bg-dark o-hidden h-100">
                <div class="card-body">
                  <div class="card-body-icon">
                    <i class="fas fa-fw fa-file-pdf"></i>
                  </div>
                  <div class="mr-5">Carreras</div>
                </div>
                <a class="card-footer text-white clearfix small z-1" href="carrera?action=consultar">
                  <span class="float-left">Ver listado de Carerras</span>
                  <span class="float-right">
                    <i class="fas fa-angle-right fa-file-pdf"></i>
                  </span>
                </a>
              </div>
                    
            </div>   
          </div>
          
        </div>
          

        </div>
            </div>
            </div>
       
        </div>
                    
        
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

<footer class="sticky-footer  bg-dark text-white" >
          <div class="container my-2">
            <div class="copyright text-center my-2">
              <span>Gestion de Notas © Programacion IV</span>
            </div>
          </div>
       
        </footer>
        </body>
   
</html>

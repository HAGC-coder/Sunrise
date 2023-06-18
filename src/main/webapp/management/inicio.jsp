<%-- 
    Document   : inicio
    Created on : 23 oct. 2022, 20:15:32
    Author     : hagc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <link href="css/index.css" rel="stylesheet" type="text/css"/> 
        <title>Inicio</title>
    </head>


    <body> 

        <nav class="navbar navbar-expand-lg navbar-dark  " style="background-color: #06203a;">
            <a class="navbar-brand" href="inicio.jsp">Sunrise</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="inicio.jsp">Inicio<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=productos&accion=Listar"  target="Contenedor">Productos</a>
                    </li>
                    <c:if test = "${empleado.getNivel() != 4 && empleado.getNivel() != null}">
                        <li class="nav-item" >
                            <a class="nav-link" href="Controlador?menu=sucursal&accion=Listar" target="Contenedor">Sucursal</a>
                        </li>
                    </c:if> 
                    <c:if test = "${empleado.getNivel() != 4 && empleado.getNivel() != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=bodega&accion=Listar" target="Contenedor">Bodega</a>
                        </li> 
                    </c:if> 
                    <c:if test = "${(empleado.getNivel() == 1) || (empleado.getNivel() == 2) && empleado.getNivel() != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=proveedor&accion=Listar" target="Contenedor">Proveedor</a>
                        </li>
                    </c:if> 
                    <c:if test = "${empleado.getNivel() != 4 && empleado.getNivel() != null}">
                        <li class="nav-item">
                            <a class="nav-link" href="Controlador?menu=empleados&accion=Listar" target="Contenedor">Empleados</a>
                        </li>
                    </c:if> 
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=clientes&accion=Listar" target="Contenedor">Clientes</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Controlador?menu=pedidos&accion=default" target="Contenedor">Pedidos</a>
                    </li>
                </ul>
                <input type="hidden" id="status" value="<%=  request.getAttribute("status")%>"> 
                <div class="btn-group" style="margin-right: 10px;">
                    <button type="button" class="btn btn-outline-light dropdown-empl" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa-regular fa-circle-user" style="font-size: 22px;"></i> ${ empleado.getCorreo_empleado() } 
                    </button>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" type="button">ID: ${ empleado.getId_empleado() }</a> 
                        <a class="dropdown-item" type="button">Usuario: ${ empleado.getNombre_empleado() } </a> 
                        <div class="dropdown-divider"></div>
                        <form class="dropdown-item" method="POST" action="Validar">
                            <button id="cerrarSesion" class="btn btn-outline-danger center-block" type="submit" name="accion" value="Salir">Cerrar Sesión</button>
                        </form>
                    </div>
                </div>

        </nav>

        <div class="m-3" style="height:1000px;">
            <iframe name="Contenedor" style="height:100%; width:100%;" frameBorder="0"></iframe>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script> 
        <script>
            var status = document.getElementById("status").value;
            if (status == "bienvenido") {
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: '    ¡Bienvenido!',
                    showConfirmButton: false,
                    timer: 1000
                });
            }
        </script>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> 


    </body>
</html>

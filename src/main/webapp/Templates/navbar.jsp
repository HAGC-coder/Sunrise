<%-- 
    Document   : navbar
    Created on : 2 feb. 2023, 23:12:45
    Author     : hagc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script defer src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script defer src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>
        <link href="../css/navbar.css" rel="stylesheet" type="text/css"/>


        <c:set var="url">${pageContext.request.requestURL}</c:set>
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
        <script>var base = document.getElementsByTagName("base")[0].href;</script> 
    </head>


    <body> 
        <input type="hidden" value="<%=  session.getAttribute("cliente")%>" id="cliente">
        <!--  class="sticky-top"-->
        <header class="sticky-top">
            <div class="container-fluid" style="background-color: #06203a; font-size: 15px; padding: 10px;"> 
                <div class="row">
                    <div class="col-lg-3" style="padding: 10px;">
                        <a class="navbar-brand nav-item active" style="font-size: 25px; margin: 0px 10px 0 20px; color: #fff;" href="index.jsp">Sunrise</a>
                    </div>    
                    <div class="col-lg-6">

                        <form action="Inicio?menu=Buscador" method="post">
                            <div class="search-wrap search-wrap1">
                                <div class="search-box">
                                    <input type="search" class="input" name="ch" placeholder="Buscar">  
                                    <button type="submit" class="btn btn-common" name="accion" value="Buscar"> 
                                        <i class="fas fa-search"></i> 
                                    </button> 
                                </div>
                            </div> 
                        </form>
                    </div>   
                    <c:choose>
                        <c:when test="${estado != true && cliente == null}">  
                            <div class="col-lg-3 text-center" style="font-size: 15px;"> 
                                <a type="button" class="btn btn-outline-light my-2 my-sm-0" href="login.jsp">Iniciar sesión</a>  
                            </div>    
                        </c:when>
                        <c:otherwise>
                            <div class="btn-group col-lg-3 text-centercol-lg-3 text-center" style="font-size: 15px; padding: 10px;">

                                <div class="dropdown">
                                    <button type="button" class="btn btn-outline-light dropdown-empl" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        <i class="fa-regular fa-circle-user" style="font-size: 22px;"></i> ${ cliente.getCorreo_cliente() } 
                                    </button>
                                    <ul class="dropdown-menu">
                                        <a class="dropdown-item" type="button">ID: ${ cliente.getId_cliente() }</a> 
                                        <a class="dropdown-item" type="button">Usuario: ${ cliente.getNombres_cliente() } </a> 
                                        <div class="dropdown-divider"></div>
                                        <form class="dropdown-item" method="POST" action="Validar">
                                            <div data-toggle="modal" data-target="#exampleModalCenter">
                                                <button id="cerrarSesion"  
                                                        class="btn btn-outline-danger center-block"
                                                        type="submit" name="accion" 
                                                        value="Salir">
                                                    Cerrar Sesión
                                                </button>
                                            </div>
                                        </form>
                                    </ul>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>       
                </div>    

            </div>
            <nav class="navbar navbarco navbar-expand-lg navbar-dark animated fadeIn fast" style="background-color: #06203a; ">

                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul class="navbar-nav mr-auto" style="font-size: 18px;">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Inicio<span class="sr-only">(current)</span></a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="Inicio?menu=Playa&accion=Listar">Playa</a>
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="Inicio?menu=Juguetes&accion=Listar">Juguetes</a>
                        </li> 
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="Inicio?menu=Hogar&accion=Listar">Hogar</a>
                        </li> 
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="Inicio?menu=ArtPersonales&accion=Listar">Articulos Personales</a>
                        </li> 
                        </li> 
                        <li class="nav-item">
                            <a class="nav-link" href="Inicio?menu=Juegos&accion=Listar">Juegos de Mesa</a>
                        </li>  
                        <c:if test="${estado == true && cliente != null}">
                            <li class="nav-item">  
                                <a class="nav-link"  href="MiCarrito.jsp"><i class="fa-solid fa-cart-shopping"></i> Mi carrito</a> 
                            </li>  
                        </c:if> 
                        <c:if test="${estado == true && cliente != null}">
                            <li class="nav-item">  
                                <a class="nav-link"  href="Pedido.jsp"> Pedido </a> 
                            </li>  
                        </c:if> 
                    </ul>   

                </div>
            </nav>

        </header>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="../js/navbar.js" type="text/javascript"></script>
        <script src="../js/funcionesNavbar.js" type="text/javascript"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script> 

    </body>
</html>

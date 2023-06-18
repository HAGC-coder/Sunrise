 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>
        <link href="../css/catalogo.css" rel="stylesheet" type="text/css"/>
        <!-- Animaciones --> 
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <link href="../css/sidebar.css" rel="stylesheet" type="text/css"/>
        <link href="../css/carrito.css" rel="stylesheet" type="text/css"/>


        <title>Busqueda</title>
    </head>
    <body>
        <input type="hidden" value="<%=  session.getAttribute("cliente")%>" id="cliente"> 
        <%@include file = "../Templates/navbar.jsp"%> 
        <input type="hidden" id="status" value="<%=  request.getAttribute("categoria")%>">
        <input type="hidden" value="<%=  session.getAttribute("cliente")%>" id="cliente">

        <c:choose>
            <c:when test="${ conexion == false }">
                <div class="container w-100 text-center">
                    <h3 style="padding-top: 25%">Nuestro sistema está presentando fallas, por favor espere</h3>
                </div>
            </c:when>
            <c:otherwise> 
                <div class="m-2"
                     data-aos="zoom-out"
                     data-aos-easing="linear"
                     data-aos-duration="500"> 

                    <div class="container-cat" style="margin-top: 50px;" id="listaArticulos">

                        <c:forEach var="p" items="${productos}">
                            <c:if test = "${!productos.isEmpty() && p.getCantidad() > 0}">
                                <div class="caja articulo" data-aos="zoom-in-up"> 
                                    <input type="hidden" id="id" value="${p.getId_productos()}">
                                    <img class="img-cat" src="img/catalogo/${p.getArchivoimg()}" alt="${p.getNombre_producto()}"/> 
                                    <p>${p.getNombre_producto()}</p>
                                    <p>Precio: $ ${p.getPresupuesto()}</p> 
                                    <a href="Inicio?menu=Producto&accion=Ver&id=${p.getId_productos()}&categoria=${p.getTipo_producto()}" type="button" class="btn btn-outline-info">Ver más</a>
                                    <c:choose>
                                        <c:when test="${cliente != null}">
                                            <a type="button" class="btn btn-outline-success"  href="MiCarrito?accion=Añadir&id=${p.getId_productos()}&id_cli=${ cliente.getId_cliente() }"><i class="fa-solid fa-cart-shopping"></i> Añadir </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a ctype="button" class="btn btn-outline-success" href="login.jsp"><i class="fa-solid fa-cart-shopping"></i> Añadir </a>
                                        </c:otherwise> 
                                    </c:choose>
                                </div>
                            </c:if>
                        </c:forEach>

                    </div>
                </div>
            </c:otherwise>
        </c:choose>  

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> 
        <!-- Animaciones -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <script src="../js/sidebar.js" type="text/javascript"></script>
        <script>
            AOS.init();
        </script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script> 
        <c:if test="${ not empty agrCarrito }">  
            <div id="toast"> ${agrCarrito} </div>

            <script type="text/javascript">
            showToast();
            function showToast(content)
            {
                $('#toast').addClass("display");
                $('#toast').html(content);
                setTimeout(() => {
                    $("#toast").removeClass("display");
                }, 2000)
            }
            </script>
            <c:remove var="agrCarrito" scope="session"/>
        </c:if>
    </body>
</html>

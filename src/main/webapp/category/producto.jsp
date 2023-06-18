<%-- 
    Document   : producto
    Created on : 30 mar. 2023, 17:02:25
    Author     : hagc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sunrise.Conexion"%>
<%  Conexion con = new Conexion();%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>


        <link href="css/productos.css" rel="stylesheet" type="text/css"/>
        <title>Producto</title> 
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
                <div class="container-prod">
                    <div class="container-title">${productoSel.getNombre_producto()}</div> 
                    <main>
                        <div class="container-img">
                            <img class="img-cat" src="img/catalogo/${productoSel.getArchivoimg()}" alt="${productoSel.getArchivoimg()}"/>
                        </div>
                        <div class="container-info-product">
                            <div class="container-price">
                                <span>${productoSel.getPresupuesto()}</span>
                                <i class="fa-solid fa-angle-right"></i>
                            </div>

                            <div class="container-add-cart">
                                <!--<div class="container-quantity">
                                    <input
                                        type="number"
                                        placeholder="1"
                                        value="1"
                                        min="1"
                                        class="input-quantity"
                                        />
                                    <div class="btn-increment-decrement">
                                        <i class="fa-solid fa-chevron-up" id="increment"></i>
                                        <i class="fa-solid fa-chevron-down" id="decrement"></i>
                                    </div>
                                </div>-->

                                <c:choose>
                                    <c:when test="${cliente != null}">
                                        <a type="button" class="btn-add-to-cart"  href="MiCarrito?accion=Añadir&id=${p.getId_productos()}&id_cli=${ cliente.getId_cliente() }"><i class="fa-solid fa-plus"></i> Añadir </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a ctype="button" class="btn-add-to-cart" href="login.jsp"><i class="fa-solid fa-plus"></i> Añadir </a>
                                    </c:otherwise> 
                                </c:choose> 
                            </div>

                            <div class="container-description">
                                <div class="title-description">
                                    <h4>Descripción</h4>
                                    <i class="fa-solid fa-chevron-down"></i>
                                </div>
                                <div class="text-description">
                                    <p>
                                        ${productoSel.getDesc()}
                                    </p>
                                </div>
                            </div>

                            <!-- <div class="container-additional-information">
                                <div class="title-additional-information">
                                    <h4>Información adicional</h4>
                                    <i class="fa-solid fa-chevron-down"></i>
                                </div>
                                <div class="text-additional-information hidden">
                                    <p>-----------</p>
                                </div>
                            </div>
        
                            <div class="container-reviews">
                                <div class="title-reviews">
                                    <h4>Reseñas</h4>
                                    <i class="fa-solid fa-chevron-down"></i>
                                </div>
                                <div class="text-reviews hidden">
                                    <p>-----------</p>
                                </div>
                            </div>-->

                        </div>
                    </main>

                    <div class="container-related-products">
                        <h2>Productos Relacionados</h2>
                        <div class="card-list-products row">
                            <c:forEach var="prodRel" items="${productos}">
                                <div class="card col-xl">
                                    <div class="card-img">
                                        <img
                                            class="img-cat"
                                            src="img/catalogo/${prodRel.getArchivoimg()}"
                                            alt="${prodRel.getArchivoimg()}"
                                            />
                                    </div>
                                    <div class="info-card">
                                        <div class="text-product">
                                            <h3>${prodRel.getNombre_producto()}</h3>
                                            <p class="category"></p>
                                        </div>
                                        <div class="price">${prodRel.getPresupuesto()}</div> 
                                    </div>
                                    <a href="Inicio?menu=Producto&accion=Ver&id=${prodRel.getId_productos()}&categoria=${prodRel.getTipo_producto()}" type="button" class="btn btn-outline-info">Ver más</a>
                                </div>
                            </c:forEach>
                        </c:otherwise> 
                    </c:choose>
                </div>
            </div>
        </div>
        <%@include file = "../Templates/footer.jsp"%>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <script src="js/producto.js" type="text/javascript"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script> 
    </body>
</html>

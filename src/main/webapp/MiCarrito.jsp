<%-- 
    Document   : MiCarrito
    Created on : 15 may. 2023, 18:51:22
    Author     : hagc
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="modelos.*"%> 
<%@page import="com.sunrise.Conexion"%>
<%@page import="java.util.List"%>
<%float total = 0, t = 0; %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <link href="css/carrito.css" rel="stylesheet" type="text/css"/>

        <title>Mi carrito</title>
    </head>
    <body>
        <%@include file = "../Templates/navbar.jsp"%> 
        <c:if test="${empty cliente}">
            <c:redirect url="login.jsp"></c:redirect> 
        </c:if>

        <div class="container">
            <div class="row">
                <div class="col-lg-6"> 
                    <div class="card m-2">
                        <div class="card-body">
                            <h3 class="text-center text-success">Productos seleccionados</h3>
                            <table class="table">
                                <thead class="thead-dark">
                                    <tr>
                                        <th scope="col">Producto</th>
                                        <th scope="col">Categoría/s</th>
                                        <th scope="col">Precio</th>
                                        <th scope="col">Acción</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        Clientes cli = (Clientes) session.getAttribute("cliente");
                                        CarritoDAO carritoDAO = new CarritoDAO();
                                        List<Carrito> listCarrito = carritoDAO.ListarPorIdCli(cli.getId_cliente());

                                        for (Carrito c : listCarrito) {
                                            t = c.getTotal();
                                    %> 
                                    <tr> 
                                        <th scope="row"> <%= c.getNombreProducto()%></th>
                                        <td><%= c.getCatProducto()%></td>
                                        <td><%= c.getPrecio()%></td>
                                        <td>
                                            <input type="hidden" value="<%= c.getID() %>" id="codigo_prod" >
                                            <a id="eliminarProductos" class="btn btn-outline-danger" href="MiCarrito?accion=Eliminar&id=<%= c.getID_prod() %>">Quitar</a>
                                        </td
                                    </tr>    
                                    <%}
                                        total = t;
                                    %>
                                </tbody>
                            </table> 
                            <label class="col-md-12 text-center ml-auto fw-bold">Total:</label>
                            <div class="col-md-12 ml-auto"> 
                                <input type=text" name="txtTotal" class="form-control" placeholder="$" readonly value="<%= total%>">
                            </div> 
                        </div>
                    </div>
                </div>

                <div class="col-lg-6">
                    <div class="card m-2">
                        <div class="card-body">
                            <h3 class="text-center text-primary">Detalles del pedido</h3>

                            <form action="MiOrden" method="post">
                                <input type="hidden" value="${ cliente.getId_cliente() }" name="id">
                                <div class="form-row">
                                    <div class="form-group col-md-6 mb-3">
                                        <label>Nombre/s</label>
                                        <input type="text" class="form-control" name="textNbrsCli" minlength="4" placeholder="Nombre/s" value="${ cliente.getNombres_cliente() }" required> 
                                    </div>
                                    <div class="form-group col-md-6 mb-3">
                                        <label>Apellido/s</label>
                                        <input type="text" class="form-control" name="textAdosCli" minlength="5" placeholder="Apellido/s" value="${ cliente.getApellidos_cliente() }" required> 
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12 mb-3">
                                        <label>Teléfono</label>
                                        <input type="text" class="form-control" name="textTelCli" minlength="10" placeholder="Ingresa un número de contacto" value="${ cliente.getTelefono() }" required> 
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-12 mb-3">
                                        <label>Direción</label>
                                        <input type="text" class="form-control" name="textDirCli" minlength="15" placeholder="Dirección" value=" ${ cliente.getDireccion_cliente() } " required> 
                                    </div> 

                                    <div class="form-group col-md-12 mb-3">
                                        <label>Método de pago</label>
                                        <select class="form-control" name="tipoPago">
                                            <option value="noSeleccionado"> Seleccionar </option>
                                            <!-- COD = cash on delivery-->
                                            <option value="COD"> Contra-reembolso </option>
                                        </select>
                                    </div>  
                                </div>
                                <div class="text-center">
                                    <a type="button" class="btn btn-outline-primary" href="index.jsp">Seguir comprando</a>
                                    <button type="submit" class="btn btn-outline-success" name="accion" value="Ordenar">Confirmar pedido</button> 
                                </div> 
                            </form>    

                        </div>
                    </div>
                </div>
            </div>
        </div>  

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script>  
        <c:if test="${ not empty delCarrito }">  
            <div id="toast"> ${delCarrito} </div> 
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
            <c:remove var="delCarrito" scope="session"/>
        </c:if>
        <c:if test="${ not empty msg }" >  
            <div id="toast"> ${ msg } </div> 
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
            <c:remove var="msg" scope="session"/> 
        </c:if> 
        <c:if test="${ not empty errPedido }" > 
            <div id="toast"> ${ errPedido } </div> 
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
            <c:remove var="errPedido" scope="session"/>
        </c:if> 
        <c:if test="${ not empty msgError }" > 
            <div id="toast"> ${ msgError } </div> 
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
            <c:remove var="msgError" scope="session"/>
        </c:if>    
            
    </body>
</html>

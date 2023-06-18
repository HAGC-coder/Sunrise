<%-- 
    Document   : Pedido
    Created on : 17 may. 2023, 20:39:36
    Author     : hagc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@page import="modelos.*"%> 
<%@page import="com.sunrise.Conexion"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″ />
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <title>Pedido</title>
    </head>
    <body>
        <%@include file = "../Templates/navbar.jsp"%> 
        <c:if test="${empty cliente}">
            <c:redirect url="login.jsp"></c:redirect> 
        </c:if>

        <div class="mt-3">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">No. pedido</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Teléfono</th>
                        <th scope="col">Dirección</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Categoría</th>
                        <th scope="col">Precio</th>
                        <th scope="col">Método de pago</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Clientes cli = (Clientes) session.getAttribute("cliente");
                        OrdenDAO orDAO = new OrdenDAO();
                        List<Orden> listOrden = orDAO.ListarPedido(cli.getTelefono());

                        for (Orden o : listOrden) {
                    %> 
                    <tr>
                        <th scope="row"> <%= o.getId_orden()%></th>
                        <td><%= o.getNombreProducto()%></td>
                        <td><%= o.getTelefonoUsuario()%></td>
                        <td><%= o.getDireccion()%></td>
                        <td><%= o.getNombreProducto()%></td>
                        <td><%= o.getCatProducto()%></td>
                        <td><%= o.getPrecio()%></td>
                        <td><%= o.getTipoPago()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    </body>
</html>

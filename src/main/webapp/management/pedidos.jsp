<!doctype html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <title>Sistema de pedidos</title>
        <style>
            @media print{
                .seccion1, .btn, .columna{
                    display:none;
                }
            }
        </style>
    </head>
    <body>
        <div class="row">
            <div class="col-lg-4 seccion1">
                <div class="card">
                    <h5 class="card-header">Datos del cliente</h5>
                    <div class="card-body">
                        <form method="post" action="Controlador?menu=pedidos">
                            <div class="row">
                                <div class="col-sm-3 d-flex form-group">
                                    <input type="number" name="txtIdCliente" class="form-control" placeholder="ID" value="${ cliente.getId_cliente() }">
                                </div>  
                                <div class="col-sm-2 d-flex form-group">
                                    <button type="submit" name="accion" value="Buscar" class="btn btn-outline-dark"> <i class="fa-solid fa-magnifying-glass"></i> </button>
                                </div>
                                <div class="col-md-7 d-flex form-group">
                                    <input type="text" name="txtNomCliente" class="form-control" placeholder="Nombre del cliente" readonly value="${ cliente.getNombres_cliente() }">
                                </div>
                            </div>
                            <div class="row"></div>

                        </form>
                    </div>
                </div>
                <div class="card">
                    <h5 class="card-header">Datos del producto</h5>
                    <div class="card-body">
                        <form action="Controlador?menu=pedidos" method="post">
                            <div class="row">
                                <div class="col-sm-3 d-flex form-group">
                                    <input type="number" name="txtIdProducto" class="form-control" placeholder="ID" value="${ productoSel.getId_productos() }">
                                </div>
                                <div class="col-sm-2 d-flex form-group">
                                    <button type="submit" name="accion" value="Buscar Producto" class="btn btn-outline-dark"> <i class="fa-solid fa-magnifying-glass"></i> </button>
                                </div>
                                <div class="col-md-7 d-flex form-group">
                                    <input type="text" name="txtNombreProd" class="form-control" placeholder="Nombre Producto" readonly value="${ productoSel.getNombre_producto() }">
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="text" name="txtPrecioProd" class="form-control" readonly placeholder="$" value="${ productoSel.getPresupuesto() }">
                                </div> 
                                <div class="col-md-4 d-flex form-group">
                                    <input type="number" value="1" name="cantidad" class="form-control" placeholder="#">
                                </div>
                                <div class="col-md-4 d-flex form-group">
                                    <input type="number" name="txtCantidadProd" class="form-control" placeholder="Stock" readonly value="${ productoSel.getCantidad_cajas() }">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="AgregarProducto" class="btn btn-success col text-center">Agregar <i class="fa-solid fa-plus"></i></button>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body">
                        <div class="form-group row">
                            <label>Numero de factura</label>
                            <input class="form-control col-md-12" type="text" name="txtNumFactura" readonly value="${ numFactura }">
                        </div>

                    </div>
                    <div class="card-body">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Codigo</th>
                                    <th scope="col">Producto</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Subtotal</th>
                                    <th scope="col"> </th> 
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="lista" items="${listaPedidos}">
                                    <tr>
                                        <th scope="row" style="width: 30px;">${lista.getItem()}</th>
                                        <td style="width: 30px;">${lista.getId_productos()}</td>
                                        <td style="width: 350px;">${lista.getNomProd()}</td>
                                        <td>$ ${lista.getPrecioUnidad()}</td>
                                        <td>
                                            ${lista.getCantidadProd()} 
                                        </td>
                                        <td style="width: 30px;">$ ${lista.getSubtotal()}</td>  
                                        <td class="columna">
                                            <input type="hidden" id="id" value="${lista.getItem()}">
                                            <a class="btn btn-danger form-group" name="accion" value="EliminarProducto" href="Controlador?menu=pedidos&accion=EliminarProducto&id=${lista.getItem()}"> <i class="fa-solid fa-eraser"></i> </a> 
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-md-6">
                            <a class="btn btn-success" onclick="print()" href="Controlador?menu=pedidos&accion=GenerarVenta">Generar Venta <i class="fa-solid fa-check"></i></a>
                            <a class="btn btn-danger" href="Controlador?menu=pedidos&accion=NuevaVenta">Nueva Venta <i class="fa-solid fa-plus"></i>    </a> 
                        </div>
                        <label class="col-md-3 text-right ml-auto">Total </label>
                        <div class="col-md-3 ml-auto"> 
                            <input type=text" name="txtTotal" class="form-control" placeholder="$" readonly value="${ total }">
                        </div>
                    </div>

                </div>

            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script>
        <script src="js/funcionesPedidos.js" type="text/javascript"></script>

    </body>
</html>


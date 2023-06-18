<%@page contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <title>Productos</title>
    </head>
    <body> 
        
        <div class="row">
            <div class="col-lg-4">
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title">Registro de productos</h5> 
                        <form action="Controlador?menu=productos" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID</label>
                                <input id="idProductos" type="number" class="form-control" placeholder="Ingresa el ID" required name="txtID" value="${productoSel.getId_productos()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Nombre producto</label>
                                <input type="text" class="form-control" placeholder="Ingresa el nombre del producto" required minlength="4" name="txtNombre" value="${productoSel.getNombre_producto()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputFile">Subir Imagen</label>
                                <input id="exampleInputFile" type="file" class="form-control" name="imagen" value="${productoSel.getArchivoimg()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Proveedor</label>
                                <input type="number" class="form-control" placeholder="Ingresa el ID del proveedor" required name="txtProveedor" value="${productoSel.getProveedor()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Presupuesto</label>
                                <input type="number" step="0.01" class="form-control" placeholder="Ingresa la cantidad" required name="txtPresupuesto" value="${productoSel.getPresupuesto()}">  
                            </div>  
                            <div class="form-group">
                                <label for="exampleInputEmail1">Tipo producto</label>
                                <input type="text" class="form-control"   placeholder="¿Qué tipo de producto es?" name="txtTipoProd" value="${productoSel.getTipo_producto()}">
                            </div> 
                            <div class="form-group">
                                <label for="exampleInputEmail1">Otro tipo</label>
                                <input type="text" class="form-control"   placeholder="¿Qué tipo de producto es?" name="txtTipoProd2" value="${productoSel.getTipo_producto2()}">
                            </div> 
                            <div class="form-group">
                                <label for="exampleInputEmail1">Cantidad</label>
                                <input type="number" class="form-control" placeholder="Ingresa la cantidad" required minlength="12" name="txtCantidad" value="${productoSel.getCantidad()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Detalles</label>
                                <input type="text" class="form-control" placeholder="Ingresa la cantidad" name="txtDesc" value="${productoSel.getDesc()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID Sucursal</label>
                                <input type="number" class="form-control" placeholder="Ingresa el ID de la sucursal" required name="txtSucursal" value="${productoSel.getSucursal_id()}">  
                            </div>
                            <button type="submit" class="btn btn-success form-group" name="accion" value="Agregar">Agregar <i class="fa-solid fa-plus"></i></button>
                            <button type="submit" class="btn btn-primary form-group" name="accion" value="Actualizar">Actualizar <i class="fa-solid fa-arrows-rotate"></i></button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <table class="table">
                    <thead>
                        <tr> 
                            <th scope="col">ID</th>
                            <th scope="col">Imagen</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Proveedor</th> 
                            <th scope="col">Presupuesto</th> 
                            <th scope="col">Tipo de producto</th> 
                            <th scope="col">Otro tipo</th> 
                            <th scope="col">Cantidad</th>
                            <th scope="col">Detalles</th>
                            <th scope="col">Sucursal</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <th scope="row">${producto.getId_productos()}</th>  
                                <td>
                                    <c:choose>
                                        <c:when test="${producto.getArchivoimg() != null}">
                                            ${producto.getArchivoimg()}
                                        </c:when>    
                                        <c:otherwise>
                                            Empty
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${producto.getNombre_producto()}</td>
                                <td>${producto.getProveedor()}</td> 
                                <td>${producto.getPresupuesto()}</td> 
                                <td>${producto.getTipo_producto()}</td> 
                                <td>${producto.getTipo_producto2()}</td> 
                                <td>${producto.getCantidad()}</td> 
                                <td>${producto.getDesc()}</td>
                                <td>${producto.getSucursal_id()}</td>
                                <td> 
                                    <input type="hidden" id="codigo" value="${producto.getId_productos()}">
                                    <a id="editarProductos" href="Controlador?menu=productos&accion=Cargar&id=${producto.getId_productos()}" class="btn btn-warning form-group">
                                        <i class="fa-regular fa-pen-to-square"></i>                                    
                                    </a> 

                                    <a id="eliminarProductos" class="btn btn-danger form-group">
                                        <i class="fa-solid fa-eraser"></i>
                                    </a> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>                  

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script>
        <script src="js/funcionesProductos.js" type="text/javascript"></script>

    </body>
</html>
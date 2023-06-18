<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <title>SUCURSALES</title>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-4">
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title">Registro de sucursales</h5>
                        <form action="Controlador?menu=sucursal" method="post"> 
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID</label>
                                <input id="idSucursal" type="number" class="form-control" placeholder="Ingresa el ID de la sucursal" required name="txtID" value="${sucursalSel.getId_sucursal()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Domicilio De La Sucursal</label>
                                <input type="text" class="form-control" placeholder="Ingresa el domicio de la sucursal" required minlength="4" name="txtDomicilio" value="${sucursalSel.getDomicilio_sucursal()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Telefono</label>
                                <input type="number" class="form-control" placeholder="Ingresa el telefono de la sucursal" required minlength="10" maxlength="10" name="txtTelefono" value="${sucursalSel.getTelefono_sucursal()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Correo</label>
                                <input type="text" class="form-control" placeholder="Ingresa el correo de la sucursal" required name="txtCorreo" value="${sucursalSel.getCorreo_sucursal()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Numero de empleados</label>
                                <input type="number" step="0.01" class="form-control" placeholder="Ingresa la cantidad de empleados en la sucursal" required name="txtNumeroEmpleados" value="${sucursalSel.getNum_empleados()}">  
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
                            <th scope="col">Domicilio</th>
                            <th scope="col">Telefono</th> 
                            <th scope="col">Correo</th> 
                            <th scope="col">Numero De Empleados</th> 
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="sucursal" items="${sucursales}">
                            <tr>
                                <th scope="row">${sucursal.getId_sucursal()}</th>  
                                <td>${sucursal.getDomicilio_sucursal()}</td>
                                <td>${sucursal.getTelefono_sucursal()}</td>
                                <td>${sucursal.getCorreo_sucursal()}</td> 
                                <td>${sucursal.getNum_empleados()}</td> 
                                <td> 
                                    <input type="hidden" id="codigo" value="${sucursal.getId_sucursal()}">
                                    <a id="editarSucursal" class="btn btn-warning form-group" href="Controlador?menu=sucursal&accion=Cargar&id=${sucursal.getId_sucursal()}">
                                        <i class="fa-regular fa-pen-to-square"></i>                                    
                                    </a> 

                                    <a id="eliminarSucursal" class="btn btn-danger form-group">
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
        <script src="js/funcionesSucursales.js" type="text/javascript"></script>

    </body>
</html>

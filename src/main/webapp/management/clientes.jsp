<%-- 
    Document   : clientes
    Created on : 23 oct. 2022, 20:59:16
    Author     : hagc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 
        <link href="img/favicon-32x32.png" rel="icon"/>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <title>Clientes</title>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-4">
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title">Registro de clientes</h5>
                        <form action="Controlador?menu=clientes" method="post" > 
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID</label>
                                <input type="number" class="form-control" placeholder="Ingresa el ID" required name="txtID" readonly value="${clienteSel.getId_cliente()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Nombres</label>
                                <input type="text" class="form-control" placeholder="Ingresa los nombres" required minlength="4" name="txtNombres" value="${clienteSel.getNombres_cliente()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Apellidos</label>
                                <input type="text" class="form-control" placeholder="Ingresa los apellidos" required minlength="5" name="txtApellidos" value="${clienteSel.getApellidos_cliente()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Dirección</label>
                                <input type="text" class="form-control" placeholder="Ingresa la dirección" required name="txtDireccion" value="${clienteSel.getDireccion_cliente()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Teléfono</label>
                                <input type="text" class="form-control" placeholder="Ingresa el número de teléfono" required minlength="10" maxlength="10" name="txtTelefono" value="${clienteSel.getTelefono()}">  
                            </div>  
                            <div class="form-group">
                                <label for="exampleInputEmail1">Correo electrónico</label>
                                <input type="email" class="form-control"   placeholder="Ingresa el correo" name="txtCorreo" value="${clienteSel.getCorreo_cliente()}">
                            </div> 
                            <div class="form-group">
                                <label for="exampleInputEmail1">Contraseña</label>
                                <input type="text" class="form-control" placeholder="Ingresa el ID de la sucursal" required minlength="12" name="txtContra" value="${clienteSel.getContrasenia()}">  
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
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Dirección</th>
                            <th scope="col">Teléfono</th> 
                            <th scope="col">Correo</th> 
                            <th scope="col">Contraseña</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}">
                            <tr>
                                <th scope="row">${cliente.getId_cliente()}</th> 
                                <td>${cliente.getNombres_cliente()}</td>
                                <td>${cliente.getApellidos_cliente()}</td>
                                <td>${cliente.getDireccion_cliente()}</td>
                                <td>${cliente.getTelefono()}</td> 
                                <td>${cliente.getCorreo_cliente()}</td> 
                                <td>${cliente.getContrasenia()}</td>
                                <td> 
                                    <input type="hidden" id="codigo" value="${cliente.getId_cliente()}"> 
                                    <a id="editarClientes" class="btn btn-warning form-group" href="Controlador?menu=clientes&accion=Cargar&id=${cliente.getId_cliente()}">
                                        <i class="fa-regular fa-pen-to-square"></i>                                    
                                    </a> 

                                    <a id="eliminarClientes" class="btn btn-danger form-group">
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
        <script src="js/funcionesClientes.js" type="text/javascript"></script>

    </body>
</html>
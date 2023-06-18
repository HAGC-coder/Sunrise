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

        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>
        
        <title>Empleados</title>
    </head>
    <body>

        <div class="row">
            <div class="col-lg-3">
                <div class="card" >
                    <div class="card-body">
                        <h5 class="card-title">Registro de empleados</h5>
                        <form action="Controlador?menu=empleados" method="post"> 
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID</label>
                                <input type="number" class="form-control" placeholder="Ingresa el ID" required name="txtID" value="${empleadoSel.getId_empleado()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Nombres</label>
                                <input type="text" class="form-control" placeholder="Ingresa los nombres" required minlength="4" name="txtNombres" value="${empleadoSel.getNombre_empleado()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Apellidos</label>
                                <input type="text" class="form-control" placeholder="Ingresa los apellidos" required minlength="5" name="txtApellidos" value="${empleadoSel.getApellidos_empleado()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Teléfono</label>
                                <input type="text" class="form-control" placeholder="Ingresa el número de teléfono" required minlength="10" maxlength="10" name="txtTelefono" value="${empleadoSel.getTel_empleado()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Nivel</label>
                                <input type="number" class="form-control" placeholder="Ingresa el nivel de empleado" name="txtNivel" value="${empleadoSel.getNivel()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Correo electrónico</label>
                                <input type="email" class="form-control"   placeholder="Ingresa el correo" name="txtCorreo" value="${empleadoSel.getCorreo_empleado()}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Contraseña</label>
                                <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Ingresa la contraseña" name="txtPassword" value="${empleadoSel.getContra_empleado()}">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID Bodega</label>
                                <input type="number" class="form-control" placeholder="Ingresa el ID de la bodega" required minlength="12" name="txtBodega" value="${empleadoSel.getBodega_ID()}">  
                            </div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">ID Sucursal</label>
                                <input type="number" class="form-control" placeholder="Ingresa el ID de la sucursal" required minlength="12" name="txtSucursal" value="${empleadoSel.getSucursal_ID()}">  
                            </div>
                            <button type="submit" class="btn btn-success form-group" name="accion" value="Agregar">Agregar <i class="fa-solid fa-plus"></i></button>
                            <button type="submit" class="btn btn-primary form-group" name="accion" value="Actualizar">Actualizar <i class="fa-solid fa-arrows-rotate"></i></button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-lg-9">
                <table class="table">
                    <thead>
                        <tr> 
                            <th scope="col">ID</th>
                            <th scope="col">Nombre</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Nivel</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Contraseña</th>
                            <th scope="col">Bodega</th>
                            <th scope="col">Sucursal</th>
                            <th scope="col"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                            <tr>
                                <th scope="row">${empleado.getId_empleado()}</th> 
                                <td>${empleado.getNombre_empleado()}</td>
                                <td>${empleado.getApellidos_empleado()}</td>
                                <td>${empleado.getTel_empleado()}</td>
                                <td>${empleado.getNivel()}</td>
                                <td>${empleado.getCorreo_empleado()}</td>
                                <td>${empleado.getContra_empleado()}</td>
                                <td>${empleado.getBodega_ID()}</td>
                                <td>${empleado.getSucursal_ID()}</td>
                                <td> 
                                    <input type="hidden" id="codigo" value="${empleado.getId_empleado()}"> 
                                    <a id="editarEmpleados" class="btn btn-warning" href="Controlador?menu=empleados&accion=Cargar&id=${empleado.getId_empleado()}">Editar</a> 

                                    <a id="eliminarEmpleados" class="btn btn-danger">Eliminar</a> 
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
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script>
        <script src="js/funcionesEmpleados.js" type="text/javascript"></script>
    
    </body>
</html>
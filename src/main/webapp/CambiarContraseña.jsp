
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!doctype html>
<html>
    <head> 
        <meta name='viewport' content='width=device-width, initial-scale=1'>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>

        <title>Cambiar contraseña</title>
    </head>
    <body oncontextmenu='return false' class='snippet-body'>
        <div class="container padding-bottom-3x mb-2 mt-5">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <div class="forgot">
                        <h2>¿Olvidaste tu contraseña?</h2>
                        <p>Cambia tu contraseña en tres simples pasos:</p>
                        <ol class="list-unstyled">
                            <li><span class="text-primary text-medium">1. </span>Escribe tu correo electrónico en el campo de abajo.</li>
                            <li><span class="text-primary text-medium">2. </span>Recibirás un código temporal (OTP).</li>
                            <li><span class="text-primary text-medium">3. </span>Ingresa el código en la siguiente página </li>
                            <p class="text-center text-danger"><small>
                                    Nota: Solo podrás realizar los pasos 2 y 3 si tu correo se encuentra registrado en nuestro sistema, 
                                    de lo contrario serás redireccionado a la página anterior.
                                </small></p>
                        </ol>
                    </div>
                    <form class="card mt-4" action="RecuperarPassword" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label for="email-for-pass">Ingresa tu correo electrónico</label> <input
                                    class="form-control" type="text" name="email" id="email-for-pass" required=""><small
                                    class="form-text text-muted">Ingresa el correo registrado. Entonces enviaremos una contraseña temporal a esa dirección.</small>
                                <div>
                                    <label for="cli">Soy cliente</label> 
                                    <input id="cli" type="radio" name="check" value="Cliente" required>

                                    <label for="cli2">Soy empleado</label>
                                    <input id="cli2" type="radio" name="check" value="Empleado" required>
                                </div>
                            </div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-success" type="submit">Obtén una nueva
                                contraseña</button>
                            <button class="btn btn-danger" type="submit">Regresar al login</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script> 


    </body>
</html>
<%-- 
    Document   : login.jsp
    Created on : 23 oct. 2022, 17:46:32
    Author     : hagc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css"/>

        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Inicio</title>
    </head>
    <body> 

        <input type="hidden" id="status" value="<%=  request.getAttribute("status")%>">
        <div class="container-form row"> 

            <div class="container-form sign-up"> 
                <div class="welcome-back col-lg-5"> 
                    <div class="message">
                        <h2>Bienvenido</h2>
                        <p>Si ya tienes una cuenta puedes iniciar sesión aquí</p>
                        <button class="sign-btn">Iniciar sesión</button>
                    </div>
                </div>
                <form class="formulario" action="http://localhost:8090/Validar" method="post"> 
                <!--<form class="formulario" action="http://sunrise.sp.skdrive.net/Validar" method="post"> -->

                    <h2 class="login">Crear cuenta</h2>
                    <input class="form-control rounded"
                           type="text"
                           name="txtNombre-signup" 
                           required 
                           placeholder="Escribe tu/s nombre/s"
                           minlenght="4"> 
                    <input class="form-control rounded"
                           type="text"
                           name="txtApellidos-signup" 
                           required
                           minlenght="5" 
                           placeholder="Escribe tu/s apellido/s"> 
                    <input type="text" 
                           class="form-control" 
                           placeholder="Ingresa la dirección" 
                           required 
                           name="txtDireccion-signup"
                           minlenght="15">
                    <input class="form-control rounded"
                           type="text"
                           name="txtNumero-signup" 
                           required 
                           placeholder="+52"
                           minlenght="10"> 
                    <input class="form-control rounded"
                           type="email"
                           name="txtCorreo-signup" 
                           required 
                           placeholder="Ingresa tu correo"
                           minlenght="17"> 
                    <input class="form-control rounded"
                           type="password"
                           name="txtPassword-signup" 
                           required
                           minlenght="8" 
                           placeholder="Contraseña"> 
                    <small id="emailHelp" class="form-text">No compartas tus datos de acceso.</small>
                    <button class="sign-in-btn" type="submit" name="accion" value="Registrar">Registrarse</button>    

                </form> 
            </div>
            <div class="container-form log-in1">
                <form class="formulario" action="http://localhost:8090/Validar" method="post"> 
                <!--<form class="formulario" action="http://sunrise.sp.skdrive.net/Validar" method="post"> -->

                    <h2 class="login">Iniciar sesión</h2>

                    <input class="form-control rounded"
                           type="email"
                           name="txtCorreo" 
                           required 
                           placeholder="Ingresa tu correo"
                           minlenght="17"> 
                    <input class="form-control rounded"
                           type="password"
                           name="txtPassword" 
                           required
                           minlenght="8" 
                           placeholder="Contraseña">  
                    <div>
                        <label for="cli">Soy cliente</label> 
                        <input id="cli" type="radio" name="checkCliente" value="Cliente" required>

                        <label for="cli2">Soy empleado</label>
                        <input id="cli2" type="radio" name="checkCliente" value="No" required>
                    </div>
                    <small id="emailHelp" class="form-text">No compartas tus datos de acceso.</small>
                    <button class="sign-in-btn" type="submit" name="accion" value="Ingresar">Iniciar Sesión</button>    
                    <small id="emailHelp" class="form-text"><a style="color:#fff; margin-top: 1rem;" href="CambiarContraseña.jsp">¿Olvidaste tu contraseña?</a></small>
                </form> 
                <div class="welcome-back col-lg-5"> 
                    <div class="message">
                        <h2>Bienvenido de nuevo</h2>
                        <p>¿Eres nuevo en Sunrise?</p>
                        <button class="log-btn">Regístrate</button>
                    </div>
                </div>
            </div>

        </div> 

        <script src="js/login.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="sweetalert2/sweetalert.min.js" type="text/javascript"></script> 
        <script>
            var status = document.getElementById("status").value;
            if (status == "resetSuccess") {
                swal("Listo!", "Su contraseña ha sido restablecida", "success");
            } else if (status == "resetFailed") {
                swal("Error", "Su contraseña no se ha podido restablecer", "error");
            } else if (status == "noexiste") {
                swal("Error", "El correo no existe en nuestra base de datos", "error");
            } else if (status == "usrIncorrecto") {
                swal("Error", "Usuario no encontrado, verifique sus datos", "info");
            } else if (status == "errorbase") {
                swal("Error", "Error en la conexión a la base de datos", "error");
            } else if (status == "existe") {
                swal("Listo!", "El usuario ya existe", "error");
            } else if (status == "correcto") {
                swal("Listo!", "Se ha registrado correctamente", "success");
            } else if (status == "cerrar") {
                Swal.fire({
                    position: 'top-end',
                    icon: 'success',
                    title: '    ¡Hasta luego!',
                    showConfirmButton: false,
                    timer: 1000
                });
            }
        </script>   

        <c:remove var="status"/>
    </body>
</html>

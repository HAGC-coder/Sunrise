<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="img/favicon-32x32.png" rel="icon" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
        integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css" />
    <link rel="shortcut icon" href="img/Sunrise.png" type="image/x-icon">
    <link rel="stylesheet" href="img/Sunrise.png" tabindex="image/x-icon">
    <link rel="stylesheet" href="estilos.css">
    <!-- Animaciones -->
    <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
    <title>Contacto</title>
</head>

<body>
    <%@include file = "../Templates/navbar.jsp"%>
 
    <section class="nosotros" my-5>
        <h2 class="text-center my-5">Contactanos</h2>
        <div class="container">
            <div class="row">
                <div class="col-6">
                    <p class="text-justify">Estamos a tus órdenes para todo lo que necesites.
                        Para mayor información o sugerencias, háblanos o escribe tus comentarios y con gusto te daremos
                        respuesta a la
                        brevedad.</p>
                </div>
                <div class="col-6">
                    <img src="img/Sunrise.png" alt="Empresa">
                </div>
            </div>
        </div>
    </section>
    <div class="uno">
        <div id="content">
            <h2>CONTACTANOS</h2>
            <form action="">
                <label for="">Nombre</label>
                <input id="salida" type="text">
                <br>
                <label for="">Telefono</label>
                <input id="salida" type="text">
                <br>
                <label for="">Correo</label>
                <input id="salida" type="email">
                <br>
                <label for="">Mensaje</label>
                <textarea name="Mensaje" id="textArea" cols="30" rows="10">Mensaje</textarea>
                <br>
                <input type="submit" value="ENVIAR" style="width: 100px;">
            </form>
            <br>
            <section class="nosotros" my-5>
                <h2 class="text-center my-5">Sucursales</h2>
                <div class="container">
                    <div class="row">
                        <div class="col-6">
                            <h3>Sucursal 218</h3>
                            <ul>
                                <li>Telefono: (33) 3617-3891</li>
                                <li>Email: contacto@salvavidassunrise.com</li>
                                <li>Dirección: Av. Ãlvaro ObregÃ³n, No. 218, Col. San Juan de Dios, C.P. 44360,
                                    Guadalajara, Jalisco.</li>
                            </ul>
                        </div>
                        <div class="col-6">
                            <h3>Sucursal 405</h3>
                            <ul>
                                <li>Telefono: (33) 3617-9381</li>
                                <li>Email: contacto@salvavidassunrise.com</li>
                                <li>DirecciÃ³n: Av. Ãlvaro ObregÃ³n, No. 405, Col. San Juan de Dios, C.P. 44360,
                                    Guadalajara, Jalisco.</li>
                            </ul>

                        </div>
                    </div>
            </section>
        </div>
        <section class="nosotros" my-5>
            <h2 class="text-center my-5">Sucursales Direcciones</h2>
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <h3>Sucursal 218</h3>
                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3732.9013966924676!2d-103.3406215854741!3d20.673590186191866!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8428b1f39ff8ed4f%3A0x902624e52323757f!2sC.%20%C3%81lvaro%20Obreg%C3%B3n%20218%2C%20San%20Juan%20de%20Dios%2C%2044360%20Guadalajara%2C%20Jal.!5e0!3m2!1ses-419!2smx!4v1680058351868!5m2!1ses-419!2smx"
                            width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                            referrerpolicy="no-referrer-when-downgrade"></iframe>

                    </div>
                    <div class="col-6">
                        <h3>Sucursal 405</h3>
                        <iframe
                            src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3732.919687139646!2d-103.3374048854741!3d20.6728461861923!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8428b18ca7484691%3A0xe86806fba8572af8!2sC.%20%C3%81lvaro%20Obreg%C3%B3n%20405%2C%20San%20Juan%20de%20Dios%2C%2044360%20Guadalajara%2C%20Jal.!5e0!3m2!1ses-419!2smx!4v1680057976856!5m2!1ses-419!2smx"
                            width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                            referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                </div>
        </section>
    </div> 
    <%@include file="../Templates/footer.jsp" %>
        <!-- Animaciones -->
        <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
        <script>
            AOS.init();
        </script>
</body>

</html>
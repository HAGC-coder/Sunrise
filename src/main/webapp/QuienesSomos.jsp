<!doctype html>
<html lang="es">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="img/favicon-32x32.png" rel="icon" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
              integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link href="sweetalert2/sweetalert.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="Img/Sunrise.png" type="image/x-icon">
        <link rel="stylesheet" href="Img/Sunrise.png" tabindex="image/x-icon">
        <link rel="stylesheet" href="estilos.css">
        <!-- Animaciones -->
        <link href="https://unpkg.com/aos@2.3.1/dist/aos.css" rel="stylesheet">
        <title>¿Quiénes Somos?</title>
    </head>

    <body>
        <%@include file = "../Templates/navbar.jsp"%>

        <section class="nosotros" my-5>
            <h2 class="text-center my-5">¿Quiénes Somos?</h2>
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <p>Sunrise es una Empresa 100% Mexicana, orientada a la compra y venta de productos
                            para el bienestar de
                            la comunidad, la cual se orienta
                            a los salvavidas entre muchos productos mÃ¡s...</p>
                    </div>
                    <div class="col-6">
                        <img src="img/Sunrise.png" alt="Empresa">
                    </div>
                </div>
            </div>
        </section>
        <section class="nosotros" my-5>
            <h2 class="text-center my-5">Productos</h2>
            <div class="container">
                <div class="row">
                    <div class="col-6">
                        <img src="img/Salvavidas.jpeg" alt="Salvavidas">
                    </div>
                    <div class="col-6">
                        <p>En Jugueteria Sunrise tenemos para ti salvavidas, flotadores para bebe, chalecos,
                            lanchas, albercas y
                            más. Todo lo necesario para hacer que esa experiencia en el agua sea inolvidable.</p>
                    </div>
                </div>
            </div>
        </section>
        <section class="nosotros" my-5>
            <h2 class="text-center my-5">Salvavidas</h2>
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-3">
                            <img src="img/Salvavidas.jpeg" alt="Salvavidas">
                        </div>
                        <div class="col-3">
                            <h3>Salvavidas Dona</h3>
                            <ul>
                                <li>Salvavidas Dona Rosa</li>
                                <li>Precio: 89.0</li>
                                <li>Diametro: 45"</li>
                                <li>Piezas: 1 Salvavidas</li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <img src="img/Salvavidas.jpeg" alt="Salvavidas">
                        </div>
                        <div class="col-3">
                            <h3>Salvavidas Dona</h3>
                            <ul>
                                <li>Salvavidas Dona Verde</li>
                                <li>Precio: 89.0</li>
                                <li>Diametro: 45"</li>
                                <li>Piezas: 1 Salvavidas</li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <img src="img/Salvavidas.jpeg" alt="Salvavidas">
                        </div>
                        <div class="col-3">
                            <h3>Salvavidas Dona</h3>
                            <ul>
                                <li>Salvavidas Dona Naranja</li>
                                <li>Precio: 89.0</li>
                                <li>Diametro: 45"</li>
                                <li>Piezas: 1 Salvavidas</li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <img src="img/Salvavidas.jpeg" alt="Salvavidas">
                        </div>
                        <div class="col-3">
                            <h3>Salvavidas Dona</h3>
                            <ul>
                                <li>Salvavidas Dona Roja</li>
                                <li>Precio: 89.0</li>
                                <li>Diametro: 45"</li>
                                <li>Piezas: 1 Salvavidas</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="nosotros" my-5>
            <h2 class="text-center my-5">Empleados</h2>
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-3">
                            <img src="img/empleado.png" alt="Empleados" width="200px" height="200px">
                        </div>
                        <div class="col-3">
                            <h3>Empleado Misael</h3>
                            <ul>
                                <li>Empleado Misael</li>
                                <li>Edad 24 años</li>
                                <li>Perfil: Almacenista</li>
                                <li>Telefono: 3345678954</li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <img src="img/empleado.png" alt="Empleados" width="200px" height="200px">
                        </div>
                        <div class="col-3">
                            <h3>Empleado Memo</h3>
                            <ul>
                                <li>Empleado Memo</li>
                                <li>Edad 40 años</li>
                                <li>Perfil: Gerente</li>
                                <li>Telefono: 3345678978</li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <img src="img/empleado.png" alt="Empleados" width="200px" height="200px">
                        </div>
                        <div class="col-3">
                            <h3>Empleado Eduardo</h3>
                            <ul>
                                <li>Empleado Eduardo</li>
                                <li>Edad 20 años</li>
                                <li>Perfil: Almacenista</li>
                                <li>Telefono: 3345678978</li>
                            </ul>
                        </div>
                        <div class="col-3">
                            <img src="img/empleado.png" alt="Empleados" width="200px" height="200px">
                        </div>
                        <div class="col-3">
                            <h3>Empleado Carlo</h3>
                            <ul>
                                <li>Empleado Carlo</li>
                                <li>Edad 30 años</li>
                                <li>Perfil: Chofer</li>
                                <li>Telefono: 334678958</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section> 

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"> instead of < script src = "https://code.jquery.com/jquery-3.1.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script> 
    </body>

</html>
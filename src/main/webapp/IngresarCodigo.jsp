 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
         
        <title>Código de recuperación</title>
    </head>

    <body>

        <div class="container card" style="margin-top: 50px;">

            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center"> 
                        <h2 class="text-center">Ingresa el código de recuperación</h2>
                        <%
                            if (request.getAttribute("message") != null) {
                                out.print("<p class='text-danger ml-1'>" + request.getAttribute("message") + "</p>");
                            }

                        %>

                        <div class="panel-body">

                            <form id="register-form" action="ValidarCodigo" role="form" autocomplete="off"
                                  class="form" method="post">

                                <div class="form-group">
                                    <div class="input-group">
                                        <input
                                            id="opt" name="otp" placeholder="Código de recuperación"
                                            class="form-control" type="text" required="required">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <button name="recover-submit"
                                            class="btn btn-lg btn-primary btn-block"
                                            value="Reset Password" type="submit">
                                        Restablecer la contraseña
                                    </button>
                                </div>
                                <input type="hidden" name="check" value="${ check }"> 
                                <input type="hidden" class="hide" name="token" id="token"
                                       value="">
                            </form>

                        </div>
                    </div> 
                </div>
            </div>
        </div>

    </body>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


</html>

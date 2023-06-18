<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="img/favicon-32x32.png" rel="icon"/>
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css' rel='stylesheet'>
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.3/css/font-awesome.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        
        
        <title>Nueva contraseña</title>
    </head>
</head>
<body oncontextmenu='return false' class='snippet-body'>

    <div>
        <!-- Container containing all contents -->
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5"> 
                    <div class="container card rounded mt-2 mb-2 px-0">
                        <!-- Main Heading -->
                        <div class="row justify-content-center align-items-center pt-3">
                            <h1>
                                <strong>Restablecer contraseña</strong>
                            </h1>
                        </div>
                        <div class="pt-3 pb-3">
                            <form class="form-horizontal" action="CambiarPassword" method="POST"> 
                                <input type="hidden" name="check" value="${ check }"> 
                                <div class="form-group row justify-content-center px-3">
                                    <div class="col-9 px-0">
                                        <input type="text" name="password" placeholder="Nueva contraseña"
                                               class="form-control border-info placeicon">
                                    </div>
                                </div> 
                                <div class="form-group row justify-content-center px-3">
                                    <div class="col-9 px-0">
                                        <input type="password" name="confPassword"
                                               placeholder="Confirma la contraseña"
                                               class="form-control border-info placeicon">
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-3 px-3 mt-3">
                                        <button type="submit" value="Reset"
                                                class="btn btn-block btn-info">Confirmar</button>
                                    </div>
                                </div>
                            </form>
                             
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/js/all.js" integrity="sha512-S1KaVll2UTj29SOXML7O4LxU7zEoQhJgnondHE/ZvNrk7H4Rc9TLFKDaWuEzsHmAEkJnWFedc0hcVrpvFTOlwA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

</body>
</html>

$(document).ready(function () {
    $("tr #eliminarSucursal").click(function (e) {
        e.preventDefault();
        var cod = $(this).parent().find('#codigo').val();

        swal({
            title: "Estás seguro de eliminar el registro?",
            text: "Verifica el registro antes de eliminarlo!",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-danger",
            confirmButtonText: "Aceptar",
            cancelButtonText: "Cancelar",
            closeOnConfirm: false,
            closeOnCancel: false
        },
                function (isConfirm) {
                    if (isConfirm) {
                        eliminarUsuario(cod);
                        swal("Registro eliminado", " ", "success");
                        setTimeout(actualizar, 1000);
                    } else {
                        swal("Cancelado", "", "error");
                    }
                });

    });
     
    function actualizar() { 
        location.reload();
    }   
    function eliminarUsuario(cod) {
        var url = "Controlador?menu=sucursal&accion=Eliminar&id=" + cod;
        console.log("Sucursal eliminada");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            succes: function (r) {}
        });
    }
    
});


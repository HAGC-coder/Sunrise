$(document).ready(function () {
    $("tr #eliminarProveedor").click(function (e) {
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
                        eliminarProveedor(cod);
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
    function eliminarProveedor(cod) {
        var url = "Controlador?menu=proveedor&accion=Eliminar&id=" + cod;
        console.log("Proveedor eliminado");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            succes: function (r) {}
        });
    }
    
});


$(document).ready(function () {
    $("tr #eliminarBodega").click(function (e) {
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
                        eliminarBodega(cod);
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
    function eliminarBodega(cod) {
        var url = "Controlador?menu=bodega&accion=Cargar&id="+cod; 
        console.log("Bodega eliminada");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            succes: function (r) {}
        });
    }
    
});


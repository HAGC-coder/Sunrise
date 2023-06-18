$(document).ready(function () {
    $("tr #eliminarPedidos").click(function (e) {
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
                        eliminarPedidos(cod);
                        swal("Registro eliminado", " ", "success");
                        setTimeout(actualizar, 500);
                    } else {
                        swal("Cancelado", "", "error");
                    }
                });

    });
   
    function actualizar() {
        location.reload();
    } 
    function eliminarPedidos(cod) {
        var url = "Controlador?menu=pedidos&accion=EliminarProducto&id=" + cod;
        console.log("Pedido eliminado");
        $.ajax({
            type: 'POST',
            url: url,
            async: true,
            succes: function (r) {}
        });
    }
});
 
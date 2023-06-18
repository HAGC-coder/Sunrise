/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import com.sunrise.GenerarFactura;
import java.io.*;
import static java.lang.System.out;
import java.util.*;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelos.*;

/**
 *
 * @author hagc
 */ 
@MultipartConfig
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleados empleados = new Empleados();
    EmpleadosDAO empleadosDAO = new EmpleadosDAO();
    Clientes clientes = new Clientes();
    ClientesDAO clientesDAO = new ClientesDAO();
    Productos productos = new Productos();
    ProductosDAO productosDAO = new ProductosDAO();
    Pedidos pedidos = new Pedidos();
    PedidosDAO pedidosDAO = new PedidosDAO();
    Sucursal sucursal = new Sucursal();
    SucursalDAO sucursalDAO = new SucursalDAO();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();
    Bodega bodega = new Bodega();
    BodegaDAO bodegaDAO = new BodegaDAO();

    int id_empleado, id_cliente, id_pedidos, id_productos, id_sucursal, id_proveedor, id_bodega, item = 0, indice = 0, idProd, cantidad, cantidadItem, idItem;
    float precioProd, subtotal, total, iva = (float) 0.16, subiva;
    String nomProd, numFactura;

    List<Pedidos> listaPedidos = new ArrayList();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");
        try {
            id_empleado = Integer.parseInt(request.getParameter("id"));
            id_cliente = Integer.parseInt(request.getParameter("id"));
            id_pedidos = Integer.parseInt(request.getParameter("id"));
            id_productos = Integer.parseInt(request.getParameter("id"));
            id_sucursal = Integer.parseInt(request.getParameter("id"));
            id_bodega = Integer.parseInt(request.getParameter("id"));
            id_proveedor = Integer.parseInt(request.getParameter("id"));

            idItem = Integer.parseInt(request.getParameter("id"));

        } catch (NumberFormatException ex) {
        }

        if (menu.equalsIgnoreCase("inicio")) {

            request.getRequestDispatcher("/management/inicio.jsp").forward(request, response);
        }

        if (menu.equalsIgnoreCase("productos")) {
            switch (accion) {
                case "Listar":
                    List lista = productosDAO.Listar();
                    request.setAttribute("productos", lista);
                    break;
                case "Agregar": 
                    try {  
                        int id = Integer.parseInt(request.getParameter("txtID"));
                        Part part = request.getPart("imagen");
                        String fileName = part.getSubmittedFileName();
                        
                        String nombre = request.getParameter("txtNombre");
                        int proveedor_prod = Integer.parseInt(request.getParameter("txtProveedor"));
                        float presupuesto = Float.valueOf(request.getParameter("txtPresupuesto"));
                        String tipo_prod = request.getParameter("txtTipoProd");
                        String tipo_prod2 = request.getParameter("txtTipoProd2");
                        int cantidad_prod = Integer.parseInt(request.getParameter("txtCantidad"));
                        String desc = request.getParameter("txtDesc");
                        int sucursal_id = Integer.parseInt(request.getParameter("txtSucursal"));

                        productos.setId_productos(id);
                        productos.setArchivoimg(fileName);
                        productos.setNombre_producto(nombre);
                        productos.setProveedor(proveedor_prod);
                        productos.setPresupuesto(presupuesto);
                        productos.setTipo_producto(tipo_prod);
                        productos.setTipo_producto2(tipo_prod2);
                        productos.setCantidad(cantidad_prod);
                        productos.setDesc(desc);
                        productos.setSucursal_id(sucursal_id); 
                        
                        String path = getServletContext().getRealPath("") + "img/catalogo";
                        File f = new File(path);
                        part.write(path + File.separator + fileName);
                        
                        productosDAO.Agregar(productos);
                        request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    } catch (NullPointerException ex) {
                        out.println(ex); 
                    } 
                break;
                case "Cargar":
                    Productos productos = productosDAO.ListarPorId(id_productos);
                    request.setAttribute("productoSel", productos);
                    request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    productosDAO.Eliminar(id_productos);
                    request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    try {
                        Productos productosUPD = new Productos();

                        Part part_upd = request.getPart("imagen");
                        String fileName_upd = part_upd.getSubmittedFileName();

                        String nombre_upd = request.getParameter("txtNombre");
                        int proveedor_upd = Integer.parseInt(request.getParameter("txtProveedor"));
                        float presupuesto_upd = Float.valueOf(request.getParameter("txtPresupuesto"));
                        String tipo_prod_upd = request.getParameter("txtTipoProd");
                        String tipo_prod2_upd = request.getParameter("txtTipoProd2");
                        int cantidad_prod_upd = Integer.parseInt(request.getParameter("txtCantidad"));
                        String desc_upd = request.getParameter("txtDesc");
                        int sucursal_id_upd = Integer.parseInt(request.getParameter("txtSucursal"));

                        productosUPD.setId_productos(id_productos);
                        productosUPD.setArchivoimg(fileName_upd);
                        productosUPD.setNombre_producto(nombre_upd);
                        productosUPD.setProveedor(proveedor_upd);
                        productosUPD.setPresupuesto(presupuesto_upd);
                        productosUPD.setTipo_producto(tipo_prod_upd);
                        productosUPD.setTipo_producto2(tipo_prod2_upd);
                        productosUPD.setCantidad(cantidad_prod_upd);
                        productosUPD.setDesc(desc_upd);
                        productosUPD.setSucursal_id(sucursal_id_upd);
                        
                        String path = getServletContext().getRealPath("") + "img/catalogo";
                        File f = new File(path);
                        part_upd.write(path + File.separator + fileName_upd);
                        
                        productosDAO.Actualizar(productosUPD);
                        request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    } catch (NullPointerException ex) {
                        out.println(ex);
                    }
                    break; 
            }
            request.getRequestDispatcher("/management/productos.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("sucursal")) {
            switch (accion) {
                case "Listar":
                    List lista = sucursalDAO.Listar();
                    request.setAttribute("sucursales", lista);
                    break;
                case "Agregar":
                    int id = Integer.parseInt(request.getParameter("txtID"));
                    String domicilio = request.getParameter("txtDomicilio");
                    String telefono = request.getParameter("txtTelefono");
                    String correo = (request.getParameter("txtCorreo"));
                    int numeroEmpleados = Integer.parseInt(request.getParameter("txtNumeroEmpleados"));

                    sucursal.setId_sucursal(id);
                    sucursal.setDomicilio_sucursal(domicilio);
                    sucursal.setTelefono_sucursal(telefono);
                    sucursal.setCorreo_sucursal(correo);
                    sucursal.setNum_empleados(numeroEmpleados);
                    System.out.println(sucursal);
                    sucursalDAO.Agregar(sucursal);
                    request.getRequestDispatcher("Controlador?menu=sucursal&accion=Listar").forward(request, response);
                    break;
                case "Cargar":
                    Sucursal sucursal = sucursalDAO.ListarPorId(id_sucursal);
                    request.setAttribute("sucursalSel", sucursal);
                    request.getRequestDispatcher("Controlador?menu=sucursal&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    sucursalDAO.Eliminar(id_sucursal);
                    request.getRequestDispatcher("Controlador?menu=sucursal&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Sucursal sucursalUPD = new Sucursal();

                    String domicilio_upd = request.getParameter("txtDomicilio");
                    String telefono_upd = request.getParameter("txtTelefono");
                    String correo_upd = request.getParameter("txtCorreo");
                    int numeroEmpleados_udp = Integer.parseInt(request.getParameter("txtNumeroEmpleados"));

                    sucursalUPD.setId_sucursal(id_sucursal);

                    sucursalUPD.setDomicilio_sucursal(domicilio_upd);
                    sucursalUPD.setTelefono_sucursal(telefono_upd);
                    sucursalUPD.setCorreo_sucursal(correo_upd);
                    sucursalUPD.setNum_empleados(numeroEmpleados_udp);
                    sucursalDAO.Actualizar(sucursalUPD);
                    request.getRequestDispatcher("Controlador?menu=sucursal&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("/management/sucursal.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("bodega")) {
            switch (accion) {
                case "Listar":
                    List lista = bodegaDAO.Listar();
                    request.setAttribute("bodegas", lista);
                    break;
                case "Agregar":
                    int id = Integer.parseInt(request.getParameter("txtID"));
                    String domicilio = request.getParameter("txtDomicilio");
                    String telefono = request.getParameter("txtTelefono");

                    bodega.setId_bodega(id);
                    bodega.setDireccion_bodega(domicilio);
                    bodega.setTel_bodega(telefono);

                    bodegaDAO.Agregar(bodega);
                    request.getRequestDispatcher("Controlador?menu=bodega&accion=Listar").forward(request, response);
                    break;
                case "Cargar":
                    Bodega bodega = bodegaDAO.ListarPorId(id_bodega);
                    request.setAttribute("bodegaSel", bodega);
                    request.getRequestDispatcher("Controlador?menu=bodega&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    bodegaDAO.Eliminar(id_bodega);
                    request.getRequestDispatcher("Controlador?menu=bodega&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Bodega bodegaUPD = new Bodega();

                    String domicilio_upd = request.getParameter("txtDomicilio");
                    String telefono_upd = request.getParameter("txtTelefono");

                    bodegaUPD.setId_bodega(id_bodega);
                    bodegaUPD.setDireccion_bodega(domicilio_upd);
                    bodegaUPD.setTel_bodega(telefono_upd);

                    bodegaDAO.Actualizar(bodegaUPD);
                    request.getRequestDispatcher("Controlador?menu=bodega&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("/management/bodega.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("proveedor")) {
            switch (accion) {
                case "Listar":
                    List lista = proveedorDAO.Listar();
                    request.setAttribute("proveedores", lista);
                    break;
                case "Agregar":
                    int id = Integer.parseInt(request.getParameter("txtID"));
                    String nombre = request.getParameter("txtNombre");
                    String productos = request.getParameter("txtProductos");
                    String telefono = request.getParameter("txtTelefono");
                    String correo = request.getParameter("txtCorreo");
                    String pais = request.getParameter("txtPais");

                    proveedor.setId_proveedor(id);
                    proveedor.setNombre_proveedor(nombre);
                    proveedor.setProductos_proveedor(productos);
                    proveedor.setTel_proveedor(telefono);

                    proveedor.setCorreo_proveedor(correo);
                    proveedor.setPais_origen(pais);
                    proveedorDAO.Agregar(proveedor);
                    request.getRequestDispatcher("Controlador?menu=proveedor&accion=Listar").forward(request, response);
                    break;
                case "Cargar":
                    Proveedor proveedor = proveedorDAO.ListarPorId(id_proveedor);
                    request.setAttribute("proveedorSel", proveedor);
                    request.getRequestDispatcher("Controlador?menu=proveedor&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    proveedorDAO.Eliminar(id_proveedor);
                    request.getRequestDispatcher("Controlador?menu=proveedor&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Proveedor proveedorUPD = new Proveedor();
                    String nombre_upd = request.getParameter("txtNombre");
                    String productos_upd = request.getParameter("txtProductos");
                    String telefono_upd = request.getParameter("txtTelefono");
                    String correo_upd = request.getParameter("txtCorreo");
                    String pais_upd = request.getParameter("txtPais");

                    proveedorUPD.setId_proveedor(id_proveedor);
                    proveedorUPD.setNombre_proveedor(nombre_upd);
                    proveedorUPD.setProductos_proveedor(productos_upd);
                    proveedorUPD.setTel_proveedor(telefono_upd);
                    proveedorUPD.setCorreo_proveedor(correo_upd);
                    proveedorUPD.setPais_origen(pais_upd);
                    proveedorDAO.Actualizar(proveedorUPD);
                    request.getRequestDispatcher("Controlador?menu=proveedor&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("/management/proveedor.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("empleados")) {
            switch (accion) {
                case "Listar":
                    List lista = empleadosDAO.Listar();
                    request.setAttribute("empleados", lista);
                    break;
                case "Agregar":
                    int id = Integer.parseInt(request.getParameter("txtID"));
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String telefono = request.getParameter("txtTelefono");
                    int nivel = Integer.parseInt(request.getParameter("txtNivel"));
                    String correo = request.getParameter("txtCorreo");
                    String contra = request.getParameter("txtPassword");
                    int bodega_id = Integer.parseInt(request.getParameter("txtBodega"));
                    int sucursal_id = Integer.parseInt(request.getParameter("txtSucursal"));

                    empleados.setId_empleado(id);
                    empleados.setNombre_empleado(nombres);
                    empleados.setApellidos_empleado(apellidos);
                    empleados.setTel_empleado(telefono);
                    empleados.setNivel(nivel);
                    empleados.setCorreo_empleado(correo);
                    empleados.setContra_empleado(contra);
                    empleados.setBodega_ID(bodega_id);
                    empleados.setSucursal_ID(sucursal_id);

                    empleadosDAO.Agregar(empleados);
                    response.setHeader("refresh", "1;Controlador?menu=empleados&accion=Listar");
                    break;
                case "Cargar":
                    Empleados empleados = empleadosDAO.ListarPorId(id_empleado);
                    request.setAttribute("empleadoSel", empleados);
                    request.getRequestDispatcher("Controlador?menu=empleados&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    empleadosDAO.Eliminar(id_empleado);
                    response.setHeader("refresh", "1;Controlador?menu=empleados&accion=Listar");
                    break;
                case "Actualizar":
                    Empleados empleadosUPD = new Empleados();
                    String nombres_upd = request.getParameter("txtNombres");
                    String apellidos_upd = request.getParameter("txtApellidos");
                    String telefono_upd = request.getParameter("txtTelefono");
                    int nivel_upd = Integer.parseInt(request.getParameter("txtNivel"));
                    String correo_upd = request.getParameter("txtCorreo");
                    String contra_upd = request.getParameter("txtPassword");
                    int bodega_id_upd = Integer.parseInt(request.getParameter("txtBodega"));
                    int sucursal_id_upd = Integer.parseInt(request.getParameter("txtSucursal"));

                    empleadosUPD.setId_empleado(id_empleado);

                    empleadosUPD.setNombre_empleado(nombres_upd);
                    empleadosUPD.setApellidos_empleado(apellidos_upd);
                    empleadosUPD.setTel_empleado(telefono_upd);
                    empleadosUPD.setNivel(nivel_upd);
                    empleadosUPD.setCorreo_empleado(correo_upd);
                    empleadosUPD.setContra_empleado(contra_upd);
                    empleadosUPD.setBodega_ID(bodega_id_upd);
                    empleadosUPD.setSucursal_ID(sucursal_id_upd);

                    empleadosDAO.Actualizar(empleadosUPD);
                    //request.getRequestDispatcher("Controlador?menu=empleados&accion=Listar").forward(request, response);
                    response.setHeader("refresh", "1;Controlador?menu=empleados&accion=Listar");
                    break;

            }
            request.getRequestDispatcher("/management/empleados.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("clientes")) {
            switch (accion) {
                case "Listar":
                    List lista = clientesDAO.Listar();
                    request.setAttribute("clientes", lista);
                    break;
                case "Agregar":
                    String nombres = request.getParameter("txtNombres");
                    String apellidos = request.getParameter("txtApellidos");
                    String direccion = request.getParameter("txtDireccion");
                    String telefono = request.getParameter("txtTelefono");
                    String correo = request.getParameter("txtCorreo");
                    String contrasenia = request.getParameter("txtContra");

                    clientes.setNombres_cliente(nombres);
                    clientes.setApellidos_cliente(apellidos);
                    clientes.setDireccion_cliente(direccion);
                    clientes.setTelefono(telefono);
                    clientes.setCorreo_cliente(correo);
                    clientes.setContrasenia(contrasenia);

                    clientesDAO.Agregar(clientes);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Cargar":
                    Clientes clientes = clientesDAO.ListarPorId(id_cliente);
                    request.setAttribute("clienteSel", clientes);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    clientesDAO.Eliminar(id_cliente);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    Clientes clientesUPD = new Clientes();

                    String nombres_upd = request.getParameter("txtNombres");
                    String apellidos_upd = request.getParameter("txtApellidos");
                    String direccion_upd = request.getParameter("txtDireccion");
                    String telefono_upd = request.getParameter("txtTelefono");
                    String correo_upd = request.getParameter("txtCorreo");
                    String contrasenia_upd = request.getParameter("txtContra");

                    clientesUPD.setId_cliente(id_cliente);

                    clientesUPD.setNombres_cliente(nombres_upd);
                    clientesUPD.setApellidos_cliente(apellidos_upd);
                    clientesUPD.setDireccion_cliente(direccion_upd);
                    clientesUPD.setTelefono(telefono_upd);
                    clientesUPD.setCorreo_cliente(correo_upd);
                    clientesUPD.setContrasenia(contrasenia_upd);

                    clientesDAO.Actualizar(clientesUPD);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;

            }
            request.getRequestDispatcher("/management/clientes.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("pedidos")) {
            switch (accion) {
                case "Buscar Producto":
                    int id_prod = Integer.parseInt(request.getParameter("txtIdProducto"));
                    productos = productosDAO.BuscarProducto(id_prod);

                    request.setAttribute("productoSel", productos);
                    request.setAttribute("cliente", clientes);
                    request.setAttribute("total", total);
                    request.setAttribute("listaPedidos", listaPedidos);

                    break;
                case "Buscar":
                    int id_cli = Integer.parseInt(request.getParameter("txtIdCliente"));
                    clientes = clientesDAO.BuscarCliente(id_cli);
                    request.setAttribute("cliente", clientes);
                    request.setAttribute("numFactura", numFactura);
                    break;

                case "AgregarProducto":
                    pedidos = new Pedidos();
                    total = (float) 0.00;
                    item++;
                    idProd = Integer.parseInt(request.getParameter("txtIdProducto"));
                    nomProd = request.getParameter("txtNombreProd");
                    precioProd = Float.valueOf(request.getParameter("txtPrecioProd"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subiva = precioProd * iva;
                    subtotal = (precioProd + subiva) * cantidad;

                    pedidos.setItem(item);
                    pedidos.setNomProd(nomProd);
                    pedidos.setCantidadProd(cantidad);
                    pedidos.setPrecioUnidad(precioProd);
                    pedidos.setSubtotal(subtotal);
                    pedidos.setId_productos(idProd);
                    listaPedidos.add(pedidos);
                    for (int i = 0; i < listaPedidos.size(); i++) {
                        total += listaPedidos.get(i).getSubtotal();
                    }
                    request.setAttribute("total", total);
                    request.setAttribute("listaPedidos", listaPedidos);
                    request.setAttribute("numFactura", numFactura);
                    request.setAttribute("cliente", clientes);
                    break;
                case "EliminarProducto":
                    indice = listaPedidos.indexOf(idItem);
                    total = (float) 0.00;
                    listaPedidos.remove(indice + 1);

                    for (int i = 0; i < listaPedidos.size(); i++) {
                        total += listaPedidos.get(i).getSubtotal();
                    }
                    request.setAttribute("total", total);
                    request.setAttribute("listaPedidos", listaPedidos);
                    request.setAttribute("numFactura", numFactura);
                    request.setAttribute("cliente", clientes);
                    item--;
                    break;
                case "GenerarVenta":
                    for (int i = 0; i < listaPedidos.size(); i++) {
                        Productos productos = new Productos();
                        int cantidad, producto_id, stockActl;
                        cantidad = listaPedidos.get(i).getCantidadProd();
                        producto_id = listaPedidos.get(i).getId_productos();

                        ProductosDAO productosDAO = new ProductosDAO();
                        productos = productosDAO.BuscarProducto(producto_id);
                        stockActl = productos.getCantidad() - cantidad;

                        productosDAO.actualizarStock(producto_id, stockActl);
                    }
                    Date fecha = Date.valueOf(LocalDate.now());
                    pedidos.setCorresponde(clientes.getId_cliente());
                    pedidos.setNumFactura(numFactura);
                    pedidos.setFecha_pedido(fecha);
                    pedidos.setTotal(total);
                    pedidosDAO.RegistrarPedido(pedidos);

                    int pedidos_id = pedidosDAO.ObtenerIDPedido();
                    for (int i = 0; i < listaPedidos.size(); i++) {
                        pedidos = new Pedidos();
                        pedidos.setId_pedidos(pedidos_id);
                        pedidos.setId_productos(listaPedidos.get(i).getId_productos());
                        pedidos.setCantidadProd(listaPedidos.get(i).getCantidadProd());
                        pedidos.setPrecioUnidad(precioProd);
                        pedidosDAO.GuardarDetallePedido(pedidos);
                    }
                    NuevaVenta();
                    break;
                case "NuevaVenta":
                    NuevaVenta();
                    request.setAttribute("listaPedidos", listaPedidos);
                    break;
                default:
                    NuevaVenta();
                    request.setAttribute("listaPedidos", listaPedidos);
                    numFactura = pedidosDAO.ObtenerNumeroDeFactura();
                    if (numFactura == null) {
                        numFactura = "00000001";
                        request.setAttribute("numFactura", numFactura);
                    } else {
                        int incremento = Integer.parseInt(numFactura);
                        GenerarFactura fctra = new GenerarFactura();
                        numFactura = fctra.generarFactura(incremento);
                        request.setAttribute("numFactura", numFactura);
                    }
                    request.getRequestDispatcher("/management/pedidos.jsp").forward(request, response);
            }
            request.setAttribute("numFactura", numFactura);
            request.getRequestDispatcher("/management/pedidos.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void GenerarFactura() {

    }

    public void NuevaVenta() {
        item = 0;
        total = (float) 0.0;
        pedidos = new Pedidos();
        listaPedidos.clear();
    }
}

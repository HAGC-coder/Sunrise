/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Carrito;
import modelos.CarritoDAO;
import modelos.Orden;
import modelos.OrdenDAO;

/**
 *
 * @author hagc
 */
public class MiOrden extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    CarritoDAO carritoDAO = new CarritoDAO();
    int id_cli;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        String accion = request.getParameter("accion");
        try {
            id_cli = Integer.parseInt(request.getParameter("id"));

        } catch (NumberFormatException ex) {
        }
        switch (accion) {
            case "Ordenar":
                String nombres = request.getParameter("textNbrsCli");
                String apellidos = request.getParameter("textAdosCli");
                String telefono = request.getParameter("textTelCli");
                String direccion = request.getParameter("textDirCli");
                String tipo_pago = request.getParameter("tipoPago");

                List<Carrito> lista = carritoDAO.ListarPorIdCli(id_cli);
                if (lista.isEmpty()) {
                    session.setAttribute("msgError", "No hay productos en el carrito, añade uno para continuar");
                    response.sendRedirect("MiCarrito.jsp");
                } else {
                    OrdenDAO ordenDAO = new OrdenDAO();
                    //int i = ordenDAO.obtenerNumOrden();
                    Orden orden = null;

                    ArrayList<Orden> orLista = new ArrayList<>();
                    Random rand = new Random();
                    for (Carrito c : lista) {
                        //i++;
                        orden = new Orden();
                        orden.setId_orden("PROD--PEDIDO--0000" + rand.nextInt(1000));
                        orden.setNombreUsuario(nombres);
                        orden.setApellidosUsuario(apellidos);
                        orden.setDireccion(direccion);
                        orden.setTelefonoUsuario(telefono);
                        orden.setDireccion(direccion);
                        orden.setNombreProducto(c.getNombreProducto());
                        orden.setCatProducto(c.getCatProducto());
                        orden.setPrecio(c.getPrecio());
                        orden.setTipoPago(tipo_pago);

                        orLista.add(orden);
                    }

                    if ("noSeleccionado".equals(tipo_pago)) {
                        session.setAttribute("msg", "Selecciona el método de pago");
                        response.sendRedirect("MiCarrito.jsp");
                    } else {
                        boolean pedido = ordenDAO.guardarPedido(orLista);
                        if (pedido) {
                            response.sendRedirect("PedidoConfirmado.jsp");
                            System.out.println("Listo");
                        } else {
                            session.setAttribute("errPedido", "Error al momento de confirmar, intenta más tarde");
                            response.sendRedirect("MiCarrito.jsp");
                            System.out.println("Error");
                        }
                    }
                }
                break;
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

}

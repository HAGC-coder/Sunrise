/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Carrito;
import modelos.CarritoDAO;
import modelos.Productos;
import modelos.ProductosDAO;

/**
 *
 * @author hagc
 */
public class MiCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Productos p = new Productos();
    ProductosDAO productosDAO = new ProductosDAO();
    Carrito carrito = new Carrito();
    CarritoDAO carritoDAO = new CarritoDAO();

    int id_prod, id_cli;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        String accion = request.getParameter("accion");
        try {
            id_prod = Integer.parseInt(request.getParameter("id"));
            id_cli = Integer.parseInt(request.getParameter("id_cli")); 

        } catch (NumberFormatException ex) {
        }
        System.out.println(id_prod);
        
        switch (accion) {
            case "Añadir":
                p = productosDAO.ListarPorId(id_prod);

                carrito.setID_prod(id_prod);
                carrito.setID_cliente(id_cli);
                carrito.setNombreProducto(p.getNombre_producto());
                carrito.setCatProducto(p.getTipo_producto());
                carrito.setCatProducto2(p.getTipo_producto2());
                carrito.setPrecio(p.getPresupuesto());
                carrito.setTotal(p.getPresupuesto());

                int f = carritoDAO.Agregar(carrito);
                if (f != 1) {
                    System.out.println("Se añadio");
                    session.setAttribute("agrCarrito", "Producto añadido al carrito");
                    response.sendRedirect("index.jsp");
                } else {
                    System.out.println("No se añadio el producto");
                    session.setAttribute("error", "Se produjo un error");
                    response.sendRedirect("index.jsp");
                }
                break;
            case "Eliminar":
                System.out.println(id_prod);
                boolean del = carritoDAO.Eliminar(id_prod);
                if (del == true ) {
                    System.out.println("Eliminado");
                    session.setAttribute("delCarrito", "Producto eliminado");
                    response.sendRedirect("MiCarrito.jsp");
                } else {
                    System.out.println("No se añadio el producto");
                    session.setAttribute("error", "Se produjo un error");
                    response.sendRedirect("MiCarrito.jsp");
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

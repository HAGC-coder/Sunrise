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
import modelos.Productos;
import modelos.ProductosDAO;
import com.sunrise.Conexion;

/**
 *
 * @author hagc
 */
public class Inicio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Productos productos = new Productos();
    ProductosDAO productosDAO = new ProductosDAO();

    Boolean conex = true;
    String cat_productos, cat_productos2;
    int id_productos;
    String categoria;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Conexion con = new Conexion();

        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        String cat_productos = request.getParameter("categoria");
        String cat_productos2 = request.getParameter("categoria2");
        String ch = request.getParameter("ch");
        try {
            id_productos = Integer.parseInt(request.getParameter("id"));

        } catch (NumberFormatException ex) {
        }

        if (menu.equalsIgnoreCase("Juguetes")) {
            categoria = "Juguetes";
            if (con.Conexion() == null) {
                conex = false;
                request.setAttribute("conexion", conex);
            } else {
                switch (accion) {
                    case "Listar": 
                        List lista = productosDAO.ListarCat(menu);
                        request.setAttribute("productos", lista);
                        break;
                    case "A-Z":
                        List listaAZ = productosDAO.ListarAZ(menu);
                        request.setAttribute("productos", listaAZ);
                        break;
                    case "Z-A":
                        List listaZA = productosDAO.ListarZA(menu);
                        request.setAttribute("productos", listaZA);
                        break;
                }
            }
            request.setAttribute("nombrecat", categoria);
            request.setAttribute("categoria", menu);
            request.getRequestDispatcher("/category/Productos.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("ArtPersonales")) {
            categoria = "Artículos Personales";
            if (con.Conexion() == null) {
                conex = false;
                request.setAttribute("conexion", conex);
            } else {
                switch (accion) {
                    case "Listar": 
                        List lista = productosDAO.ListarCat(menu);
                        request.setAttribute("productos", lista);
                        break;
                    case "A-Z":
                        List listaAZ = productosDAO.ListarAZ(menu);
                        request.setAttribute("productos", listaAZ);
                        break;
                    case "Z-A":
                        List listaZA = productosDAO.ListarZA(menu);
                        request.setAttribute("productos", listaZA);
                        break;
                }
            }
            request.setAttribute("nombrecat", categoria);
            request.setAttribute("categoria", menu);
            request.getRequestDispatcher("/category/Productos.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("Hogar")) {
            categoria = "Hogar";
            if (con.Conexion() == null) {
                conex = false;
                request.setAttribute("conexion", conex);
            } else {
                switch (accion) {
                    case "Listar": 
                        List lista = productosDAO.ListarCat(menu);
                        request.setAttribute("productos", lista);
                        break;
                    case "A-Z":
                        List listaAZ = productosDAO.ListarAZ(menu);
                        request.setAttribute("productos", listaAZ);
                        break;
                    case "Z-A":
                        List listaZA = productosDAO.ListarZA(menu);
                        request.setAttribute("productos", listaZA);
                        break;
                }
            }
            request.setAttribute("nombrecat", categoria);
            request.setAttribute("categoria", menu);
            request.getRequestDispatcher("/category/Productos.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("Juegos")) {
            categoria = "Juegos";
            if (con.Conexion() == null) {
                conex = false;
                request.setAttribute("conexion", conex);
            } else {
                switch (accion) {
                    case "Listar": 
                        List lista = productosDAO.ListarCat(menu);
                        request.setAttribute("productos", lista);
                        break;
                    case "A-Z":
                        List listaAZ = productosDAO.ListarAZ(menu);
                        request.setAttribute("productos", listaAZ);
                        break;
                    case "Z-A":
                        List listaZA = productosDAO.ListarZA(menu);
                        request.setAttribute("productos", listaZA);
                        break;
                }
            }
            request.setAttribute("nombrecat", categoria);
            request.setAttribute("categoria", menu);
            request.getRequestDispatcher("/category/Productos.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("Playa")) {
            categoria = "Plays";
            if (con.Conexion() == null) {
                conex = false;
                request.setAttribute("conexion", conex);
            } else {
                switch (accion) {
                    case "Listar": 
                        List lista = productosDAO.ListarCat(menu);
                        request.setAttribute("productos", lista);
                        break;
                    case "A-Z":
                        List listaAZ = productosDAO.ListarAZ(menu);
                        request.setAttribute("productos", listaAZ);
                        break;
                    case "Z-A":
                        List listaZA = productosDAO.ListarZA(menu);
                        request.setAttribute("productos", listaZA);
                        break;
                }
            }
            request.setAttribute("nombrecat", categoria);
            request.setAttribute("categoria", menu);
            request.getRequestDispatcher("/category/Productos.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("Producto")) {
            switch (accion) {
                case "Ver":
                    Productos productos = productosDAO.ListarPorId(id_productos);
                    request.setAttribute("productoSel", productos);
                    List lista = productosDAO.ListarCatRel(id_productos, cat_productos);
                    request.setAttribute("productos", lista);
                    break;
            }
            request.getRequestDispatcher("/category/producto.jsp").forward(request, response);
        }
        if (menu.equalsIgnoreCase("Buscador")) {
            switch (accion) {
                case "Buscar":
                    List lista = productosDAO.ProductosPorBusqueda(ch);
                    request.setAttribute("productos", lista);
                    break;
            }
            request.getRequestDispatcher("busqueda.jsp").forward(request, response);
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

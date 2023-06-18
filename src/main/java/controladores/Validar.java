/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import com.sunrise.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Clientes;
import modelos.ClientesDAO;
import modelos.Empleados;
import modelos.EmpleadosDAO;

/**
 *
 * @author hagc
 */
public class Validar extends HttpServlet {

    Empleados empleado = new Empleados();
    EmpleadosDAO empleadoDAO = new EmpleadosDAO();
    Clientes cliente = new Clientes();
    ClientesDAO clienteDAO = new ClientesDAO();

    Boolean estado = false;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
        Conexion con = new Conexion();

        String accion = request.getParameter("accion");
        String selecc = request.getParameter("checkCliente");
        HttpSession sesion = request.getSession();
        if (accion.equalsIgnoreCase("Ingresar")) {
            if ("Cliente".equals(selecc)) { 
                String correo_cli = request.getParameter("txtCorreo"), contra_cli = request.getParameter("txtPassword");
                cliente = clienteDAO.Validar(correo_cli, contra_cli);
                
                if (cliente.getNombres_cliente() != null) {
                    System.out.println("Soy cliente");
                    estado = true;
                    request.setAttribute("status", "bienvenido");
                    sesion.setAttribute("cliente", cliente);
                    sesion.setAttribute("estado", estado);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } else if (con.Conexion() == null) {
                    response.setHeader("refresh", "4;login.jsp");
                    request.setAttribute("status", "errorbase");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    response.setHeader("refresh", "4;login.jsp");
                    request.setAttribute("status", "usrIncorrecto");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else if ("No".equals(selecc)) {
                System.out.println("Soy empleado");

                String correo = request.getParameter("txtCorreo"), contra = request.getParameter("txtPassword");
                empleado = empleadoDAO.Validar(correo, contra);
                if (empleado.getNombre_empleado() != null) {
                    request.setAttribute("status", "bienvenido");
                    sesion.setAttribute("empleado", empleado);
                    request.getRequestDispatcher("Controlador?menu=inicio").forward(request, response);
                    request.removeAttribute("status");
                } else if (con.Conexion() == null) {
                    response.setHeader("refresh", "4;login.jsp");
                    request.setAttribute("status", "errorbase");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    response.setHeader("refresh", "4;login.jsp");
                    request.setAttribute("status", "usrIncorrecto");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        }
        if (accion.equalsIgnoreCase("Registrar")) {
            try {
                Clientes clientes = new Clientes(); 
                ClientesDAO clientesDAO = new ClientesDAO();
                
                String nombre_cliente = request.getParameter("txtNombre-signup");
                String apellidos_cliente = request.getParameter("txtApellidos-signup");
                String direccion_cliente = request.getParameter("txtDireccion-signup");
                String telefono_cliente = request.getParameter("txtNumero-signup");
                String correo_cliente = request.getParameter("txtCorreo-signup");
                String contrasenia_cliente = request.getParameter("txtPassword-signup");

                clientes = clientesDAO.ValidarCorreo(correo_cliente);
                if (clientes.getNombres_cliente() != null) {
                    request.setAttribute("status", "existe");
                    response.setHeader("refresh", "4;login.jsp");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                } else {
                    clientes.setNombres_cliente(nombre_cliente);
                    clientes.setApellidos_cliente(apellidos_cliente);
                    clientes.setDireccion_cliente(direccion_cliente);
                    clientes.setTelefono(telefono_cliente);
                    clientes.setCorreo_cliente(correo_cliente);
                    clientes.setContrasenia(contrasenia_cliente);

                    clientesDAO.Agregar(clientes);
                    request.setAttribute("status", "correcto");
                    response.setHeader("refresh", "4;login.jsp");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (accion.equalsIgnoreCase("Salir")) {
            estado = false; 
            request.removeAttribute("estado");
            sesion.removeAttribute("empleado");
            sesion.removeAttribute("cliente");
            sesion.invalidate();
            request.logout();
            response.setHeader("refresh", "1;login.jsp");
            request.setAttribute("status", "cerrar");
            request.getRequestDispatcher("login.jsp").forward(request, response);  
        }

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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.*;

public class CambiarPassword extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpleadosDAO empleadoDAO = new EmpleadosDAO();
        ClientesDAO clienteDAO = new ClientesDAO();

        HttpSession session = request.getSession();
        String checkUser = request.getParameter("check");
        String newPassword = request.getParameter("password");
        String confPassword = request.getParameter("confPassword");
        String correo = String.valueOf(session.getAttribute("email"));
        RequestDispatcher dispatcher = null;

        if ( checkUser.equalsIgnoreCase("Empleado") ) {
            if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

                int act = empleadoDAO.ActualizarPassword(newPassword, correo);

                System.out.println(act);
                if (act > 0) {
                    request.setAttribute("status", "resetSuccess");
                    dispatcher = request.getRequestDispatcher("login.jsp");

                    System.out.println(act);
                } else {
                    request.setAttribute("status", "resetFailed");
                    dispatcher = request.getRequestDispatcher("login.jsp");

                }
                dispatcher.forward(request, response);

            }
        }
        if ( checkUser.equalsIgnoreCase("Cliente") ) {
            if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

                int act = clienteDAO.ActualizarPassword(newPassword, correo);

                System.out.println(act);
                if (act > 0) {
                    request.setAttribute("status", "resetSuccess");
                    dispatcher = request.getRequestDispatcher("login.jsp");

                    System.out.println(act);
                } else {
                    request.setAttribute("status", "resetFailed");
                    dispatcher = request.getRequestDispatcher("login.jsp");

                }
                dispatcher.forward(request, response);

            }
        }
    }

}

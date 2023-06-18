/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controladores;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.*;

@WebServlet(name = "RecuperarPassword", urlPatterns = {"/RecuperarPassword"})

public class RecuperarPassword extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Empleados empleado = new Empleados();
        EmpleadosDAO empleadoDAO = new EmpleadosDAO();
        Clientes cliente = new Clientes();
        ClientesDAO clienteDAO = new ClientesDAO();

        String email = request.getParameter("email");
        String check = request.getParameter("check");
        RequestDispatcher dispatcher = null;
        int otpvalue = 0;
        HttpSession mySession = request.getSession();
        
        System.out.println(check);
        if (check.equalsIgnoreCase("Empleado")) {
            empleado = empleadoDAO.ValidarEmail(email);
            if (email != null && !email.equals("") && empleado.getCorreo_empleado() != null) {
                // sending otp
                Random rand = new Random();
                otpvalue = rand.nextInt(1255650);

                String to = email;// change accordingly
                // Get the session object
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("aministraciondesunrise@gmail.com", "kukyzlgiewdxklfo");// Put your email
                        // id and
                        // password here
                    }
                });
                // compose message
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(email));// change accordingly
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("No responder a este correo");
                    message.setText("Tu código de recuperación es: " + otpvalue);
                    // send message
                    Transport.send(message);
                    System.out.println("message sent successfully");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                dispatcher = request.getRequestDispatcher("IngresarCodigo.jsp");
                request.setAttribute("message", "El código se envío a tu correo");

                mySession.setAttribute("otp", otpvalue);
                mySession.setAttribute("email", email);
                mySession.setAttribute("check", check);
                dispatcher.forward(request, response);

            } else {
                response.setHeader("refresh", "5;login.jsp");
                request.setAttribute("status", "noexiste");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else if (check.equalsIgnoreCase("Cliente")) {
            cliente = clienteDAO.ValidarEmail(email);
            System.out.println(cliente);
            if (email != null && !email.equals("") && cliente.getCorreo_cliente()!= null) {
                // sending otp
                Random rand = new Random();
                otpvalue = rand.nextInt(1255650);

                String to = email;// change accordingly
                // Get the session object
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("aministraciondesunrise@gmail.com", "kukyzlgiewdxklfo");// Put your email
                        // id and
                        // password here
                    }
                });
                // compose message
                try {
                    MimeMessage message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(email));// change accordingly
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    message.setSubject("No responder a este correo");
                    message.setText("Tu código de recuperación es: " + otpvalue);
                    // send message
                    Transport.send(message);
                    System.out.println("message sent successfully");
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
                dispatcher = request.getRequestDispatcher("IngresarCodigo.jsp");
                request.setAttribute("message", "El código se envío a tu correo");

                mySession.setAttribute("otp", otpvalue);
                mySession.setAttribute("email", email);
                mySession.setAttribute("check", check);
                dispatcher.forward(request, response);

            } else {
                response.setHeader("refresh", "5;login.jsp");
                request.setAttribute("status", "noexiste");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            response.setHeader("refresh", "5;login.jsp");
                request.setAttribute("status", "noexiste");
                request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}

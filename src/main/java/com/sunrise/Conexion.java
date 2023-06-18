/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sunrise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hagc
 */
public class Conexion {

    Connection con = null;
    //String url = "jdbc:mysql://node10289-sunrise.sp.skdrive.net:3306/sunrise";  
    String url = "jdbc:mysql://localhost:3306/sunrise";  
    String usuario = "root";
    //String contrasena = "XOdYk4coo4"; 
    String contrasena = "Password"; 

    public Conexion() {

    }

    public Connection Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, contrasena);
            /*if (con != null) {
                System.out.println("Se ha establecido una conexión a la base de datos " + url);
            }*/
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error " + e);
        }
        return con;
    } 

    public static void main(String[] args) {

    }
}

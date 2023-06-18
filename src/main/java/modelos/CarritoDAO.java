/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.sunrise.Conexion;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author hagc
 */
public class CarritoDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public List<Carrito> ListarPorIdCli(int id_cli) {
        List<Carrito> lista = new ArrayList<Carrito>();
        Carrito carrito = null;
        float total = 0;
        String consulta = "SELECT * FROM carrito where ID_cliente = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id_cli);
            rs = ps.executeQuery();
            rs.next();
            do {
                carrito = new Carrito();
                carrito.setID(rs.getInt(1));
                carrito.setID_prod(rs.getInt(2));
                carrito.setID_cliente(rs.getInt(3));
                carrito.setNombreProducto(rs.getString(4));
                carrito.setCatProducto(rs.getString(5));
                carrito.setCatProducto2(rs.getString(6));
                carrito.setPrecio(rs.getFloat(7));
                total += rs.getFloat(8);
                carrito.setTotal(total);

                lista.add(carrito);
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Carrito carrito) {

        String sentencia = "INSERT INTO carrito (ID_prod, ID_cliente, NombreProducto, CatProducto, CatProducto2, Precio, Total) VALUES (?,?,?,?,?,?,?);";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, carrito.getID_prod());
            ps.setInt(2, carrito.getID_cliente());
            ps.setString(3, carrito.getNombreProducto());
            ps.setString(4, carrito.getCatProducto());
            ps.setString(5, carrito.getCatProducto2());
            ps.setFloat(6, carrito.getPrecio());
            ps.setFloat(7, carrito.getTotal());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public boolean Eliminar(int id) {
        boolean f = false;
        try {
            String sentencia = "DELETE from carrito WHERE ID_prod = ?";
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, id);

            int del = ps.executeUpdate();
            if (del == 1) {
                f = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
}

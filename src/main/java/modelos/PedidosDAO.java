/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import com.sunrise.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

/**
 *
 * @author hagc
 */
public class PedidosDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public String ObtenerNumeroDeFactura() {
        String numFactura = "";
        String consulta = "SELECT MAX(numFactura) FROM pedidos";
        con = cn.Conexion();

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                numFactura = rs.getString(1); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return numFactura;

    }
    public int ObtenerIDPedido(){
        int pedido_ID = 0;
        String consulta = "SELECT MAX(ID) FROM pedidos"; 
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                pedido_ID = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedido_ID;
    }
    public void RegistrarPedido(Pedidos pedidos) {
        String sentencia = "INSERT INTO pedidos (Corresponde, numFactura, Fecha_pedido, TotalPedido) VALUES (?,?,?,?)";  
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
             ps = con.prepareStatement(sentencia);
            ps.setInt(1, pedidos.getCorresponde());
            ps.setString(2, pedidos.getNumFactura());
            ps.setDate(3, pedidos.getFecha_pedido());
            ps.setFloat(4, pedidos.getTotal());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void GuardarDetallePedido(Pedidos pedidos) {
        String sentencia = "INSERT INTO detalles_pedido (pedidos_ID, productos_ID, Cantidad_producto, Precio_venta) VALUES(?,?,?,?)";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, pedidos.getId_pedidos());
            ps.setInt(2, pedidos.getId_productos());
            ps.setInt(3, pedidos.getCantidadProd());
            ps.setFloat(4, pedidos.getPrecioUnidad());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    public int Eliminar(int id_pedidos) {
        String sentencia = "DELETE from pedidos WHERE ID = '" + id_pedidos + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PedidosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}

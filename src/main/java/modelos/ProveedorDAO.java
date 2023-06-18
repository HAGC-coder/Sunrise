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
public class ProveedorDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
 
    public List Listar() {
        String consulta = "SELECT * FROM proveedor";
        List<Proveedor> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_proveedor(rs.getInt(1));
                proveedor.setNombre_proveedor(rs.getString(2));
                proveedor.setProductos_proveedor(rs.getString(3));
                proveedor.setTel_proveedor(rs.getString(4));
                proveedor.setCorreo_proveedor(rs.getString(5));
                proveedor.setPais_origen(rs.getString(6));
                lista.add(proveedor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Proveedor proveedor) {
        
        String sentencia = "INSERT INTO proveedor (ID, Nombre, Productos, Telefono, Correo, PaisDeOrigen) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, proveedor.getId_proveedor());
            ps.setString(2, proveedor.getNombre_proveedor());
            ps.setString(3, proveedor.getProductos_proveedor());
            
            ps.setString(4, proveedor.getTel_proveedor());
            ps.setString(5, proveedor.getCorreo_proveedor());
            ps.setString(6, proveedor.getPais_origen());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Proveedor ListarPorId(int id) {
        Proveedor proveedor = new Proveedor();
        String consulta = "SELECT * FROM proveedor WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.setId_proveedor(rs.getInt(1));
                proveedor.setNombre_proveedor(rs.getString(2));
                proveedor.setProductos_proveedor(rs.getString(3));
                proveedor.setTel_proveedor(rs.getString(4));
                proveedor.setCorreo_proveedor(rs.getString(5));
                proveedor.setPais_origen(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proveedor;
    }

    public int Actualizar(Proveedor proveedor) { 

        String sentencia = "UPDATE proveedor set Nombre = ?, Productos=?, Telefono = ?, Correo =?, PaisDeOrigen = ? WHERE ID = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, proveedor.getNombre_proveedor());
            ps.setString(2, proveedor.getProductos_proveedor());
            ps.setString(3, proveedor.getTel_proveedor());
            ps.setString(4, proveedor.getCorreo_proveedor());
            ps.setString(5, proveedor.getPais_origen());
            
            ps.setInt(6, proveedor.getId_proveedor());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Eliminar(int id_proveedor) {
        String sentencia = "DELETE from proveedor WHERE ID = '" + id_proveedor+ "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
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
public class ProductosDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;

    public int Agregar(Productos productos) {

        String sentencia = "INSERT INTO productos (ID, archivoimg, NombreProducto, Proveedor, Presupuesto, TipoProducto, TipoProducto2, Cantidad, Detalles, Sucursal_ID) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, productos.getId_productos());
            ps.setString(2, productos.getArchivoimg());
            ps.setString(3, productos.getNombre_producto());
            ps.setInt(4, productos.getProveedor());
            ps.setFloat(5, productos.getPresupuesto());
            ps.setString(6, productos.getTipo_producto());
            ps.setString(7, productos.getTipo_producto2());
            ps.setInt(8, productos.getCantidad());
            ps.setString(9, productos.getDesc());
            ps.setInt(10, productos.getSucursal_id());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Productos BuscarProducto(int id) {
        Productos productos = new Productos();
        con = cn.Conexion();
        String consulta = "SELECT * FROM productos WHERE id = " + id;

        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    public int actualizarStock(int id, int cantidad) {
        String sentencia = "UPDATE productos set CantidadDeCajas = ? WHERE ID = ?";
        con = cn.Conexion();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, cantidad);
            ps.setInt(2, id);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List Listar() {
        String consulta = "SELECT * FROM productos";
        List<Productos> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = this.con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos = new Productos();
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));

                lista.add(productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List ListarAZ(String cat) {
        String consulta = "SELECT * FROM productos WHERE TipoProducto = '" + cat + "' or TipoProducto2 = '" + cat + "' ORDER BY NombreProducto ASC";
        List<Productos> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = this.con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos = new Productos();
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));

                lista.add(productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List ListarZA(String cat) {
        String consulta = "SELECT * FROM productos WHERE TipoProducto = '" + cat + "' or TipoProducto2 = '" + cat + "' ORDER BY NombreProducto DESC";
        List<Productos> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = this.con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos = new Productos();
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));

                lista.add(productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List ListarCat(String cat) {
        String consulta = "SELECT * FROM productos WHERE TipoProducto = '" + cat + "' or TipoProducto2 = '" + cat + "'";
        List<Productos> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = this.con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos = new Productos();
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));

                lista.add(productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List ListarCatRel(int id, String cat) {
        String consulta = "SELECT * FROM productos WHERE ID != '" + id + "' and TipoProducto = '" + cat + "' or TipoProducto2 = '" + cat + "' ORDER BY RAND() Limit 4";
        List<Productos> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = this.con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos = new Productos();
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));

                lista.add(productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Productos ListarPorId(int id) {
        Productos productos = new Productos();
        String consulta = "SELECT * FROM productos WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }

    public int Actualizar(Productos productos) {

        String sentencia = "UPDATE productos set archivoimg = ?, NombreProducto = ?, Proveedor = ?, Presupuesto = ?, TipoProducto = ?, TipoProducto2 = ?, Cantidad = ?, Detalles = ?, Sucursal_ID = ? WHERE ID = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.setString(1, productos.getArchivoimg());
            ps.setString(2, productos.getNombre_producto());
            ps.setInt(3, productos.getProveedor());
            ps.setFloat(4, productos.getPresupuesto());
            ps.setString(5, productos.getTipo_producto());
            ps.setString(6, productos.getTipo_producto2());
            ps.setInt(7, productos.getCantidad());
            ps.setString(8, productos.getDesc());
            ps.setInt(9, productos.getSucursal_id());

            ps.setInt(10, productos.getId_productos());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Eliminar(int id_productos) {
        String sentencia = "DELETE from productos WHERE ID = '" + id_productos + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public List ProductosPorBusqueda(String ch) {
        List<Productos> lista = new ArrayList();
        //String consulta = "SELECT * FROM productos WHERE NombreProducto like %'" + ch + "'% or TipoProducto like %'" + ch + "'% or TipoProducto2 like %'" + ch + "'% and Cantidad > 0";
        try {
            String consulta = "SELECT * FROM productos WHERE NombreProducto like ? or TipoProducto like ? or TipoProducto2 like ?";
            con = cn.Conexion();
            ps = this.con.prepareStatement(consulta);
            ps.setString(1, "%" + ch + "%");
            ps.setString(2, "%" + ch + "%");
            ps.setString(3, "%" + ch + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                Productos productos = new Productos();
                productos.setId_productos(rs.getInt(1));
                productos.setArchivoimg(rs.getString(2));
                productos.setNombre_producto(rs.getString(3));
                productos.setProveedor(rs.getInt(4));
                productos.setPresupuesto(rs.getFloat(5));
                productos.setTipo_producto(rs.getString(6));
                productos.setTipo_producto2(rs.getString(7));
                productos.setCantidad(rs.getInt(8));
                productos.setDesc(rs.getString(9));
                productos.setSucursal_id(rs.getInt(10));

                lista.add(productos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}

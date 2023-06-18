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
public class EmpleadosDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
     
    public Empleados Validar(String correo, String contra) {
        Empleados empleados = new Empleados();
        String consulta = "SELECT * FROM empleados WHERE Correo = ? AND Contrasenia = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            ps.setString(2, contra);
            rs = ps.executeQuery();
            rs.next();
            do {
                empleados.setId_empleado(rs.getInt(1));
                empleados.setNombre_empleado(rs.getString(2));
                empleados.setApellidos_empleado(rs.getString(3));
                empleados.setTel_empleado(rs.getString(4));
                empleados.setNivel(rs.getInt(5));
                empleados.setCorreo_empleado(rs.getString(6));
                empleados.setContra_empleado(rs.getString(7));
                empleados.setBodega_ID(rs.getInt(8));
                empleados.setSucursal_ID(rs.getInt(9));

            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    public int ActualizarPassword(String nuevaContrasenia, String correo) {
        String sentencia = "UPDATE empleados set Contrasenia = ? WHERE Correo = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, nuevaContrasenia);
            ps.setString(2, correo);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r+1;
    }

    public Empleados ValidarEmail(String correo) {
        Empleados empleados = new Empleados();
        String consulta = "SELECT * FROM empleados WHERE Correo = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            rs.next();
            do {
                empleados.setId_empleado(rs.getInt(1));
                empleados.setNombre_empleado(rs.getString(2));
                empleados.setApellidos_empleado(rs.getString(3));
                empleados.setTel_empleado(rs.getString(4));
                empleados.setNivel(rs.getInt(5));
                empleados.setCorreo_empleado(rs.getString(6));
                empleados.setContra_empleado(rs.getString(7));
                empleados.setBodega_ID(rs.getInt(8));
                empleados.setSucursal_ID(rs.getInt(9));

            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return empleados;
    }

    public List Listar() {
        String consulta = "SELECT * FROM empleados";
        List<Empleados> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Empleados empleados = new Empleados();
                empleados.setId_empleado(rs.getInt(1));
                empleados.setNombre_empleado(rs.getString(2));
                empleados.setApellidos_empleado(rs.getString(3));
                empleados.setTel_empleado(rs.getString(4));
                empleados.setNivel(rs.getInt(5));
                empleados.setCorreo_empleado(rs.getString(6));
                empleados.setContra_empleado(rs.getString(7));
                empleados.setBodega_ID(rs.getInt(8));
                empleados.setSucursal_ID(rs.getInt(9));
                lista.add(empleados);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Empleados empleados) {

        String sentencia = "INSERT INTO empleados (ID, Nombre, Apellidos, Telefono, Nivel, Correo, Contrasenia, Bodega_ID, Sucursal_ID) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, empleados.getId_empleado());
            ps.setString(2, empleados.getNombre_empleado());
            ps.setString(3, empleados.getApellidos_empleado());
            ps.setString(4, empleados.getTel_empleado());
            ps.setInt(5, empleados.getNivel());
            ps.setString(6, empleados.getCorreo_empleado());
            ps.setString(7, empleados.getContra_empleado());
            ps.setInt(8, empleados.getBodega_ID());
            ps.setInt(9, empleados.getSucursal_ID());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Empleados ListarPorId(int id) {
        Empleados empleados = new Empleados();
        String consulta = "SELECT * FROM empleados WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleados.setId_empleado(rs.getInt(1));
                empleados.setNombre_empleado(rs.getString(2));
                empleados.setApellidos_empleado(rs.getString(3));
                empleados.setTel_empleado(rs.getString(4));
                empleados.setNivel(rs.getInt(5));
                empleados.setCorreo_empleado(rs.getString(6));
                empleados.setContra_empleado(rs.getString(7));
                empleados.setBodega_ID(rs.getInt(8));
                empleados.setSucursal_ID(rs.getInt(9));

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    public int Actualizar(Empleados empleados) {
        String sentencia = "UPDATE empleados set Nombre = ?, Apellidos = ?, Telefono = ?, Nivel = ?, Correo = ?, Contrasenia = ?, Bodega_ID = ?, Sucursal_ID = ? WHERE ID = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, empleados.getNombre_empleado());
            ps.setString(2, empleados.getApellidos_empleado());
            ps.setString(3, empleados.getTel_empleado());
            ps.setInt(4, empleados.getNivel());
            ps.setString(5, empleados.getCorreo_empleado());
            ps.setString(6, empleados.getContra_empleado());
            ps.setInt(7, empleados.getBodega_ID());
            ps.setInt(8, empleados.getSucursal_ID());

            ps.setInt(9, empleados.getId_empleado());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Eliminar(int id_empleados) {
        String sentencia = "DELETE from empleados WHERE ID = '" + id_empleados + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}

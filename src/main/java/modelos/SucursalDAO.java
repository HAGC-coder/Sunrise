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
public class SucursalDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
 
    public List Listar() {
        String consulta = "SELECT * FROM sucursal";
        List<Sucursal> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setId_sucursal(rs.getInt(1));
                sucursal.setDomicilio_sucursal(rs.getString(2));
                sucursal.setTelefono_sucursal(rs.getString(3));
                sucursal.setCorreo_sucursal(rs.getString(4));
                sucursal.setNum_empleados(rs.getInt(5));
                lista.add(sucursal);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Sucursal sucursal) {

        String sentencia = "INSERT INTO sucursal (ID, Domicilio, Telefono, Correo, NumeroEmpleados) VALUES (?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, sucursal.getId_sucursal());
            ps.setString(2, sucursal.getDomicilio_sucursal());
            ps.setString(3, sucursal.getTelefono_sucursal());
            ps.setString(4, sucursal.getCorreo_sucursal());
            ps.setInt(5, sucursal.getNum_empleados());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Sucursal ListarPorId(int id) {
        Sucursal sucursal = new Sucursal();
        String consulta = "SELECT * FROM sucursal WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                sucursal.setId_sucursal(rs.getInt(1));
                sucursal.setDomicilio_sucursal(rs.getString(2));
                sucursal.setTelefono_sucursal(rs.getString(3));
                sucursal.setCorreo_sucursal(rs.getString(4));
                sucursal.setNum_empleados(rs.getInt(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucursal;
    }

    public int Actualizar(Sucursal sucursal) { 

        String sentencia = "UPDATE sucursal set Domicilio = ?, Telefono = ?, Correo = ? , NumeroEmpleados = ? WHERE ID = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, sucursal.getDomicilio_sucursal());
            ps.setString(2, sucursal.getTelefono_sucursal());
            ps.setString(3, sucursal.getCorreo_sucursal());
            ps.setInt(4, sucursal.getNum_empleados());
            ps.setInt(5, sucursal.getId_sucursal());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Eliminar(int id_sucursal) {
        String sentencia = "DELETE from sucursal WHERE ID = '" + id_sucursal + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
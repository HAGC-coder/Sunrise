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
public class ClientesDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
 

    public Clientes Validar(String correo, String contra) {
        Clientes clientes = new Clientes();
        String consulta = "SELECT * FROM clientes WHERE Correo = ? AND Contrasenia = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            ps.setString(2, contra); 
            rs = ps.executeQuery();
            rs.next();
            do {
                clientes.setId_cliente(rs.getInt(1));
                clientes.setNombres_cliente(rs.getString(2));
                clientes.setApellidos_cliente(rs.getString(3));
                clientes.setDireccion_cliente(rs.getString(4));
                clientes.setTelefono(rs.getString(5));
                clientes.setCorreo_cliente(rs.getString(6));
                clientes.setContrasenia(rs.getString(7));

            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
    
    public Clientes ValidarEmail(String correo) {
        Clientes clientes = new Clientes();
        String consulta = "SELECT * FROM clientes WHERE Correo = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            rs.next();
            do {
                clientes.setId_cliente(rs.getInt(1));
                clientes.setNombres_cliente(rs.getString(2));
                clientes.setApellidos_cliente(rs.getString(3));
                clientes.setDireccion_cliente(rs.getString(4));
                clientes.setTelefono(rs.getString(5));
                clientes.setCorreo_cliente(rs.getString(6));
                clientes.setContrasenia(rs.getString(7));

            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clientes;
    }
    
    public int ActualizarPassword(String nuevaContrasenia, String correo) {
        String sentencia = "UPDATE clientes set Contrasenia = ? WHERE Correo = ?";
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
    
    public Clientes BuscarCliente(int id) {
        Clientes clientes = new Clientes();
        String consulta = "SELECT * FROM clientes WHERE ID = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes.setId_cliente(rs.getInt(1));
                clientes.setNombres_cliente(rs.getString(2));
                clientes.setApellidos_cliente(rs.getString(3));
                clientes.setDireccion_cliente(rs.getString(4));
                clientes.setTelefono(rs.getString(5));
                clientes.setCorreo_cliente(rs.getString(6));
                clientes.setContrasenia(rs.getString(7));
                System.err.println("" + clientes.getNombres_cliente());
            }
        } catch (SQLException e) {
        }
        return clientes;
    }
    
    public List Listar() {
        String consulta = "SELECT * FROM clientes";
        List<Clientes> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Clientes clientes = new Clientes();
                clientes.setId_cliente(rs.getInt(1));
                clientes.setNombres_cliente(rs.getString(2));
                clientes.setApellidos_cliente(rs.getString(3));
                clientes.setDireccion_cliente(rs.getString(4));
                clientes.setTelefono(rs.getString(5));
                clientes.setCorreo_cliente(rs.getString(6));
                clientes.setContrasenia(rs.getString(7));
                lista.add(clientes);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Clientes ValidarCorreo(String correo) {
        Clientes clientes = new Clientes();
        String consulta = "SELECT * FROM clientes WHERE Correo = ?";
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            rs.next();
            do {
                clientes.setNombres_cliente(rs.getString(1));
                clientes.setApellidos_cliente(rs.getString(2));
                clientes.setDireccion_cliente(rs.getString(3));
                clientes.setTelefono(rs.getString(4));
                clientes.setCorreo_cliente(rs.getString(5));
                clientes.setContrasenia(rs.getString(6));

            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public int Agregar(Clientes clientes) {

        String sentencia = "INSERT INTO clientes (Nombres, Apellidos, Direccion, Telefono, Correo, Contrasenia) VALUES (?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps = con.prepareStatement(sentencia);
            ps.setString(1, clientes.getNombres_cliente());
            ps.setString(2, clientes.getApellidos_cliente());
            ps.setString(3, clientes.getDireccion_cliente());
            ps.setString(4, clientes.getTelefono());
            ps.setString(5, clientes.getCorreo_cliente());
            ps.setString(6, clientes.getContrasenia());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Clientes ListarPorId(int id) {
        Clientes clientes = new Clientes();
        String consulta = "SELECT * FROM clientes WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                clientes.setId_cliente(rs.getInt(1));
                clientes.setNombres_cliente(rs.getString(2));
                clientes.setApellidos_cliente(rs.getString(3));
                clientes.setDireccion_cliente(rs.getString(4));
                clientes.setTelefono(rs.getString(5));
                clientes.setCorreo_cliente(rs.getString(6));
                clientes.setContrasenia(rs.getString(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public int Actualizar(Clientes clientes) {
        String sentencia = "UPDATE clientes set Nombres = ?, Apellidos = ?, Direccion = ?, Telefono = ?, Correo = ?, Contrasenia = ? WHERE ID = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, clientes.getNombres_cliente());
            ps.setString(2, clientes.getApellidos_cliente());
            ps.setString(3, clientes.getDireccion_cliente());
            ps.setString(4, clientes.getTelefono());
            ps.setString(5, clientes.getCorreo_cliente());
            ps.setString(6, clientes.getContrasenia());

            ps.setInt(7, clientes.getId_cliente());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Eliminar(int id_clientes) {
        String sentencia = "DELETE from clientes WHERE ID = '" + id_clientes + "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

}

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
public class BodegaDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
 
    public List Listar() {
        String consulta = "SELECT * FROM bodega";
        List<Bodega> lista = new ArrayList();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                Bodega bodega = new Bodega();
                bodega.setId_bodega(rs.getInt(1));
                bodega.setDireccion_bodega(rs.getString(2));
                bodega.setTel_bodega(rs.getString(3));
                lista.add(bodega);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int Agregar(Bodega bodega) {

        String sentencia = "INSERT INTO bodega (ID, Direccion, Telefono) VALUES (?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setInt(1, bodega.getId_bodega());
            ps.setString(2, bodega.getDireccion_bodega());
            ps.setString(3, bodega.getTel_bodega());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public Bodega ListarPorId(int id) {
        Bodega bodega = new Bodega();
        String consulta = "SELECT * FROM bodega WHERE id=" + id;
        con = cn.Conexion();
        try {
            ps = con.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                bodega.setId_bodega(rs.getInt(1));
                bodega.setDireccion_bodega(rs.getString(2));
                bodega.setTel_bodega(rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bodega;
    }

    public int Actualizar(Bodega bodega) { 

        String sentencia = "UPDATE bodega set Direccion = ?, Telefono = ? WHERE ID = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, bodega.getDireccion_bodega());
            ps.setString(2, bodega.getTel_bodega());
            
            ps.setInt(3, bodega.getId_bodega());
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public int Eliminar(int id_bodega) {
        String sentencia = "DELETE from bodega WHERE ID = '" + id_bodega+ "'";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
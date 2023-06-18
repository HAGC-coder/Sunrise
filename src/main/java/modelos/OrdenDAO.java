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
public class OrdenDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    int r;
    
    /*public int obtenerNumOrden(){
        int i = 1;
        
        try{
            String sentencia = "SELECT * FROM Orden";
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            rs = ps.executeQuery();
            while(rs.next()){
                i++;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }s
        
        return i;
    }*/
    
    public boolean guardarPedido(List<Orden> lista){
       boolean f = false; 
        try {
            String sentencia = "INSERT INTO orden (ID, Id_orden, NombreUsuario, ApellidosUsuario, TelefonoUsuario, Direccion, NombreProducto, CatProd, Precio, TipoPago) VALUES (?,?,?,?,?,?,?,?,?,?)";
            con = cn.Conexion();
            con.setAutoCommit(false);
            ps = con.prepareStatement(sentencia);
             
            for(Orden or:lista){
                ps.setInt(1, 0);
                ps.setString(2, or.getId_orden());
                ps.setString(3, or.getNombreUsuario());
                ps.setString(4, or.getApellidosUsuario());
                ps.setString(5, or.getTelefonoUsuario());
                ps.setString(6, or.getDireccion());
                ps.setString(7, or.getNombreProducto());
                ps.setString(8, or.getCatProducto());
                ps.setFloat(9, or.getPrecio());
                ps.setString(10, or.getTipoPago());
                ps.addBatch();
            }
            int[] cont = ps.executeBatch();
            con.commit();
            f = true;
            con.setAutoCommit(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return f;
    }
    public List<Orden> ListarPedido(String telefono){
        List<Orden> lista = new ArrayList<Orden>();
        Orden orden = null;
        try {
            String sentencia = "SELECT * FROM orden where TelefonoUsuario = ?";
            con = cn.Conexion();
            ps = con.prepareStatement(sentencia);
            ps.setString(1, telefono);
            rs = ps.executeQuery();
            while(rs.next()){
                orden = new Orden();
                orden.setID(rs.getInt(1));
                orden.setId_orden(rs.getString(2));
                orden.setNombreUsuario(rs.getString(3));
                orden.setApellidosUsuario(rs.getString(4));
                orden.setTelefonoUsuario(rs.getString(5));
                orden.setDireccion(rs.getString(6));
                orden.setNombreProducto(rs.getString(7));
                orden.setCatProducto(rs.getString(8));
                orden.setPrecio(rs.getFloat(9));
                orden.setTipoPago(rs.getString(10));
                lista.add(orden);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }
    
}

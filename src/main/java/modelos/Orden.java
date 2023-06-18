/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class Orden { 
    private int ID;
    private String Id_orden;
    private String NombreUsuario;
    private String ApellidosUsuario;
    private String TelefonoUsuario;
    private String Direccion;
    private String NombreProducto;
    private String CatProducto; 
    private float Precio;
    private String TipoPago;

    public Orden() {
    }

    public Orden(int ID, String Id_orden, String NombreUsuario, String ApellidosUsuario, String TelefonoUsuario, String Direccion, String NombreProducto, String CatProducto, float Precio, String TipoPago) {
        this.ID = ID;
        this.Id_orden = Id_orden;
        this.NombreUsuario = NombreUsuario;
        this.ApellidosUsuario = ApellidosUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
        this.Direccion = Direccion;
        this.NombreProducto = NombreProducto;
        this.CatProducto = CatProducto;
        this.Precio = Precio;
        this.TipoPago = TipoPago;
    }

     
 
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getId_orden() {
        return Id_orden;
    }

    public void setId_orden(String Id_orden) {
        this.Id_orden = Id_orden;
    }
      
    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getApellidosUsuario() {
        return ApellidosUsuario;
    }

    public void setApellidosUsuario(String ApellidosUsuario) {
        this.ApellidosUsuario = ApellidosUsuario;
    }

    public String getTelefonoUsuario() {
        return TelefonoUsuario;
    }

    public void setTelefonoUsuario(String TelefonoUsuario) {
        this.TelefonoUsuario = TelefonoUsuario;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public String getCatProducto() {
        return CatProducto;
    }

    public void setCatProducto(String CatProducto) {
        this.CatProducto = CatProducto;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public String getTipoPago() {
        return TipoPago;
    }

    public void setTipoPago(String TipoPago) {
        this.TipoPago = TipoPago;
    }
     
    
}

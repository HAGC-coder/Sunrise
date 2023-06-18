/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class Proveedor {
    private int id_proveedor;
    private String nombre_proveedor, productos_proveedor, correo_proveedor, pais_origen, tel_proveedor;

    public Proveedor() {
    }

    public Proveedor(int id_proveedor, String tel_proveedor, String nombre_proveedor, String productos_proveedor, String correo_proveedor, String pais_origen) {
        this.id_proveedor = id_proveedor;
        this.tel_proveedor = tel_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.productos_proveedor = productos_proveedor;
        this.correo_proveedor = correo_proveedor;
        this.pais_origen = pais_origen;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getTel_proveedor() {
        return tel_proveedor;
    }

    public void setTel_proveedor(String tel_proveedor) {
        this.tel_proveedor = tel_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getProductos_proveedor() {
        return productos_proveedor;
    }

    public void setProductos_proveedor(String productos_proveedor) {
        this.productos_proveedor = productos_proveedor;
    }

    public String getCorreo_proveedor() {
        return correo_proveedor;
    }

    public void setCorreo_proveedor(String correo_proveedor) {
        this.correo_proveedor = correo_proveedor;
    }

    public String getPais_origen() {
        return pais_origen;
    }

    public void setPais_origen(String pais_origen) {
        this.pais_origen = pais_origen;
    }


}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.io.InputStream;

/**
 *
 * @author hagc
 */
public class Productos {
    private int id_productos;
    private String archivoimg;
    private String nombre_producto;
    private int proveedor;
    private float presupuesto;
    private String tipo_producto;
    private String tipo_producto2;
    private String desc;
    private int cantidad;
    private int sucursal_id;
    
    public Productos() {
    }

    public Productos(int id_productos, String archivoimg, String nombre_producto, int proveedor, float presupuesto, String tipo_producto, String tipo_producto2, int cantidad, String desc, int sucursal_id) {
        this.id_productos = id_productos;
        this.archivoimg = archivoimg;
        this.nombre_producto = nombre_producto;
        this.proveedor = proveedor;
        this.presupuesto = presupuesto;
        this.tipo_producto = tipo_producto;
        this.tipo_producto2 = tipo_producto2;
        this.cantidad = cantidad;
        this.desc = desc; 
        this.sucursal_id = sucursal_id;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(String archivoimg) {
        this.archivoimg = archivoimg;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getTipo_producto2() {
        return tipo_producto2;
    }

    public void setTipo_producto2(String tipo_producto2) {
        this.tipo_producto2 = tipo_producto2;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSucursal_id() {
        return sucursal_id;
    }

    public void setSucursal_id(int sucursal_id) {
        this.sucursal_id = sucursal_id;
    }

    

     

}

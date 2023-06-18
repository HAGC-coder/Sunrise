/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class detallePedido {
    private int pedidos_id, productos_id;
    private String numFactura;
    private int cantidad_producto;
    private float precio_unidad;

    public detallePedido() {
    }

    public detallePedido(int pedidos_id, int productos_id, String numFactura, int cantidad_producto, float precio_unidad) {
        this.pedidos_id = pedidos_id;
        this.productos_id = productos_id;
        this.numFactura = numFactura;
        this.cantidad_producto = cantidad_producto;
        this.precio_unidad = precio_unidad;
    }

    public int getPedidos_id() {
        return pedidos_id;
    }

    public void setPedidos_id(int pedidos_id) {
        this.pedidos_id = pedidos_id;
    }

    public int getProductos_id() {
        return productos_id;
    }

    public void setProductos_id(int productos_id) {
        this.productos_id = productos_id;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public float getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(float precio_unidad) {
        this.precio_unidad = precio_unidad;
    }
    
    
}

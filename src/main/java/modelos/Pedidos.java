/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;
//https://es.stackoverflow.com/questions/85822/como-guardar-fecha-en-java

import java.sql.Date;
 
/**
 *
 * 
 *  
 * @author hagc
 */
public class Pedidos {
    private int id_pedidos, id_productos, corresponde, cantidadProd, item;
    private Date fecha_pedido;
    private String nomProd, numFactura;
    private float precioUnidad, subtotal, total;
    
    public Pedidos() {
    }

    public Pedidos(int id_pedidos, int id_productos, int corresponde, String numFactura, int cantidadProd, int item, Date fecha_pedido, String nomProd, float precioUnidad, float subtotal, float total) {
        this.id_pedidos = id_pedidos;
        this.id_productos = id_productos;
        this.corresponde = corresponde;
        this.numFactura = numFactura;
        this.cantidadProd = cantidadProd;
        this.item = item;
        this.fecha_pedido = fecha_pedido;
        this.nomProd = nomProd;
        this.precioUnidad = precioUnidad;
        this.subtotal = subtotal;
        this.total = total;
    }

    public int getId_pedidos() {
        return id_pedidos;
    }

    public void setId_pedidos(int id_pedidos) {
        this.id_pedidos = id_pedidos;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public int getCorresponde() {
        return corresponde;
    }

    public void setCorresponde(int corresponde) {
        this.corresponde = corresponde;
    }

    public String getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }

    public int getCantidadProd() {
        return cantidadProd;
    }

    public void setCantidadProd(int cantidadProd) {
        this.cantidadProd = cantidadProd;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Date getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getNomProd() {
        return nomProd;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    } 
    
    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
 
    
}

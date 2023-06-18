/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class Carrito {

    private int ID;
    private int ID_prod;
    private int ID_cliente;
    private String NombreProducto;
    private String CatProducto;
    private String CatProducto2;
    private float Precio;
    private float Total;

    public Carrito() {
    }

    public Carrito(int ID, int ID_Prod, int ID_Cliente, String NombreProducto, String CatProducto, String CatProducto2, float Precio, float Total) {
        this.ID = ID;
        this.ID_prod = ID_Prod;
        this.ID_cliente = ID_Cliente;
        this.NombreProducto = NombreProducto;
        this.CatProducto = CatProducto;
        this.CatProducto2 = CatProducto2;
        this.Precio = Precio;
        this.Total = Total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_prod() {
        return ID_prod;
    }

    public void setID_prod(int ID_prod) {
        this.ID_prod = ID_prod;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
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

    public String getCatProducto2() {
        return CatProducto2;
    }

    public void setCatProducto2(String CatProducto2) {
        this.CatProducto2 = CatProducto2;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    
}

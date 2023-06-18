/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class Bodega {
    private int id_bodega; 
    private String direccion_bodega, tel_bodega;

    public Bodega() {
    }

    public Bodega(int id_bodega, String tel_bodega, String direccion_bodega) {
        this.id_bodega = id_bodega;
        this.tel_bodega = tel_bodega;
        this.direccion_bodega = direccion_bodega;
    }

    public int getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }

    public String getTel_bodega() {
        return tel_bodega;
    }

    public void setTel_bodega(String tel_bodega) {
        this.tel_bodega = tel_bodega;
    }

    public String getDireccion_bodega() {
        return direccion_bodega;
    }

    public void setDireccion_bodega(String direccion_bodega) {
        this.direccion_bodega = direccion_bodega;
    }
    
}

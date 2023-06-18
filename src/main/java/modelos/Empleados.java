/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class Empleados {
    private int id_empleado;
    private String nombre_empleado;
    private String apellidos_empleado;
    private String tel_empleado;
    private int Nivel;
    private String correo_empleado;
    private String contra_empleado;
    private int Bodega_ID;
    private int Sucursal_ID;
    
    public Empleados() {
    }

    public Empleados(int id_empleado, String nombre_empleado, String apellidos_empleado, String tel_empleado, int Nivel, String correo_empleado, String contra_empleado, int Bodega_ID, int Sucursal_ID) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellidos_empleado = apellidos_empleado;
        this.tel_empleado = tel_empleado;
        this.Nivel = Nivel;
        this.correo_empleado = correo_empleado;
        this.contra_empleado = contra_empleado;
        this.Bodega_ID = Bodega_ID;
        this.Sucursal_ID = Sucursal_ID;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellidos_empleado() {
        return apellidos_empleado;
    }

    public void setApellidos_empleado(String apellidos_empleado) {
        this.apellidos_empleado = apellidos_empleado;
    }

    public String getTel_empleado() {
        return tel_empleado;
    }

    public void setTel_empleado(String tel_empleado) {
        this.tel_empleado = tel_empleado;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public String getCorreo_empleado() {
        return correo_empleado;
    }

    public void setCorreo_empleado(String correo_empleado) {
        this.correo_empleado = correo_empleado;
    }

    public String getContra_empleado() {
        return contra_empleado;
    }

    public void setContra_empleado(String contra_empleado) {
        this.contra_empleado = contra_empleado;
    }

    public int getBodega_ID() {
        return Bodega_ID;
    }

    public void setBodega_ID(int Bodega_ID) {
        this.Bodega_ID = Bodega_ID;
    }

    public int getSucursal_ID() {
        return Sucursal_ID;
    }

    public void setSucursal_ID(int Sucursal_ID) {
        this.Sucursal_ID = Sucursal_ID;
    }
 
    
    
}

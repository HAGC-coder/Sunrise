/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author hagc
 */
public class Sucursal {
    private int id_sucursal;
    private int num_empleados;
    private String telefono_sucursal, correo_sucursal, domicilio_sucursal;

    public Sucursal() {
    }

    public Sucursal(int id_sucursal, String telefono_sucursal, int num_empleados, String correo_sucursal, String domicilio_sucursal) {
        this.id_sucursal = id_sucursal;
        this.telefono_sucursal = telefono_sucursal;
        this.num_empleados = num_empleados;
        this.correo_sucursal = correo_sucursal;
        this.domicilio_sucursal = domicilio_sucursal;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getTelefono_sucursal() {
        return telefono_sucursal;
    }

    public void setTelefono_sucursal(String telefono_sucursal) {
        this.telefono_sucursal = telefono_sucursal;
    }

    public int getNum_empleados() {
        return num_empleados;
    }

    public void setNum_empleados(int num_empleados) {
        this.num_empleados = num_empleados;
    }

    public String getCorreo_sucursal() {
        return correo_sucursal;
    }

    public void setCorreo_sucursal(String correo_sucursal) {
        this.correo_sucursal = correo_sucursal;
    }

    public String getDomicilio_sucursal() {
        return domicilio_sucursal;
    }

    public void setDomicilio_sucursal(String domicilio_sucursal) {
        this.domicilio_sucursal = domicilio_sucursal;
    }
    
    
}

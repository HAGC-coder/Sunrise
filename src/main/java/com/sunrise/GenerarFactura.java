/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sunrise;

/**
 *
 * @author hagc
 */
public class GenerarFactura {

    private int dato;
    private String numero;
 
    public String generarFactura(int dato) {
        this.dato = dato + 1;
        numero = String.format("%08d", this.dato);
        return numero;
    }
}

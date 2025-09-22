/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cliente;

/**
 *
 * @author bere1
 */
public class VehiculoFactory {
    public Vehiculo crearVehiculo(String tipo){
        if(tipo == null){
            return null;
        }
        if(tipo.equalsIgnoreCase("COCHE")){
            return new Coche();
        }else if(tipo.equalsIgnoreCase("MOTO")){
            return new Moto();
        }else if(tipo.equalsIgnoreCase("CAMION")){
            return new Camion();
        }
        return null;
    }  
}

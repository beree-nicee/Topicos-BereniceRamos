/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cliente;

/**
 *
 * @author bere1
 */
public class Cliente {

    public static void main(String[] args) {
        VehiculoFactory factory = new VehiculoFactory();
        
        //Crear un coche 
        Vehiculo coche = factory.crearVehiculo("COCHE");
        coche.conducir();
        
        //Crear una moto
        Vehiculo moto = factory.crearVehiculo("MOTO");
        moto.conducir();
        
        //Crear un camión
        Vehiculo camion = factory.crearVehiculo("CAMION");
        camion.conducir(); 
    }
}

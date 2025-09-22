/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfact;

/**
 *
 * @author bere1
 */
public class FiguraFactory {
    public static Figura getFigura(String tipo){
        if(tipo.equalsIgnoreCase("CIRCULO")){
            return new Circulo();
        }else if(tipo.equalsIgnoreCase("CUADRADO")){
            return new Cuadrado();
        }
        return null;
    }
    
}

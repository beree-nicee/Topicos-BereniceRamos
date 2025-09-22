/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.interfact;

/**
 *
 * @author bere1
 */
public class InterFact {

    public static void main(String[] args) {
        Figura figura1 = FiguraFactory.getFigura("CIRCULO"); 
        figura1.dibujar(); 
        
        Figura figura2 = FiguraFactory.getFigura ("CUADRADO"); 
        figura2.dibujar(); 
    }
}






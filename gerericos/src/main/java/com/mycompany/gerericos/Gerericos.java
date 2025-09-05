/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.gerericos;

/**
 *
 * @author bere1
 */


public class Gerericos {
    /**
    public static void main(String[] args) {
        Caja<String> cajaTexto = new Caja<>("Hola Mundo");
        System.out.println(cajaTexto.getContenido());
        
        Caja<Integer> cajaNumero = new Caja<>(42);
        System.out.println(cajaNumero.getContenido());
    }
    * */
    
    /**
    public static void main(String[] args) {
        Utilidad.imprimir("Texto Generico");
        Utilidad.imprimir(123);
        Utilidad.imprimir(3.14);
    }
    * */
    
    
    public static void main(String[] args) {
        /**
        Suma suma = new Suma();
        System.out.println(suma.ejecutar(10,5));
        * */
        
        
        Calculadora<Integer> calc1 = new Calculadora<>(10);
        System.out.println(calc1.getDoble());
        
    }
    
    
    
    
}







/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerericos;

/**
 *
 * @author bere1
 */
//metodos genericos
//permiten definir parámetros de tipo sin hacer la clase generica
class Utilidad {
    public static <T> void imprimir(T elemento){
        System.out.println(elemento);
    } 
}

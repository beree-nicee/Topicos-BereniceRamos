/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerericos;

/**
 *
 * @author bere1
 */
//Las interfaces genéricas funcionan igual que las clases
interface Operacion<T> {
    T ejecutar(T a, T b); 
}

//Con enteros

class Suma implements Operacion<Integer>{
    @Override
    public Integer ejecutar(Integer a, Integer b){
        return a + b;
    }
}
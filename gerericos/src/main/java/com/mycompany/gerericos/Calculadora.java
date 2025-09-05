/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerericos;

/**
 *
 * @author bere1
 */
class Calculadora<T extends Number> {
    private T numero;
    
    public Calculadora(T numero){
        this.numero = numero;
    }
    
    public double getDoble(){
        return numero.doubleValue() *2;
    }
    
}

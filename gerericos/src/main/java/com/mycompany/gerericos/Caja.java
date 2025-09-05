/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerericos;

/**
 *
 * @author bere1
 */
//Generics en Clases
//clase genérica usando <> para definir un tipo genérico T:
class Caja<T> {
    private T contenido;
    
    public Caja(T contenido){
        this.contenido = contenido;
    }
    
    public T getContenido(){
        return contenido;
    }
    
    public void setContenido(T contenido){
        this.contenido = contenido;
    }
    
}

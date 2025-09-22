/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.documentos;

/**
 *
 * @author bere1
 */
public class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abriendo PDF...");
    }

    @Override
    public void save() {
        System.out.println("Guardando PDF...");
    }
}
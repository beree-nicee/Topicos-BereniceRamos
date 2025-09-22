/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.documentos;

/**
 *
 * @author bere1
 */
public class DocxDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abriendo DOCX...");
    }

    @Override
    public void save() {
        System.out.println("Guardando DOCX...");
    }
}
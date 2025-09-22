/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.documentos;

/**
 *
 * @author bere1
 */

public class Documentos {
    public static void main(String[] args) {
        Document doc1 = DocumentFactory.createDocument("pdf");
        doc1.open();
        doc1.save();

        Document doc2 = DocumentFactory.createDocument("docx");
        doc2.open();
        doc2.save();
    }
}
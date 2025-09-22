/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.documentos;

/**
 *
 * @author bere1
 */
public class DocumentFactory {
    public static Document createDocument(String extension) {
        if (extension.equalsIgnoreCase("pdf")) {
            return new PDFDocument();
        } else if (extension.equalsIgnoreCase("docx")) {
            return new DocxDocument();
        }
        throw new UnsupportedOperationException("Formato no soportado");
    }
}
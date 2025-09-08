package org.example;


import Controllers.InventarioController;
import Models.Electronico;
import Models.Inventario;
import Models.Libro;
import Views.InventarioView;

public class Main {
    public static void main(String[] args) {
        // Vista y controlador
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(vista);

        // Agregar a Inventario de Libros, los guarda
        Inventario<Libro> inventarioLibros = new Inventario<>();
        inventarioLibros.agregarItem(new Libro("El Principito", "Antoine de Saint-Exupéry"));
        inventarioLibros.agregarItem(new Libro("Cien Años de Soledad", "Gabriel García Márquez"));

        //Agregar a Inventario de Electrónicos
        Inventario<Electronico> inventarioElectronicos = new Inventario<>();
        inventarioElectronicos.agregarItem(new Electronico("Laptop", "Dell"));
        inventarioElectronicos.agregarItem(new Electronico("Smartphone", "Samsung"));

        // Mostrar resultados
        controlador.mostrarInventario("Inventario de Libros", inventarioLibros);
        controlador.mostrarInventario("Inventario de Electrónicos", inventarioElectronicos);
    }
}

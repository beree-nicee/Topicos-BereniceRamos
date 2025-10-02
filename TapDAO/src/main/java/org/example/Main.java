package org.example;


import DAO.LibroDAO;
import Models.Libro;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Main de la aplicación Biblioteca
 */
public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAO();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ BIBLIOTECA ---");
            System.out.println("1 - Insertar");
            System.out.println("2 - Consultar todos los libros");
            System.out.println("3 - Actualizar disponibilidad");
            System.out.println("4 - Eliminar libro por ID");
            System.out.println("0 - Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            try {
                switch (opcion) {
                    case 1 -> {
                        //usando
                        /*
                        Libro libro = new Libro.LibroBuilder()
                                .setTitulo("Cien años de soledad")
                                .setAutor("Gabriel García Márquez")
                                .setAnio(1967)
                                .build();
                        //Insertar el libro en la base de datos mediante el DAO
                        libroDAO.insertar(libro);
                        // Confirma la inserción mostrando el libro
                        System.out.println("Libro insertado: " + libro);

                         */


                        System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Año: ");
                    double precio = sc.nextDouble();
                    sc.nextLine(); // limpiar buffer

                    // Crear libro con el Builder
                    Libro libro = new Libro.LibroBuilder()
                            .setTitulo(titulo)
                            .setAutor(autor)
                            .setDisponible(true) // por defecto disponible
                            .build();
                    libroDAO.insertar(libro);
                    System.out.println("Libro insertado: " + libro);




                    }
                    case 2 -> {
                        System.out.println("--- LISTA DE LIBROS ---");
                        // Obtiene todos los libros y los imprime usando forEach
                        // forEach(System.out::println) es equivalente a forEach(libro -> System.out.println(libro))
                        libroDAO.consultarTodos().forEach(System.out::println);
                    }
                    case 3 -> {
                        System.out.print("ID del libro a cambiar disponibilidad: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        // Busca el libro en la lista usando Streams API
                        // stream() - convierte la lista en un Stream para procesamiento funcional
                        // filter() - filtra los libros que coincidan con el ID
                        // findFirst() - obtiene el primer resultado (Optional)
                        Libro libro = libroDAO.consultarTodos().stream()
                                .filter(l -> l.getId() == id).findFirst().orElse(null);
                        if (libro != null) {
                            // Cambiar disponibilidad directamente
                            libro.setDisponible(!libro.isDisponible());
                            libroDAO.actualizar(libro);
                            System.out.println("Libro actualizado: " + libro);
                        } else {
                            System.out.println("Libro no encontrado");
                        }
                    }
                    case 4 -> {
                        System.out.print("ID del libro a eliminar: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        libroDAO.eliminar(id);
                        System.out.println("Libro eliminado");
                    }
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } while (opcion != 0);

        sc.close();
    }
}

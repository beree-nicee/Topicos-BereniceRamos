package org.example;

import Controllers.RestaurantController;
import Views.RestaurantView;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear vista
            RestaurantView view = new RestaurantView();

            // Crear controlador
            RestaurantController controller = new RestaurantController(view);

            // Ejecutar demostración
            controller.runCompleteDemo();

        } catch (Exception e) {
            System.err.println(" Error crítico en el sistema: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n Sistema finalizado correctamente.");
        }
    }
}
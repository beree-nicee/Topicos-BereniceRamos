package Views;

import Models.RestaurantMenu;
import java.util.List;

/**
 * Vista del sistema - Maneja la presentación
 */
public class RestaurantView {

    public void displayMenu(RestaurantMenu menu) {
        if (menu != null) {
            System.out.println(menu.toString());
        } else {
            System.out.println("Error: No se puede mostrar un menú vacío");
        }
    }

    public void displayMessage(String message) {
        if (message != null && !message.trim().isEmpty()) {
            System.out.println("\n" + message);
        }
    }

    public void displayTitle(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    " + title);
        System.out.println("=".repeat(60) + "\n");
    }

    public void displaySeparator() {
        System.out.println("\n" + "-".repeat(60) + "\n");
    }

    public void displayMenuComparison(List<RestaurantMenu> menus) {
        displayTitle("COMPARACIÓN DE MENÚS");

        for (int i = 0; i < menus.size(); i++) {
            System.out.println("OPCIÓN " + (i + 1) + ":");
            displayMenu(menus.get(i));
            if (i < menus.size() - 1) {
                displaySeparator();
            }
        }
    }

    public void displayWelcome() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              ¡Bienvenido a Matt's Restaurant!            ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    public void displayGoodbye() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║               ¡Gracias por visitarnos!                   ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
    }
}

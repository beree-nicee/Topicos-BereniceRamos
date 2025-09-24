package Views;

import Models.Hamburger;

// Vista: responsable de mostrar información al usuario (consola en este ejemplo)
public class HamburguesaView {
    // Método para mostrar la hamburguesa construida
    public void showHamburger(Hamburger h) {
        // Imprime la representación del objeto (toString)
        System.out.println("=== Tu hamburguesa ===");
        System.out.println("Tamaño: " + h.getSize());
        System.out.println("Queso: " + (h.hasCheese() ? "Sí" : "No"));
        System.out.println("Tocino: " + (h.hasBacon() ? "Sí" : "No"));
        System.out.println("Lechuga: " + (h.hasLettuce() ? "Sí" : "No"));
        System.out.println("Tomate: " + (h.hasTomato() ? "Sí" : "No"));
        System.out.println(h.toString()); // también mostramos la salida compacta
    }

    // Método para mostrar mensajes genéricos (errores, instrucciones)
    public void showMessage(String message) {
        System.out.println(message);
    }
}
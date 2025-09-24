import Controllers.HamburguesaController;
import Views.HamburguesaView;

public class MainHamburguesa {
    public static void main(String[] args) {
        // Crea la vista
        HamburguesaView view = new HamburguesaView();

        // Crea el controlador, involucrando la vista
        HamburguesaController controller = new HamburguesaController(view);

        // Simula entradas del usuario: tamaño "large" con queso y lechuga
        controller.createHamburger("large", true, false, true, false);

        // Simula otra entrada: tamaño "medium" con tocino y tomate
        controller.createHamburger("medium", false, true, false, true);
    }
}
package Controllers;

// Controlador que coordina la creación del modelo usando el Builder y actualiza la vista
import Models.Hamburger;
import Views.HamburguesaView;

public class HamburguesaController {

    private final HamburguesaView view; // referencia a la vista

    // la vista en el controlador (construcción simple)
    public HamburguesaController(HamburguesaView view) {
        this.view = view;
    }

    // Método que recibe las opciones (simula datos de entrada) y construye la hamburguesa
    public void createHamburger(String size, boolean wantCheese, boolean wantBacon,
                                boolean wantLettuce, boolean wantTomato) {
        // Validación simple de los parámetros (se puede ampliar)
        if (size == null || size.isEmpty()) {
            view.showMessage("Error: debe especificar un tamaño");
            return;
        }

        // Inicia el builder con el parámetro obligatorio (size)
        Hamburger.Builder builder = new Hamburger.Builder(size);

        // Aplica las opciones según los booleanos
        if (wantCheese)  builder.addCheese();
        if (wantBacon)   builder.addBacon();
        if (wantLettuce) builder.addLettuce();
        if (wantTomato)  builder.addTomato();

        // Construye el modelo final
        Hamburger h = builder.build();

        // Pide a la vista que muestre la hamburguesa
        view.showHamburger(h);
    }
}
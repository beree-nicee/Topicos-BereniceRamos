package Views;

import Controllers.InventarioController;

//Esta clase usa el controller, el cual usa el factory para crear objetos

//Punto de entrada del programa para agregar items
//Crea un Controlador, agrega productos y muestra el inventario.

public class Inventario {
    public static void main(String[] args) {
        InventarioController controlador = new InventarioController();

        // Usamos el Factory para crear productos
        //Se agregan productos con el controlador, el tipo que sea
        controlador.agregarProducto("libro", "El Quijote", 199.99);
        controlador.agregarProducto("electronico", "Laptop", 15000.00);
        controlador.agregarProducto("libro", "Clean Code", 499.50);

        // Mostrar inventario con la Vista genérica
        //Inventario del controller
        controlador.mostrarInventario();
    }
}
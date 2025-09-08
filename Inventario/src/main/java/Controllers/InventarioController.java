package Controllers;

import Models.Inventario;
import Views.InventarioView;

//Conectar el modelo coon la vista
public class InventarioController {
    private InventarioView view;

    public InventarioController(InventarioView view) {
        this.view = view;
    }

    //Saber que va a mostrar, libro o electronico, es T, Lo que llama
    public <T> void mostrarInventario(String titulo, Inventario<T> inventario) {
        //devolver la lista
        view.mostrarInventario(titulo, inventario.getItems());
    }
}

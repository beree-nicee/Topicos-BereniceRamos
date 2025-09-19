package Controllers;


//El Controlador coordina
//Usa el Factory para crear productos.
//Guarda los productos en un inventario.
//Llama a la Vista para mostrarlos.
import Factory.ProductoFactory;

//Usar cuenquier producto de los modelos que se tienen
import Models.Producto;
import Views.InventarioView;

import java.util.ArrayList;
import java.util.List;

public class InventarioController {

    //Poder mostrar la lista de cualquier producto
    private List<Producto> inventario = new ArrayList<>();
    private InventarioView vista = new InventarioView();

    public void agregarProducto(String tipo, String nombre, double precio) {

        //Crear el producto del tipo que sea,

        Producto p = ProductoFactory.crearProducto(tipo, nombre, precio);
        //Agregarlo a la lista
        inventario.add(p);
    }

    public void mostrarInventario() {
        vista.mostrarLista("Inventario", inventario);
    }
}

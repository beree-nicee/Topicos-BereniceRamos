package Views;

import java.util.List;

//Permite mostrar cualquier lista
public class InventarioView {
    //Tipo local del metodo y Listas
    public <T> void mostrarInventario(String titulo, List<T> items) {
        //Encabezado
        System.out.println("\n=== " + titulo + " ===");
        //Itera sobre la lista
        for (T item : items) {
            //uso del toString para imprimir los datos
            System.out.println(item);
        }
    }
}

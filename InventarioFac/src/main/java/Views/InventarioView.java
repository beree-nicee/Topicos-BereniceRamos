package Views;

//Aqui usé Genéricos (<T>)
// esta vista puede mostrar listas de cualquier tipo, no solo productos.
//Recorre la lista e imprime los elementos con toString().
import java.util.List;

public class InventarioView {
    public <T> void mostrarLista(String titulo, List<T> items) {
        System.out.println("\n=== " + titulo + " ===");
        for (T item : items) {
            System.out.println(item);
        }

        /**
         * for (int i = 0; i < items.size(); i++) {
         *     T item = items.get(i);
         *     System.out.println(item);
         * }
         **/
    }
}
package Views;
import java.util.List;
import java.util.Scanner;

//usé el me´todo generico para agregar item a cualquiera de las listas
public class VistaGenerica {
    private Scanner scanner = new Scanner(System.in);

    //uso del metoodp generico para poder visualizar las listas dependiendo de lo que quiera mostrar
    public <T> void mostrarLista(String titulo, List<T> items) {
        System.out.println("\n=== " + titulo + " ===");
        if (items.isEmpty()) {
            System.out.println("No hay datos registrados.");
        } else {
            for (T item : items) {
                System.out.println(item);
            }
        }
    }

    //metodos que sirven para producto y cliente

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    public int leerInt(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }
}
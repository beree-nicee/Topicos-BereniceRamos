package moneda;
import java.util.Scanner;
public class Moneda {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Cajero cajero1 = new Cajero();
        System.out.println("Ingresa los euros a transformar (0 para terminar):");

        while (true) {
            int cantidad = leer.nextInt();
            if (cantidad == 0) {
                System.out.println("Programa terminado.");
                break;
            }
            if (cantidad < 0) {
                System.out.println("Error: Solo se aceptan valores positivos.");
                continue;
            }

            cajero1.setCantidad(cantidad);
            cajero1.cambio();
        }

        leer.close();
    }
    
}

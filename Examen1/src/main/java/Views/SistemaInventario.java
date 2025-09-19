package Views;

import Controllers.Controlador;

public class SistemaInventario {
    public static void main(String[] args) {
        VistaGenerica vista = new VistaGenerica();
        Controlador controlador = new Controlador(vista);

        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== SISTEMA DE INVENTARIO =====");

            System.out.println("\n----- MENÚ PRINCIPAL ------");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Agregar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Salir");
            int opcion = vista.leerInt("Seleccione una opción: ");
            vista.leerTexto(""); // consumir salto de línea

            switch (opcion) {
                case 1:
                    controlador.agregarProducto();
                    break;
                case 2:
                    controlador.listarProductos();
                    break;
                case 3:
                    controlador.agregarCliente();
                    break;
                case 4:
                    controlador.listarClientes();
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Adiós!!!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        System.out.println("Gracias por usar el sistema.");
    }
}
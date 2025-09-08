package Views;

import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;

    public CajeroView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarBienvenida() {
        System.out.println("============================");
        System.out.println("Bienvenido al Cajero Automático del Banco del Bajío");
        System.out.println("============================");
    }

    public String solicitarNumeroCuenta() {
        System.out.print("Ingresa tu número de cuenta: ");
        return scanner.nextLine().trim();
    }

    public String solicitarPin() {
        System.out.print("Ingresa tu PIN: ");
        return scanner.nextLine().trim();
    }

    public String solicitarPin(String tipo) {
        System.out.print("Ingresa tu PIN " + tipo + ": ");
        return scanner.nextLine().trim();
    }

    public void mostrarMenuPrincipal(String titular) {
        System.out.println("============================");
        System.out.println("Bienvenid@ " + titular);
        System.out.println("============================");
        System.out.println("1.- Consultar saldo");
        System.out.println("2.- Retirar");
        System.out.println("3.- Depositar");
        System.out.println("4.- Transferir");
        System.out.println("5.- Cambiar PIN");
        System.out.println("9.- Salir");
        System.out.print("Selecciona una opción: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarSaldo(double saldo) {
        System.out.println("============================");
        System.out.println("Tu saldo actual es: $" + String.format("%.2f", saldo));
        System.out.println("============================");
    }

    public double solicitarCantidad(String operacion) {
        System.out.print("Ingresa la cantidad a " + operacion + ": $");
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println("===== " + mensaje + " =====");
    }

    public String solicitarCuentaDestino(String operacion) {
        System.out.print("Ingresa el número de cuenta para " + operacion + ": ");
        return scanner.nextLine().trim();
    }

    public String solicitarNuevoPin() {
        System.out.print("Ingresa tu nuevo PIN (4 dígitos): ");
        return scanner.nextLine().trim();
    }

    public boolean confirmarOperacion(String mensaje) {
        System.out.print(mensaje + " (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí");
    }
}

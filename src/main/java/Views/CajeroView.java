package Views;

import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;
    public CajeroView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarBienvenida(){
        System.out.println("============================");
        System.out.println("Bienvenido al Cajero automático del banco del bajio");
        System.out.println("============================");
    }

    public String solicitarNumeroCuenta(){
        System.out.println("Ingresa tu número de cuenta: ");
        return scanner.nextLine();
    }

    public String solicitarPin(){
        System.out.println("Ingresa una pin: ");
        return scanner.nextLine();
    }

    public void mostrarMenuPrincipal(String titular){
        System.out.println("============================");
        System.out.println("Bienvenid@ " + titular);
        System.out.println("============================");
        System.out.println("1.- Consultar saldo");
        System.out.println("2.- Retirar ");
        System.out.println("3.- Depositar ");
        System.out.println("4.- Transferir");
        System.out.println("5.- Cambiar NIP");
        //Definir las opciones faltantes
        System.out.println("9.- Salir ");
    }
    //retornar la opción si no pone un número, es decir si ingresó una letra
    public int leerOpcion(){
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            return -1;
        }
    }

    public void mostrarSaldo(double saldo){
        System.out.println("============================");
        System.out.println("Tu saldo actual es: $ "+saldo);
        System.out.println("============================");
    }

    public double solicitarCantidad(String operacion){
        System.out.println("Ingresa la cantidad a " + operacion + ": ");
        try{
            return Double.parseDouble(scanner.nextLine());
        }catch (NumberFormatException e){
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje){
        System.out.println("===== "+mensaje);
    }

    //pedir cuenta para transferir
    public String solicitarCuentaDestino() {
        System.out.print("Ingresa el número de cuenta destino: ");
        return scanner.nextLine();
    }

    //solicitar el NIP PARA CAMBIARLO
    public String solicitarNuevoPin() {
        System.out.print("Ingresa tu nuevo PIN: ");
        return scanner.nextLine();
    }





}

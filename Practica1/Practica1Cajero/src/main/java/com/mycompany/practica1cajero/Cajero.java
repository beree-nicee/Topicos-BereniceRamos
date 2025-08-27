/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica1cajero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author bere1
 */
public class Cajero {
    Scanner scan = new Scanner(System.in);
    private List<Usuario> usuarios = new ArrayList<>();
    public Cajero() {
        //ejemplos
        usuarios.add(new Usuario("1234", "Juan", 1000.0));
        usuarios.add(new Usuario("5678", "Maria", 2500.0));
    }
    
    
    public void iniciar() {
        System.out.println("=== Bienvenido al Cajero ===");
        Usuario usuario = autenticar();

        if (usuario == null) {
            System.out.println("Demasiados intentos fallidos. Adiós.");
            return;
        }

        System.out.println("Bienvenido a tu cuenta, " + usuario.getNombre());
        mostrarMenu(usuario);
    }
    
    private Usuario autenticar() {
        int intentos = 0;

        while (intentos < 3) {
            System.out.print("Ingrese su PIN: ");
            String pin = scan.nextLine();

            
            for (int i = 0; i < usuarios.size(); i++) {
                Usuario u = usuarios.get(i); //obtenerr el usuario en la posicion i
                if (u.getPin().equals(pin)) {
                     return u;
            }
}
            System.out.println("PIN incorrecto.");
            intentos++;
        }
        return null;
    }
    
    private void mostrarMenu(Usuario usuario){
        boolean salir = false;
        while (!salir) {
            System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo es: $" + usuario.getSaldo());
                    break;

                case 2:
                    System.out.print("Ingrese cantidad a retirar: ");
                    double retiro = scan.nextDouble();
                    if (usuario.retirar(retiro)) {
                        System.out.println("Retiro exitoso. Nuevo saldo: $" + usuario.getSaldo());
                    } else {
                        System.out.println("Fondos insuficientes.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese cantidad a depositar: ");
                    double deposito = scan.nextDouble();
                    usuario.depositar(deposito);
                    System.out.println("Depósito exitoso!!. Nuevo saldo: $" + usuario.getSaldo());
                    break;

                case 4:
                    salir = true;
                    System.out.println("Gracias por usar el cajero!");
                    break;

                default:
                    System.out.println("¡¡Opción inválida!!");
                    System.out.println("Intentelo nuevamente");
            }
        }
    }
}


    
   
    
    

 

package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

//se calcula la comisión de acuerdo al monto
public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria();

        System.out.println("=== Cuenta de Ahorro ===");
        cuenta.setEstrategia(new ComisionAhorro());
        cuenta.realizarOperacion(1000);

        System.out.println("\n=== Cuenta de Nómina ===");
        cuenta.setEstrategia(new ComisionNomina());
        cuenta.realizarOperacion(1000);

        System.out.println("\n=== Cuenta Empresarial ===");
        cuenta.setEstrategia(new ComisionEmpresarial());
        cuenta.realizarOperacion(1000);
    }
}

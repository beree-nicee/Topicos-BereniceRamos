package org.example;


//Aquí se calculan las comisiones
public class CuentaBancaria {
    private ComisionStrategy estrategia;

    // Permite cambiar de estrategia en tiempo de ejecución
    public void setEstrategia(ComisionStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void realizarOperacion(double monto) {
        double comision = estrategia.calcularComision(monto);
        double total = monto - comision;
        System.out.println("Monto: " + monto);
        System.out.println("Comisión: " + comision);
        System.out.println("Total a entregar: " + total);
    }
}
package org.example;

// Comisión para cuentas de ahorro
public class ComisionAhorro implements ComisionStrategy {
    @Override
    public double calcularComision(double monto) {
        return monto * 0.02; // 2%
    }
}
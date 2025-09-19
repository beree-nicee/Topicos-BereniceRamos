package org.example;


// Comisión para cuentas de nómina
public class ComisionNomina implements ComisionStrategy {
    @Override
    public double calcularComision(double monto) {
        return monto * 0.01; // 1%
    }
}
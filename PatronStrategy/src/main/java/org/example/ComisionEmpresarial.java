package org.example;


// Comisión para cuentas empresariales
public class ComisionEmpresarial implements ComisionStrategy {
    @Override
    public double calcularComision(double monto) {
        return monto * 0.05; // 5%
    }
}
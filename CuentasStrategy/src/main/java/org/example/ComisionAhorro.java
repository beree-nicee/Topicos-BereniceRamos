package org.example;

/**
 * ESTRATEGIA CONCRETA 1: Comisión para Cuentas de Ahorro
 * Implementa el cálculo de comisión específico para cuentas de ahorro
 * con una tasa del 2%
 */
public class ComisionAhorro implements ComisionStrategy {

    /**
     * Calcula la comisión para cuentas de ahorro
     * Aplica un 2% de comisión sobre el monto de la operación
     */
    @Override
    public double calcularComision(double monto) {
        // Multiplica el monto por 0.02 para obtener el 2% de comisión
        return monto * 0.02; // 2% de comisión para cuentas de ahorro
    }
}

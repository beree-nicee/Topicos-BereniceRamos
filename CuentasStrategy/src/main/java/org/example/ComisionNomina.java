package org.example;

/**
 * ESTRATEGIA CONCRETA 2: Comisión para Cuentas de Nómina
 * Implementa el cálculo de comisión específico para cuentas de nómina
 * con una tasa preferencial del 1%
 */
public class ComisionNomina implements ComisionStrategy {

    /**
     * Calcula la comisión para cuentas de nómina
     * Aplica un 1% de comisión (tasa preferencial) sobre el monto
     */
    @Override
    public double calcularComision(double monto) {
        // Multiplica el monto por 0.01 para obtener el 1% de comisión
        return monto * 0.01; // 1% de comisión para cuentas de nómina
    }
}
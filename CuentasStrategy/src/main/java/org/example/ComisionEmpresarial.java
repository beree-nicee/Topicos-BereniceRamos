package org.example;

/**
 * ESTRATEGIA CONCRETA 3: Comisión para Cuentas Empresariales
 * Implementa el cálculo de comisión específico para cuentas empresariales
 * con una tasa mayor del 5% debido a servicios adicionales
 */
public class ComisionEmpresarial implements ComisionStrategy {

    /**
     * Calcula la comisión para cuentas empresariales
     * Aplica un 5% de comisión sobre el monto debido a servicios premium
     */
    @Override
    public double calcularComision(double monto) {
        // Multiplica el monto por 0.05 para obtener el 5% de comisión
        return monto * 0.05; // 5% de comisión para cuentas empresariales
    }
}


package org.example;

/**
 * ESTRATEGIA CONCRETA 4: Sin Comisión (Cuentas Premium)
 * Estrategia adicional para cuentas que no cobran comisión
 */
public class SinComision implements ComisionStrategy {

    /**
     * Calcula la comisión para cuentas premium sin costo
     * No aplica comisión alguna
     */
    @Override
    public double calcularComision(double monto) {
        // Retorna 0 ya que no se cobra comisión
        return 0.0; // Sin comisión para cuentas premium
    }
}
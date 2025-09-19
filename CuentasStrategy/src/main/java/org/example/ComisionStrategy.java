package org.example;


/**
 * INTERFAZ STRATEGY
 * Define el contrato común que deben implementar todas las estrategias
 * de cálculo de comisión. Esta interfaz permite intercambiar algoritmos
 * de comisión sin modificar el código cliente.
 */
public interface ComisionStrategy {
    /**
     * Método abstracto que debe implementar cada estrategia concreta
     * para calcular la comisión según el tipo de cuenta
     * @param monto - cantidad sobre la cual se calculará la comisión
     * @return - valor de la comisión calculada
     */
    double calcularComision(double monto);
}
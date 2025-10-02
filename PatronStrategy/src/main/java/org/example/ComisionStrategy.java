package org.example;

//Es el "contrato" que define que todas las estrategias de comisión deben tener un metodo para calcular comisión.
// Esto permite que diferentes tipos de cuenta calculen sus comisiones de manera distinta.

public interface ComisionStrategy {
    double calcularComision(double monto);
}
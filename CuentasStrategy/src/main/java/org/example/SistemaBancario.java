package org.example;


public class SistemaBancario {

    /**
     * Método principal que ejecuta la demostración
     * @param args - argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Crear una cuenta con saldo inicial
        Cuenta cuenta = new Cuenta("001-234-567", 5000.00);

        // Mostrar información inicial
        System.out.println("SISTEMA BANCARIO - DEMOSTRACIÓN DEL PATRÓN STRATEGY");
        System.out.printf("Cuenta creada: %s con saldo inicial: $%.2f%n%n",
                cuenta.getNumeroCuenta(), cuenta.getSaldo());

        // DEMOSTRACIÓN 1: Cuenta de Ahorro
        System.out.println("=== OPERACIÓN 1: CUENTA DE AHORRO ===");
        cuenta.setTipoCuenta("Cuenta de Ahorro");           // Establecer tipo
        cuenta.setEstrategiaComision(new ComisionAhorro()); // Configurar estrategia (2%)
        cuenta.realizarRetiro(1000);                        // Realizar operación
        System.out.println(); // Línea en blanco para separación

        // DEMOSTRACIÓN 2: Cuenta de Nómina
        System.out.println("=== OPERACIÓN 2: CUENTA DE NÓMINA ===");
        cuenta.setTipoCuenta("Cuenta de Nómina");           // Cambiar tipo
        cuenta.setEstrategiaComision(new ComisionNomina()); // Cambiar estrategia (1%)
        cuenta.realizarRetiro(1000);                        // Realizar operación
        System.out.println(); // Línea en blanco para separación

        // DEMOSTRACIÓN 3: Cuenta Empresarial
        System.out.println("=== OPERACIÓN 3: CUENTA EMPRESARIAL ===");
        cuenta.setTipoCuenta("Cuenta Empresarial");             // Cambiar tipo
        cuenta.setEstrategiaComision(new ComisionEmpresarial()); // Cambiar estrategia (5%)
        cuenta.realizarRetiro(1000);                            // Realizar operación
        System.out.println(); // Línea en blanco para separación

        // DEMOSTRACIÓN 4: Cuenta Premium (sin comisión)
        System.out.println("=== OPERACIÓN 4: CUENTA PREMIUM ===");
        cuenta.setTipoCuenta("Cuenta Premium");           // Cambiar tipo
        cuenta.setEstrategiaComision(new SinComision());  // Cambiar estrategia (0%)
        cuenta.realizarRetiro(1000);                      // Realizar operación
        System.out.println(); // Línea en blanco para separación

        // DEMOSTRACIÓN ADICIONAL: Manejo de errores
        demostrarManejoErrores(cuenta);

        // DEMOSTRACIÓN FINAL: Comparación de estrategias
        compararEstrategias();
    }

    /**
     * Método para demostrar el manejo de errores del sistema
     * @param cuenta - cuenta para realizar las pruebas
     */
    private static void demostrarManejoErrores(Cuenta cuenta) {
        System.out.println("=== DEMOSTRACIÓN DE MANEJO DE ERRORES ===");

        // Error 1: Monto mayor al saldo disponible
        System.out.println("1. Intento de retiro mayor al saldo:");
        cuenta.setEstrategiaComision(new ComisionAhorro());
        cuenta.realizarRetiro(10000); // Monto mayor al saldo
        System.out.println();

        // Error 2: Monto negativo
        System.out.println("2. Intento de retiro con monto negativo:");
        cuenta.realizarRetiro(-100); // Monto inválido
        System.out.println();

        // Error 3: Sin estrategia configurada
        System.out.println("3. Operación sin estrategia configurada:");
        cuenta.setEstrategiaComision(null); // Quitar estrategia
        cuenta.realizarRetiro(100); // Intentar operación
        System.out.println();
    }

    /**
     * Método para comparar diferentes estrategias con el mismo monto
     * Demuestra la flexibilidad del patrón Strategy
     */
    private static void compararEstrategias() {
        System.out.println("=== COMPARACIÓN DE ESTRATEGIAS ===");
        System.out.println("Comparación para un retiro de $1000:\n");

        // Array con todas las estrategias disponibles
        ComisionStrategy[] estrategias = {
                new ComisionAhorro(),      // 2%
                new ComisionNomina(),      // 1%
                new ComisionEmpresarial(), // 5%
                new SinComision()          // 0%
        };

        // Nombres descriptivos para cada estrategia
        String[] nombres = {
                "Cuenta de Ahorro (2%)",
                "Cuenta de Nómina (1%)",
                "Cuenta Empresarial (5%)",
                "Cuenta Premium (0%)"
        };

        double monto = 1000.0; // Monto fijo para comparación

        // Mostrar encabezado de la tabla
        System.out.printf("%-25s | %-10s | %-15s | %-10s%n",
                "Tipo de Cuenta", "Comisión", "Monto Entregado", "Total Desc.");
        System.out.println("-".repeat(70));

        // Calcular y mostrar resultados para cada estrategia
        for (int i = 0; i < estrategias.length; i++) {
            double comision = estrategias[i].calcularComision(monto);      // Calcular comisión
            double montoEntregado = monto;                                 // Monto entregado al cliente
            double totalDescontado = monto + comision;                     // Total descontado del saldo

            // Mostrar fila de la tabla con los resultados
            System.out.printf("%-25s | $%-9.2f | $%-14.2f | $%-9.2f%n",
                    nombres[i], comision, montoEntregado, totalDescontado);
        }

        System.out.println("-".repeat(70));
        System.out.println("* El patrón Strategy permite cambiar el algoritmo de cálculo");
        System.out.println("  sin modificar el código de la clase Cuenta.");
    }
}

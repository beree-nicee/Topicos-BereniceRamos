package org.example;

// ==================================================
// CONTEXTO
// La clase Cuenta utiliza las estrategias de comisión
// y puede cambiar de estrategia en tiempo de ejecución
// ==================================================


/**
 * CLASE CONTEXTO: Cuenta Bancaria
 * Esta clase utiliza el patrón Strategy para calcular comisiones
 * según el tipo de cuenta. Mantiene una referencia a la estrategia
 * actual y puede cambiarla dinámicamente.
 */
public class Cuenta {
    // Referencia a la estrategia de comisión actual
    private ComisionStrategy estrategiaComision;
    // Información adicional de la cuenta
    private String numeroCuenta;
    private String tipoCuenta;
    private double saldo;

    /**
     * Constructor que inicializa la cuenta con información básica
     * @param numeroCuenta - número identificador de la cuenta
     * @param saldo - saldo inicial de la cuenta
     */
    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta; // Asigna el número de cuenta
        this.saldo = saldo;               // Establece el saldo inicial
        this.tipoCuenta = "Sin definir";  // Tipo de cuenta inicial
    }

    /**
     * Método para cambiar la estrategia de comisión en tiempo de ejecución
     * Este es el corazón del patrón Strategy: permite intercambiar algoritmos
     * @param estrategia - nueva estrategia de comisión a utilizar
     */
    public void setEstrategiaComision(ComisionStrategy estrategia) {
        this.estrategiaComision = estrategia; // Asigna la nueva estrategia
    }

    /**
     * Establece el tipo de cuenta para fines informativos
     * @param tipoCuenta - descripción del tipo de cuenta
     */
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta; // Actualiza el tipo de cuenta
    }

    /**
     * Realiza una operación bancaria (retiro) aplicando la comisión correspondiente
     * Este método delega el cálculo de comisión a la estrategia actual
     * @param monto - cantidad a retirar
     */
    public void realizarRetiro(double monto) {
        // Validar que hay una estrategia configurada
        if (estrategiaComision == null) {
            System.out.println("ERROR: No se ha configurado una estrategia de comisión");
            return; // Sale del método sin procesar
        }

        // Validar que el monto sea positivo
        if (monto <= 0) {
            System.out.println("ERROR: El monto debe ser mayor a cero");
            return; // Sale del método sin procesar
        }

        // Validar que hay saldo suficiente
        if (monto > saldo) {
            System.out.printf("ERROR: Saldo insuficiente. Saldo actual: $%.2f%n", saldo);
            return; // Sale del método sin procesar
        }

        // Delegar el cálculo de comisión a la estrategia actual
        double comision = estrategiaComision.calcularComision(monto);

        // Calcular el monto total a descontar (monto + comisión)
        double totalDescuento = monto + comision;

        // Verificar que el saldo cubra monto + comisión
        if (totalDescuento > saldo) {
            System.out.printf("ERROR: Saldo insuficiente para cubrir monto + comisión. ");
            System.out.printf("Requerido: $%.2f, Disponible: $%.2f%n", totalDescuento, saldo);
            return; // Sale del método sin procesar
        }

        // Actualizar el saldo descontando monto + comisión
        saldo -= totalDescuento;

        // Mostrar detalles de la operación
        mostrarDetallesOperacion(monto, comision, monto, totalDescuento);
    }

    /**
     * Muestra los detalles completos de la operación realizada
     * @param montoSolicitado - cantidad que el usuario quiso retirar
     * @param comision - comisión calculada por la estrategia
     * @param montoEntregado - cantidad efectivamente entregada al usuario
     * @param totalDescontado - monto total descontado del saldo
     */
    private void mostrarDetallesOperacion(double montoSolicitado, double comision,
                                          double montoEntregado, double totalDescontado) {
        // Crear separador visual
        System.out.println("=".repeat(55));
        System.out.println("DETALLES DE LA OPERACIÓN");
        System.out.println("=".repeat(55));

        // Mostrar información de la cuenta
        System.out.printf("Cuenta: %s (%s)%n", numeroCuenta, tipoCuenta);

        // Mostrar detalles de la transacción
        System.out.printf("Monto solicitado: $%.2f%n", montoSolicitado);
        System.out.printf("Comisión aplicada: $%.2f%n", comision);
        System.out.printf("Monto entregado: $%.2f%n", montoEntregado);
        System.out.printf("Total descontado: $%.2f%n", totalDescontado);
        System.out.printf("Saldo restante: $%.2f%n", saldo);

        // Cerrar separador visual
        System.out.println("=".repeat(55));
    }

    /**
     * Getter para obtener el saldo actual
     * @return saldo actual de la cuenta
     */
    public double getSaldo() {
        return saldo; // Retorna el saldo actual
    }

    /**
     * Getter para obtener el número de cuenta
     * @return número de cuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta; // Retorna el número de cuenta
    }

    /**
     * Getter para obtener el tipo de cuenta
     * @return tipo de cuenta actual
     */
    public String getTipoCuenta() {
        return tipoCuenta; // Retorna el tipo de cuenta
    }
}
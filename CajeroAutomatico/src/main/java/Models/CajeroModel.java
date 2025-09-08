package Models;

import java.util.HashMap;
import java.util.Map;

public class CajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public CajeroModel() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    private void inicializarCuentas() {
        cuentas.put("12345", new Cuenta("12345", "1111", 500, "Juan Perez"));
        cuentas.put("654789", new Cuenta("654789", "1234", 8500, "Bere Ramos"));
        cuentas.put("411116", new Cuenta("411116", "4321", 10200, "Claudia Pizano"));
    }

    public boolean autenticar(String numeroCuenta, String pin) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual() {
        return this.cuentaActual;
    }

    public double consultarSaldo() {
        return this.cuentaActual != null ? cuentaActual.getSaldo() : 0;
    }

    public boolean realizarRetiro(double cantidad) {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }

    // Método mejorado para depósito que acepta número de cuenta
    public boolean realizarDeposito(String numeroCuenta, double cantidad) {
        if (cantidad <= 0) {
            return false;
        }

        Cuenta cuentaDestino = cuentas.get(numeroCuenta);
        if (cuentaDestino != null) {
            cuentaDestino.depositar(cantidad);
            return true;
        }
        return false;
    }

    // Sobrecarga para depósito a cuenta actual
    public boolean realizarDeposito(double cantidad) {
        return realizarDeposito(cuentaActual.getNumeroCuenta(), cantidad);
    }

    public boolean cuentaExiste(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta);
    }

    public boolean realizarTransferencia(String cuentaDestino, double cantidad) {
        if (cuentaActual != null && cuentas.containsKey(cuentaDestino)) {
            Cuenta destino = cuentas.get(cuentaDestino);
            return cuentaActual.transferir(destino, cantidad);
        }
        return false;
    }

    public boolean cambiarPin(String pinActual, String nuevoPin) {
        return cuentaActual != null && cuentaActual.cambiarPin(pinActual, nuevoPin);
    }

    // Método para obtener titular de una cuenta
    public String obtenerTitularCuenta(String numeroCuenta) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        return cuenta != null ? cuenta.getTitular() : null;
    }

    // Método para obtener saldo de una cuenta específica
    public double obtenerSaldoCuenta(String numeroCuenta) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        return cuenta != null ? cuenta.getSaldo() : -1;
    }
}
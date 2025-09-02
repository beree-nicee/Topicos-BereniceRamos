package models;

import java.util.HashMap;
import java.util.Map;

public class CajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public CajeroModel() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    //interaccion con la cuenta y crea un mapa

    private void inicializarCuentas() {
        cuentas.put("12345", new Cuenta("12345", "1111", 500, "Juan Perez"));

        cuentas.put("654789", new Cuenta("654789", "1234", 8500, "Bere Ramos"));

        cuentas.put("411116", new Cuenta("411116", "4321", 10200, "Claudia Pizano"));
    }

    public boolean autenticar(String numeroCuenta, String pin) {
        //Me marcaba un error con cuenta sin la s
        //Cuenta cuenta = cuenta.get(numeroCuenta);
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            this.cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual(){
        return this.cuentaActual;
    }
    
    public double consultarSaldo() {
        return this.cuentaActual != null ? cuentaActual.getSaldo():0;
        
    }
    
    public boolean realizarRetiro(double cantidad) {
        return cuentaActual != null && cuentaActual.retirar(cantidad);
    }

    public boolean realizarDeposito(double cantidad) {
        if(cuentaActual != null && cantidad>0) {
            cuentaActual.depositar(cantidad);
            return true;
        }

        return false;
    }

    public boolean cuentaExiste(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta);
    }

    // Tarea definir el metodo para transferir
    public boolean realizarTransferencia(String cuentaDestino, double cantidad) {

        if (cuentaActual != null && cuentas.containsKey(cuentaDestino)) {
            Cuenta destino = cuentas.get(cuentaDestino);
            return cuentaActual.transferir(destino, cantidad);
        }
        return false;
    }

    //Falta metodo de retirar
    public boolean retirar(Cuenta cuenta, double monto) {
        if (monto <= 0) {
            System.out.println("El monto a retirar debe ser mayor a cero.");
            return false;
        }
        if (monto > cuenta.getSaldo()) {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        cuenta.setSaldo(cuenta.getSaldo() - monto);
        System.out.println("Retiro exitoso. Nuevo saldo: " + cuenta.getSaldo());
        return true;
    }






    
    
}

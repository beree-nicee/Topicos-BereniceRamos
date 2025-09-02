package models;
//independientes del controlador y de las vistas

public class Cuenta {

    private String numeroCuenta;

    private String pin;

    private double saldo;
    private String titular;

    public Cuenta(String numeroCuenta, String pin, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldo;
        this.titular = titular;
    }

    public String getNumeroCuenta() {return numeroCuenta;}

    public String getPin() {return pin;}

    public double getSaldo() {return saldo;}

    public String getTitular() {return titular;}
    //reglas de negocio

    public boolean validarPin(String pinIngresado){
        return this.pin.equals(pinIngresado);
    }


    public boolean retirar(double cantidad){
        if(cantidad > 0 && cantidad <= this.saldo){
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public void depositar(double cantidad){
        if(cantidad >0 ){
            saldo += cantidad;
        }
    }

    //Tarea diseñar los comportamientos
    //transferir
    public boolean transferir(Cuenta destino, double cantidad) {
        if (this.retirar(cantidad)) {
            destino.depositar(cantidad);
            return true;
        }
        return false;
    }

    //cambiar PIN
    public boolean cambiarPin(String pinActual, String nuevoPin) {
        //Ya está dentro de su cuenta
        if (validarPin(pinActual) && nuevoPin != null && !nuevoPin.isEmpty()) {
            this.pin = nuevoPin;
            return true;
        }
        return false;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }






    //
}

package Controllers;

import Views.CajeroView;
import models.CajeroModel;

import models.Cuenta;

public class CajeroController {
    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;

    public CajeroController(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void iniciarSistema() {
        view.mostrarBienvenida();
        while (sistemaActivo) {
            if (autenticarUsuario()) {
                ejecutarMenuPrincipal();
            } else {
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero");
    }

    private boolean autenticarUsuario() {
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }

    private void ejecutarMenuPrincipal() {
        boolean sessionActiva = true;
        while (sessionActiva) {
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();

            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    realizarRetiro();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    realizarTransferencia();
                    break;
                case 5:
                    cambiarPin();
                    break;
                case 9:
                    sessionActiva = false;
                    view.mostrarMensaje("Sesión finalizada");
                    break;
                default:
                    view.mostrarMensaje("Opción no válida");
                    break;
            }
        }
    }

    // Método genérico para operaciones con validación de cantidad
    private <T> boolean validarCantidad(double cantidad, String operacion) {
        if (cantidad <= 0) {
            view.mostrarMensaje("Error: La cantidad debe ser mayor a 0");
            return false;
        }
        return true;
    }

    // Método genérico para confirmar operaciones
    private boolean confirmarOperacion(String mensaje) {
        return view.confirmarOperacion(mensaje);
    }

    public void consultarSaldo() {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }

    public void realizarRetiro() {
        double cantidad = view.solicitarCantidad("retirar");

        if (!validarCantidad(cantidad, "retiro")) {
            return;
        }

        if (!confirmarOperacion("¿Confirmar retiro de $" + cantidad + "?")) {
            view.mostrarMensaje("Operación cancelada");
            return;
        }

        if (model.realizarRetiro(cantidad)) {
            view.mostrarMensaje("Retiro exitoso de: $" + cantidad);
            view.mostrarSaldo(model.consultarSaldo());
        } else {
            view.mostrarMensaje("Error: Fondos insuficientes");
        }
    }

    public void realizarDeposito() {
        // Solicitar número de cuenta para depósito
        String numeroCuentaDestino = view.solicitarCuentaDestino("depósito");

        // Verificar que la cuenta existe
        if (!model.cuentaExiste(numeroCuentaDestino)) {
            view.mostrarMensaje("Error: La cuenta no existe");
            return;
        }

        double cantidad = view.solicitarCantidad("depositar");

        if (!validarCantidad(cantidad, "depósito")) {
            return;
        }

        if (!confirmarOperacion("¿Confirmar depósito de $" + cantidad + " a la cuenta " + numeroCuentaDestino + "?")) {
            view.mostrarMensaje("Operación cancelada");
            return;
        }

        if (model.realizarDeposito(numeroCuentaDestino, cantidad)) {
            view.mostrarMensaje("Depósito exitoso por la cantidad de: $" + cantidad);
            if (numeroCuentaDestino.equals(model.getCuentaActual().getNumeroCuenta())) {
                view.mostrarSaldo(model.consultarSaldo());
            }
        } else {
            view.mostrarMensaje("Error al procesar el depósito");
        }
    }

    public void realizarTransferencia() {
        String cuentaDestino = view.solicitarCuentaDestino("transferencia");

        if (!model.cuentaExiste(cuentaDestino)) {
            view.mostrarMensaje("Error: La cuenta destino no existe");
            return;
        }

        if (cuentaDestino.equals(model.getCuentaActual().getNumeroCuenta())) {
            view.mostrarMensaje("Error: No puedes transferir a tu misma cuenta");
            return;
        }

        double cantidad = view.solicitarCantidad("transferir");

        if (!validarCantidad(cantidad, "transferencia")) {
            return;
        }

        if (!confirmarOperacion("¿Confirmar transferencia de $" + cantidad + " a la cuenta " + cuentaDestino + "?")) {
            view.mostrarMensaje("Operación cancelada");
            return;
        }

        if (model.realizarTransferencia(cuentaDestino, cantidad)) {
            view.mostrarMensaje("Transferencia exitosa de $" + cantidad + " a la cuenta " + cuentaDestino);
            view.mostrarSaldo(model.consultarSaldo());
        } else {
            view.mostrarMensaje("Error: Fondos insuficientes o error en la transferencia");
        }
    }

    public void cambiarPin() {
        String pinActual = view.solicitarPin("actual");
        String nuevoPin = view.solicitarNuevoPin();

        if (nuevoPin == null || nuevoPin.length() != 4) {
            view.mostrarMensaje("Error: El PIN debe tener exactamente 4 dígitos");
            return;
        }

        if (!confirmarOperacion("¿Confirmar cambio de PIN?")) {
            view.mostrarMensaje("Operación cancelada");
            return;
        }

        if (model.cambiarPin(pinActual, nuevoPin)) {
            view.mostrarMensaje("PIN cambiado exitosamente");
        } else {
            view.mostrarMensaje("Error: PIN actual incorrecto");
        }
    }
}
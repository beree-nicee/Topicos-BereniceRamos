package Controllers;

import Views.CajeroView;
import models.CajeroModel;

public class CajeroController {
    private CajeroModel model;
    private CajeroView view;

    private boolean sistemaActivo;

    //asociado a un parametro dentro de una clase, diferentes tipos de view
    public CajeroController(CajeroModel model, CajeroView view) {
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void iniciarSistema() {
        view.mostrarBienvenida();
        while (sistemaActivo) {
            if( autenticarUsuario() ){
                ejecutarMenuPrincipal();
            }else{
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
            //instancia trae a titular
            view.mostrarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();
            //determinar las opciones
            switch (opcion) {
                case 1:
                    consultarSaldo();
                    break;
                    case 2:
                        this.realizarRetiro();
                        break;
                        case 3:
                            this.realizarDeposito();
                            break;
                            case 9:
                                //forzosamente  lleva un default
                                break;
                            default:
                                break;
            }

        }
    }

    public void consultarSaldo(){
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
    }

    public void realizarRetiro(){
        double cantidad = view.solicitarCantidad("Retirar");
        if (cantidad > 0) {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarRetiro(cantidad)) {
            view.mostrarMensaje("Retiro exitoso de: $"+cantidad);
        }else{
            view.mostrarMensaje("Fondos insuficientes");
        }
    }

    public void realizarDeposito(){
        double cantidad = view.solicitarCantidad("Deposito");
        if (cantidad <= 0) {
            view.mostrarMensaje("Error en la cantidad");
            return;
        }
        if (model.realizarDeposito(cantidad)) {
            view.mostrarMensaje("Deposito exitoso por la cantidad de : $"+cantidad);
        }else{
            view.mostrarMensaje("Error al procesar el deposito");
        }
    }






}

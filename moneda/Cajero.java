package moneda;
public class Cajero {
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void cambio() {
        int[] denominaciones = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        int cantidadR = cantidad;

        System.out.println("\nDesglose de " + cantidad + " euros:");
        
        for (int i = 0; i < denominaciones.length; i++) {
            int denom = denominaciones[i];
            int num = cantidadR / denom;
            if (num > 0) {
                if (denom >= 20) {
                    System.out.println(num + " billete de " + denom);
                } else {
                    System.out.println(num + " monedas de " + denom);
                }
                cantidadR %= denom;
            }
        }

        if (cantidadR == 0) {
            System.out.println("Cambio completo entregado.\n");
        }
    }
}
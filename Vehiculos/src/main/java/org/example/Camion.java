package org.example;


// Clase Camion que implementa la interfaz Vehiculo
class Camion implements Vehiculo {
    private String marca;            // Campo privado para almacenar la marca del camión
    private double capacidadCarga;   // Campo privado para almacenar la capacidad de carga en toneladas

    // Constructor de la clase Camion que recibe marca y capacidad de carga
    public Camion(String marca, double capacidadCarga) {
        this.marca = marca;                         // Asigna la marca recibida al campo de instancia
        this.capacidadCarga = capacidadCarga;       // Asigna la capacidad recibida al campo de instancia
    }

    // Implementación del método acelerar específica para camiones
    @Override
    public void acelerar() {
        // Imprime mensaje indicando aceleración lenta debido al peso del camión
        System.out.println("El camión " + marca + " está acelerando lentamente con " + capacidadCarga + " toneladas");
    }

    // Implementación del método frenar específica para camiones
    @Override
    public void frenar() {
        // Imprime mensaje sobre el sistema de frenos neumático característico de camiones
        System.out.println("El camión está frenando con sistema de frenos neumático");
    }

    // Implementación del método mostrarInfo específica para camiones
    @Override
    public void mostrarInfo() {
        // Imprime información con emoji y capacidad de carga del camión
        System.out.println("🚛 Camión: " + marca + " - Capacidad: " + capacidadCarga + " toneladas");
    }
}
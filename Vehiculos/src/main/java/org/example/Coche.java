package org.example;

// Clase Coche que implementa la interfaz Vehiculo
class Coche implements Vehiculo {
    private String marca;  // Campo privado para almacenar la marca del coche
    private String modelo; // Campo privado para almacenar el modelo del coche

    // Constructor de la clase Coche que recibe marca y modelo como parámetros
    public Coche(String marca, String modelo) {
        this.marca = marca;   // Asigna el parámetro marca al campo marca de la instancia
        this.modelo = modelo; // Asigna el parámetro modelo al campo modelo de la instancia
    }

    // Implementación del método acelerar específica para coches
    @Override
    public void acelerar() {
        // Imprime mensaje personalizado mostrando que el coche está acelerando
        System.out.println("El coche " + marca + " " + modelo + " está acelerando por la carretera");
    }

    // Implementación del método frenar específica para coches
    @Override
    public void frenar() {
        // Imprime mensaje específico sobre el tipo de frenos que usa un coche
        System.out.println("El coche está frenando con frenos de disco");
    }

    // Implementación del método mostrarInfo específica para coches
    @Override
    public void mostrarInfo() {
        // Imprime información completa del coche con emoji y características
        System.out.println("🚗 Coche: " + marca + " " + modelo + " - 4 ruedas, motor a gasolina");
    }
}

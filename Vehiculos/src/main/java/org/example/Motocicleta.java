package org.example;

// Clase Motocicleta que implementa la interfaz Vehiculo
class Motocicleta implements Vehiculo {
    private String marca;     // Campo privado para almacenar la marca de la motocicleta
    private int cilindrada;   // Campo privado para almacenar la cilindrada en cc

    // Constructor de la clase Motocicleta que recibe marca y cilindrada
    public Motocicleta(String marca, int cilindrada) {
        this.marca = marca;           // Asigna el parámetro marca al campo marca de la instancia
        this.cilindrada = cilindrada; // Asigna el parámetro cilindrada al campo cilindrada
    }

    // Implementación del método acelerar específica para motocicletas
    @Override
    public void acelerar() {
        // Imprime mensaje mostrando la marca y cilindrada al acelerar
        System.out.println("La motocicleta " + marca + " está acelerando con " + cilindrada + "cc");
    }

    // Implementación del método frenar específica para motocicletas
    @Override
    public void frenar() {
        // Imprime mensaje específico sobre el frenado precautivo de motocicletas
        System.out.println("La motocicleta está frenando con precaución");
    }

    // Implementación del método mostrarInfo específica para motocicletas
    @Override
    public void mostrarInfo() {
        // Imprime información completa con emoji y características de la motocicleta
        System.out.println("🏍️ Motocicleta: " + marca + " " + cilindrada + "cc - 2 ruedas, ágil y rápida");
    }
}
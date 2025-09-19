package org.example;

// Clase adicional Bicicleta que también implementa la interfaz Vehiculo
class Bicicleta implements Vehiculo {
    private String tipo;           // Campo privado para el tipo de bicicleta
    private int numVelocidades;    // Campo privado para el número de velocidades

    // Constructor que recibe tipo y número de velocidades
    public Bicicleta(String tipo, int numVelocidades) {
        this.tipo = tipo;                       // Asigna el tipo a la instancia
        this.numVelocidades = numVelocidades;   // Asigna el número de velocidades
    }

    // Implementación del método acelerar para bicicletas
    @Override
    public void acelerar() {
        // Imprime mensaje específico sobre pedalear la bicicleta
        System.out.println("La bicicleta " + tipo + " está siendo pedaleada");
    }

    // Implementación del método frenar para bicicletas
    @Override
    public void frenar() {
        // Imprime mensaje sobre el tipo de frenos de la bicicleta
        System.out.println("La bicicleta está frenando con frenos de mano");
    }

    // Implementación del método mostrarInfo para bicicletas
    @Override
    public void mostrarInfo() {
        // Imprime información completa con emoji y características ecológicas
        System.out.println("🚲 Bicicleta: " + tipo + " - " + numVelocidades + " velocidades, ecológica");
    }
}

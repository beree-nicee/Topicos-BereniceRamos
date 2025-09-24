package Models;

// Modelo, es la representación de la hamburguesa y su Builder interno
public class Hamburger {
    // Atributos del producto (ingredientes y tamaño)
    private String size; // Tamaño: "small", "medium", "large"
    private boolean cheese; // ¿Tiene queso?
    private boolean bacon;  // ¿Tiene tocino?
    private boolean lettuce; // ¿Tiene lechuga?
    private boolean tomato;  // ¿Tiene tomate?

    // Constructor privado para forzar el uso del Builder
    private Hamburger() { }

    // Getters públicos para que la Vista/Controlador puedan leer el estado
    public String getSize() {
        return size;
    }
    public boolean hasCheese() {
        return cheese;
    }
    public boolean hasBacon() {
        return bacon;
    }
    public boolean hasLettuce() {
        return lettuce;
    }
    public boolean hasTomato() {
        return tomato;
    }

    // Representación en String para depuración / salida
    @Override
    public String toString() {
        return String.format("Hamburger[size=%s, cheese=%b, bacon=%b, lettuce=%b, tomato=%b]",
                size, cheese, bacon, lettuce, tomato);
    }

    // Builder estático interno: estilo "fluent API" común en Java
    public static class Builder {
        // Campos del builder (mismos que el producto)
        private final String size; // tamaño obligatorio
        private boolean cheese;
        private boolean bacon;
        private boolean lettuce;
        private boolean tomato;

        // Constructor del Builder que recibe los parámetros obligatorios
        public Builder(String size) {
            // Validación básica: no permitir tamaño nulo
            if (size == null || size.isEmpty()) {
                throw new IllegalArgumentException("Size must be provided");
            }
            this.size = size; // asigna el tamaño al builder
        }

        // Métodos "fluent" para configurar cada ingrediente opcional
        public Builder addCheese() { this.cheese = true; return this; } // añade queso
        public Builder addBacon()  { this.bacon = true;  return this; } // añade tocino
        public Builder addLettuce(){ this.lettuce = true; return this; } // añade lechuga
        public Builder addTomato() { this.tomato = true;  return this; } // añade tomate

        // Método build: crea la instancia final de Hamburger
        public Hamburger build() {
            Hamburger h = new Hamburger(); // instancia el producto
            h.size = this.size;            // copia valores desde el builder
            h.cheese = this.cheese;
            h.bacon = this.bacon;
            h.lettuce = this.lettuce;
            h.tomato = this.tomato;
            return h; // devuelve el producto construido
        }
    }
}
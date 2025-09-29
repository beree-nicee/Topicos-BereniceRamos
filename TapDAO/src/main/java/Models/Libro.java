package Models;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    private Libro(LibroBuilder builder) {
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.anio = builder.anio;
        this.disponible = builder.disponible;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnio() { return anio; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return id + " - " + titulo + " - " + autor + " - " + anio + " - " + (disponible ? "Disponible" : "No disponible");
    }
    // Builder
    public static class LibroBuilder {
        private String titulo;
        private String autor;
        private int anio;
        private boolean disponible = true; // por defecto disponible

        public LibroBuilder setTitulo(String titulo) { this.titulo = titulo; return this; }
        public LibroBuilder setAutor(String autor) { this.autor = autor; return this; }
        public LibroBuilder setAnio(int anio) { this.anio = anio; return this; }
        public LibroBuilder setDisponible(boolean disponible) { this.disponible = disponible; return this; }

        public Libro build() { return new Libro(this); }
    }
}

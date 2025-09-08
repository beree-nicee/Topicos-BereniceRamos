package Models;

public class Libro {
    private String titulo;
    private String autor;

    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    //Personalización para poder mostrarlo
    //Metodo sobreeescrito
    public String toString() {
        return "Libro: " + titulo + " - " + autor;
    }
}

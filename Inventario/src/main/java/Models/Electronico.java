package Models;

public class Electronico {
    private String nombre;
    private String marca;

    public Electronico(String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }


    //Salida acomodada
    public String toString() {
        return "Electrónico: " + nombre + " - descripción " + marca;
    }
}

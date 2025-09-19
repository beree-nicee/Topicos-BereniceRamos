package Models;

//Es un producto concreto, un Libro. Implementa la interfaz Producto.
public class Libro implements Producto {
    private String nombre;
    private double precio;

    public Libro(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    //Acomodar la salida
    public String toString() {
        return "Libro: " + nombre + " - $" + precio;
    }
}

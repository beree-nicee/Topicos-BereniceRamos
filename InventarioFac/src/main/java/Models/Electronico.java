package Models;

//Otro producto concreto, en este caso Electrónico.
public class Electronico implements Producto {
    private String nombre;
    private double precio;

    public Electronico(String nombre, double precio) {
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
        return "Electrónico: " + nombre + " - $" + precio;
    }
}

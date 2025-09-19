package Models;

//Define el ajuste que deben seguir todos los productos: tener nombre y precio.
//Todoo lo que sea un Item debe poder regresar su nombre y precio
//No importa si es un producto, un libro, un coche, etc.
//
public interface Producto {
    String getNombre();
    double getPrecio();
}
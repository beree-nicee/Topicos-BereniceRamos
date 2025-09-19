package Factory;

import Models.Electronico;
import Models.Libro;
import Models.Producto;

public class ProductoFactory {
    //Uso del static, para estandarizar
    public static Producto crearProducto(String tipo, String nombre, double precio) {
        if (tipo.equalsIgnoreCase("libro")) {
            return new Libro(nombre, precio);
        } else if (tipo.equalsIgnoreCase("electronico")) {
            return new Electronico(nombre, precio);
        }
        throw new IllegalArgumentException("Tipo de producto no soportado");
    }
}
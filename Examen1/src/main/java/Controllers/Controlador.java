package Controllers;

import Models.Cliente;
import Models.Producto;
import Views.VistaGenerica;

import java.util.ArrayList;
import java.util.List;

//poder usar el mwtodo generico y agregar los productos en un arraylist para poder mostrar y visualizar la lista
public class Controlador {
    private List<Producto> productos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private VistaGenerica vista;

    public Controlador(VistaGenerica vista) {
        this.vista = vista;
    }

    //Controlador de Productos que usan los métos de vistaGenerica
    public void agregarProducto() {
        String codigo = vista.leerTexto("Código: ");
        String nombre = vista.leerTexto("Nombre: ");
        double precio = vista.leerDouble("Precio: "); vista.leerTexto("");
        int cantidad = vista.leerInt("Cantidad: "); vista.leerTexto("");
        String categoria = vista.leerTexto("Categoría: ");
        String fecha = vista.leerTexto("Fecha de vencimiento: ");
        productos.add(new Producto(codigo, nombre, precio, cantidad, categoria, fecha));
        System.out.println("Producto agregado con éxito.");
    }

    public void listarProductos() {
        vista.mostrarLista("-----Productos-----", productos);
    }

    //Clientes
    public void agregarCliente() {
        String nombre = vista.leerTexto("Nombre: ");
        String email = vista.leerTexto("Email: ");
        String telefono = vista.leerTexto("Teléfono: ");
        double saldo = vista.leerDouble("Saldo inicial: "); vista.leerTexto("");
        clientes.add(new Cliente(nombre, email, telefono, saldo));
        System.out.println("Cliente agregado con éxito.");
    }

    //Mostrar los clientes
    public void listarClientes() {
        vista.mostrarLista("------Clientes------", clientes);
    }
}

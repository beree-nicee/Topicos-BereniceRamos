package Models;
import java.util.ArrayList;
import java.util.List;
//Clase Genérica con T como parametro de tipoo, cmpos y retornos
//T vendria siendo un libro o un electronico
//Saber el tipo de de objeto
public class Inventario <T>{
    //Lista con elementos de tipo T
    private List<T> items;

    //Arraylist constructor
    public Inventario() {
        this.items = new ArrayList<>();
    }

    //Añadir a la listaa
    public void agregarItem(T item){
        items.add(item);
    }

    //Regresar la lista y se regresa el tipo de lista que se requiera
    public List<T> getItems(){
        return items;
    }
}

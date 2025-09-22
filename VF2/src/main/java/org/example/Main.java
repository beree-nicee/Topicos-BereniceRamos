package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
interface CarFactory { // Interfaz para factory de coches - define contrato para crear coches
    Car createCar(); // Método que debe implementar cada factory concreta
}


interface Car { // Interfaz Car - define contrato común para todos los coches
    void assemble(); // Método que debe implementar cada tipo de coche
}


class Sedan implements Car { // Clase concreta que implementa la interfaz Car para sedanes
    @Override
    public void assemble() { // Implementación específica para ensamblar sedanes
        System.out.println("Assembling a sedan car."); // Mensaje de ensamblaje de sedan
    }
}

class SUV implements Car { // Clase concreta que implementa la interfaz Car para SUVs
    @Override
    public void assemble() { // Implementación específica para ensamblar SUVs
        System.out.println("Assembling an SUV car."); // Mensaje de ensamblaje de SUV
    }
}


class SedanFactory implements CarFactory { // Factory concreta para crear sedanes
    @Override
    public Car createCar() { // Implementa createCar para devolver instancia de Sedan
        return new Sedan(); // Crea y retorna nueva instancia de Sedan
    }
}

class SUVFactory implements CarFactory { // Factory concreta para crear SUVs
    @Override
    public Car createCar() { // Implementa createCar para devolver instancia de SUV
        return new SUV(); // Crea y retorna nueva instancia de SUV
    }
}




public class Main { // Clase principal que demuestra el segundo ejemplo de Factory Pattern
    public static void main(String[] args) { // Método main del segundo ejemplo
        CarFactory sedanFactory = new SedanFactory(); // Crea factory específica para sedanes
        Car sedan = sedanFactory.createCar(); // Usa factory para crear sedan
        sedan.assemble(); // Llama método assemble del sedan creado

        CarFactory suvFactory = new SUVFactory(); // Crea factory específica para SUVs
        Car suv = suvFactory.createCar(); // Usa factory para crear SUV
        suv.assemble(); // Llama método assemble del SUV creado
    }
}
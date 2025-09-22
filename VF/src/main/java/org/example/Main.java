package org.example;

interface Vehiculo { // Interfaz que define el contrato común para todos los vehículos
    void acelerar(); // Método abstracto para acelerar
    void frenar(); // Método abstracto para frenar
    void mostrarInfo(); // Método abstracto para mostrar información
}


class Coche implements Vehiculo { // Clase que implementa la interfaz Vehiculo para coches
    private String marca; // Campo privado para la marca del coche
    private String modelo; // Campo privado para el modelo del coche

    public Coche(String marca, String modelo) { // Constructor que recibe marca y modelo
        this.marca = marca; //Asigna el parámetro marca al campo marca de la instancia
        this.modelo = modelo; // Asigna el modelo recibido al campo de instancia
    }

    @Override
    public void acelerar() { // Implementación específica del método acelerar para coches
        // Mensaje personalizado de aceleración
        System.out.println("El coche " + marca + " " + modelo + " está acelerando por la carretera");
    }

    @Override
    public void frenar() { // Implementación específica del método frenar para coches
        System.out.println("El coche está frenando con frenos de disco"); // Mensaje sobre el tipo de frenos
    }

    @Override
    public void mostrarInfo() { // Implementación específica para mostrar información del coche
        System.out.println("🚗 Coche: " + marca + " " + modelo + " - 4 ruedas, motor a gasolina"); // Información completa del coche
    }
}

class Motocicleta implements Vehiculo { // Clase que implementa la interfaz Vehiculo para motocicletas
    private String marca; // Campo privado para la marca de la motocicleta
    private int cilindrada; // Campo privado para la cilindrada en cc

    public Motocicleta(String marca, int cilindrada) { // Constructor que recibe marca y cilindrada
        this.marca = marca; // Asigna la marca recibida al campo de instancia
        this.cilindrada = cilindrada; // Asigna la cilindrada recibida al campo de instancia
    }

    @Override
    public void acelerar() { // Implementación específica del método acelerar para motocicletas
        System.out.println("La motocicleta " + marca + " está acelerando con " + cilindrada + "cc"); // Mensaje con marca y cilindrada
    }

    @Override
    public void frenar() { // Implementación específica del método frenar para motocicletas
        System.out.println("La motocicleta está frenando con precaución"); // Mensaje sobre frenado precautivo
    }

    @Override
    public void mostrarInfo() { // Implementación específica para mostrar información de la motocicleta
        System.out.println("🏍️ Motocicleta: " + marca + " " + cilindrada + "cc - 2 ruedas, ágil y rápida"); // Información completa con características
    }
}

class Camion implements Vehiculo { // Clase que implementa la interfaz Vehiculo para camiones
    private String marca; // Campo privado para la marca del camión
    private double capacidadCarga; // Campo privado para la capacidad de carga en toneladas

    public Camion(String marca, double capacidadCarga) { // Constructor que recibe marca y capacidad
        this.marca = marca; // Asigna la marca recibida al campo de instancia
        this.capacidadCarga = capacidadCarga; // Asigna la capacidad recibida al campo de instancia
    }

    @Override
    public void acelerar() { // Implementación específica del método acelerar para camiones
        System.out.println("El camión " + marca + " está acelerando lentamente con " + capacidadCarga + " toneladas"); // Mensaje con peso que justifica velocidad lenta
    }

    @Override
    public void frenar() { // Implementación específica del método frenar para camiones
        System.out.println("El camión está frenando con sistema de frenos neumático"); // Mensaje sobre sistema de frenos específico
    }

    @Override
    public void mostrarInfo() { // Implementación específica para mostrar información del camión
        System.out.println("🚛 Camión: " + marca + " - Capacidad: " + capacidadCarga + " toneladas"); // Información con capacidad de carga
    }
}


enum TipoVehiculo { // Enumeración que define los tipos de vehículos disponibles
    COCHE, MOTOCICLETA, CAMION // Constantes que representan cada tipo de vehículo
}


class VehiculoFactory { // Clase Factory que implementa el patrón Factory para crear vehículos


    public static Vehiculo crearVehiculo(TipoVehiculo tipo, String... parametros) { // Método estático principal que crea vehículos según tipo y parámetros
        switch (tipo) { // Switch para determinar qué tipo de vehículo crear
            case COCHE: // Caso para crear un coche
                if (parametros.length >= 2) { // Verifica si hay al menos 2 parámetros
                    return new Coche(parametros[0], parametros[1]); // Crea coche con parámetros específicos
                } else {
                    return new Coche("Toyota", "Corolla");  // Crea coche con valores por defecto
                }

            case MOTOCICLETA: // Caso para crear una motocicleta
                if (parametros.length >= 2) { // Verifica parámetros suficientes
                    try {
                        int cilindrada = Integer.parseInt(parametros[1]); // Convierte segundo parámetro a entero
                        return new Motocicleta(parametros[0], cilindrada); // Crea motocicleta con parámetros convertidos
                    } catch (NumberFormatException e) { // Maneja error de conversión
                        return new Motocicleta(parametros[0], 250);  // Usa cilindrada por defecto si falla conversión
                    }
                } else {
                    return new Motocicleta("Yamaha", 250); // Crea motocicleta con valores por defecto
                }

            case CAMION: // Caso para crear un camión
                if (parametros.length >= 2) { // Verifica parámetros suficientes
                    try {
                        double capacidad = Double.parseDouble(parametros[1]); // Convierte segundo parámetro a double
                        return new Camion(parametros[0], capacidad); // Crea camión con parámetros convertidos
                    } catch (NumberFormatException e) { // Maneja error de conversión
                        return new Camion(parametros[0], 10.0); // Usa capacidad por defecto si falla conversión
                    }
                } else {
                    return new Camion("Volvo", 15.0); // Crea camión con valores por defecto
                }

            default: // Caso por defecto para tipos no válidos
                throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo); // Lanza excepción para tipos no soportados
        }
    }


    public static Vehiculo crearVehiculoPorDefecto(TipoVehiculo tipo) { // Método auxiliar que crea vehículos con valores por defecto
        return crearVehiculo(tipo); // Llama al método principal sin parámetros adicionales
    }
}


public class Main { // Clase principal que demuestra el patrón Factory

    public static void main(String[] args) { // Método main - punto de entrada del programa
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN FACTORY ===\n"); // Título de la demostración


        Vehiculo coche1 = VehiculoFactory.crearVehiculo(TipoVehiculo.COCHE, "Honda", "Civic"); // Crea coche con parámetros específicos
        Vehiculo moto1 = VehiculoFactory.crearVehiculo(TipoVehiculo.MOTOCICLETA, "Kawasaki", "600"); // Crea motocicleta con parámetros específicos
        Vehiculo camion1 = VehiculoFactory.crearVehiculo(TipoVehiculo.CAMION, "Mercedes", "12.5"); // Crea camión con parámetros específicos


        Vehiculo coche2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.COCHE); // Crea coche con valores por defecto
        Vehiculo moto2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.MOTOCICLETA); // Crea motocicleta con valores por defecto


        Vehiculo[] vehiculos = {coche1, moto1, camion1, coche2, moto2}; // Arreglo que contiene todos los vehículos creados


        System.out.println("1. INFORMACIÓN DE VEHÍCULOS:"); // Encabezado de la primera sección
        System.out.println("----------------------------"); // Separador visual
        for (Vehiculo vehiculo : vehiculos) { // Itera sobre cada vehículo en el arreglo
            vehiculo.mostrarInfo(); // Llama al método mostrarInfo de cada vehículo polimórficamente
        }

        System.out.println("\n2. ACELERANDO TODOS LOS VEHÍCULOS:"); // Encabezado de la segunda sección
        System.out.println("----------------------------------"); // Separador visual
        for (Vehiculo vehiculo : vehiculos) { // Itera sobre cada vehículo
            vehiculo.acelerar(); // Llama al método acelerar de cada vehículo polimórficamente
        }

        System.out.println("\n3. FRENANDO TODOS LOS VEHÍCULOS:"); // Encabezado de la tercera sección
        System.out.println("--------------------------------"); // Separador visual
        for (Vehiculo vehiculo : vehiculos) { // Itera sobre cada vehículo
            vehiculo.frenar(); // Llama al método frenar de cada vehículo polimórficamente
        }

        System.out.println("\n4. CREACIÓN DINÁMICA BASADA EN INPUT:"); // Encabezado de la cuarta sección
        System.out.println("-------------------------------------"); // Separador visual


        String[] tiposInput = {"COCHE", "MOTOCICLETA", "CAMION"}; // Arreglo de strings que representa tipos de vehículos

        for (String tipoStr : tiposInput) { // Itera sobre cada string de tipo
            try {
                TipoVehiculo tipo = TipoVehiculo.valueOf(tipoStr); // Convierte string a enum TipoVehiculo
                Vehiculo vehiculo = VehiculoFactory.crearVehiculoPorDefecto(tipo); // Crea vehículo usando factory
                System.out.print("Creado dinámicamente: "); // Mensaje introductorio
                vehiculo.mostrarInfo(); // Muestra información del vehículo creado dinámicamente
            } catch (IllegalArgumentException e) { // Captura excepción si el tipo no es válido
                System.out.println("Tipo de vehículo no válido: " + tipoStr); // Mensaje de error para tipos inválidos
            }
        }

        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ==="); // Mensaje final de la demostración
    }
}


class Bicicleta implements Vehiculo { // Clase adicional que implementa la interfaz Vehiculo
    private String tipo; // Campo privado para el tipo de bicicleta
    private int numVelocidades; // Campo privado para el número de velocidades

    public Bicicleta(String tipo, int numVelocidades) { // Constructor que recibe tipo y número de velocidades
        this.tipo = tipo; // Asigna el tipo recibido al campo de instancia
        this.numVelocidades = numVelocidades; // Asigna el número de velocidades al campo de instancia
    }

    @Override
    public void acelerar() { // Implementación específica del método acelerar para bicicletas
        System.out.println("La bicicleta " + tipo + " está siendo pedaleada"); // Mensaje específico sobre pedalear
    }

    @Override
    public void frenar() { // Implementación específica del método frenar para bicicletas
        System.out.println("La bicicleta está frenando con frenos de mano"); // Mensaje sobre tipo de frenos
    }

    @Override
    public void mostrarInfo() { // Implementación específica para mostrar información de la bicicleta
        System.out.println("🚲 Bicicleta: " + tipo + " - " + numVelocidades + " velocidades, ecológica"); // Información con característica ecológica
    }
}

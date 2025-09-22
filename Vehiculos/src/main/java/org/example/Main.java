package org.example;


// Definición de la interfaz Vehiculo que establece el contrato común para todos los vehículos


// Enumeración que define los tipos de vehículos disponibles para la factory
enum TipoVehiculo {
    COCHE,        // Constante para representar el tipo coche
    MOTOCICLETA,  // Constante para representar el tipo motocicleta
    CAMION        // Constante para representar el tipo camión
}


// Clase principal que demuestra el funcionamiento del patrón Factory
public class Main {

    // Método main - punto de entrada del programa
    public static void main(String[] args) {
        // Imprime título de la demostración
        System.out.println("=== DEMOSTRACIÓN DEL PATRÓN FACTORY ===\n");

        // Crea vehículos específicos usando la factory con parámetros personalizados
        Vehiculo coche1 = VehiculoFactory.crearVehiculo(TipoVehiculo.COCHE, "Honda", "Civic");
        Vehiculo moto1 = VehiculoFactory.crearVehiculo(TipoVehiculo.MOTOCICLETA, "Kawasaki", "600");
        Vehiculo camion1 = VehiculoFactory.crearVehiculo(TipoVehiculo.CAMION, "Mercedes", "12.5");

        // Crea vehículos con parámetros por defecto usando el método auxiliar
        Vehiculo coche2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.COCHE);
        Vehiculo moto2 = VehiculoFactory.crearVehiculoPorDefecto(TipoVehiculo.MOTOCICLETA);

        // Crea un arreglo que contiene todos los vehículos creados
        Vehiculo[] vehiculos = {coche1, moto1, camion1, coche2, moto2};

        // Sección 1: Muestra información de todos los vehículos
        System.out.println("1. INFORMACIÓN DE VEHÍCULOS:");
        System.out.println("----------------------------");
        for (Vehiculo vehiculo : vehiculos) { // Itera sobre cada vehículo en el arreglo
            vehiculo.mostrarInfo(); // Llama al método mostrarInfo de cada vehículo
        }

        // Sección 2: Hace que todos los vehículos aceleren
        System.out.println("\n2. ACELERANDO TODOS LOS VEHÍCULOS:");
        System.out.println("----------------------------------");
        for (Vehiculo vehiculo : vehiculos) { // Itera sobre cada vehículo
            vehiculo.acelerar(); // Llama al método acelerar de cada vehículo
        }

        // Sección 3: Hace que todos los vehículos frenen
        System.out.println("\n3. FRENANDO TODOS LOS VEHÍCULOS:");
        System.out.println("--------------------------------");
        for (Vehiculo vehiculo : vehiculos) { // Itera sobre cada vehículo
            vehiculo.frenar(); // Llama al método frenar de cada vehículo
        }

        // Sección 4: Demuestra creación dinámica basada en strings
        System.out.println("\n4. CREACIÓN DINÁMICA BASADA EN INPUT:");
        System.out.println("-------------------------------------");

        // Arreglo de strings que representa tipos de vehículos
        String[] tiposInput = {"COCHE", "MOTOCICLETA", "CAMION"};

        // Itera sobre cada string de tipo de vehículo
        for (String tipoStr : tiposInput) {
            try {
                // Convierte el string a enum TipoVehiculo
                TipoVehiculo tipo = TipoVehiculo.valueOf(tipoStr);
                // Crea vehículo usando la factory con el tipo convertido
                Vehiculo vehiculo = VehiculoFactory.crearVehiculoPorDefecto(tipo);
                // Imprime mensaje y muestra información del vehículo creado
                System.out.print("Creado dinámicamente: ");
                vehiculo.mostrarInfo();
            } catch (IllegalArgumentException e) { // Captura excepción si el tipo no es válido
                // Imprime mensaje de error para tipos no válidos
                System.out.println("Tipo de vehículo no válido: " + tipoStr);
            }
        }

        // Imprime mensaje final de la demostración
        System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
    }
}



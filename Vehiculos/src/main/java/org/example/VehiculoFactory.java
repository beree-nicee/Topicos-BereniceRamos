package org.example;

// Clase Factory que implementa el patrón Factory para crear vehículos
class VehiculoFactory {

    // Método estático principal que crea vehículos según el tipo y parámetros dados
    public static Vehiculo crearVehiculo(TipoVehiculo tipo, String... parametros) {
        // Switch que determina qué tipo de vehículo crear según el enum recibido
        switch (tipo) {
            case COCHE: // Caso para crear un coche
                if (parametros.length >= 2) { // Verifica si se proporcionaron al menos 2 parámetros
                    // Crea coche con marca y modelo específicos
                    return new Coche(parametros[0], parametros[1]);
                } else {
                    // Crea coche con valores por defecto si no hay suficientes parámetros
                    return new Coche("Toyota", "Corolla");
                }

            case MOTOCICLETA: // Caso para crear una motocicleta
                if (parametros.length >= 2) { // Verifica parámetros suficientes
                    try {
                        // Intenta convertir el segundo parámetro a entero para la cilindrada
                        int cilindrada = Integer.parseInt(parametros[1]);
                        return new Motocicleta(parametros[0], cilindrada);
                    } catch (NumberFormatException e) {
                        // Si la conversión falla, usa cilindrada por defecto
                        return new Motocicleta(parametros[0], 250);
                    }
                } else {
                    // Crea motocicleta con valores por defecto
                    return new Motocicleta("Yamaha", 250);
                }

            case CAMION: // Caso para crear un camión
                if (parametros.length >= 2) { // Verifica parámetros suficientes
                    try {
                        // Intenta convertir el segundo parámetro a double para la capacidad
                        double capacidad = Double.parseDouble(parametros[1]);
                        return new Camion(parametros[0], capacidad);
                    } catch (NumberFormatException e) {
                        // Si la conversión falla, usa capacidad por defecto
                        return new Camion(parametros[0], 10.0);
                    }
                } else {
                    // Crea camión con valores por defecto
                    return new Camion("Volvo", 15.0);
                }

            default: // Caso por defecto si se pasa un tipo no válido
                // Lanza excepción para tipos no soportados
                throw new IllegalArgumentException("Tipo de vehículo no soportado: " + tipo);
        }
    }

    // Método auxiliar que crea vehículos con parámetros por defecto
    public static Vehiculo crearVehiculoPorDefecto(TipoVehiculo tipo) {
        // Llama al método principal sin parámetros adicionales
        return crearVehiculo(tipo);
    }
}

package Singleton;

public class MainConfiguracion {
    public static void main(String[] args) {
        // Pedimos la instancia dos veces
        Configuracion config1 = Configuracion.getInstancia();
        config1.mostrarConfiguracion();



        //Modificar la configuración desde otra referencia
        Configuracion config2 = Configuracion.getInstancia();

        // Mostramos los valores iniciales
        System.out.println("Config1 URL: " + config1.getUrl());
        System.out.println("Config2 URL: " + config2.getUrl());

        // Cambiamos valores usando config2
        config2.setUrl("jdbc:mysql://localhost:3308/tap");
        config2.setUsuario("root");
        config2.setPassword("nueva_clave");

        //Mostrar configuración desde la primera referencia
        System.out.println("\nDespués de cambiar config2:");
        config1.mostrarConfiguracion();
        System.out.println("Config1 URL: " + config1.getUrl());
        System.out.println("Config1 Usuario: " + config1.getUsuario());

        //Verificar que ambas referencias apuntan
        System.out.println("\n ¿Config1 y config2 son el mismo objeto?" + " " + (config1 == config2));
    }
}

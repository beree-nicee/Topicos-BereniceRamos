package Controllers;

// IMPORTS EXPLÍCITOS para evitar conflictos
import Models.RestaurantMenu;  // ← IMPORTANTE: Import explícito de nuestra clase
import Models.MattsRestaurant;
import Models.VegetarianMenuBuilder;
import Models.MeatMenuBuilder;
import Models.SeafoodMenuBuilder;
import Models.KidsMenuBuilder;
import Views.RestaurantView;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador del sistema - SOLUCIONADO con imports explícitos
 */
public class RestaurantController {
    private RestaurantView view;
    private MattsRestaurant restaurant;

    public RestaurantController(RestaurantView view) {
        this.view = view != null ? view : new RestaurantView();
        this.restaurant = new MattsRestaurant();
    }

    public RestaurantMenu createVegetarianMenu() {  // ← Cambio: RestaurantMenu en lugar de Menu
        try {
            restaurant.setBuilder(new VegetarianMenuBuilder());
            RestaurantMenu vegMenu = restaurant.buildCompleteMenu();  // ← Cambio aquí también

            view.displayTitle("🌱 MENÚ VEGETARIANO CREADO");
            view.displayMessage("✅ ¡Su menú vegetariano ha sido preparado con ingredientes frescos y orgánicos!");
            view.displayMenu(vegMenu);

            return vegMenu;

        } catch (Exception e) {
            view.displayMessage("❌ Error al crear menú vegetariano: " + e.getMessage());
            return null;
        }
    }

    public RestaurantMenu createMeatMenu() {  // ← Todos los tipos cambiados
        try {
            restaurant.setBuilder(new MeatMenuBuilder());
            RestaurantMenu meatMenu = restaurant.buildCompleteMenu();

            view.displayTitle("🥩 MENÚ CARNÍVORO PREMIUM CREADO");
            view.displayMessage("✅ ¡Su menú carnívoro premium ha sido preparado con las mejores carnes!");
            view.displayMenu(meatMenu);

            return meatMenu;

        } catch (Exception e) {
            view.displayMessage("❌ Error al crear menú carnívoro: " + e.getMessage());
            return null;
        }
    }

    public RestaurantMenu createSeafoodMenu() {
        try {
            restaurant.setBuilder(new SeafoodMenuBuilder());
            RestaurantMenu seafoodMenu = restaurant.buildCompleteMenu();

            view.displayTitle("🐟 MENÚ ESPECIALIDAD DEL MAR CREADO");
            view.displayMessage("✅ ¡Su menú de mariscos ha sido preparado con productos frescos del mar!");
            view.displayMenu(seafoodMenu);

            return seafoodMenu;

        } catch (Exception e) {
            view.displayMessage("❌ Error al crear menú de mariscos: " + e.getMessage());
            return null;
        }
    }

    public RestaurantMenu createKidsMenu() {
        try {
            restaurant.setBuilder(new KidsMenuBuilder());
            RestaurantMenu kidsMenu = restaurant.buildCompleteMenu();

            view.displayTitle("👶 MENÚ INFANTIL DIVERTIDO CREADO");
            view.displayMessage("✅ ¡Su menú infantil ha sido preparado especialmente para los pequeños!");
            view.displayMenu(kidsMenu);

            return kidsMenu;

        } catch (Exception e) {
            view.displayMessage("❌ Error al crear menú infantil: " + e.getMessage());
            return null;
        }
    }

    public List<RestaurantMenu> createBasicMenusComparison() {  // ← Lista también cambiada
        List<RestaurantMenu> menus = new ArrayList<>();

        try {
            view.displayTitle("📊 CREANDO COMPARACIÓN DE MENÚS BÁSICOS");

            restaurant.setBuilder(new VegetarianMenuBuilder());
            RestaurantMenu vegBasic = restaurant.buildBasicMenu();
            menus.add(vegBasic);

            restaurant.setBuilder(new MeatMenuBuilder());
            RestaurantMenu meatBasic = restaurant.buildBasicMenu();
            menus.add(meatBasic);

            restaurant.setBuilder(new SeafoodMenuBuilder());
            RestaurantMenu seafoodBasic = restaurant.buildBasicMenu();
            menus.add(seafoodBasic);

            restaurant.setBuilder(new KidsMenuBuilder());
            RestaurantMenu kidsBasic = restaurant.buildBasicMenu();
            menus.add(kidsBasic);

            view.displayMessage("✅ ¡Comparación de menús básicos creada exitosamente!");
            view.displayMenuComparison(menus);

            return menus;

        } catch (Exception e) {
            view.displayMessage("❌ Error al crear comparación de menús: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public RestaurantMenu createCustomMenu() {
        try {
            view.displayTitle("🎨 CREANDO MENÚ PERSONALIZADO");
            view.displayMessage("Construyendo menú personalizado paso a paso...");

            MeatMenuBuilder customBuilder = new MeatMenuBuilder();

            customBuilder.buildStarter();
            view.displayMessage("✓ Entrante agregado...");

            customBuilder.buildMainCourse();
            view.displayMessage("✓ Plato principal agregado...");

            customBuilder.buildDessert();
            view.displayMessage("✓ Postre agregado...");

            customBuilder.buildDrink();
            view.displayMessage("✓ Bebida agregada...");

            customBuilder.buildMenuInfo();
            view.displayMessage("✓ Información del menú configurada...");

            RestaurantMenu customMenu = customBuilder.build();  // ← Aquí también corregido

            customMenu.setMenuType("🎨 MENÚ PERSONALIZADO DEL CHEF");
            customMenu.setTotalPrice(customMenu.getTotalPrice() * 1.15);
            customMenu.setPreparationTime("40-45 minutos");

            view.displayMessage("✅ ¡Menú personalizado creado con éxito!");
            view.displayMessage("🎨 Incluye toque especial del chef con recargo del 15%");
            view.displayMenu(customMenu);

            return customMenu;

        } catch (Exception e) {
            view.displayMessage("❌ Error al crear menú personalizado: " + e.getMessage());
            return null;
        }
    }

    public void runCompleteDemo() {
        try {
            view.displayWelcome();
            view.displayMessage("🎬 Iniciando demostración completa del patrón Builder...");

            view.displayTitle("PARTE 1: CREACIÓN DE MENÚS INDIVIDUALES");

            view.displayMessage("1️⃣ Creando menú vegetariano...");
            createVegetarianMenu();
            view.displaySeparator();

            view.displayMessage("2️⃣ Creando menú carnívoro premium...");
            createMeatMenu();
            view.displaySeparator();

            view.displayMessage("3️⃣ Creando menú de especialidad del mar...");
            createSeafoodMenu();
            view.displaySeparator();

            view.displayMessage("4️⃣ Creando menú infantil...");
            createKidsMenu();
            view.displaySeparator();

            view.displayTitle("PARTE 2: COMPARACIÓN DE MENÚS BÁSICOS");
            createBasicMenusComparison();
            view.displaySeparator();

            view.displayTitle("PARTE 3: CREACIÓN MANUAL PERSONALIZADA");
            createCustomMenu();
            view.displaySeparator();

            view.displayTitle("🎉 DEMOSTRACIÓN COMPLETADA");
            view.displayMessage("✅ Patrón Builder implementado correctamente");

            view.displayGoodbye();

        } catch (Exception e) {
            view.displayMessage("❌ Error durante la demostración: " + e.getMessage());
        }
    }
}

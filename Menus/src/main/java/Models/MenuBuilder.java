package Models;

// =============================================================================
// BUILDER ABSTRACTO - Define la interfaz para construir menús
// =============================================================================

/**
 * Clase abstracta MenuBuilder - Builder abstracto
 */
public abstract class MenuBuilder {
    protected RestaurantMenu menu;

    public MenuBuilder() {
        this.menu = new RestaurantMenu();
    }

    public void reset() {
        this.menu = new RestaurantMenu();
    }

    // Métodos abstractos
    public abstract void buildStarter();
    public abstract void buildMainCourse();
    public abstract void buildDessert();
    public abstract void buildDrink();
    public abstract void buildMenuInfo();

    public RestaurantMenu build() {
        return menu;
    }
}




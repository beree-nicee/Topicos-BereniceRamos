package Models;

/**
 * Builder concreto para menús infantiles
 */
public class KidsMenuBuilder extends MenuBuilder {

    @Override
    public void buildStarter() {
        menu.setStarter("🧀 Palitos de Mozzarella con Salsa Ranch");
    }

    @Override
    public void buildMainCourse() {
        menu.setMainCourse("🍗 Nuggets de Pollo con Papas Fritas");
    }

    @Override
    public void buildDessert() {
        menu.setDessert("🍦 Helado de Vainilla con Chispas de Colores");
    }

    @Override
    public void buildDrink() {
        menu.setDrink("🥤 Jugo de Naranja Natural con Pajita Divertida");
    }

    @Override
    public void buildMenuInfo() {
        menu.setMenuType("👶 MENÚ INFANTIL DIVERTIDO");
        menu.setTotalPrice(180.00);
        menu.setPreparationTime("15-20 minutos");
    }
}


package Models;

/**
 * Builder concreto para menús de mariscos
 */
public class SeafoodMenuBuilder extends MenuBuilder {

    @Override
    public void buildStarter() {
        menu.setStarter("🦐 Cóctel de Camarones con Salsa Rosa");
    }

    @Override
    public void buildMainCourse() {
        menu.setMainCourse("🐟 Salmón a la Plancha con Risotto de Mariscos");
    }

    @Override
    public void buildDessert() {
        menu.setDessert("🍋 Sorbete de Limón con Menta");
    }

    @Override
    public void buildDrink() {
        menu.setDrink("🍾 Copa de Vino Blanco Sauvignon Blanc");
    }

    @Override
    public void buildMenuInfo() {
        menu.setMenuType("🐟 MENÚ ESPECIALIDAD DEL MAR");
        menu.setTotalPrice(520.75);
        menu.setPreparationTime("30-35 minutos");
    }
}

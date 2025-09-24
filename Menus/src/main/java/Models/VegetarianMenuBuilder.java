package Models;


/**
 * Builder concreto para menús vegetarianos
 */
public class VegetarianMenuBuilder extends MenuBuilder {

    @Override
    public void buildStarter() {
        menu.setStarter("🥗 Ensalada Verde con Vinagreta de Hierbas");
    }

    @Override
    public void buildMainCourse() {
        menu.setMainCourse("🍆 Lasaña de Berenjenas con Queso Ricotta");
    }

    @Override
    public void buildDessert() {
        menu.setDessert("🍓 Tarta de Fresas con Crema Batida");
    }

    @Override
    public void buildDrink() {
        menu.setDrink("🥤 Jugo Natural de Frutas Mixtas");
    }

    @Override
    public void buildMenuInfo() {
        menu.setMenuType("🌱 MENÚ VEGETARIANO");
        menu.setTotalPrice(285.50);
        menu.setPreparationTime("25-30 minutos");
    }
}
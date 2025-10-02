package Models;

/**
 * Builder concreto para menús carnívoros
 */
public class MeatMenuBuilder extends MenuBuilder {

    @Override
    public void buildStarter() {
        menu.setStarter(" Bruschettas con Jamón Serrano y Tomate");
    }

    @Override
    public void buildMainCourse() {
        menu.setMainCourse(" Filete de Res a la Parrilla con Salsa Chimichurri");
    }

    @Override
    public void buildDessert() {
        menu.setDessert(" Flan Casero con Caramelo");
    }

    @Override
    public void buildDrink() {
        menu.setDrink("Copa de Vino Tinto de la Casa");
    }

    @Override
    public void buildMenuInfo() {
        menu.setMenuType(" MENÚ CARNÍVORO PREMIUM");
        menu.setTotalPrice(450.00);
        menu.setPreparationTime("35-40 minutos");
    }
}

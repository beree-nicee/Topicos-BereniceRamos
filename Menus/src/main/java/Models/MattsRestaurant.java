package Models;
/**
 * Director del patrón Builder
 */
public class MattsRestaurant {
    private MenuBuilder menuBuilder;

    public void setBuilder(MenuBuilder menuBuilder) {
        this.menuBuilder = menuBuilder != null ? menuBuilder : new VegetarianMenuBuilder();
    }

    public RestaurantMenu buildCompleteMenu() {
        if (menuBuilder == null) {
            throw new IllegalStateException("No hay builder configurado");
        }

        menuBuilder.buildStarter();
        menuBuilder.buildMainCourse();
        menuBuilder.buildDessert();
        menuBuilder.buildDrink();
        menuBuilder.buildMenuInfo();

        return menuBuilder.build();
    }

    public RestaurantMenu buildBasicMenu() {
        if (menuBuilder == null) {
            throw new IllegalStateException("No hay builder configurado");
        }

        menuBuilder.buildStarter();
        menuBuilder.buildMainCourse();
        menuBuilder.buildMenuInfo();

        RestaurantMenu basicMenu = menuBuilder.build();
        basicMenu.setTotalPrice(basicMenu.getTotalPrice() * 0.75);
        basicMenu.setMenuType(basicMenu.getMenuType() + " (BÁSICO)");

        return basicMenu;
    }

    public RestaurantMenu buildMainCourseOnly() {
        if (menuBuilder == null) {
            throw new IllegalStateException("No hay builder configurado");
        }

        menuBuilder.buildMainCourse();
        menuBuilder.buildMenuInfo();

        RestaurantMenu quickMenu = menuBuilder.build();
        quickMenu.setTotalPrice(quickMenu.getTotalPrice() * 0.5);
        quickMenu.setMenuType(quickMenu.getMenuType() + " (PLATO INDIVIDUAL)");
        quickMenu.setPreparationTime("10-15 minutos");

        return quickMenu;
    }
}

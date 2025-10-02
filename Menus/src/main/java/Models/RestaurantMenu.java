package Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Menu - Representa el producto final que construiremos
 * Esta es la clase PRODUCTO en el patrón Builder
 */
public class RestaurantMenu {
    // Atributos privados del menú
    private String starter;
    private String mainCourse;
    private String dessert;
    private String drink;
    private String menuType;
    private double totalPrice;
    private String preparationTime;
    private LocalDateTime orderTime;
    private int menuId;

    /**
     * Constructor por defecto
     */
    public RestaurantMenu() {
        this.starter = "No entrante";
        this.mainCourse = "No plato principal";
        this.dessert = "No postre";
        this.drink = "No bebida";
        this.totalPrice = 0.0;
        this.preparationTime = "No especificado";
        this.orderTime = LocalDateTime.now();
        this.menuId = (int)(Math.random() * 10000);
    }

    // Setters
    public void setStarter(String starter) {
        this.starter = starter != null ? starter : "No entrante";
    }

    public void setMainCourse(String mainCourse) {
        this.mainCourse = mainCourse != null ? mainCourse : "No plato principal";
    }

    public void setDessert(String dessert) {
        this.dessert = dessert != null ? dessert : "No postre";
    }

    public void setDrink(String drink) {
        this.drink = drink != null ? drink : "No bebida";
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType != null ? menuType : "Menú Estándar";
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice >= 0 ? totalPrice : 0.0;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime != null ? preparationTime : "No especificado";
    }

    // Getters
    public String getStarter() { return starter; }
    public String getMainCourse() { return mainCourse; }
    public String getDessert() { return dessert; }
    public String getDrink() { return drink; }
    public String getMenuType() { return menuType; }
    public double getTotalPrice() { return totalPrice; }
    public String getPreparationTime() { return preparationTime; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public int getMenuId() { return menuId; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        StringBuilder sb = new StringBuilder();
        sb.append("╔══════════════════════════════════════════════════════════╗\n");
        sb.append("║                        MENÚ DEL RESTAURANTE              ║\n");
        sb.append("╠══════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ ID del Menú: %-43s ║\n", "#" + menuId));
        sb.append(String.format("║ Tipo: %-51s ║\n", menuType));
        sb.append("╠══════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║  Entrante: %-44s ║\n", starter));
        sb.append(String.format("║  Plato Principal: %-37s ║\n", mainCourse));
        sb.append(String.format("║  Postre: %-46s ║\n", dessert));
        sb.append(String.format("║  Bebida: %-46s ║\n", drink));
        sb.append("╠══════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║  Precio Total: $%-38.2f ║\n", totalPrice));
        sb.append(String.format("║  Tiempo de Preparación: %-31s ║\n", preparationTime));
        sb.append(String.format("║  Hora del Pedido: %-36s ║\n", orderTime.format(formatter)));
        sb.append("╚══════════════════════════════════════════════════════════╝\n");

        return sb.toString();
    }
}


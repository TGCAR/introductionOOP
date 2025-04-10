package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    // Приватная константа для фиксированной цены
    private static final int FIXED_PRICE = 50; // фиксированная цена

    // Конструктор, принимающий только имя продукта
    public FixPriceProduct(String name) {
        super(name);
    }

    // Переопределенный метод getPrice, возвращающий фиксированную цену
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true; // Товар с фиксированной ценой является специальным
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }


}

package org.skypro.skyshop.product;

public class SimpleProduct extends Product{
    public SimpleProduct(String name, int price) {
        super(name, price);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getPrice() {
        return 0;
    }
}

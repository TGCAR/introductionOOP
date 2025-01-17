package org.skypro.skyshop.product;

public class Product {
    private String nameProduct;
    private int valueProduct;



    public Product(String nameProduct, int valueProduct) {
        this.nameProduct = nameProduct;
        this.valueProduct = valueProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getValueProduct() {
        return valueProduct;
    }
}

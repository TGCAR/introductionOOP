package org.skypro.skyshop.product;

public class Product {
    private String nameProduct;
    private String valueProduct;



    public Product(String nameProduct, String valueProduct) {
        this.nameProduct = nameProduct;
        this.valueProduct = valueProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public String getValueProduct() {
        return valueProduct;
    }
}

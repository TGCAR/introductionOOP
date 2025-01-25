package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int productCount;

    public ProductBasket() {
        this.products = new Product[5];
        this.productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[productCount++] = product;
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < productCount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printBasketContents() {
        if (productCount == 0) {
            System.out.println("В корзине пусто");
        } else {
            for (int i = 0; i < productCount; i++) {
                System.out.println(products[i].getName() + ": " + products[i].getPrice());
            }
            System.out.println("Итого: " + getTotalPrice());
        }
    }

    public boolean hasProduct(String productName) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < productCount; i++) {
            products[i] = null;
        }
        productCount = 0;
    }

    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();

        Product apple = new Product("Яблоко", 100);
        Product banana = new Product("Банан", 150);
        Product orange = new Product("Апельсин", 200);

        basket1.addProduct(apple);
        basket1.addProduct(banana);
        basket1.printBasketContents();

        basket2.addProduct(orange);
        basket2.printBasketContents();

        System.out.println("Продукт Банан в корзине basket1: " + basket1.hasProduct("Банан"));
        System.out.println("Продукт Банан в корзине basket2: " + basket2.hasProduct("Банан"));

        basket1.clearBasket();
        basket1.printBasketContents();
    }
}

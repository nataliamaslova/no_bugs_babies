package org.example.productprice;

import java.util.HashMap;

public class PriceList {
    private HashMap<String, Double> products;

    public PriceList() {
        this.products = new HashMap<>();
    }

    public HashMap<String, Double> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product.getPrice());
    }

    public void changePrice(String product, double price) {
        products.put(product, price);
    }

    public double getProductPrice(String product) {
        return products.get(product);
    }
}

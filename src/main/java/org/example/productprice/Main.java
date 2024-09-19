package org.example.productprice;

/**
 * Отображение товаров и их цен
 *
 * Создайте класс Product  полями для наименования и цены товара.
 * В классе PriceList используйте HashMap<String, Double> для хранения
 * списка товров, где ключом является название товара, а значением -
 * его цена.
 * Реализуйте методы для добавления нового товара и получения цены
 * товара по его названию.
 */
public class Main {
    public static void main(String[] args) {
        PriceList priceList = new PriceList();

        Product product1 = new Product("kettle", 50.0);
        Product product2 = new Product("headset", 70.0);
        Product product3 = new Product("laptop", 3150.0);
        Product product4 = new Product("kettle", 65.0);

        priceList.addProduct(product1);
        priceList.addProduct(product2);
        priceList.addProduct(product3);
        priceList.addProduct(product4);
        System.out.println(priceList.getProducts());

        priceList.changePrice("headset", 75);
        System.out.println(priceList.getProducts());

        System.out.println(priceList.getProductPrice("kettle"));
    }
}

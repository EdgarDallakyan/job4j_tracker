package ru.job4j.pojo;

public class Shop {
    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Product[] products = new Product[1];
        products[0] = new Product("Milk", 10);
        int rsl = Shop.indexOfNull(products);
        System.out.println(rsl);
    }
}
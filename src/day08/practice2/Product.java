package day08.practice2;

import static day08.practice2.Store.addSale;

public class Product{

    String productName;
    int price;

    Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    void sellProduct () {
        addSale(this.price);
    }
}

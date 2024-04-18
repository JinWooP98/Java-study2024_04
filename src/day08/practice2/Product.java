package day08.practice2;



public class Product{

    String productName;
    int price;

    Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    void sellProduct () {
        Store.addSale(this.price);
    }
}

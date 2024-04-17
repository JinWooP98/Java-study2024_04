package day07.practice;

public class Product {
    private String name;
    private int price;
    private int stock;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock || quantity < 0) {
            System.out.println("재고가 부족합니다.");
        } else {
            stock -= quantity;
        }
    }
}

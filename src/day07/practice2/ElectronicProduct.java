package day07.practice2;

public class ElectronicProduct {

    String productName;
    double price;
    String manufacturer;



    public void displayInfo () {
        System.out.printf("%s, 가격: %.0f, 제조사: %s\n", this.productName, this.price, this.manufacturer);
    }                            // %f에서 f앞에 .n 을 써주면, 소수점 n 번째까지 나타낸다.
}

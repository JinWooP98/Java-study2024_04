package day08.practice2;

public class Store {
    public static int totalSales;

    static void addSale(int amount) {
        totalSales += amount;
    }

    public static int getTotalSales() {
        return totalSales;
    }

}

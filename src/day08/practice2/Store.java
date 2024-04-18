package day08.practice2;

public class Store {
    private static int totalSales;

    public static void addSale(int amount) {
        totalSales += amount;
    }

    public static int getTotalSales() {
        return totalSales;
    }

}

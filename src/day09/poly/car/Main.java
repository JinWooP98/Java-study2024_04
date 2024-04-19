package day09.poly.car;

public class Main {


    public static void main(String[] args) {

        Car sonata1 = new Sonata();
        Car sonata2 = new Sonata();
        Sonata sonata3 = new Sonata();

        Car tucson1 = new Tucson();
        Car tucson2 = new Tucson();

        Car mustang1 = new Mustang();
        Car mustang2 = new Mustang();
        Car mustang3 = new Mustang();
        Car mustang4 = new Mustang();

        // 다형성을 통해 이종모음 배열을 구현할 수 있음.
        Car[] cArr = {sonata1, tucson1, mustang1, mustang2, mustang3, mustang4};
        for (Car car : cArr) {
            car.accelerate();
        }

        // object 타입을 이용해도 배열에 다른 타입들을 담을 수 있다.
        // 다만, object 타입을 쓰면 이것저것 들어가 활용하기 어려움.
        Object[] oArr = {"abc", "def", 100, false};

        System.out.println("======================================================");

        Driver driver = new Driver();
        driver.drive(new Mustang());
    }
}

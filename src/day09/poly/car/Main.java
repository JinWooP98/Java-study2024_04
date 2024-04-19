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

        Sonata mySonanta = new Sonata();
        mySonanta.accelerate();
        mySonanta.joinSonataClub();

        Car[] cars = new Car[3];
        cars[0] = mySonanta;

        System.out.println("============================================================");

        CarShop shop = new CarShop();

        double x = 10;
        int y = (int)x;

        // 객체타입에서 다운캐스팅의 전제 조건 : 반드시 상속관계가 있어야 하며
        // 자식객체가 부모타입으로 업캐스팅 된 것만 내릴 수 있음
        // 즉, 부모객체를 자식타입으로 내릴 수는 없다.
        Sonata car = (Sonata) shop.exportCar(3000);
        car.accelerate();
        car.joinSonataClub();

        System.out.println("==============================================================");

//        Sonata ccc = (Sonata)new Car();


    }
}

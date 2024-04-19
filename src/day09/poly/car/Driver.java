package day09.poly.car;

public class Driver {

    public void drive(Car car) {

        // 여기에 들어온 car가 소나타야?
        // instanceof == 무슨 자식이 업사이징 됐는지
        String carName = "";
        if(car instanceof  Sonata) {
            carName = "쏘나타";
        } else if(car instanceof Tucson) {
            carName = "투싼";
        } else if(car instanceof  Mustang) {
            carName = "머스탱";
        }


        System.out.println("운전을 시작합니다.");
        car.accelerate();
    }
}

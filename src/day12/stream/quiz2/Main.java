package day12.stream.quiz2;

import day07.modi.pac2.C;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {

        Destination paris = new Destination("Paris", "France");
        Destination rome = new Destination("Rome", "Italy");
        Destination berlin = new Destination("Berlin", "Germany");

        Traveler alice = new Traveler("Alice", "alice@example.com");
        Traveler bob = new Traveler("Bob", "bob@example.com");
        Traveler charlie = new Traveler("Charlie", "charlie@example.com");

        List<Booking> bookings = List.of(
                new Booking(alice, paris, 2022, 2000),
                new Booking(bob, rome, 2021, 1500),
                new Booking(alice, berlin, 2023, 1800),
                new Booking(charlie, paris, 2022, 2200),
                new Booking(bob, paris, 2021, 2500)
        );

        // 연습 1: 2022년에 예약된 모든 여행을 찾아 가격 오름차 정렬.

        List<Booking> bookingIn2022 = bookings.stream()
                .filter(b -> b.getYear() == 2022)
                .sorted(Comparator.comparing(Booking::getPrice))
                .collect(toList());

        System.out.println("bookingIn2022 = " + bookingIn2022);
        System.out.println("==========================================================");
        // 연습 2: 여행지가 있는 모든 나라 이름을 중복 없이 나열하시오.

        List<String> destinationCountries = bookings.stream()
                .map(b -> b.getDestination().getCountry())
                .distinct()
                .collect(toList());

        System.out.println("destinationCountries = " + destinationCountries);
        System.out.println("==========================================================");
        // 연습 3: Paris에 예약된 모든 여행자를 찾아 이름순으로 오름차 정렬.

        List<Booking> travlerInParis = bookings.stream()
                .filter(b -> b.getDestination().getCity().equals("Paris"))
                .sorted(Comparator.comparing(b -> b.getTraveler().getName()))
                .collect(toList());

        System.out.println("travlerInParis = " + travlerInParis);
        System.out.println("==========================================================");
        // 연습 4: 모든 여행자의 이메일을 리스트에 모아서 알파벳순으로 오름차정렬하여 반환.

        List<String> travlerEmail = bookings.stream()
                .sorted(Comparator.comparing(b -> b.getTraveler().getEmail()))
                .map(b -> b.getTraveler().getEmail())
                .distinct()
                .sorted()
                .collect(toList());

        System.out.println("travlerEmail = " + travlerEmail);
        System.out.println("==========================================================");
        // 연습 5: Italy로의 여행이 한 건이라도 있는지 여부 확인.

        boolean isItaly = bookings.stream()
                .anyMatch(b -> b.getDestination().getCountry().equals("Italy"));

        System.out.println("isItaly = " + isItaly);
        System.out.println("==========================================================");
        // 연습 6: France로의 모든 여행의 총 가격을 출력.
        Double totolPriceInFrance = bookings.stream()
                .filter(b -> b.getDestination().getCountry().equals("France"))
                .mapToDouble(b -> b.getPrice())
                .sum();

        System.out.println("totolPriceInFrance = " + totolPriceInFrance);
        System.out.println("==========================================================");
        // 연습 7: 예약된 모든 여행에서 최고 가격은 얼마인가?
        double maxPrice = bookings.stream()
                .sorted(Comparator.comparing((Booking b) -> b.getPrice()).reversed())
                .mapToDouble(b -> b.getPrice())
                .limit(1)
                .sum();

        System.out.println("MaxPrice = " + maxPrice);
        System.out.println("==========================================================");


        // 연습 8: 가장 저렴한 여행의 정보 탐색.
        List<Booking> minPriceTravelInfo = bookings.stream()
                .sorted(Comparator.comparing(b -> b.getPrice()))
                .limit(1)
                .collect(toList());

        System.out.println("minPriceTravelInfo = " + minPriceTravelInfo);
        System.out.println("==========================================================");


        // 연습 9: 가격이 2000 이상인 모든 여행 예약 정보를 출력.

        List<Booking> travleInfoUpto2000 = bookings.stream()
                .filter(b -> b.getPrice() >= 2000)
                .collect(toList());

        System.out.println("travleInfoUpto2000 = " + travleInfoUpto2000);
        System.out.println("==========================================================");

        // 연습 10: 모든 예약에서 가장 낮은 가격보다 높은 가격을 가진 예약의 평균 가격을 계산하시오.
        double minPrice = bookings.stream()
                .sorted(Comparator.comparing((Booking b) -> b.getPrice()))
                .mapToDouble(b -> b.getPrice())
                .limit(1)
                .sum();

        double averagePrice = bookings.stream()
                .filter(b -> b.getPrice() > minPrice)
                .mapToDouble(Booking::getPrice)
                .average()
                .getAsDouble();

        System.out.println("averagePrice = " + averagePrice);
        System.out.println("==========================================================");
        // 연습 11: 모든 여행자의 여행 예약을 여행지별로 그룹화하여 출력하시오.
        Map<String, List<Booking>> alltravler = new HashMap<>();

        List<Booking> bookingInParis = bookings.stream()
                .filter(b -> b.getDestination().getCity().equals("Paris"))
                .collect(toList());

        List<Booking> bookingInRome = bookings.stream()
                .filter(b -> b.getDestination().getCity().equals("Rome"))
                .collect(toList());

        List<Booking> bookingInBerlin = bookings.stream()
                .filter(b -> b.getDestination().getCity().equals("Berlin"))
                .collect(toList());

        alltravler.put("Paris", bookingInParis);
        alltravler.put("Rome", bookingInRome);
        alltravler.put("Berlin", bookingInBerlin);

        for (String s : alltravler.keySet()) {
            System.out.println("City = " + s);
            for (Booking booking : alltravler.get(s)) {
                System.out.println(booking);
            }
        }



        // 연습 12: 모든 예약 중 최고 가격과 최저 가격의 차이를 계산하시오.

        System.out.println(maxPrice - minPrice);
    }


}

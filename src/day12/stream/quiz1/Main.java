package day12.stream.quiz1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        // List<Transaction>
        List<Transaction> transactionValueIn2021 = transactions.stream()
                .filter(t -> t.getYear() == 2021)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println("transactionValueIn2021 = " + transactionValueIn2021);

        System.out.println("==========================================================");


        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        // List<String>
        List<String> tradeCity = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("tradeCity = " + tradeCity);

        System.out.println("==========================================================");
        // 연습 3: Cambridge에 근무하는 모든 거래자를 찾아 거래자리스트로 이름순으로 오름차정렬.
        // List<Trader>

        List<Trader> traderInCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(t -> t.getName()))
                .distinct()
                .collect(Collectors.toList());

        System.out.println("traderInCambridge = " + traderInCambridge);
        System.out.println("==========================================================");

        // 연습 4: 모든 거래자의 이름을 리스트에 모아서 알파벳순으로  오름차정렬하여 반환
        // List<String>

        List<String> traderName = transactions.stream()
                .sorted(Comparator.comparing(t -> t.getTrader().getName()))
                .map(t -> t.getTrader().getName())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("traderName = " + traderName);
        System.out.println("==========================================================");


        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?

        boolean isMilan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));

        System.out.println("isMilan = " + isMilan);
        System.out.println("==========================================================");

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.

        int totalValueInCambridge = transactions.stream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();

        System.out.println("totalValueInCambridge = " + totalValueInCambridge);
        System.out.println("==========================================================");

        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
        int MaxValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .getAsInt();



        System.out.println("MaxValue = " + MaxValue);
        System.out.println("==========================================================");

        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
//        int MinValue = transactions.stream()
//                .sorted(Comparator.comparing(Transaction::getValue))
//                .limit(1)
//                .mapToInt(Transaction::getValue)
//                .sum();
        /*
        자바의 단점: 널체크 문법이 없음
         */


        Transaction MinValue = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElse(null); // 만약 결과가 null 일 경우 어케 할거임




        System.out.println("MinValue = " + MinValue);
        System.out.println("==========================================================");

        // 연습 9. 거래액이 500 이상인 거래들만 필터링하고, 해당 거래의 정보를 출력하시오.

        List<Transaction> tradeInfoByValue = transactions.stream()
                .filter(t -> t.getValue() >= 500)
                .collect(Collectors.toList());

        System.out.println("tradeInfoByValue = " + tradeInfoByValue);
        System.out.println("==========================================================");
        // 연습 10. 모든 거래에서 가장 작은 거래액보다 큰 거래액을 가진 거래의 평균을 계산하시오.
        // 출력값: 752.0
        int MinValues = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .getAsInt();

        double average = transactions.stream()
                .filter(t -> t.getValue() > MinValues)
                .mapToInt(Transaction::getValue)
                .average()
                .getAsDouble();

        System.out.println("average = " + average);
        System.out.println("==========================================================");





        // 연습 11. "Cambridge"에서 거래하는 모든 거래자의 거래액을 연도별로 그룹화하여 출력하시오.
        /*
               출력예시

                Year: 2021
                {Trader: Brian in Cambridge, year: 2021, value: 300}
                {Trader: Raoul in Cambridge, year: 2021, value: 400}

                Year: 2022
                {Trader: Raoul in Cambridge, year: 2022, value: 1000}
                {Trader: Alan in Cambridge, year: 2022, value: 950}
         */
        Map<Integer, List<Transaction>> groupByYearMap = new HashMap<>();

        List<Transaction> liveInCambridege = transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.toList());

        System.out.println("Year: 2021");
        liveInCambridege.stream()
                .filter(t -> t.getYear() == 2021)
                .forEach(t -> System.out.println(t.MytoString()));

        System.out.println("\nYear: 2022");
        liveInCambridege.stream()
                .filter(t -> t.getYear() == 2022)
                .forEach(t -> System.out.println(t.MytoString()));


        System.out.println("==========================================================");


        // 연습 12. 모든 거래 중 가장 큰 거래액과 가장 작은 거래액의 차이를 계산하시오.
        // 출력 값 : 700

        System.out.println(MaxValue - MinValues);

    }

}

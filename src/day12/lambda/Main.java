package day12.lambda;

import java.util.List;

import static day12.lambda.Color.*;
import static day12.lambda.FilterApple.filter;
import static day12.lambda.FilterApple.filterApples;

public class Main {

    // 내부 클래스 생성
    private static class AppleColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == RED || apple.getColor() == GREEN;
        }
    }

    public static void main(String[] args) {

        // 사과 바구니 생성
        List<Apple> appleBasket = List.of(
                new Apple(80, GREEN)
                , new Apple(155, GREEN)
                , new Apple(120, RED)
                , new Apple(97, RED)
                , new Apple(200, GREEN)
                , new Apple(50, RED)
                , new Apple(85, YELLOW)
                , new Apple(75, YELLOW)
        );

        List<Apple> greenApples = FilterApple.filterGreenApples(appleBasket);
        System.out.println("greenApples = " + greenApples);

        List<Apple> redApples = FilterApple.filterApplesByColor(appleBasket, RED);
        System.out.println("redApples = " + redApples);

        System.out.println("================ 무거운 사과(100그램 이상) 필터링 ===============");

        List<Apple> apples1 = filterApples(appleBasket, new AppleWeightPredicate());

        System.out.println("apples1 = " + apples1);

        System.out.println("========== 빨강 또는 녹색 사과 필터링 ==========");
        List<Apple> apples2 = filterApples(appleBasket, new AppleColorPredicate());

        System.out.println("apples2 = " + apples2);

        System.out.println("========== 빨강이면서 무거운(100이상) 사과 필터링");
        List<Apple> apples3 = filterApples(appleBasket, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == RED && apple.getWeight() >= 100;
            }
        });

        System.out.println("apples3 = " + apples3);

        System.out.println("========== 노란색이면서 가벼운(100이하) 사과 필터링");
        List<Apple> apples4 = filterApples(appleBasket, apple -> apple.getColor() == YELLOW && apple.getWeight() <= 100 );
        System.out.println("apples4 = " + apples4);


        System.out.println("========== 녹색 사과 필터링 =========");

        List<Apple> apples5 = filter(appleBasket, apple -> apple.getColor() == GREEN);
        System.out.println("apples5 = " + apples5);

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        System.out.println("========= 짝수만 필터링 =========");
        List<Integer> filter = filter(numbers, n -> n % 2 == 0);
        System.out.println("filter = " + filter);

        System.out.println("========== 사과의 색상만 추출 =========");
        List<Color> colors = MappingApple.mppingApplesByColor(appleBasket);
        System.out.println("colors = " + colors);

        System.out.println("===== 사과의 무게만 추출 =====");

        List<Integer> map1 = MappingApple.map(appleBasket, new GenericFunction<Apple, Integer>() {
            @Override
            public Integer apply(Apple apple) {
                return apple.getWeight();
            }
        });

        System.out.println("map1 = " + map1);


        List<Color> map2 = MappingApple.map(appleBasket, (apple) -> apple.getColor());
        System.out.println("map2 = " + map2);

        System.out.println("===== 숫자리스트에서 각 숫자들의 제곱을 추출 =====");
        List<Integer> pows = MappingApple.map(numbers, n -> n * n);
        System.out.println("pows = " + pows);
    }
}


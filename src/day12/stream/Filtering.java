package day12.stream;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {

        // 요리 메뉴 중 채식주의자가 먹을 수 있는 요리만 필터링
        List<Dish> menuList = Menu.menuList;

        menuList.stream().filter(dish -> dish.isVegeterian()).collect(Collectors.toList());

//        System.out.println("menuList = " + menuList);

        menuList.forEach(dish -> System.out.println(dish.getName()));

        System.out.println("===============================================");

        // 메뉴 목록중에 육류이면서 600칼로리 미만인 요리 필터링해서 출력
        menuList
                .stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT && dish.getCalories() < 600)
                .collect(Collectors.toList())
                .forEach(dish -> System.out.println(dish));
        System.out.println("===============================================================");
        // 메뉴 목록에서 요리 이름이 4글자인 것만 필터링
        menuList
                .stream()
                .filter(dish -> dish.getName().length() == 4)
                .collect(Collectors.toList())
                .forEach(dish -> System.out.println(dish));

        System.out.println("===============================================================");

        // 칼로리가 300칼로리보다 큰 요리 중 앞에서 3개만 추출
        menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList())
                .forEach(dish -> System.out.println(dish));
        System.out.println("===============================================================");
        // 300칼로리보다 높은 요리 중 처음 2개는 제끼고 필터링
        menuList.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList())
                .forEach(dish -> System.out.println(dish));


        System.out.println("===============================================");

        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,9);
        List<Integer> integerList =
        numbers.stream()
                .filter(n -> n % 2 == 0 )
                .distinct()
                .collect(Collectors.toList());

        System.out.println("integerList = " + integerList);
    }


}

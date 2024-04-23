package day11.collection.list;

import day09.book.BookList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class ListExample {

    public static void main(String[] args) {

        List<String> foods = new ArrayList<>();
        // push
        foods.add("짜장면");
        foods.add("볶음밥");
        foods.add("파스타");
        foods.add("리조또");

        System.out.println(foods);

        // 중간삽입 add(index, E)
        foods.add(1, "짬뽕");

        System.out.println(foods);
        // length
        int size = foods.size();
        System.out.println("size = " + size);
        // index
        int index = foods.indexOf("파스타");
        System.out.println("index = " + index);
        // 포함 여부
        boolean flag = foods.contains("파스타");
        System.out.println(flag);
        // 제거
        foods.remove(0);
        foods.remove("파스타");

        System.out.println("foods = " + foods);
        // 수정
        foods.set(0, "동파육");
        // 값 가져오기
        String s = foods.get(1);
        System.out.println("s = " + s);

        // 반복문 처리
        for (int i = 0; i < foods.size() ; i++) {
            System.out.println(foods.get(i));
        }
        System.out.println("====================================");
        // 배열 순회 'iter'
        for (String food : foods) {
            System.out.println(food + " JMT!!");
        }
        // 초기화
        foods.clear();
        System.out.println(foods);
        // 비었는지 확인
        System.out.println(foods.isEmpty());

        // 리스트에 초기값 넣고 시작하기
        int[] arr = {10, 20, 30};
        List<Integer> numbers = new ArrayList<>(List.of(99, 24, 800, 10, 20, 30, 40 ,50));

        System.out.println(numbers);

        // 오름차 정렬
        numbers.sort(Integer::compareTo);
        System.out.println("numbers = " + numbers);
        // 내림차 정렬
        numbers.sort(Comparator.reverseOrder());
        System.out.println("numbers = " + numbers);
    }
}

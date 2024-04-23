package day11.collection.map;

import day09.poly.car.Mustang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        System.out.println(map);
        // 데이터 추가 : put()
        map.put("지갑잔액", 500);
        map.put("좋아하는 자동차", new Mustang());
        map.put("오늘 저녁 메뉴", "계란복음밥");

        Map<String, Object> emp = new HashMap<>();
        emp.put("empName", "김철수");
        emp.put("empAge", 27);

        System.out.println(map.size());
        System.out.println(map);

        // get(key)
        int money = (int)map.get("지갑잔액");
        System.out.println(money);

        // 중복된 키를 저장하면 값이 수정된다.
        map.put("지갑잔액", 99999);
        System.out.println(map);

        // map의 반복문 처리
        for (String s : map.keySet()) {
            System.out.println("key = " + s);
            System.out.println("value = " + map.get(s));
        }
    }
}

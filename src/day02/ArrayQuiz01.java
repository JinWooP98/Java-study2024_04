package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("# 먹고 싶은 음식을 입력하세요!!");
        System.out.println("# 입력을 중지하려면 <그만>이라고 입력하세요.");
        String[] foodList = new String[] {};

        while (true) {
            System.out.print(">> ");
            String food = scan.nextLine();
            if(food.equals("그만")) break;

            String[] temp = new String[foodList.length + 1];

            for (int i = 0; i < foodList.length; i++) {
                temp[i] = foodList[i];
            }
            temp[foodList.length] = food;
            foodList = temp;
            temp = null;
        }

        System.out.printf("먹고 싶은 음식리스트 : %s", Arrays.toString(foodList));
    }
}

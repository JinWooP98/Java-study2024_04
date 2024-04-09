package Day03;

import java.util.Arrays;

public class MethodQuiz {

    static String[] foods = {"떡볶이", "치킨", "파스타"};
    static String[] userNames = {"홍길동", "고길동"};

    static void printFoods() {
        System.out.println(Arrays.toString(foods));
    }

    static void push (String newFood) {
        String[] temp = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }
        temp[foods.length] = newFood;

        foods = temp;
        temp = null;
    }

    static int indexOf(String targetIndex) {
        int indexNum = -1;
        for (int i = 0; i < foods.length; i++) {
            if(targetIndex.equals(foods[i])){
                indexNum = i;
            }
        }
        return indexNum;
    }

    static void remove(String targetFood) {
        int targetIndex = indexOf(targetFood);
        String[] temp = new String[foods.length - 1];
        for (int i = targetIndex; i < foods.length - 1; i++) {
            foods[i] = foods[i + 1];
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i] = foods[i];
        }

        foods = temp;
        temp = null;
    }

    static boolean include (String targetFood) {
        for (int i = 0; i < foods.length; i++) {
            if (targetFood.equals(foods[i])) {
                return true;
            }
        }
        return false;
    }

    static void insert (int targetIndex, String newFood) {
        String [] temp = new String[foods.length + 1];
        for (int i = 0; i < foods.length; i++) {
            temp[i] = foods[i];
        }

        for (int i = foods.length; i > targetIndex ; i--) {
            temp[i] = temp[i-1];
        }

        temp[targetIndex] = newFood;

        foods = temp;
        temp = null;
    }

    static void  modify (int targetIndex, String newFood) {
        foods[targetIndex] = newFood;
    }

    public static void main(String[] args) {

        printFoods();
        push("라면");
        push("김치찌개");
        printFoods();

        int index = indexOf("파스타");
        System.out.println("index = " + index);

        int index2 = indexOf("라면땅");
        System.out.println("index2 = " + index2);

        remove("치킨");
        printFoods();


        boolean flag1 = include("파스타");
        System.out.println("flag1 = " + flag1);

        boolean flag2 = include("떡라면");
        System.out.println("flag2 = " + flag2);

        insert(3, "파인애플");

        printFoods();

        modify(2, "닭갈비");
        printFoods();




    }
}

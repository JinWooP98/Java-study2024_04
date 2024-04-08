package Day02;

import java.util.Arrays;

public class ArrayDelete {

    public static void main(String[] args) {

        // 배열에서 원하는 위치의 값 삭제하기
        int[] numbers = {1, 3, 5, 7, 9, 11};

        int targetIndex = 2;
        // targetIndex부터 다음 인덱스의 값을 땡겨온다, 해당 배열 length-1 번까지
        for (int i = targetIndex; i < numbers.length-1; i++) {
            numbers[i] = numbers[i + 1];
        }
        // pop
        int[] temp = new int[numbers.length - 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = numbers[i];
        }

        numbers = temp;
        temp = null;


        System.out.println(Arrays.toString(numbers));
    }
}

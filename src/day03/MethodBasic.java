package day03;

import java.util.Arrays;

public class MethodBasic {

    // 자바의 함수는 반드시 클래스 블록 내부, 다른 함수 외부에 만들어야 함.

    // 두개의 정수를 전달받아 합으 리턴하는 함수
    // 자바의 함수
    // 1. 매개변수의 타입을 정해주어야 함
    // 2. js function 자리에 리턴할 값의 타입을 적어주어야 함.
    // 3. static은 일단 아무 이유없이 붙이기 후에 배움
    static int add(int n1, int n2) {

        return n1 + n2;
        // return밑 코드 X
    }

    // n개의 정수를 전달받아 그 총합을 반환하는 함수
    static int addAll(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }
    
    // 2개의 정수를 전달받아 사칙연산의 결과를 모두 리턴
    static int[] operate(int n1, int n2) {

        return new int[] {add(n1, n2), n1 - n2, n1 * n2, n1 / n2};
    }

    // 4. return이 없을 경우 void(공허하다, 비어있다)를 사용
    static void multiply(int n1, int n2) {
        if (n1> 100) return;
        System.out.printf("%d x %d = %d\n", n1, n2, n1 * n2);
    }
    public static void main(String[] args) {
        // main도 함수이기 때문에 이곳에서 함수 생성 X
        // 함수를 호출할 때는 함수 안에서만 가능
        int r1 = add(10, 20);
        System.out.println("r1 = " + r1);

        // void함수는 함수의 결과를 변수에 담을 수 없음
        // 반드시 단독호출해서 사용
        multiply(5, 3);

//        int [] arr = {1, 3, 5, 7, 9};
        int r2 = addAll(new int[] {1, 3, 5, 7, 9});
        System.out.println("r2 = " + r2);

        int r3 = addAll(10, 20, 30, 40, 50);
        System.out.println("r3 = " + r3);

        int[] operateResultList = operate(20, 10);
        System.out.println("operateResultList = " + Arrays.toString(operateResultList));
        
    } // end main method

} // end class

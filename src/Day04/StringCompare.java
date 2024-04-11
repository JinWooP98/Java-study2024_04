package Day04;

import java.util.Scanner;

public class StringCompare {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        String inputName = scan.nextLine();
        String myName = "홍길동";

//        char[] nickName = {'축', '구', '감', '상'};
//        String nick = new String(nickName);
//        System.out.println("nick = " + nick);

        System.out.println("myName = " + myName);
        System.out.println("inputName = " + inputName);
        // ==은 스택을 비교하는 것
        if(myName.equals(inputName)) {
            System.out.println("두 문자열이 같다!");
        } else {
            System.out.println("두 문자열이 다르다!");
        }
    }
}

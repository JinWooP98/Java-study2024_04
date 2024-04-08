package Day02;

import java.io.IOException;
import java.util.Scanner;

public class StdIO {

    public static void main(String[] args) throws IOException {

        // print는 출력은 해주지만 줄 개행 X
        // println은 출력을 해주며 마지막에 \n을 넣어줌
        // 변수값을 넣고 싶으면 printf
        String name = "김철수";

        //%s: 문자열포맷팅, %d: 정수, %f: 실수, %c: 단일문자
        System.out.printf("%s의 강아지\n", name);
        System.out.printf("%s의 고양이\n", name);


        // 자바에서 키보드 입력받기
        Scanner scan = new Scanner(System.in); // 입력준비 딱 1회만 하면 됨

        // 문자 입력받기
        System.out.print("이름 : ");
        String userName = scan.nextLine();
        System.out.println("userName = " + userName);

        // 정수 입력받기 - 문자를 입력받은 뒤 정수로 변환
        System.out.print("출생년도: ");
        int birthYear = Integer.parseInt(scan.nextLine());
        System.out.print("birthYear = " + birthYear);
    }
}

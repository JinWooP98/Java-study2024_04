package day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz02 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] nickName = new String[] {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};
        System.out.printf("* 우리반 학생들의 별명 : %s\n", Arrays.toString(nickName));

        while (true) {
            //탐색 알고리즘
            System.out.println("- 삭제할 학생의 별명을 입력하세요.");
            System.out.print(">> ");
            String target = scan.nextLine();

            int index = -1;
            for (int i = 0; i < nickName.length; i++) {
                if(target.equals(nickName[i])) {
                    index = i;
                    break;
                }
            }


            if (index != -1) {
                // 삭제 알고리즘
                for (int i = index; i < nickName.length - 1; i++) {
                    nickName[i] = nickName[i+1];
                }

                String[] temp = new String[nickName.length - 1];

                for (int i = 0; i < nickName.length - 1 ; i++) {
                    temp[i] = nickName[i];
                }

                nickName = temp;
                temp = null;

                System.out.println("* 삭제 후 정보: " + Arrays.toString(nickName));
                break;
            } else {
                System.out.printf("해당 별명 %s(은)는 존재하지 않습니다.\n", target);
            }
        }


    }
}

package Day02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayQuiz03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] member = new String[] {"영웅재중", "최강창민", "시아준수", "믹키유천", "유노윤호"};

        System.out.println("* 변경 전 정보: " + Arrays.toString(member));

        while (true) {
            System.out.println("- 수정할 멤버의 이름을 입력하세요.");
            System.out.print(">> ");
            String removeMember = scan.nextLine();

            int index = -1;
            for (int i = 0; i < member.length; i++) {
                if (removeMember.equals(member[i])) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                System.out.printf("%s의 별명을 변경합니다.\n", removeMember);
                System.out.println("변경할 새로운 이름을 입력하세요.");
                System.out.print(">> ");
                String newMember = scan.nextLine();
                member[index] = newMember;
                System.out.println("변경 완료!!");
                System.out.println("* 변경 후 정보 : " + Arrays.toString(member));
                break;
            } else {
                System.out.println(removeMember + "은(는) 없는 이름입니다.");
            }
        }
    }
    }


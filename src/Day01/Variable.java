package Day01;

//파일 명하고 일치해야 한다. 대제목 느김이라 첫 글자 대문자
public class Variable {

    static int n4 = 40;

    public static void main(String[] args) {

        System.out.println(n4);
        int score = 78; //숫자, 정수만
        String userName = "홍길동"; // 문자열, 자바는 camelCase를 관례적으로 사용

        // 변수의 스코프 - 블록레벨 스코프
        // 자바의 변수는 생성된 블록이 종료되면 메모리에서 사라짐
        int i = 100;
        for (int j = 0; j < 5; j++) {
            System.out.println(j);
        } // end for
        int n1 = 10;
        int n2;

        if (true) {
            System.out.println(n1);
            n2 = 20;

            while(true) {
                System.out.println(n2);
                int n3 = 30;
                break;
            } // end while
            System.out.println(n2);
        } // end if
        System.out.println(n2);
    } // end main
} // end class
